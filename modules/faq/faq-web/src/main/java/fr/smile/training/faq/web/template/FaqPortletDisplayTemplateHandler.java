
package fr.smile.training.faq.web.template;

import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.portletdisplaytemplate.PortletDisplayTemplateManager;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.faq.model.Faq;
import fr.smile.training.faq.web.constants.FaqPortletKeys;

/**
 * Application Display Template handler class for the Faq.
 * 
 * @see <a
 *      href="https://dev.liferay.com/es/develop/tutorials/-/knowledge_base/7-0/implementing-application-display-templates">Implementing
 *      Application Display Templates tutorial on Liferay Developer Network</a>
 * @author Guillaume Lenoir
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + FaqPortletKeys.FAQ
	},
	service = TemplateHandler.class
)
public class FaqPortletDisplayTemplateHandler
	extends BasePortletDisplayTemplateHandler {

	@Override
	public String getClassName() {

		return Faq.class.getName();
	}

	@Override
	public String getName(Locale locale) {

		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			"content.Language", locale, getClass());

		return resourceBundle.getString("application-display-template-type");
	}

	@Override
	public String getResourceName() {

		return FaqPortletKeys.FAQ;
	}

	@Override
	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
		long classPK, String language, Locale locale)
		throws Exception {

		Map<String, TemplateVariableGroup> templateVariableGroups =
			super.getTemplateVariableGroups(classPK, language, locale);

		TemplateVariableGroup templateVariableGroup =
			templateVariableGroups.get("fields");

		templateVariableGroup.empty();

		String collectionLabel = "faqs";
		String collectionName = PortletDisplayTemplateManager.ENTRIES;
		Class<List> collectionClazz = List.class;

		String itemLabel = "faq";
		Class<Faq> itemClazz = Faq.class;
		String itemName = "currentFaq";
		String itemAccessor = "getTitle(locale)";

		templateVariableGroup.addCollectionVariable(
			collectionLabel, collectionClazz, collectionName, itemLabel,
			itemClazz, itemName, itemAccessor);

		return templateVariableGroups;
	}

	@Override
	protected String getTemplatesConfigPath() {

		return "fr/smile/training/faq/web/template/portlet-display-templates.xml";
	}

	@Reference
	private Portal _portal;
}
