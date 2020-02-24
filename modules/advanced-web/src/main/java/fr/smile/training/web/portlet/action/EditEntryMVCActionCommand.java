package fr.smile.training.web.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import fr.smile.training.web.portlet.constants.AdvancedWebPortletKeys;

/**
 * @author guillaumelenoir
 *
 */
@Component(
    immediate = true,
    property = {
    	"javax.portlet.name=" + AdvancedWebPortletKeys.ADVANCEDWEB,
        "mvc.command.name=greet"
    },
    service = MVCActionCommand.class
)
public class EditEntryMVCActionCommand extends BaseMVCActionCommand {

	/**
	 * @param actionRequest
	 */
	private void _handleActionCommand(ActionRequest actionRequest) {
		String name = ParamUtil.get(actionRequest, "name", "");

		if (_log.isInfoEnabled()) {
			_log.info("Hello " + name);
		}

		String greetingMessage = "Hello " + name + "! Welcome to OSGi";

		actionRequest.setAttribute("GREETER_MESSAGE", greetingMessage);

		// Add succes message
		// https://portal.liferay.dev/docs/7-0/tutorials/-/knowledge_base/t/adding-failure-and-success-messages
		// greetingMessage is the key
		// GREETER_MESSAGE is the value in the jsp
		// it's possible to put transaltion key for i18N
		SessionMessages.add(actionRequest, "greetingMessage", greetingMessage);
	}

	/**
	 * The logger
	 */
	private static final Log _log = LogFactoryUtil.getLog(
			EditEntryMVCActionCommand.class);

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand#doProcessAction(javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_handleActionCommand(actionRequest);
		
	}

}