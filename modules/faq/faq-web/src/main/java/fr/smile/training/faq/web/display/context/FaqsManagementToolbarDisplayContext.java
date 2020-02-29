package fr.smile.training.faq.web.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItemList;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Objects;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import fr.smile.training.faq.service.permission.FaqPermissionChecker;
import fr.smile.training.faq.web.constants.FaqPortletKeys;
import fr.smile.training.faq.web.constants.MVCCommandNames;

/**
 * Assigments management toolbar display context. 
 * 
 * This class passes contextual information to the user interface 
 * for the Clay management toolbar.
 * 
 * @author liferay
 */
public class FaqsManagementToolbarDisplayContext {

	public FaqsManagementToolbarDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		HttpServletRequest request,
		FaqPermissionChecker faqPermissionChecker) {

		_faqPermissionChecker = faqPermissionChecker;
		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_request = request;
		_currentURLObj = PortletURLUtil.getCurrent(
			liferayPortletRequest, _liferayPortletResponse);

		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
			liferayPortletRequest);
	}

	/**
	 * Returns the creation menu for the toolbar 
	 * (plus sign on the management toolbar).
	 * 
	 * @return creation menu
	 */
	public CreationMenu getCreationMenu() {

		ThemeDisplay themeDisplay =
			(ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);

		// Check if user has permissions to add faqs.

		if (!_faqPermissionChecker.containsTopLevel(
			themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(),
			"ADD_FAQ")) {

			return null;
		}

		// Create the menu.

		CreationMenu creationMenu = new CreationMenu();

		creationMenu.addDropdownItem(dropdownItem -> {
			dropdownItem.setHref(
				_liferayPortletResponse.createRenderURL(),
				"mvcRenderCommandName", MVCCommandNames.EDIT_FAQ,
				"redirect", _currentURLObj.toString());
			dropdownItem.setLabel(LanguageUtil.get(_request, "add-faq"));
		});

		return creationMenu;
	}

	/**
	 * Returns the faq list display style. 
	 * 
	 * Current selection is stored in portal preferences.
	 * 
	 * @return current display style
	 */
	public String getDisplayStyle() {

		String displayStyle = ParamUtil.getString(_request, "displayStyle");

		if (Validator.isNull(displayStyle)) {
			displayStyle = _portalPreferences.getValue(
					FaqPortletKeys.FAQ, "faqs-display-style",
				"icon");
		}
		else {
			_portalPreferences.setValue(
					FaqPortletKeys.FAQ, "faqs-display-style",
				displayStyle);

			_request.setAttribute(
				WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);
		}

		return displayStyle;
	}

	/**
	 * Returns the filter menu options.
	 * 
	 * @return menu options list
	 */
	public List<DropdownItem> getFilterDropdownItems() {

		return new DropdownItemList() {

			{
				addGroup(dropdownGroupItem -> {
					dropdownGroupItem.setDropdownItems(
						_getOrderByDropdownItems());
					dropdownGroupItem.setLabel(
						LanguageUtil.get(_request, "order-by"));
				});
			}
		};
	}

	/**
	 * Returns the sort order column.
	 * 
	 * @return sort column
	 */
	public String getOrderByCol() {

		return ParamUtil.getString(_request, "orderByCol", "title");
	}

	/**
	 * Returns the sort type (ascending / descending).
	 * 
	 * @return sort type
	 */
	public String getOrderByType() {

		return ParamUtil.getString(_request, "orderByType", "desc");
	}

	/**
	 * Returns the action URL for the search.
	 * 
	 * @return search action URL
	 */
	public String getSearchActionURL() {

		PortletURL searchURL = _liferayPortletResponse.createRenderURL();

		searchURL.setProperty(
			"mvcRenderCommandName", MVCCommandNames.VIEW_FAQS);

		searchURL.setParameter("orderByCol", getOrderByCol());
		searchURL.setParameter("orderByType", getOrderByType());

		return searchURL.toString();
	}

	/**
	 * Returns sorting URL.
	 * 
	 * @return sorting URL
	 * @throws PortletException
	 */
	public PortletURL getSortingURL()
		throws PortletException {

		PortletURL sortingURL = _getCurrentSortingURL();

		sortingURL.setParameter(
			"orderByType",
			Objects.equals(getOrderByType(), "asc") ? "desc" : "asc");

		return sortingURL;
	}

	/**
	 * Returns the view type options (card, list, table).
	 * 
	 * @return list of view types
	 */
	public ViewTypeItemList getViewTypes() {

		// Create portlet URL and set parameters.

		PortletURL portletURL = _liferayPortletResponse.createRenderURL();

		portletURL.setParameter(
			"mvcRenderCommandName", MVCCommandNames.VIEW_FAQS);

		int delta =
			ParamUtil.getInteger(_request, SearchContainer.DEFAULT_DELTA_PARAM);

		if (delta > 0) {
			portletURL.setParameter("delta", String.valueOf(delta));
		}

		String orderByCol =
			ParamUtil.getString(_request, "orderByCol", "title");
		String orderByType =
			ParamUtil.getString(_request, "orderByType", "asc");

		portletURL.setParameter("orderBycol", orderByCol);
		portletURL.setParameter("orderByType", orderByType);

		int cur =
			ParamUtil.getInteger(_request, SearchContainer.DEFAULT_CUR_PARAM);

		if (cur > 0) {
			portletURL.setParameter("cur", String.valueOf(cur));
		}

		return new ViewTypeItemList(portletURL, getDisplayStyle()) {

			{
				addCardViewTypeItem();

				addListViewTypeItem();

				addTableViewTypeItem();
			}

		};
	}

	/**
	 * Returns the current sorting URL.
	 * 
	 * @return current sorting portlet URL
	 * 
	 * @throws PortletException
	 */
	private PortletURL _getCurrentSortingURL()
		throws PortletException {

		PortletURL sortingURL =
			PortletURLUtil.clone(_currentURLObj, _liferayPortletResponse);

		sortingURL.setParameter(
			"mvcRenderCommandName", MVCCommandNames.VIEW_FAQS);

		// Reset current page.
		
		sortingURL.setParameter(SearchContainer.DEFAULT_CUR_PARAM, "0");

		String keywords = ParamUtil.getString(_request, "keywords");

		if (Validator.isNotNull(keywords)) {
			sortingURL.setParameter("keywords", keywords);
		}

		return sortingURL;
	}

	/**
	 * Return the option items for the sort column menu.
	 * 
	 * @return options list for the sort column menu
	 */
	private List<DropdownItem> _getOrderByDropdownItems() {

		return new DropdownItemList() {

			{
				add(dropdownItem -> {
					dropdownItem.setActive("title".equals(getOrderByCol()));
					dropdownItem.setHref(
						_getCurrentSortingURL(), "orderByCol", "title");
					dropdownItem.setLabel(LanguageUtil.get(_request, "title"));
				});

				add(dropdownItem -> {
					dropdownItem.setActive(
						"createDate".equals(getOrderByCol()));
					dropdownItem.setHref(
						_getCurrentSortingURL(), "orderByCol", "createDate");
					dropdownItem.setLabel(
						LanguageUtil.get(_request, "create-date"));
				});
			}
		};
	}

	private final FaqPermissionChecker _faqPermissionChecker;
	private final PortletURL _currentURLObj;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;
	private final HttpServletRequest _request;
}
