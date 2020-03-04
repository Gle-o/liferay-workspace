package fr.smile.training.faq.ws.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLTypeExtension;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import fr.smile.training.faq.ws.dto.v1_0.Faq;
import fr.smile.training.faq.ws.dto.v1_0.Owner;
import fr.smile.training.faq.ws.resource.v1_0.FaqResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.validation.constraints.NotEmpty;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Guillaume Lenoir
 * @generated
 */
@Generated("")
public class Query {

	public static void setFaqResourceComponentServiceObjects(
		ComponentServiceObjects<FaqResource>
			faqResourceComponentServiceObjects) {

		_faqResourceComponentServiceObjects =
			faqResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {faq(faqId: ___){date, id, title}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Faq faq(@GraphQLName("faqId") Long faqId) throws Exception {
		return _applyComponentServiceObjects(
			_faqResourceComponentServiceObjects, this::_populateResourceContext,
			faqResource -> faqResource.getFaq(faqId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {faqOwner(faqId: ___){name}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Owner faqOwner(@GraphQLName("faqId") Long faqId) throws Exception {
		return _applyComponentServiceObjects(
			_faqResourceComponentServiceObjects, this::_populateResourceContext,
			faqResource -> faqResource.getFaqOwner(faqId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {faqs(filter: ___, page: ___, pageSize: ___, search: ___, siteKey: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public FaqPage faqs(
			@GraphQLName("siteKey") @NotEmpty String siteKey,
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_faqResourceComponentServiceObjects, this::_populateResourceContext,
			faqResource -> new FaqPage(
				faqResource.getSiteFaqsPage(
					Long.valueOf(siteKey), search,
					_filterBiFunction.apply(faqResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(faqResource, sortsString))));
	}

	@GraphQLTypeExtension(Faq.class)
	public class GetFaqOwnerTypeExtension {

		public GetFaqOwnerTypeExtension(Faq faq) {
			_faq = faq;
		}

		@GraphQLField
		public Owner owner() throws Exception {
			return _applyComponentServiceObjects(
				_faqResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				faqResource -> faqResource.getFaqOwner(_faq.getId()));
		}

		private Faq _faq;

	}

	@GraphQLName("FaqPage")
	public class FaqPage {

		public FaqPage(Page faqPage) {
			actions = faqPage.getActions();
			items = faqPage.getItems();
			lastPage = faqPage.getLastPage();
			page = faqPage.getPage();
			pageSize = faqPage.getPageSize();
			totalCount = faqPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Faq> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private com.liferay.portal.kernel.model.Company _company;
	private com.liferay.portal.kernel.model.User _user;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private UriInfo _uriInfo;

}