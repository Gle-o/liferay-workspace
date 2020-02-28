package fr.smile.training.web.portlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.web.portlet.configuration.AdvancedPortletInstanceConfiguration;
import fr.smile.training.web.portlet.configuration.AdvancedPortletInstanceSystemConfiguration;
import fr.smile.training.web.portlet.constants.AdvancedWebPortletKeys;

/**
 * @author guillaumelenoir
 * 
 * https://portal.liferay.dev/docs/7-2/frameworks/-/knowledge_base/f/reading-unscoped-configuration-values-from-an-mvc-portlet
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-javascript=/js/main.js",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=AdvancedWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AdvancedWebPortletKeys.ADVANCEDWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.version=3.0"
	},
	service = Portlet.class
)
public class AdvancedWebPortlet extends MVCPortlet {

	private final static Log LOGGER = LogFactoryUtil.getLog(AdvancedWebPortlet.class);
	
	/**
	 * ConfigurationProvider
	 */
	private ConfigurationProvider _configurationProvider;
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		/*
		* If your configuration is scoped to anything other than SYSTEM, you have two options for reading configuration values
		* Use ConfigurationProvider. This works for any kind of configuration, and is the only way to read configuration values at the COMPANY and GROUP scopes.
		* Use PortletDisplay. This is the recommended approach for configurations at the PORTLET_INSTANCE scope, but only works at that scope.
		*
		*/
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			
			// getPortletInstanceConfiguration
			
			/*
			 * ACCESSING THE PORTLET INSTANCE CONFIGURATION THROUGH THE PORTLETDISPLAY
			 * Often you must access portlet instance settings from a JSP or from a Java class that isn’t an OSGi component.
			 * To read the settings in these cases, a method was added to PortletDisplay,
			 * which is available as a request object. Here is an example of how to use it:
			 * 
			 */
			
			LOGGER.info("themeDisplay.getPortletDisplay().getId()"+ themeDisplay.getPortletDisplay().getId());

			AdvancedPortletInstanceConfiguration advancedPortletInstanceConfiguration = themeDisplay.getPortletDisplay().getPortletInstanceConfiguration(AdvancedPortletInstanceConfiguration.class);
			LOGGER.info("city = " + advancedPortletInstanceConfiguration.city());
			LOGGER.info("autosaveInterval = " + advancedPortletInstanceConfiguration.autosaveInterval());
			LOGGER.info("defaultDisplayView = " + advancedPortletInstanceConfiguration.defaultDisplayView());
			
			renderRequest.setAttribute("city", advancedPortletInstanceConfiguration.city());
			
			//getSystemConfiguration
			
			/*
			 * Used to obtain the configuration for the system scope. These settings are specified by an admin via the System Settings application or with an OSGi configuration file.
			 */
			AdvancedPortletInstanceSystemConfiguration advancedSystemPortletInstanceConfiguration =
			_configurationProvider.getSystemConfiguration(AdvancedPortletInstanceSystemConfiguration.class);
	
			LOGGER.info("planet system = " + advancedSystemPortletInstanceConfiguration.planet());
			
			renderRequest.setAttribute("planet", advancedSystemPortletInstanceConfiguration.planet());
			
		} catch (ConfigurationException ce) {
			LOGGER.error(ce);
		}
		
		super.doView(renderRequest, renderResponse);
	}
	
	
	@Reference(unbind = "-")
	protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
	    _configurationProvider = configurationProvider;
	}
	
	
}