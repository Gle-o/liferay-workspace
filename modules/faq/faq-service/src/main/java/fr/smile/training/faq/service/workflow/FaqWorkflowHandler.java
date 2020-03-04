
package fr.smile.training.faq.service.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.permission.ResourceActions;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.faq.model.Faq;
import fr.smile.training.faq.service.FaqLocalService;

/**
 * Faqs workflow handler.
 * 
 * @author Guillaume Lenoir
 */
@Component(
	immediate = true, 
	service = WorkflowHandler.class
)
public class FaqWorkflowHandler extends BaseWorkflowHandler<Faq> {

	@Override
	public String getClassName() {

		return Faq.class.getName();
	}

	@Override
	public String getType(Locale locale) {

		return _resourceActions.getModelResource(locale, getClassName());
	}

	@Override
	public Faq updateStatus(
		int status, Map<String, Serializable> workflowContext)
		throws PortalException {

		long userId = GetterUtil.getLong(
			(String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

		long resourcePrimKey = GetterUtil.getLong(
			(String) workflowContext.get(
				WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

		if (_log.isDebugEnabled()) {
			_log.debug(
				"Updating workflow status for faq " + resourcePrimKey);
		}

		ServiceContext serviceContext =
			(ServiceContext) workflowContext.get("serviceContext");

		return _faqLocalService.updateStatus(
			userId, resourcePrimKey, status, serviceContext);
	}

	@Reference
	private FaqLocalService _faqLocalService;

	@Reference
	private ResourceActions _resourceActions;

	private Log _log = LogFactoryUtil.getLog(FaqWorkflowHandler.class);

}
