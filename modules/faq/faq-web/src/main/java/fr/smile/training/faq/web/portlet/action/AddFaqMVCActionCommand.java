
package fr.smile.training.faq.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.faq.exception.FaqValidationException;
import fr.smile.training.faq.model.Faq;
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


		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Faq.class.getName(), actionRequest);

		// Get parameters from the request.

		// Use LocalizationUtil to get a localized parameter.

		Map<Locale, String> title =
			LocalizationUtil.getLocalizationMap(actionRequest, "title");

		String description = ParamUtil.getString(actionRequest, "description");


		try {

			// Call the service to add a a new faq.
			
			_faqService.addFaq(
				themeDisplay.getScopeGroupId(), title, description,
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
			
			actionResponse.setRenderParameter(
				"mvcRenderCommandName", MVCCommandNames.EDIT_FAQ);			

		}
		catch (PortalException e) {

			_log.error(e);

			// Set error message.

			SessionErrors.add(actionRequest, "error.faq-service-error");
			
			actionResponse.setRenderParameter(
				"mvcRenderCommandName", MVCCommandNames.EDIT_FAQ);			
		}
		catch (Exception e) {
			_log.error(e);

			// Set error message.

			SessionErrors.add(actionRequest, "error.faq-service-error");
			
			actionResponse.setRenderParameter(
				"mvcRenderCommandName", MVCCommandNames.EDIT_FAQ);	
		}
		
	}

	@Reference
	protected FaqService _faqService;

	private static final Log _log =
		LogFactoryUtil.getLog(AddFaqMVCActionCommand.class);
}
