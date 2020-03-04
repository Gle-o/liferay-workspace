
package fr.smile.training.faq.web.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactory;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.Html;
import com.liferay.portal.kernel.util.Portal;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.faq.model.Faq;
import fr.smile.training.faq.service.FaqLocalService;
import fr.smile.training.faq.service.permission.FaqPermissionChecker;
import fr.smile.training.faq.web.constants.FaqPortletKeys;
import fr.smile.training.faq.web.constants.MVCCommandNames;

/**
 * Asset renderer factory component for faqs.
 * 
 * @author Guillaume Lenoir
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + FaqPortletKeys.FAQ
	}, 
	service = AssetRendererFactory.class
)
public class FaqAssetRendererFactory
	extends BaseAssetRendererFactory<Faq> {

	public FaqAssetRendererFactory() {

		setClassName(CLASS_NAME);
		setLinkable(true);
		setPortletId(FaqPortletKeys.FAQ);
		setSearchable(true);
	}

	@Override
	public AssetRenderer<Faq> getAssetRenderer(long classPK, int type)
		throws PortalException {

		Faq faq = _faqLocalService.getFaq(classPK);

		FaqAssetRenderer faqAssetRenderer =
			new FaqAssetRenderer(faq, this);

		faqAssetRenderer.setAssetRendererType(type);
		return faqAssetRenderer;
	}

	@Override
	public String getType() {

		return TYPE;
	}

	@Override
	public PortletURL getURLAdd(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse, long classTypeId) {

		PortletURL portletURL = null;

		long refererGroupId = 0;
		long refererPlid = 0;

		portletURL = _portal.getControlPanelPortletURL(
			liferayPortletRequest, getGroup(liferayPortletRequest),
			FaqPortletKeys.FAQ, refererGroupId, refererPlid,
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter(
			"mvcRenderCommandName", MVCCommandNames.EDIT_FAQ);
		portletURL.setParameter("showback", Boolean.FALSE.toString());

		return portletURL;
	}

	public FaqLocalService getFaqLocalService() {

		return _faqLocalService;
	}

	public Portal getPortal() {

		return _portal;
	}

	public FaqPermissionChecker faqPermissionChecker() {

		return _faqPermissionChecker;
	}

	public Html getHtml() {

		return _html;
	}

	public PortletURLFactory getPortletURLFactory() {

		return _portletURLFactory;
	}

	@Override
	public boolean hasAddPermission(
		PermissionChecker permissionChecker, long groupId, long classTypeId)
		throws Exception {

		return _faqPermissionChecker.containsTopLevel(
			permissionChecker, groupId,
			FaqPermissionChecker.ADD);
	}

	@Override
	public boolean hasPermission(
		PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		Faq faq = _faqLocalService.getFaq(classPK);

		return _faqPermissionChecker.contains(
			permissionChecker, faq.getGroupId(),
			faq.getFaqId(), actionId);
	}

	@Reference(target = "(osgi.web.symbolicname=fr.smile.training.faq.web)")
	private ServletContext _servletContext;

	@Reference
	private FaqLocalService _faqLocalService;

	@Reference
	private Portal _portal;

	@Reference
	private Html _html;

	@Reference
	private PortletURLFactory _portletURLFactory;

	@Reference
	private FaqPermissionChecker _faqPermissionChecker;

	public static final String CLASS_NAME = Faq.class.getName();
	public static final String TYPE = "faq";

}
