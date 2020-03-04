
package fr.smile.training.faq.web.portlet.action;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.faq.model.Faq;
import fr.smile.training.faq.service.FaqService;
import fr.smile.training.faq.service.permission.FaqPermissionChecker;
import fr.smile.training.faq.web.constants.FaqPortletKeys;
import fr.smile.training.faq.web.constants.MVCCommandNames;
import fr.smile.training.faq.web.display.context.FaqsManagementToolbarDisplayContext;

/**
 * MVC command for showing the faqs list.
 * 
 * @author liferay
 */
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + FaqPortletKeys.FAQ,
				"mvc.command.name=/",
				"mvc.command.name=" + MVCCommandNames.VIEW_FAQS
		},
		service = MVCRenderCommand.class
		)
public class ViewFaqsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
					throws PortletException {


		// Add faq list related attributes.

		addFaqListAttributes(renderRequest);

		// Add Clay management toolbar related attributes.

		addManagementToolbarAttributes(renderRequest, renderResponse);

		// Add permission checker

		renderRequest.setAttribute(
				"faqPermissionChecker", _faqPermissionChecker);

		// Add attributes needed by Application Display Templates renderer.

		addADTAttributes(renderRequest);

		return "/view.jsp";
	}

	/**
	 * Add attributes needed by Application Display Templates renderer.
	 * 
	 * @param renderRequest
	 */
	private void addADTAttributes(RenderRequest renderRequest) {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		renderRequest.setAttribute(
				"faqClassName", Faq.class.getName());

		PortletPreferences portletPreferences = renderRequest.getPreferences();

		renderRequest.setAttribute(
				"ADTdisplayStyle",
				portletPreferences.getValue("displayStyle", ""));
		renderRequest.setAttribute(
				"ADTdisplayStyleGroupId",
				GetterUtil.getLong(
						portletPreferences.getValue("displayStyleGroupId", null),
						themeDisplay.getScopeGroupId()));

	}

	/**
	 * Adds assigment list related attributes to the request.
	 * 
	 * @param renderRequest
	 */
	private void addFaqListAttributes(RenderRequest renderRequest) {


		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// Resolve start and end for the search.

		int currentPage = ParamUtil.getInteger(
				renderRequest, SearchContainer.DEFAULT_CUR_PARAM,
				SearchContainer.DEFAULT_CUR);

		int delta = ParamUtil.getInteger(
				renderRequest, SearchContainer.DEFAULT_DELTA_PARAM,
				SearchContainer.DEFAULT_DELTA);

		int start = ((currentPage > 0) ? (currentPage - 1) : 0) * delta;
		int end = start + delta;

		// Get sorting options.
		// Notice that this doesn't really sort on title because the field is
		// stored in XML
		// In real world this search would be integrated to the search engine to
		// get localized
		// sort options.

		String orderByCol =
				ParamUtil.getString(renderRequest, "orderByCol", "title");
		String orderByType =
				ParamUtil.getString(renderRequest, "orderByType", "asc");

		// Create comparator

		OrderByComparator<Faq> comp =
				OrderByComparatorFactoryUtil.create(
						"Faq", orderByCol, !("asc").equals(orderByType));

		// Get keywords.
		// Notice that cleaning keywords is not implemented.

		String keywords = ParamUtil.getString(renderRequest, "keywords");

		// Get the workflow status for the list.

		int status = getAllowedWorkflowStatus(renderRequest);

		// Call the service to get the list of faqs.

		List<Faq> assigments =
				_faqService.getFaqsByKeywords(
						themeDisplay.getScopeGroupId(), keywords, start, end, status, comp);

		// Set request attributes.

		renderRequest.setAttribute("faqs", assigments);
		renderRequest.setAttribute(
				"faqCount", _faqService.getFaqsCountByKeywords(
						themeDisplay.getScopeGroupId(), keywords, status));


	}

	/**
	 * Adds Clay management toolbar context object to the request.
	 * 
	 * @param renderRequest
	 * @param renderResponse
	 */
	private void addManagementToolbarAttributes(
			RenderRequest renderRequest, RenderResponse renderResponse) {

		LiferayPortletRequest liferayPortletRequest =
				_portal.getLiferayPortletRequest(renderRequest);

		LiferayPortletResponse liferayPortletResponse =
				_portal.getLiferayPortletResponse(renderResponse);

		FaqsManagementToolbarDisplayContext faqsManagementToolbarDisplayContext =
				new FaqsManagementToolbarDisplayContext(
						liferayPortletRequest, liferayPortletResponse,
						_portal.getHttpServletRequest(renderRequest),
						_faqPermissionChecker);

		renderRequest.setAttribute(
				"faqsManagementToolbarDisplayContext",
				faqsManagementToolbarDisplayContext);

	}

	/**
	 * Returns workflow status current user is allowed to see.
	 * 
	 * This simple example returns ANY status for company admin and
	 * APPROVED for other users.
	 * 
	 * @param renderRequest
	 * @return
	 */
	private int getAllowedWorkflowStatus(RenderRequest renderRequest) {

		ThemeDisplay themeDisplay =
				(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PermissionChecker  permissionChecker = themeDisplay.getPermissionChecker();

		int status;

		if (permissionChecker.isCompanyAdmin()) {
			status = WorkflowConstants.STATUS_ANY;
		} else {
			status = WorkflowConstants.STATUS_APPROVED;
		}

		return status;
	}

	@Reference
	protected FaqPermissionChecker _faqPermissionChecker;

	@Reference
	protected FaqService _faqService;

	@Reference
	private Portal _portal;
}
