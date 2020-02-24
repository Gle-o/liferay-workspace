package fr.smile.training.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import fr.smile.training.web.portlet.constants.AdvancedWebPortletKeys;

@Component(
		service = MVCRenderCommand.class, property = {
				"javax.portlet.name=" + AdvancedWebPortletKeys.ADVANCEDWEB,
				"mvc.command.name=Next" 
		}
)
public class NextPageRenderCommand implements MVCRenderCommand {
	private final static Log LOGGER = LogFactoryUtil.getLog(NextPageRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		LOGGER.info("render next");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String backUrl = "#";
		try {
			backUrl = PortalUtil.getLayoutFullURL(themeDisplay);
		} catch (PortalException e) {
			LOGGER.error(e);
		}
		renderRequest.setAttribute("backUrl", backUrl);
		return "/next.jsp";
	}
}
