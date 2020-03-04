package fr.smile.training.faq.search.spi.model.index.contributor;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

import fr.smile.training.faq.model.Faq;

/**
 * @author Guillaume Lenoir
 */
@Component(
	immediate = true,
	property = "indexer.class.name=fr.smile.training.faq.model.Faq",
	service = ModelDocumentContributor.class
)
public class FaqModelDocumentContributor
	implements ModelDocumentContributor<Faq> {

	@Override
	public void contribute(Document document, Faq faq) {

		String description = HtmlUtil.extractText(faq.getDescription());

		document.addText(Field.DESCRIPTION, description);
		document.addDate(Field.CREATE_DATE, faq.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, faq.getModifiedDate());
		document.addText(Field.TITLE, faq.getTitle());

		for (Locale locale :
				LanguageUtil.getAvailableLocales(faq.getGroupId())) {

			String languageId = LocaleUtil.toLanguageId(locale);

			document.addText(
				LocalizationUtil.getLocalizedName(Field.TITLE, languageId),
				faq.getTitle());
		}
	}

}