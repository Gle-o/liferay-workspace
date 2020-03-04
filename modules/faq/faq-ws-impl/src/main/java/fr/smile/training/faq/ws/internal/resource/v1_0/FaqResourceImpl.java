package fr.smile.training.faq.ws.internal.resource.v1_0;

import fr.smile.training.faq.ws.resource.v1_0.FaqResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Guillaume Lenoir
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/faq.properties",
	scope = ServiceScope.PROTOTYPE, service = FaqResource.class
)
public class FaqResourceImpl extends BaseFaqResourceImpl {
}