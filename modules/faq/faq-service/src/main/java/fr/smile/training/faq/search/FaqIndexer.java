
package fr.smile.training.faq.search;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.faq.model.Faq;
import fr.smile.training.faq.service.FaqLocalService;

/**
 * Faq indexer.
 * 
 * This class is responsible for indexing faqs.
 *  Old !!!!!
 * @author Guillaume Lenoir
 *
 */
//@Component(immediate = true, service = Indexer.class)
public class FaqIndexer extends BaseIndexer<Faq> {

	public FaqIndexer() {

		setDefaultSelectedFieldNames(Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.UID,
				Field.DESCRIPTION);
		setDefaultSelectedLocalizedFieldNames(Field.TITLE);
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {

		return CLASS_NAME;
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK,
			String actionId) throws Exception {

		Faq faq = _faqLocalService.getFaq(entryClassPK);
		return permissionChecker.hasPermission(faq.getGroupId(), Faq.class.getName(), faq.getFaqId(),
				ActionKeys.VIEW);
	}

	@Override
	public boolean isVisible(long classPK, int status) throws Exception {
		Faq entry = _faqLocalService.getFaq(classPK);

		return isVisible(entry.getStatus(), status);
	}

	@Override
	public void postProcessContextBooleanFilter(BooleanFilter contextBooleanFilter, SearchContext searchContext)
			throws Exception {

		addStatus(contextBooleanFilter, searchContext);
	}

	@Override
	protected void doDelete(Faq faq) throws Exception {

		deleteDocument(faq.getCompanyId(), faq.getFaqId());
	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext) throws Exception {

		addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, false);
		addSearchTerm(searchQuery, searchContext, Field.DESCRIPTION, false);
	}

	@Override
	protected Document doGetDocument(Faq faq) throws Exception {

		Document document = getBaseModelDocument(CLASS_NAME, faq);
		document.addLocalizedText(Field.TITLE, faq.getTitleMap());
		document.addText(Field.DESCRIPTION, faq.getDescription());

		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) throws Exception {

		String prefix = Field.SNIPPET + "";
		String title = document.get(prefix + Field.TITLE, Field.TITLE);
		String content = HtmlUtil.stripHtml(document.get(prefix + Field.DESCRIPTION, Field.DESCRIPTION));

		Summary summary = new Summary(title, content);
		summary.setMaxContentLength(200);
		return summary;
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {

		Faq faq = _faqLocalService.getFaq(classPK);
		doReindex(faq);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {

		long companyId = GetterUtil.getLong(ids[0]);
		reindexFaqs(companyId);
	}

	@Override
	protected void doReindex(Faq faq) throws Exception {

		Document document = getDocument(faq);
		_indexWriterHelper.updateDocument(getSearchEngineId(), faq.getCompanyId(), document,
				isCommitImmediately());
	}

	protected void reindexFaqs(long companyId) throws PortalException {

		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = _faqLocalService
				.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);

		// Actionable query
		// https://portal.liferay.dev/docs/7-2/appdev/-/knowledge_base/a/actionable-dynamic-queries

		indexableActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Faq>() {

			@Override
			public void performAction(Faq faq) {

				try {
					Document document = getDocument(faq);
					indexableActionableDynamicQuery.addDocuments(document);
				} catch (PortalException pe) {
					if (_log.isWarnEnabled()) {
						_log.warn("Unable to index faq " + faq.getFaqId(), pe);
					}
				}
			}
		});

		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
	}

	private static final Log _log = LogFactoryUtil.getLog(FaqIndexer.class);

	@Reference
	private FaqLocalService _faqLocalService;

	@Reference
	protected IndexWriterHelper _indexWriterHelper;

	private static final String CLASS_NAME = Faq.class.getName();
}
