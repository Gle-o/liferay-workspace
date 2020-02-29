
package fr.smile.training.faq.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.faq.exception.NoSuchFaqException;
import fr.smile.training.faq.model.Faq;
import fr.smile.training.faq.service.FaqService;
import fr.smile.training.faq.web.constants.FaqPortletKeys;
import fr.smile.training.faq.web.constants.MVCCommandNames;

/**
 * MVC Command for showing edit faq view.
 * 
 * @author liferay
 */
@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + FaqPortletKeys.FAQ,
			"mvc.command.name=" + MVCCommandNames.EDIT_FAQ
	}, 
	service = MVCRenderCommand.class
)
public class EditFaqMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		/*
		Faq faq = null;

		long faqId = ParamUtil.getLong(renderRequest, "faqId", 0);

		if (faqId > 0) {
			try {
				
				// Call the service to get the faq for editing.
				
				faq = _faqService.getFaq(faqId);
			}
			catch (NoSuchFaqException e) {
				_log.error(e);
			}
			catch (PortalException e) {
				_log.error(e);
			}
		}
		
		ThemeDisplay themeDisplay =
			(ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// Set back icon visible.
		
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		portletDisplay.setShowBackIcon(true);

		String redirect = renderRequest.getRenderParameters().getValue("redirect");

		portletDisplay.setURLBack(redirect);

		// Set faq to the request attributes
		
		renderRequest.setAttribute("faq", faq);
		renderRequest.setAttribute("faqClass", Faq.class);
		*/
		return "/faq/edit_faq.jsp";
	}

	@Reference
	private FaqService _faqService;

	private static final Log _log =
		LogFactoryUtil.getLog(EditFaqMVCRenderCommand.class);

}
