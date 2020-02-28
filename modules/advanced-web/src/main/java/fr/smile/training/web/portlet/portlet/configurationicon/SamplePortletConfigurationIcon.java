package  fr.smile.training.web.portlet.portlet.configurationicon;

import java.util.ResourceBundle;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import org.osgi.service.component.annotations.Component;

import fr.smile.training.web.portlet.constants.AdvancedWebPortletKeys;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.configuration.icon.BasePortletConfigurationIcon;
import com.liferay.portal.kernel.portlet.configuration.icon.PortletConfigurationIcon;
import com.liferay.portal.kernel.util.ResourceBundleUtil;

@Component(
		immediate = true,
		property = "javax.portlet.name=" + AdvancedWebPortletKeys.ADVANCEDWEB,
		service = PortletConfigurationIcon.class
		)
public class SamplePortletConfigurationIcon extends BasePortletConfigurationIcon {

	@Override
	public String getMessage(PortletRequest portletRequest) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
				"content.Language", getLocale(portletRequest), getClass());

		return LanguageUtil.get(resourceBundle, "sample-portlet-icon-link");
	}

	@Override
	public String getURL(
			PortletRequest portletRequest, PortletResponse portletResponse) {

		return "https://www.liferay.com";
	}

	@Override
	public double getWeight() {
		return 150.0;
	}

	@Override
	public boolean isShow(PortletRequest portletRequest) {
		return true;
	}

	@Override
	public boolean isToolTip() {
		return false;
	}

	@Override
	public boolean isUseDialog() {
		return false;
	}

}