package fr.smile.training.web.portlet.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author guillaumelenoir
 * 
 * When you register a configuration interface, a UI is auto-generated for it in System Settings → Platform → Third Party.
 * That’s the default location; read the next section to learn how to move it somewhere more intuitive.
 * 
 * Note: The annotations @Meta.OCD and @Meta.AD are part of the bnd library, but as of OSGi standard version R6, they’re included in the OSGi core under the names @ObjectClassDefinition and @AttributeDefinition.
 * The OSGi annotations can be used for simple cases like the one described in this tutorial.
 * However, a key difference between the two libraries is that the bnd annotations are available at runtime, while the OSGi annotations are not.
 * Because runtime availability is necessary for some of the Liferay-specific features described below, we recommend defaulting to the bnd annotations.
 */

@ExtendedObjectClassDefinition(
	    category = "training",
	    scope = ExtendedObjectClassDefinition.Scope.PORTLET_INSTANCE
)
/*
 * Meta.OCD: Registers this class as a configuration with a specific id.
 * The ID must be the fully qualified configuration class name.
 */
@Meta.OCD(
		id = "fr.smile.training.web.portlet.configuration.AdvancedPortletInstanceConfiguration",
		localization = "content/Language", 
		name = "advanced-portlet-web-configuration"
		)
public interface AdvancedPortletInstanceConfiguration {

	/*
	 * Meta.AD: Specifies optional metadata about the field, such as whether it’s a required field or if it has a default value.
	 * Note that if you set a field as required and don’t specify a default value, the system administrator must specify a value in order for your application to work properly.
	 * Use the deflt property to specify a default value.
	 */
	@Meta.AD(
			deflt = "Lille", required = false
			)
	public String city();

	@Meta.AD(
			deflt = "1", description = "autosave-interval-description",
			name = "autosave-interval-name", required = false
			)
	public int autosaveInterval();

	@Meta.AD(
			deflt = "descriptive", name = "default-display-view",
			optionLabels = {"Descriptive", "List"},
			optionValues = {"descriptive", "list"}, required = false
			)
	public String defaultDisplayView();
	
	


}
