package fr.smile.training.faq.web.portlet;

import fr.smile.training.faq.web.constants.FaqPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Faq",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FaqPortletKeys.FAQ,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.supported-locale=en",
        "javax.portlet.supported-locale=es",
		"javax.portlet.security-role-ref=power-user,user",
        "com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.add-default-resource=true"
	},
	service = Portlet.class
)
public class FaqPortlet extends MVCPortlet {
}