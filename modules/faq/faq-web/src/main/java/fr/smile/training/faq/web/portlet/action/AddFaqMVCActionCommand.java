
package fr.smile.training.faq.web.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.faq.service.FaqService;
import fr.smile.training.faq.web.constants.FaqPortletKeys;
import fr.smile.training.faq.web.constants.MVCCommandNames;

/**
 * MVC Action Command for adding faqs.
 * 
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + FaqPortletKeys.FAQ,
		"mvc.command.name=" + MVCCommandNames.ADD_FAQ
	},
	service = MVCActionCommand.class
)
public class AddFaqMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		/*
		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Faq.class.getName(), actionRequest);

		// Get parameters from the request.

		// Use LocalizationUtil to get a localized parameter.

		Map<Locale, String> title =
			LocalizationUtil.getLocalizationMap(actionRequest, "title");

		String description = ParamUtil.getString(actionRequest, "description");

		Date dueDate = ParamUtil.getDate(
			actionRequest, "dueDate",
			DateFormatFactoryUtil.getDate(actionRequest.getLocale()));

		try {

			// Call the service to add a a new faq.
			
			_faqService.addFaq(
				themeDisplay.getScopeGroupId(), title, description, dueDate,
				serviceContext);

			// Set success message.

			SessionMessages.add(actionRequest, "faq-added");

			// Hide default success message.

			hideDefaultSuccessMessage(actionRequest);
			
			sendRedirect(actionRequest, actionResponse);
		}
		catch (FaqValidationException e) {

			// Set error messages from the service layer.

			e.getErrors().forEach(key -> SessionErrors.add(actionRequest, key));
			
			actionResponse.getRenderParameters().setValue(
				"mvcRenderCommandName", MVCCommandNames.EDIT_FAQ);			

		}
		catch (PortalException e) {

			_log.error(e);

			// Set error message.

			SessionErrors.add(actionRequest, "error.faq-service-error");
			
			actionResponse.getRenderParameters().setValue(
				"mvcRenderCommandName", MVCCommandNames.EDIT_FAQ);			
		}
		catch (Exception e) {
			_log.error(e);

			// Set error message.

			SessionErrors.add(actionRequest, "error.faq-service-error");
			
			actionResponse.getRenderParameters().setValue(
				"mvcRenderCommandName", MVCCommandNames.EDIT_FAQ);	
		}
		*/
	}

	@Reference
	protected FaqService _faqService;

	private static final Log _log =
		LogFactoryUtil.getLog(AddFaqMVCActionCommand.class);
}
