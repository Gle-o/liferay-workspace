package fr.smile.training.web.portlet.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(
	    category = "training",
	    scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
/*
 * Meta.OCD: Registers this class as a configuration with a specific id.
 * The ID must be the fully qualified configuration class name.
 */
@Meta.OCD(
		id = "fr.smile.training.web.portlet.configuration.AdvancedPortletInstanceSystemConfiguration",
		localization = "content/Language", 
		name = "advanced-portlet-web-system-configuration"
		)
public interface AdvancedPortletInstanceSystemConfiguration {

	/*
	 * Meta.AD: Specifies optional metadata about the field, such as whether it’s a required field or if it has a default value.
	 * Note that if you set a field as required and don’t specify a default value, the system administrator must specify a value in order for your application to work properly.
	 * Use the deflt property to specify a default value.
	 */
	@Meta.AD(
			deflt = "terre", required = false
			)
	public String planet();
}
