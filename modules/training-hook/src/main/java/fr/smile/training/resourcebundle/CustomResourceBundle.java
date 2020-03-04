package fr.smile.training.resourcebundle;

import com.liferay.portal.kernel.language.UTF8Control;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

/**
 * @author Liferay
 * Note: Global language key overrides for multiple locales require a separate module for each locale. Each module’s ResourceBundle extension class (like the MyEnUsResourceBundle class above) must specify its locale in the language.id component property definition and in the language file qualified name parameter. For example, here is what they look like for the Spanish locale.

Component definition:
 */
@Component(
	immediate = true, property = {"language.id=en_US"},
	service = ResourceBundle.class
)
public class CustomResourceBundle extends ResourceBundle {

	@Override
	public Enumeration<String> getKeys() {
		return _resourceBundle.getKeys();
	}
	
	@Override
	protected Object handleGetObject(String key) {
		return _resourceBundle.getObject(key);
	}

	private final ResourceBundle _resourceBundle = ResourceBundle.getBundle(
		"content.Language_en_US", UTF8Control.INSTANCE);

}