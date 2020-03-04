package fr.smile.training.faq.ws.resource.v1_0;

import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import fr.smile.training.faq.ws.dto.v1_0.Faq;
import fr.smile.training.faq.ws.dto.v1_0.Owner;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.annotation.versioning.ProviderType;

/**
 * To access this resource, run:
 *
 *     curl -u your@email.com:yourpassword -D - http://localhost:8080/o/faqs/v1.0
 *
 * @author Guillaume Lenoir
 * @generated
 */
@Generated("")
@ProviderType
public interface FaqResource {

	public void deleteFaq(Long faqId) throws Exception;

	public Faq getFaq(Long faqId) throws Exception;

	public Faq putFaq(Long faqId, Faq faq) throws Exception;

	public Owner getFaqOwner(Long faqId) throws Exception;

	public Page<Faq> getSiteFaqsPage(
			Long siteId, String search, Filter filter, Pagination pagination,
			Sort[] sorts)
		throws Exception;

	public Faq postSiteFaq(Long siteId, Faq faq) throws Exception;

	public default void setContextAcceptLanguage(
		AcceptLanguage contextAcceptLanguage) {
	}

	public void setContextCompany(Company contextCompany);

	public default void setContextHttpServletRequest(
		HttpServletRequest contextHttpServletRequest) {
	}

	public default void setContextHttpServletResponse(
		HttpServletResponse contextHttpServletResponse) {
	}

	public default void setContextUriInfo(UriInfo contextUriInfo) {
	}

	public void setContextUser(User contextUser);

}