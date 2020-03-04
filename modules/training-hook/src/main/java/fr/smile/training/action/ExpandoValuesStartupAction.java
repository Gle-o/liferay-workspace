package fr.smile.training.action;

import com.liferay.expando.kernel.exception.NoSuchTableException;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 * 
 * Stop your server, this LifecycleAction will load during the portal startup
 *
 */
@Component(
		immediate = true, property = {
			"key=global.startup.events"
		}, service = LifecycleAction.class
)
public class ExpandoValuesStartupAction implements LifecycleAction {
	/**
	 * The logger
	 */
	private static final Log LOGGER = LogFactoryUtil.getLog(ExpandoValuesStartupAction.class);
	
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		
		// get User test
		// PortalUtil.getCompanyId(lifecycleEvent.getRequest());
		
		// Get default web id from portal.properties
		String webId = PropsUtil.get("company.default.web.id");
		
		try {
			// Get Company id -> virtual instance
			long companyId = CompanyLocalServiceUtil.getCompanyByWebId(webId).getCompanyId();
			
			// Get liferay user
			// Use liferay user service
			// Local est un accès à la base de données sans filtrages des permissions
			// Pas local utilisation du check des permissions
			User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, "test@liferay.com");
			
			// java.lang.RuntimeException: com.liferay.portal.kernel.security.auth.PrincipalException: PermissionChecker not initialized
			// Must initialize one to use user.getExpandoBridge() !!
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user);
			PermissionThreadLocal.setPermissionChecker(checker);

			LOGGER.info("user-type test@liferay.com" + GetterUtil.getString(user.getExpandoBridge().getAttribute("user-type")));

			// Set bad value using Expando api, long and painfull !
			setBadValue(companyId, user);
			
			// Set good finally:) in one line
			// Just take care about PermissionChecker
			// don't need this from portlet ...
			String[] dataGood = {"good"};
			user.getExpandoBridge().setAttribute("user-type", dataGood);
		

		} catch (PortalException e) {
			LOGGER.error("Unable to set user-type for test@liferay.com : " + e.getMessage());
		}
		LOGGER.info("start up");
	}


	/**
	 * Set bad value from current user
	 * 
	 * @param companyId the company id
	 * @param user current user
	 * @throws PortalException 
	 */
	private void setBadValue(long companyId, User user) throws PortalException {
		// Get user class name
		String className = User.class.getName();
		String tableName = ExpandoTableConstants.DEFAULT_TABLE_NAME;
		ExpandoTable expandoTable = addExpandoTable(companyId, className, tableName);
		ExpandoColumn existingEc = addExpandoColumn(companyId, className, tableName, "user-type", expandoTable);
		
		String[] data = {"bad"};
		if (existingEc != null) {
			// –Change the user-type custom field value for the user « test » programmatically at
			// startup
			ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.getValue(expandoTable.getTableId(), existingEc.getColumnId(), user.getUserId());
			if (expandoValue == null) {
				
				expandoValue = ExpandoValueLocalServiceUtil.addValue(companyId, className, tableName, existingEc.getName(), user.getUserId(), data);
			} else {
				expandoValue.setStringArray(data);
				ExpandoValueLocalServiceUtil.updateExpandoValue(expandoValue);
			}
			
			LOGGER.info("test@liferay.com => user-type = " + expandoValue.getData());
		}
	}

	
	/**
	 * add Expando Table 
	 * @param companyId the companyID
	 * @param className class name
	 * @param tableName table name
	 * @return expando table
	 */
	public ExpandoTable addExpandoTable(long companyId, String className, String tableName) {
		ExpandoTable expandoTable = null;
		try {
			expandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(companyId, className);
		} catch (NoSuchTableException nste) {
			try {
				expandoTable = ExpandoTableLocalServiceUtil.addTable(companyId, className, tableName);
			} catch (Exception e) {
				LOGGER.error(e);
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return expandoTable;

	}


	/**
	 * Add expando column
	 * 
	 * @param companyId
	 * @param className
	 * @param tableName
	 * @param columnName
	 * @param expandoTable
	 * @return expando column
	 */
	public ExpandoColumn addExpandoColumn(long companyId, String className, String tableName, String columnName,
			ExpandoTable expandoTable) {
		ExpandoColumn exandoColumn = null;
		try {
			exandoColumn = ExpandoColumnLocalServiceUtil.getColumn(companyId, className, tableName, columnName);
			if (exandoColumn == null) {
				exandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), columnName,
						ExpandoColumnConstants.STRING_ARRAY, new String[]{"good","bad","ugly"});
				UnicodeProperties typeSettings = exandoColumn.getTypeSettingsProperties();
				typeSettings.put(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE, ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_SELECTION_LIST);
				typeSettings.put(ExpandoColumnConstants.PROPERTY_VISIBLE_WITH_UPDATE_PERMISSION, "1");
				typeSettings.put(ExpandoColumnConstants.PROPERTY_HIDDEN, "0");
				
				ExpandoColumnLocalServiceUtil.updateTypeSettings(exandoColumn.getColumnId(), typeSettings.toString());
				
			}

		} catch (SystemException | PortalException e) {
			LOGGER.error(e);
		}
		LOGGER.info("Expando Column==>" + exandoColumn.getColumnId());
		return exandoColumn;
	}

}
