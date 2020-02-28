package fr.smile.training.web.portlet.configuration;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 * his class has one method that returns the class of the configuration interface you created.
 * It enables the system to keep track of configuration changes as they happen,
 * making requests for the configuration very fast.
 *
 */
@Component
public class AdvancedPortletInstanceConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return AdvancedPortletInstanceConfiguration.class;
	}

}
