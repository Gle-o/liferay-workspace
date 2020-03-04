
package fr.smile.training.faq.validation;

import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import fr.smile.training.faq.exception.FaqValidationException;

public class FaqValidator {

	/**
	 * Returns <code>true</code> if the given fields are valid for an
	 * faq.
	 * 
	 * @param titleMap
	 * @param description
	 * @param dueDate
	 * @param errors
	 * @return boolean <code>true</code> if faq is valid, otherwise
	 *         <code>false</code>
	 */
	public static boolean isFaqValid(
		final Map<Locale, String> titleMap, final String description,
		final List<String> errors) {

		boolean result = true;

		result &= isTitleValid(titleMap, errors);
		result &= isDescriptionValid(description, errors);

		return result;
	}

	/**
	 * Returns <code>true</code> if description is valid for an faq. If
	 * not valid, an error message is added to the errors list.
	 * 
	 * @param description
	 * @param errors
	 * @return boolean <code>true</code> if description is valid, otherwise
	 *         <code>false</code>
	 */
	public static boolean isDescriptionValid(
		final String description, final List<String> errors) {

		boolean result = true;

		if (Validator.isBlank(HtmlUtil.stripHtml(description))) {
			errors.add("error.faq-description-empty");
			result = false;
		}

		return result;
	}

	/**
	 * Returns <code>true</code> if title is valid for an faq. If not
	 * valid, an error message is added to the errors list.
	 * 
	 * @param titleMap
	 * @param errors
	 * @return boolean <code>true</code> if the title is valid, otherwise
	 *         <code>false</code>
	 */
	public static boolean isTitleValid(
		final Map<Locale, String> titleMap, final List<String> errors) {

		boolean result = true;

		// verify the map has something

		if (MapUtil.isEmpty(titleMap)) {
			errors.add("error.faq-title-empty");
			result = false;
		}
		else {

			// get the default locale

			Locale defaultLocale = LocaleUtil.getSiteDefault();

			result = isTitleValid(titleMap.get(defaultLocale), errors);
		}

		// get the default title string

		return result;
	}

	/**
	 * Returns <code>true</code> if title is valid for an faq.
	 * 
	 * @param title
	 * @param errors
	 * @return boolean <code>true</code> if title is valid, otherwise
	 *         <code>false</code>
	 */
	public static boolean isTitleValid(
		final String title, final List<String> errors) {

		boolean result = true;

		if ((Validator.isBlank(title))) {
			errors.add("error.faq-title-empty");
			result = false;
		}

		return result;
	}

	/**
	 * Validates faq values and throws
	 * {FaqValidationExceptionException} if the faq values are not
	 * valid.
	 * 
	 * @param titleMap
	 * @param description
	 * @param dueDate
	 * @throws FaqValidationExceptionException
	 */
	public static void validate(
		Map<Locale, String> titleMap, String description)
		throws FaqValidationException {

		List<String> errors = new ArrayList<>();
		if (!isFaqValid(titleMap, description, errors)) {
			throw new FaqValidationException(errors);
		}
	}
}
