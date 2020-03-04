package fr.smile.training.faq.ws.internal.resource.v1_0;

import javax.validation.constraints.NotNull;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import fr.smile.training.faq.service.FaqService;
import fr.smile.training.faq.ws.dto.v1_0.Faq;
import fr.smile.training.faq.ws.resource.v1_0.FaqResource;

/**
 * @author Guillaume Lenoir
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/faq.properties",
	scope = ServiceScope.PROTOTYPE, service = FaqResource.class
)
public class FaqResourceImpl extends BaseFaqResourceImpl {
	
	@Override
	public void deleteFaq(@NotNull Long faqId) throws Exception {
		_faqService.deleteFaq(faqId);
	}

	@Override
	public Faq getFaq(@NotNull Long faqId) throws Exception {
		return _toFaq(_faqService.getFaq(faqId));
	}
	
	private Faq _toFaq(fr.smile.training.faq.model.Faq faq)
			throws Exception {

			Faq appointment = new Faq();

			appointment.setId(faq.getFaqId());
			appointment.setDescription(faq.getDescription());
			appointment.setTitle(
					faq.getTitle(
					contextAcceptLanguage.getPreferredLocale()));

			return appointment;
		}
	
	@Reference
	private FaqService _faqService;
}