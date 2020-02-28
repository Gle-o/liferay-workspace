package fr.smile.training.web.portlet.portlet.configuration;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.web.portlet.configuration.AdvancedPortletInstanceConfiguration;
import fr.smile.training.web.portlet.configuration.AdvancedPortletInstanceSystemConfiguration;
import fr.smile.training.web.portlet.constants.AdvancedWebPortletKeys;

/**
 * @author guillaumelenoir
 *
 */
@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AdvancedWebPortletKeys.ADVANCEDWEB,
		},
		service = ConfigurationAction.class
)
public class AdvancedPortletConfigurationAction  extends DefaultConfigurationAction {

	/**
	 * The logger
	 */
	protected static Log LOGGER = LogFactoryUtil.getLog(AdvancedPortletConfigurationAction.class);
	
	/**
	 * ConfigurationProvider
	 */
	private ConfigurationProvider _configurationProvider;
	
	
	@Override
	public void include(PortletConfig portletConfig, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		// Init city from AdvancedPortletInstanceConfiguration
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			AdvancedPortletInstanceConfiguration advancedPortletInstanceConfiguration = themeDisplay.getPortletDisplay().getPortletInstanceConfiguration(AdvancedPortletInstanceConfiguration.class);
			LOGGER.info("city = " + advancedPortletInstanceConfiguration.city());

			request.setAttribute("advancedPortletInstanceConfiguration", advancedPortletInstanceConfiguration);
			
			/*
			 * Used to obtain the configuration for the system scope. These settings are specified by an admin via the System Settings application or with an OSGi configuration file.
			 */
			AdvancedPortletInstanceSystemConfiguration advancedSystemPortletInstanceConfiguration =
			_configurationProvider.getSystemConfiguration(AdvancedPortletInstanceSystemConfiguration.class);
	
			LOGGER.info("planet system = " + advancedSystemPortletInstanceConfiguration.planet());
			
			request.setAttribute("advancedSystemPortletInstanceConfiguration", advancedSystemPortletInstanceConfiguration);

		} catch (ConfigurationException e) {
			LOGGER.error(e);
		}
		super.include(portletConfig, request, response);
	}

	@Reference(unbind = "-")
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
	    _configurationProvider = configurationProvider;
	}
}
