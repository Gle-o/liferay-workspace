package fr.smile.training.faq.search;

import com.liferay.portal.kernel.search.BaseSearcher;
import com.liferay.portal.kernel.search.Field;

import org.osgi.service.component.annotations.Component;

import fr.smile.training.faq.model.Faq;

/**
 * @author Luan Maoski
 */
@Component(
	immediate = true,
	property = "model.class.name=fr.smile.training.faq.model.Faq",
	service = BaseSearcher.class
)
public class FaqEntrySearcher extends BaseSearcher {

	public FaqEntrySearcher() {
		setDefaultSelectedFieldNames(
			Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.DESCRIPTION,
			Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
			Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.UID);
		setFilterSearch(true);
		setPermissionAware(true);
	}

	@Override
	public String getClassName() {
		return _CLASS_NAME;
	}

	private static final String _CLASS_NAME = Faq.class.getName();

}