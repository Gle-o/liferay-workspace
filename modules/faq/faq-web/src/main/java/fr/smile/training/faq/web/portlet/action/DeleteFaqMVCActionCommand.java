
package fr.smile.training.faq.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.faq.service.FaqService;
import fr.smile.training.faq.web.constants.FaqPortletKeys;
import fr.smile.training.faq.web.constants.MVCCommandNames;

/**
 * MVC Action Command for deleting faqs.
 * 
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + FaqPortletKeys.FAQ,
		"mvc.command.name=" + MVCCommandNames.DELETE_FAQ
	},
	service = MVCActionCommand.class
)
public class DeleteFaqMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
		ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		/*
		// Get faq id from request.

		long faqId = ParamUtil.getLong(actionRequest, "faqId");

		if (_log.isDebugEnabled()) {
			_log.debug("Deleting faq " + faqId);
		}

		try {

			// Call service to delete the faq.

			_faqService.deleteFaq(faqId);

			// Set success message.

			SessionMessages.add(actionRequest, "faq-deleted");

		}
		catch (PortalException e) {

			// Set error message.

			SessionErrors.add(actionRequest, "error.faq-service-error");

			_log.error(e);
		}
		*/

	}

	@Reference
	protected FaqService _faqService;

	private static final Log _log =
		LogFactoryUtil.getLog(DeleteFaqMVCActionCommand.class);

}
