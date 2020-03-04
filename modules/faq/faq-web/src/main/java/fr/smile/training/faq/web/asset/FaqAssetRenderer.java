
package fr.smile.training.faq.web.asset;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.asset.util.AssetHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.smile.training.faq.model.Faq;
import fr.smile.training.faq.web.constants.FaqPortletKeys;
import fr.smile.training.faq.web.constants.MVCCommandNames;

/**
 * Asset renderer for faqs.
 * 
 * @author Guillaume Lenoir
 */
public class FaqAssetRenderer extends BaseJSPAssetRenderer<Faq> {

	public FaqAssetRenderer(
		Faq faq,
		FaqAssetRendererFactory faqAssetRendererFactory) {

		_faq = faq;
		_faqAssetRendererFactory = faqAssetRendererFactory;
	}

	@Override
	public Faq getAssetObject() {

		return _faq;
	}

	@Override
	public String getClassName() {

		return Faq.class.getName();
	}

	@Override
	public long getClassPK() {

		return _faq.getFaqId();
	}

	@Override
	public long getGroupId() {

		return _faq.getGroupId();
	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {

		return "/asset/" + template + ".jsp";
	}

	@Override
	public int getStatus() {

		return _faq.getStatus();
	}

	@Override
	public String getSummary(
		PortletRequest portletRequest, PortletResponse portletResponse) {

		int abstractLength = AssetHelper.ASSET_ENTRY_ABSTRACT_LENGTH;

		if (portletRequest != null) {
			abstractLength = GetterUtil.getInteger(
				portletRequest.getAttribute(
					WebKeys.ASSET_ENTRY_ABSTRACT_LENGTH),
				AssetHelper.ASSET_ENTRY_ABSTRACT_LENGTH);
		}

		String summary = HtmlUtil.stripHtml(
			StringUtil.shorten(_faq.getDescription(), abstractLength));

		return summary;
	}

	@Override
	public String getTitle(Locale locale) {

		return _faq.getTitle(locale);
	}

	@Override
	public PortletURL getURLEdit(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse)
		throws Exception {

		Group group = (Group) liferayPortletRequest.getAttribute(
			WebKeys.ASSET_RENDERER_FACTORY_GROUP);

		PortletURL portletURL =
			_faqAssetRendererFactory.getPortal().getControlPanelPortletURL(
				liferayPortletRequest, group, FaqPortletKeys.FAQ, 0,
				0, PortletRequest.RENDER_PHASE);

		portletURL.setParameter(
			"mvcRenderCommandName", MVCCommandNames.EDIT_FAQ);
		portletURL.setParameter(
			"faqId", String.valueOf(_faq.getFaqId()));
		portletURL.setParameter("showback", Boolean.FALSE.toString());

		return portletURL;
	}

	@Override
	public String getURLView(
		LiferayPortletResponse liferayPortletResponse, WindowState windowState)
		throws Exception {

		return super.getURLView(liferayPortletResponse, windowState);
	}

	@Override
	public String getURLViewInContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		String noSuchEntryRedirect)
		throws Exception {

		try {
			long plid =
				_faqAssetRendererFactory.getPortal().getPlidFromPortletId(
					_faq.getGroupId(), FaqPortletKeys.FAQ);

			PortletURL portletURL;
			if (plid == LayoutConstants.DEFAULT_PLID) {
				portletURL = liferayPortletResponse.createLiferayPortletURL(
					getControlPanelPlid(liferayPortletRequest),
					FaqPortletKeys.FAQ,
					PortletRequest.RENDER_PHASE);
			}
			else {
				portletURL =
						_faqAssetRendererFactory.getPortletURLFactory().create(
						liferayPortletRequest, FaqPortletKeys.FAQ,
						plid, PortletRequest.RENDER_PHASE);
			}

			portletURL.setParameter(
				"mvcRenderCommandName", MVCCommandNames.VIEW_FAQS);
			portletURL.setParameter(
				"faqId", String.valueOf(_faq.getFaqId()));

			String currentUrl =
				_faqAssetRendererFactory.getPortal().getCurrentURL(
					liferayPortletRequest);

			portletURL.setParameter("redirect", currentUrl);

			return portletURL.toString();

		}
		catch (PortalException e) {

		}
		catch (SystemException e) {
		}
		return null;
	}

	@Override
	public long getUserId() {

		return _faq.getUserId();
	}

	@Override
	public String getUserName() {

		return _faq.getUserName();
	}

	@Override
	public String getUuid() {

		return _faq.getUuid();
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker)
		throws PortalException {

		return _faqAssetRendererFactory.faqPermissionChecker().contains(
			permissionChecker, _faq.getGroupId(),
			_faq.getFaqId(), ActionKeys.UPDATE);
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker)
		throws PortalException {

		return _faqAssetRendererFactory.faqPermissionChecker().contains(
			permissionChecker, _faq.getGroupId(),
			_faq.getFaqId(), ActionKeys.VIEW);
	}

	@Override
	public boolean include(
		HttpServletRequest request, HttpServletResponse response,
		String template)
		throws Exception {

		request.setAttribute("faq", _faq);

		return super.include(request, response, template);
	}

	
	private Faq _faq;
	private FaqAssetRendererFactory _faqAssetRendererFactory;
}
