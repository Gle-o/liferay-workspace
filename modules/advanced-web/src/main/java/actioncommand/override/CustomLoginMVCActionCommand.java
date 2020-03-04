package actioncommand.override;

import com.liferay.login.web.internal.constants.LoginPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author guillaumelenoir
 *
 *  scr:list | grep LoginMVCActionCommand
 *  scr:info 5835
 */
@Component(
		property = {
				"javax.portlet.name=" + LoginPortletKeys.FAST_LOGIN,
				"javax.portlet.name=" + LoginPortletKeys.LOGIN,
				"mvc.command.name=/login/login",
				"service.ranking:Integer=100" 
		},
		service = MVCActionCommand.class
		)
public class CustomLoginMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction
	(ActionRequest actionRequest, ActionResponse actionResponse) 
			throws Exception {

		_log.info("CustomLoginMVCActionCommand processAction");
		_loginMVCactionCommand.processAction(actionRequest, actionResponse);
	}

	private static final Log _log = LogFactoryUtil.getLog(
			CustomLoginMVCActionCommand.class);

	@Reference(
			target = "(component.name=com.liferay.login.web.internal.portlet.action.LoginMVCActionCommand)")
	private MVCActionCommand _loginMVCactionCommand;

}
