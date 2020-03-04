package fr.smile.training.faq.ws.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import fr.smile.training.faq.ws.dto.v1_0.Faq;
import fr.smile.training.faq.ws.resource.v1_0.FaqResource;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.constraints.NotEmpty;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Guillaume Lenoir
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setFaqResourceComponentServiceObjects(
		ComponentServiceObjects<FaqResource>
			faqResourceComponentServiceObjects) {

		_faqResourceComponentServiceObjects =
			faqResourceComponentServiceObjects;
	}

	@GraphQLField
	public boolean deleteFaq(@GraphQLName("faqId") Long faqId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_faqResourceComponentServiceObjects, this::_populateResourceContext,
			faqResource -> faqResource.deleteFaq(faqId));

		return true;
	}

	@GraphQLField
	public Response deleteFaqBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_faqResourceComponentServiceObjects, this::_populateResourceContext,
			faqResource -> faqResource.deleteFaqBatch(callbackURL, object));
	}

	@GraphQLField(description = "")
	public Faq updateFaq(
			@GraphQLName("faqId") Long faqId, @GraphQLName("faq") Faq faq)
		throws Exception {

		return _applyComponentServiceObjects(
			_faqResourceComponentServiceObjects, this::_populateResourceContext,
			faqResource -> faqResource.putFaq(faqId, faq));
	}

	@GraphQLField
	public Response updateFaqBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_faqResourceComponentServiceObjects, this::_populateResourceContext,
			faqResource -> faqResource.putFaqBatch(callbackURL, object));
	}

	@GraphQLField(description = "")
	public Faq createSiteFaq(
			@GraphQLName("siteKey") @NotEmpty String siteKey,
			@GraphQLName("faq") Faq faq)
		throws Exception {

		return _applyComponentServiceObjects(
			_faqResourceComponentServiceObjects, this::_populateResourceContext,
			faqResource -> faqResource.postSiteFaq(Long.valueOf(siteKey), faq));
	}

	@GraphQLField
	public Response createSiteFaqBatch(
			@GraphQLName("siteKey") @NotEmpty String siteKey,
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_faqResourceComponentServiceObjects, this::_populateResourceContext,
			faqResource -> faqResource.postSiteFaqBatch(
				Long.valueOf(siteKey), callbackURL, object));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(FaqResource faqResource)
		throws Exception {

		faqResource.setContextAcceptLanguage(_acceptLanguage);
		faqResource.setContextCompany(_company);
		faqResource.setContextHttpServletRequest(_httpServletRequest);
		faqResource.setContextHttpServletResponse(_httpServletResponse);
		faqResource.setContextUriInfo(_uriInfo);
		faqResource.setContextUser(_user);
	}

	private static ComponentServiceObjects<FaqResource>
		_faqResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private com.liferay.portal.kernel.model.User _user;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private UriInfo _uriInfo;

}