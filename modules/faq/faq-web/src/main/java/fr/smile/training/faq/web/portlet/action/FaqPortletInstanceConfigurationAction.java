package fr.smile.training.faq.web.portlet.action;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.faq.web.constants.FaqPortletKeys;

/**
 * Configuration action component (configuration.jsp).
 * 
 * @author liferay
 */
@Component(
	immediate = true, 
	property = {
		"javax.portlet.name=" + FaqPortletKeys.FAQ
	}, 
	service = ConfigurationAction.class
)
public class FaqPortletInstanceConfigurationAction extends DefaultConfigurationAction {

	@Override
	@Reference(target = "(osgi.web.symbolicname=fr.smile.training.faq.web)", unbind = "-")
	public void setServletContext(ServletContext servletContext) {

		super.setServletContext(servletContext);
	}
}
