package fr.smile.training.liferay.service;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceWrapper;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author guillaumelenoir
 * 
 * Notice that you must specify the fully qualified class name of the service wrapper class that you want to extend.
 * The service argument was used in full in this import statement:
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class MyUserServiceOverride extends UserLocalServiceWrapper {

	private static Log _log = LogFactoryUtil.getLog(MyUserServiceOverride.class);
	
	public MyUserServiceOverride() {
		super(null);
	}
	
	/**
	 * @param userLocalService user service to override
	 * Lastly, you must add the following method to the bottom of your service wrapper,
	 * so it can find the appropriate service it’s overriding on deployment.
	 */
	@Reference(unbind = "-")
	private void serviceSetter(UserLocalService userLocalService) {
	    setWrappedService(userLocalService);
	}

	/*
	 * The generated UserLocalServiceOverride class does not actually customize any Liferay service.
	 * Before you can test that your service wrapper module actually works, you need to override at least one service method.
	 * 
	 */
	@Override
	public User deleteUser(long userId) throws PortalException {
		_log.info("User " + getUser(userId).getScreenName() + " has been deleted.");
		return super.deleteUser(userId);
	}

//	@Override
//	public User getUser(long userId) throws PortalException {
//		_log.info("User " + userId + " from service wrapper.");
//		return super.getUser(userId);
//	}

	@Override
	public User addDefaultAdminUser(long companyId, String screenName, String emailAddress, Locale locale,
			String firstName, String middleName, String lastName) throws PortalException {
		// TODO Auto-generated method stub
		return super.addDefaultAdminUser(companyId, screenName, emailAddress, locale, firstName, middleName, lastName);
	}

	@Override
	public void addDefaultGroups(long userId) throws PortalException {
		// TODO Auto-generated method stub
		super.addDefaultGroups(userId);
	}

	@Override
	public void addDefaultRoles(long userId) throws PortalException {
		// TODO Auto-generated method stub
		super.addDefaultRoles(userId);
	}

	@Override
	public void addDefaultUserGroups(long userId) throws PortalException {
		// TODO Auto-generated method stub
		super.addDefaultUserGroups(userId);
	}

	@Override
	public void addGroupUser(long groupId, long userId) {
		// TODO Auto-generated method stub
		super.addGroupUser(groupId, userId);
	}

	@Override
	public void addGroupUser(long groupId, User user) {
		// TODO Auto-generated method stub
		super.addGroupUser(groupId, user);
	}

	@Override
	public void addGroupUsers(long groupId, List<User> users) throws PortalException {
		// TODO Auto-generated method stub
		super.addGroupUsers(groupId, users);
	}

	@Override
	public void addGroupUsers(long groupId, long[] userIds) throws PortalException {
		// TODO Auto-generated method stub
		super.addGroupUsers(groupId, userIds);
	}

	@Override
	public void addOrganizationUser(long organizationId, long userId) {
		// TODO Auto-generated method stub
		super.addOrganizationUser(organizationId, userId);
	}

	@Override
	public void addOrganizationUser(long organizationId, User user) {
		// TODO Auto-generated method stub
		super.addOrganizationUser(organizationId, user);
	}

	@Override
	public void addOrganizationUsers(long organizationId, List<User> users) throws PortalException {
		// TODO Auto-generated method stub
		super.addOrganizationUsers(organizationId, users);
	}

	@Override
	public void addOrganizationUsers(long organizationId, long[] userIds) throws PortalException {
		// TODO Auto-generated method stub
		super.addOrganizationUsers(organizationId, userIds);
	}

	@Override
	public void addPasswordPolicyUsers(long passwordPolicyId, long[] userIds) {
		// TODO Auto-generated method stub
		super.addPasswordPolicyUsers(passwordPolicyId, userIds);
	}

	@Override
	public void addRoleUser(long roleId, long userId) {
		// TODO Auto-generated method stub
		super.addRoleUser(roleId, userId);
	}

	@Override
	public void addRoleUser(long roleId, User user) {
		// TODO Auto-generated method stub
		super.addRoleUser(roleId, user);
	}

	@Override
	public void addRoleUsers(long roleId, List<User> users) throws PortalException {
		// TODO Auto-generated method stub
		super.addRoleUsers(roleId, users);
	}

	@Override
	public void addRoleUsers(long roleId, long[] userIds) throws PortalException {
		// TODO Auto-generated method stub
		super.addRoleUsers(roleId, userIds);
	}

	@Override
	public void addTeamUser(long teamId, long userId) {
		// TODO Auto-generated method stub
		super.addTeamUser(teamId, userId);
	}

	@Override
	public void addTeamUser(long teamId, User user) {
		// TODO Auto-generated method stub
		super.addTeamUser(teamId, user);
	}

	@Override
	public void addTeamUsers(long teamId, List<User> users) throws PortalException {
		// TODO Auto-generated method stub
		super.addTeamUsers(teamId, users);
	}

	@Override
	public void addTeamUsers(long teamId, long[] userIds) throws PortalException {
		// TODO Auto-generated method stub
		super.addTeamUsers(teamId, userIds);
	}

	@Override
	public User addUser(long creatorUserId, long companyId, boolean autoPassword, String password1, String password2,
			boolean autoScreenName, String screenName, String emailAddress, long facebookId, String openId,
			Locale locale, String firstName, String middleName, String lastName, long prefixId, long suffixId,
			boolean male, int birthdayMonth, int birthdayDay, int birthdayYear, String jobTitle, long[] groupIds,
			long[] organizationIds, long[] roleIds, long[] userGroupIds, boolean sendEmail,
			ServiceContext serviceContext) throws PortalException {
		// TODO Auto-generated method stub
		return super.addUser(creatorUserId, companyId, autoPassword, password1, password2, autoScreenName, screenName,
				emailAddress, facebookId, openId, locale, firstName, middleName, lastName, prefixId, suffixId, male,
				birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail,
				serviceContext);
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return super.addUser(user);
	}

	@Override
	public void addUserGroupUser(long userGroupId, long userId) {
		// TODO Auto-generated method stub
		super.addUserGroupUser(userGroupId, userId);
	}

	@Override
	public void addUserGroupUser(long userGroupId, User user) {
		// TODO Auto-generated method stub
		super.addUserGroupUser(userGroupId, user);
	}

	@Override
	public void addUserGroupUsers(long userGroupId, List<User> users) throws PortalException {
		// TODO Auto-generated method stub
		super.addUserGroupUsers(userGroupId, users);
	}

	@Override
	public void addUserGroupUsers(long userGroupId, long[] userIds) throws PortalException {
		// TODO Auto-generated method stub
		super.addUserGroupUsers(userGroupId, userIds);
	}

	@Override
	public User addUserWithWorkflow(long creatorUserId, long companyId, boolean autoPassword, String password1,
			String password2, boolean autoScreenName, String screenName, String emailAddress, long facebookId,
			String openId, Locale locale, String firstName, String middleName, String lastName, long prefixId,
			long suffixId, boolean male, int birthdayMonth, int birthdayDay, int birthdayYear, String jobTitle,
			long[] groupIds, long[] organizationIds, long[] roleIds, long[] userGroupIds, boolean sendEmail,
			ServiceContext serviceContext) throws PortalException {
		// TODO Auto-generated method stub
		return super.addUserWithWorkflow(creatorUserId, companyId, autoPassword, password1, password2, autoScreenName,
				screenName, emailAddress, facebookId, openId, locale, firstName, middleName, lastName, prefixId, suffixId, male,
				birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds, roleIds, userGroupIds, sendEmail,
				serviceContext);
	}

	@Override
	public int authenticateByEmailAddress(long companyId, String emailAddress, String password,
			Map<String, String[]> headerMap, Map<String, String[]> parameterMap, Map<String, Object> resultsMap)
			throws PortalException {
		// TODO Auto-generated method stub
		return super.authenticateByEmailAddress(companyId, emailAddress, password, headerMap, parameterMap, resultsMap);
	}

	@Override
	public int authenticateByScreenName(long companyId, String screenName, String password,
			Map<String, String[]> headerMap, Map<String, String[]> parameterMap, Map<String, Object> resultsMap)
			throws PortalException {
		// TODO Auto-generated method stub
		return super.authenticateByScreenName(companyId, screenName, password, headerMap, parameterMap, resultsMap);
	}

	@Override
	public int authenticateByUserId(long companyId, long userId, String password, Map<String, String[]> headerMap,
			Map<String, String[]> parameterMap, Map<String, Object> resultsMap) throws PortalException {
		// TODO Auto-generated method stub
		return super.authenticateByUserId(companyId, userId, password, headerMap, parameterMap, resultsMap);
	}

	@Override
	public long authenticateForBasic(long companyId, String authType, String login, String password)
			throws PortalException {
		// TODO Auto-generated method stub
		return super.authenticateForBasic(companyId, authType, login, password);
	}

	@Override
	public long authenticateForDigest(long companyId, String username, String realm, String nonce, String method,
			String uri, String response) throws PortalException {
		// TODO Auto-generated method stub
		return super.authenticateForDigest(companyId, username, realm, nonce, method, uri, response);
	}

	@Override
	public boolean authenticateForJAAS(long userId, String encPassword) {
		// TODO Auto-generated method stub
		return super.authenticateForJAAS(userId, encPassword);
	}

	@Override
	public void checkLockout(User user) throws PortalException {
		// TODO Auto-generated method stub
		super.checkLockout(user);
	}

	@Override
	public void checkLoginFailure(User user) {
		// TODO Auto-generated method stub
		super.checkLoginFailure(user);
	}

	@Override
	public void checkLoginFailureByEmailAddress(long companyId, String emailAddress) throws PortalException {
		// TODO Auto-generated method stub
		super.checkLoginFailureByEmailAddress(companyId, emailAddress);
	}

	@Override
	public void checkLoginFailureById(long userId) throws PortalException {
		// TODO Auto-generated method stub
		super.checkLoginFailureById(userId);
	}

	@Override
	public void checkLoginFailureByScreenName(long companyId, String screenName) throws PortalException {
		// TODO Auto-generated method stub
		super.checkLoginFailureByScreenName(companyId, screenName);
	}

	@Override
	public void checkPasswordExpired(User user) throws PortalException {
		// TODO Auto-generated method stub
		super.checkPasswordExpired(user);
	}

	@Override
	public void clearGroupUsers(long groupId) {
		// TODO Auto-generated method stub
		super.clearGroupUsers(groupId);
	}

	@Override
	public void clearOrganizationUsers(long organizationId) {
		// TODO Auto-generated method stub
		super.clearOrganizationUsers(organizationId);
	}

	@Override
	public void clearRoleUsers(long roleId) {
		// TODO Auto-generated method stub
		super.clearRoleUsers(roleId);
	}

	@Override
	public void clearTeamUsers(long teamId) {
		// TODO Auto-generated method stub
		super.clearTeamUsers(teamId);
	}

	@Override
	public void clearUserGroupUsers(long userGroupId) {
		// TODO Auto-generated method stub
		super.clearUserGroupUsers(userGroupId);
	}

	@Override
	public void completeUserRegistration(User user, ServiceContext serviceContext) throws PortalException {
		// TODO Auto-generated method stub
		super.completeUserRegistration(user, serviceContext);
	}

	@Override
	public User createUser(long userId) {
		// TODO Auto-generated method stub
		return super.createUser(userId);
	}

	@Override
	public KeyValuePair decryptUserId(long companyId, String name, String password) throws PortalException {
		// TODO Auto-generated method stub
		return super.decryptUserId(companyId, name, password);
	}

	@Override
	public void deleteGroupUser(long groupId, long userId) {
		// TODO Auto-generated method stub
		super.deleteGroupUser(groupId, userId);
	}

	@Override
	public void deleteGroupUser(long groupId, User user) {
		// TODO Auto-generated method stub
		super.deleteGroupUser(groupId, user);
	}

	@Override
	public void deleteGroupUsers(long groupId, List<User> users) {
		// TODO Auto-generated method stub
		super.deleteGroupUsers(groupId, users);
	}

	@Override
	public void deleteGroupUsers(long groupId, long[] userIds) {
		// TODO Auto-generated method stub
		super.deleteGroupUsers(groupId, userIds);
	}

	@Override
	public void deleteOrganizationUser(long organizationId, long userId) {
		// TODO Auto-generated method stub
		super.deleteOrganizationUser(organizationId, userId);
	}

	@Override
	public void deleteOrganizationUser(long organizationId, User user) {
		// TODO Auto-generated method stub
		super.deleteOrganizationUser(organizationId, user);
	}

	@Override
	public void deleteOrganizationUsers(long organizationId, List<User> users) {
		// TODO Auto-generated method stub
		super.deleteOrganizationUsers(organizationId, users);
	}

	@Override
	public void deleteOrganizationUsers(long organizationId, long[] userIds) {
		// TODO Auto-generated method stub
		super.deleteOrganizationUsers(organizationId, userIds);
	}

	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel) throws PortalException {
		// TODO Auto-generated method stub
		return super.deletePersistedModel(persistedModel);
	}

	@Override
	public void deletePortrait(long userId) throws PortalException {
		// TODO Auto-generated method stub
		super.deletePortrait(userId);
	}

	@Override
	public void deleteRoleUser(long roleId, long userId) throws PortalException {
		// TODO Auto-generated method stub
		super.deleteRoleUser(roleId, userId);
	}

	@Override
	public void deleteRoleUser(long roleId, User user) throws PortalException {
		// TODO Auto-generated method stub
		super.deleteRoleUser(roleId, user);
	}

	@Override
	public void deleteRoleUsers(long roleId, List<User> users) {
		// TODO Auto-generated method stub
		super.deleteRoleUsers(roleId, users);
	}

	@Override
	public void deleteRoleUsers(long roleId, long[] userIds) {
		// TODO Auto-generated method stub
		super.deleteRoleUsers(roleId, userIds);
	}

	@Override
	public void deleteTeamUser(long teamId, long userId) {
		// TODO Auto-generated method stub
		super.deleteTeamUser(teamId, userId);
	}

	@Override
	public void deleteTeamUser(long teamId, User user) {
		// TODO Auto-generated method stub
		super.deleteTeamUser(teamId, user);
	}

	@Override
	public void deleteTeamUsers(long teamId, List<User> users) {
		// TODO Auto-generated method stub
		super.deleteTeamUsers(teamId, users);
	}

	@Override
	public void deleteTeamUsers(long teamId, long[] userIds) {
		// TODO Auto-generated method stub
		super.deleteTeamUsers(teamId, userIds);
	}

	@Override
	public User deleteUser(User user) throws PortalException {
		// TODO Auto-generated method stub
		return super.deleteUser(user);
	}

	@Override
	public void deleteUserGroupUser(long userGroupId, long userId) throws PortalException {
		// TODO Auto-generated method stub
		super.deleteUserGroupUser(userGroupId, userId);
	}

	@Override
	public void deleteUserGroupUser(long userGroupId, User user) throws PortalException {
		// TODO Auto-generated method stub
		super.deleteUserGroupUser(userGroupId, user);
	}

	@Override
	public void deleteUserGroupUsers(long userGroupId, List<User> users) {
		// TODO Auto-generated method stub
		super.deleteUserGroupUsers(userGroupId, users);
	}

	@Override
	public void deleteUserGroupUsers(long userGroupId, long[] userIds) {
		// TODO Auto-generated method stub
		super.deleteUserGroupUsers(userGroupId, userIds);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		// TODO Auto-generated method stub
		return super.dynamicQuery();
	}

	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
			OrderByComparator<T> orderByComparator) {
		// TODO Auto-generated method stub
		return super.dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start, int end) {
		// TODO Auto-generated method stub
		return super.dynamicQuery(dynamicQuery, start, end);
	}

	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		// TODO Auto-generated method stub
		return super.dynamicQuery(dynamicQuery);
	}

	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery, Projection projection) {
		// TODO Auto-generated method stub
		return super.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		// TODO Auto-generated method stub
		return super.dynamicQueryCount(dynamicQuery);
	}

	@Override
	public String encryptUserId(String name) throws PortalException {
		// TODO Auto-generated method stub
		return super.encryptUserId(name);
	}

	@Override
	public User fetchUser(long userId) {
		// TODO Auto-generated method stub
		return super.fetchUser(userId);
	}

	@Override
	public User fetchUserByContactId(long contactId) {
		// TODO Auto-generated method stub
		return super.fetchUserByContactId(contactId);
	}

	@Override
	public User fetchUserByEmailAddress(long companyId, String emailAddress) {
		// TODO Auto-generated method stub
		return super.fetchUserByEmailAddress(companyId, emailAddress);
	}

	@Override
	public User fetchUserByFacebookId(long companyId, long facebookId) {
		// TODO Auto-generated method stub
		return super.fetchUserByFacebookId(companyId, facebookId);
	}

	@Override
	public User fetchUserByGoogleUserId(long companyId, String googleUserId) {
		// TODO Auto-generated method stub
		return super.fetchUserByGoogleUserId(companyId, googleUserId);
	}

	@Override
	public User fetchUserById(long userId) {
		// TODO Auto-generated method stub
		return super.fetchUserById(userId);
	}

	@Override
	public User fetchUserByOpenId(long companyId, String openId) {
		// TODO Auto-generated method stub
		return super.fetchUserByOpenId(companyId, openId);
	}

	@Override
	public User fetchUserByPortraitId(long portraitId) {
		// TODO Auto-generated method stub
		return super.fetchUserByPortraitId(portraitId);
	}

	@Override
	public User fetchUserByReferenceCode(long companyId, String externalReferenceCode) {
		// TODO Auto-generated method stub
		return super.fetchUserByReferenceCode(companyId, externalReferenceCode);
	}

	@Override
	public User fetchUserByScreenName(long companyId, String screenName) {
		// TODO Auto-generated method stub
		return super.fetchUserByScreenName(companyId, screenName);
	}

	@Override
	public User fetchUserByUuidAndCompanyId(String uuid, long companyId) {
		// TODO Auto-generated method stub
		return super.fetchUserByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		// TODO Auto-generated method stub
		return super.getActionableDynamicQuery();
	}

	@Override
	public List<User> getCompanyUsers(long companyId, int start, int end) {
		// TODO Auto-generated method stub
		return super.getCompanyUsers(companyId, start, end);
	}

	@Override
	public int getCompanyUsersCount(long companyId) {
		// TODO Auto-generated method stub
		return super.getCompanyUsersCount(companyId);
	}

	@Override
	public User getDefaultUser(long companyId) throws PortalException {
		// TODO Auto-generated method stub
		return super.getDefaultUser(companyId);
	}

	@Override
	public long getDefaultUserId(long companyId) throws PortalException {
		// TODO Auto-generated method stub
		return super.getDefaultUserId(companyId);
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(PortletDataContext portletDataContext) {
		// TODO Auto-generated method stub
		return super.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public long[] getGroupPrimaryKeys(long userId) {
		// TODO Auto-generated method stub
		return super.getGroupPrimaryKeys(userId);
	}

	@Override
	public long[] getGroupUserIds(long groupId) {
		// TODO Auto-generated method stub
		return super.getGroupUserIds(groupId);
	}

	@Override
	public List<User> getGroupUsers(long groupId) {
		// TODO Auto-generated method stub
		return super.getGroupUsers(groupId);
	}

	@Override
	public List<User> getGroupUsers(long groupId, int start, int end) throws PortalException {
		// TODO Auto-generated method stub
		return super.getGroupUsers(groupId, start, end);
	}

	@Override
	public List<User> getGroupUsers(long groupId, int status, int start, int end, OrderByComparator<User> obc)
			throws PortalException {
		// TODO Auto-generated method stub
		return super.getGroupUsers(groupId, status, start, end, obc);
	}

	@Override
	public List<User> getGroupUsers(long groupId, int start, int end, OrderByComparator<User> orderByComparator) {
		// TODO Auto-generated method stub
		return super.getGroupUsers(groupId, start, end, orderByComparator);
	}

	@Override
	public List<User> getGroupUsers(long groupId, int status, OrderByComparator<User> obc) throws PortalException {
		// TODO Auto-generated method stub
		return super.getGroupUsers(groupId, status, obc);
	}

	@Override
	public int getGroupUsersCount(long groupId) {
		// TODO Auto-generated method stub
		return super.getGroupUsersCount(groupId);
	}

	@Override
	public int getGroupUsersCount(long groupId, int status) throws PortalException {
		// TODO Auto-generated method stub
		return super.getGroupUsersCount(groupId, status);
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		// TODO Auto-generated method stub
		return super.getIndexableActionableDynamicQuery();
	}

	@Override
	public List<User> getInheritedRoleUsers(long roleId, int start, int end, OrderByComparator<User> obc)
			throws PortalException {
		// TODO Auto-generated method stub
		return super.getInheritedRoleUsers(roleId, start, end, obc);
	}

	@Override
	public List<User> getNoAnnouncementsDeliveries(String type) {
		// TODO Auto-generated method stub
		return super.getNoAnnouncementsDeliveries(type);
	}

	@Override
	public List<User> getNoContacts() {
		// TODO Auto-generated method stub
		return super.getNoContacts();
	}

	@Override
	public List<User> getNoGroups() {
		// TODO Auto-generated method stub
		return super.getNoGroups();
	}

	@Override
	public long[] getOrganizationPrimaryKeys(long userId) {
		// TODO Auto-generated method stub
		return super.getOrganizationPrimaryKeys(userId);
	}

	@Override
	public int getOrganizationsAndUserGroupsUsersCount(long[] organizationIds, long[] userGroupIds) {
		// TODO Auto-generated method stub
		return super.getOrganizationsAndUserGroupsUsersCount(organizationIds, userGroupIds);
	}

	@Override
	public long[] getOrganizationUserIds(long organizationId) {
		// TODO Auto-generated method stub
		return super.getOrganizationUserIds(organizationId);
	}

	@Override
	public List<User> getOrganizationUsers(long organizationId) {
		// TODO Auto-generated method stub
		return super.getOrganizationUsers(organizationId);
	}

	@Override
	public List<User> getOrganizationUsers(long organizationId, int start, int end) throws PortalException {
		// TODO Auto-generated method stub
		return super.getOrganizationUsers(organizationId, start, end);
	}

	@Override
	public List<User> getOrganizationUsers(long organizationId, int status, int start, int end,
			OrderByComparator<User> obc) throws PortalException {
		// TODO Auto-generated method stub
		return super.getOrganizationUsers(organizationId, status, start, end, obc);
	}

	@Override
	public List<User> getOrganizationUsers(long organizationId, int start, int end,
			OrderByComparator<User> orderByComparator) {
		// TODO Auto-generated method stub
		return super.getOrganizationUsers(organizationId, start, end, orderByComparator);
	}

	@Override
	public List<User> getOrganizationUsers(long organizationId, int status, OrderByComparator<User> obc)
			throws PortalException {
		// TODO Auto-generated method stub
		return super.getOrganizationUsers(organizationId, status, obc);
	}

	@Override
	public int getOrganizationUsersCount(long organizationId) {
		// TODO Auto-generated method stub
		return super.getOrganizationUsersCount(organizationId);
	}

	@Override
	public int getOrganizationUsersCount(long organizationId, int status) throws PortalException {
		// TODO Auto-generated method stub
		return super.getOrganizationUsersCount(organizationId, status);
	}

	@Override
	public String getOSGiServiceIdentifier() {
		// TODO Auto-generated method stub
		return super.getOSGiServiceIdentifier();
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj) throws PortalException {
		// TODO Auto-generated method stub
		return super.getPersistedModel(primaryKeyObj);
	}

	@Override
	public long[] getRolePrimaryKeys(long userId) {
		// TODO Auto-generated method stub
		return super.getRolePrimaryKeys(userId);
	}

	@Override
	public long[] getRoleUserIds(long roleId) {
		// TODO Auto-generated method stub
		return super.getRoleUserIds(roleId);
	}

	@Override
	public List<User> getRoleUsers(long roleId) {
		// TODO Auto-generated method stub
		return super.getRoleUsers(roleId);
	}

	@Override
	public List<User> getRoleUsers(long roleId, int start, int end) {
		// TODO Auto-generated method stub
		return super.getRoleUsers(roleId, start, end);
	}

	@Override
	public List<User> getRoleUsers(long roleId, int start, int end, OrderByComparator<User> orderByComparator) {
		// TODO Auto-generated method stub
		return super.getRoleUsers(roleId, start, end, orderByComparator);
	}

	@Override
	public int getRoleUsersCount(long roleId) {
		// TODO Auto-generated method stub
		return super.getRoleUsersCount(roleId);
	}

	@Override
	public int getRoleUsersCount(long roleId, int status) throws PortalException {
		// TODO Auto-generated method stub
		return super.getRoleUsersCount(roleId, status);
	}

	@Override
	public List<User> getSocialUsers(long userId, int socialRelationType, String socialRelationTypeComparator,
			int start, int end, OrderByComparator<User> obc) throws PortalException {
		// TODO Auto-generated method stub
		return super.getSocialUsers(userId, socialRelationType, socialRelationTypeComparator, start, end, obc);
	}

	@Override
	public List<User> getSocialUsers(long userId1, long userId2, int socialRelationType, int start, int end,
			OrderByComparator<User> obc) throws PortalException {
		// TODO Auto-generated method stub
		return super.getSocialUsers(userId1, userId2, socialRelationType, start, end, obc);
	}

	@Override
	public List<User> getSocialUsers(long userId1, long userId2, int start, int end, OrderByComparator<User> obc)
			throws PortalException {
		// TODO Auto-generated method stub
		return super.getSocialUsers(userId1, userId2, start, end, obc);
	}

	@Override
	public int getSocialUsersCount(long userId, int socialRelationType, String socialRelationTypeComparator)
			throws PortalException {
		// TODO Auto-generated method stub
		return super.getSocialUsersCount(userId, socialRelationType, socialRelationTypeComparator);
	}

	@Override
	public int getSocialUsersCount(long userId1, long userId2) throws PortalException {
		// TODO Auto-generated method stub
		return super.getSocialUsersCount(userId1, userId2);
	}

	@Override
	public int getSocialUsersCount(long userId1, long userId2, int socialRelationType) throws PortalException {
		// TODO Auto-generated method stub
		return super.getSocialUsersCount(userId1, userId2, socialRelationType);
	}

	@Override
	public long[] getTeamPrimaryKeys(long userId) {
		// TODO Auto-generated method stub
		return super.getTeamPrimaryKeys(userId);
	}

	@Override
	public List<User> getTeamUsers(long teamId) {
		// TODO Auto-generated method stub
		return super.getTeamUsers(teamId);
	}

	@Override
	public List<User> getTeamUsers(long teamId, int start, int end) {
		// TODO Auto-generated method stub
		return super.getTeamUsers(teamId, start, end);
	}

	@Override
	public List<User> getTeamUsers(long teamId, int start, int end, OrderByComparator<User> orderByComparator) {
		// TODO Auto-generated method stub
		return super.getTeamUsers(teamId, start, end, orderByComparator);
	}

	@Override
	public int getTeamUsersCount(long teamId) {
		// TODO Auto-generated method stub
		return super.getTeamUsersCount(teamId);
	}

	@Override
	public User getUserByContactId(long contactId) throws PortalException {
		// TODO Auto-generated method stub
		return super.getUserByContactId(contactId);
	}

	@Override
	public User getUserByEmailAddress(long companyId, String emailAddress) throws PortalException {
		// TODO Auto-generated method stub
		return super.getUserByEmailAddress(companyId, emailAddress);
	}

	@Override
	public User getUserByFacebookId(long companyId, long facebookId) throws PortalException {
		// TODO Auto-generated method stub
		return super.getUserByFacebookId(companyId, facebookId);
	}

	@Override
	public User getUserByGoogleUserId(long companyId, String googleUserId) throws PortalException {
		// TODO Auto-generated method stub
		return super.getUserByGoogleUserId(companyId, googleUserId);
	}

	@Override
	public User getUserById(long userId) throws PortalException {
		// TODO Auto-generated method stub
		return super.getUserById(userId);
	}

	@Override
	public User getUserById(long companyId, long userId) throws PortalException {
		// TODO Auto-generated method stub
		return super.getUserById(companyId, userId);
	}

	@Override
	public User getUserByOpenId(long companyId, String openId) throws PortalException {
		// TODO Auto-generated method stub
		return super.getUserByOpenId(companyId, openId);
	}

	@Override
	public User getUserByPortraitId(long portraitId) throws PortalException {
		// TODO Auto-generated method stub
		return super.getUserByPortraitId(portraitId);
	}

	@Override
	public User getUserByScreenName(long companyId, String screenName) throws PortalException {
		// TODO Auto-generated method stub
		return super.getUserByScreenName(companyId, screenName);
	}

	@Override
	public User getUserByUuidAndCompanyId(String uuid, long companyId) throws PortalException {
		// TODO Auto-generated method stub
		return super.getUserByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public long[] getUserGroupPrimaryKeys(long userId) {
		// TODO Auto-generated method stub
		return super.getUserGroupPrimaryKeys(userId);
	}

	@Override
	public List<User> getUserGroupUsers(long userGroupId) {
		// TODO Auto-generated method stub
		return super.getUserGroupUsers(userGroupId);
	}

	@Override
	public List<User> getUserGroupUsers(long userGroupId, int start, int end) {
		// TODO Auto-generated method stub
		return super.getUserGroupUsers(userGroupId, start, end);
	}

	@Override
	public List<User> getUserGroupUsers(long userGroupId, int start, int end,
			OrderByComparator<User> orderByComparator) {
		// TODO Auto-generated method stub
		return super.getUserGroupUsers(userGroupId, start, end, orderByComparator);
	}

	@Override
	public int getUserGroupUsersCount(long userGroupId) {
		// TODO Auto-generated method stub
		return super.getUserGroupUsersCount(userGroupId);
	}

	@Override
	public int getUserGroupUsersCount(long userGroupId, int status) throws PortalException {
		// TODO Auto-generated method stub
		return super.getUserGroupUsersCount(userGroupId, status);
	}

	@Override
	public long getUserIdByEmailAddress(long companyId, String emailAddress) throws PortalException {
		// TODO Auto-generated method stub
		return super.getUserIdByEmailAddress(companyId, emailAddress);
	}

	@Override
	public long getUserIdByScreenName(long companyId, String screenName) throws PortalException {
		// TODO Auto-generated method stub
		return super.getUserIdByScreenName(companyId, screenName);
	}

	@Override
	public List<User> getUsers(int start, int end) {
		// TODO Auto-generated method stub
		return super.getUsers(start, end);
	}

	@Override
	public List<User> getUsers(long companyId, boolean defaultUser, int status, int start, int end,
			OrderByComparator<User> obc) {
		// TODO Auto-generated method stub
		return super.getUsers(companyId, defaultUser, status, start, end, obc);
	}

	@Override
	public int getUsersCount() {
		// TODO Auto-generated method stub
		return super.getUsersCount();
	}

	@Override
	public int getUsersCount(long companyId, boolean defaultUser, int status) {
		// TODO Auto-generated method stub
		return super.getUsersCount(companyId, defaultUser, status);
	}

	@Override
	public boolean hasGroupUser(long groupId, long userId) {
		// TODO Auto-generated method stub
		return super.hasGroupUser(groupId, userId);
	}

	@Override
	public boolean hasGroupUsers(long groupId) {
		// TODO Auto-generated method stub
		return super.hasGroupUsers(groupId);
	}

	@Override
	public boolean hasOrganizationUser(long organizationId, long userId) {
		// TODO Auto-generated method stub
		return super.hasOrganizationUser(organizationId, userId);
	}

	@Override
	public boolean hasOrganizationUsers(long organizationId) {
		// TODO Auto-generated method stub
		return super.hasOrganizationUsers(organizationId);
	}

	@Override
	public boolean hasPasswordPolicyUser(long passwordPolicyId, long userId) {
		// TODO Auto-generated method stub
		return super.hasPasswordPolicyUser(passwordPolicyId, userId);
	}

	@Override
	public boolean hasRoleUser(long roleId, long userId) {
		// TODO Auto-generated method stub
		return super.hasRoleUser(roleId, userId);
	}

	@Override
	public boolean hasRoleUser(long companyId, String name, long userId, boolean inherited) throws PortalException {
		// TODO Auto-generated method stub
		return super.hasRoleUser(companyId, name, userId, inherited);
	}

	@Override
	public boolean hasRoleUsers(long roleId) {
		// TODO Auto-generated method stub
		return super.hasRoleUsers(roleId);
	}

	@Override
	public boolean hasTeamUser(long teamId, long userId) {
		// TODO Auto-generated method stub
		return super.hasTeamUser(teamId, userId);
	}

	@Override
	public boolean hasTeamUsers(long teamId) {
		// TODO Auto-generated method stub
		return super.hasTeamUsers(teamId);
	}

	@Override
	public boolean hasUserGroupUser(long userGroupId, long userId) {
		// TODO Auto-generated method stub
		return super.hasUserGroupUser(userGroupId, userId);
	}

	@Override
	public boolean hasUserGroupUsers(long userGroupId) {
		// TODO Auto-generated method stub
		return super.hasUserGroupUsers(userGroupId);
	}

	@Override
	public boolean isPasswordExpired(User user) throws PortalException {
		// TODO Auto-generated method stub
		return super.isPasswordExpired(user);
	}

	@Override
	public boolean isPasswordExpiringSoon(User user) throws PortalException {
		// TODO Auto-generated method stub
		return super.isPasswordExpiringSoon(user);
	}

	@Override
	public User loadGetDefaultUser(long companyId) throws PortalException {
		// TODO Auto-generated method stub
		return super.loadGetDefaultUser(companyId);
	}

	@Override
	public List<User> search(long companyId, String keywords, int status, LinkedHashMap<String, Object> params,
			int start, int end, OrderByComparator<User> obc) {
		// TODO Auto-generated method stub
		return super.search(companyId, keywords, status, params, start, end, obc);
	}

	@Override
	public Hits search(long companyId, String keywords, int status, LinkedHashMap<String, Object> params, int start,
			int end, Sort sort) {
		// TODO Auto-generated method stub
		return super.search(companyId, keywords, status, params, start, end, sort);
	}

	@Override
	public Hits search(long companyId, String keywords, int status, LinkedHashMap<String, Object> params, int start,
			int end, Sort[] sorts) {
		// TODO Auto-generated method stub
		return super.search(companyId, keywords, status, params, start, end, sorts);
	}

	@Override
	public List<User> search(long companyId, String firstName, String middleName, String lastName, String screenName,
			String emailAddress, int status, LinkedHashMap<String, Object> params, boolean andSearch, int start,
			int end, OrderByComparator<User> obc) {
		// TODO Auto-generated method stub
		return super.search(companyId, firstName, middleName, lastName, screenName, emailAddress, status, params, andSearch,
				start, end, obc);
	}

	@Override
	public Hits search(long companyId, String firstName, String middleName, String lastName, String screenName,
			String emailAddress, int status, LinkedHashMap<String, Object> params, boolean andSearch, int start,
			int end, Sort sort) {
		// TODO Auto-generated method stub
		return super.search(companyId, firstName, middleName, lastName, screenName, emailAddress, status, params, andSearch,
				start, end, sort);
	}

	@Override
	public Hits search(long companyId, String firstName, String middleName, String lastName, String screenName,
			String emailAddress, int status, LinkedHashMap<String, Object> params, boolean andSearch, int start,
			int end, Sort[] sorts) {
		// TODO Auto-generated method stub
		return super.search(companyId, firstName, middleName, lastName, screenName, emailAddress, status, params, andSearch,
				start, end, sorts);
	}

	@Override
	public int searchCount(long companyId, String keywords, int status, LinkedHashMap<String, Object> params) {
		// TODO Auto-generated method stub
		return super.searchCount(companyId, keywords, status, params);
	}

	@Override
	public int searchCount(long companyId, String firstName, String middleName, String lastName, String screenName,
			String emailAddress, int status, LinkedHashMap<String, Object> params, boolean andSearch) {
		// TODO Auto-generated method stub
		return super.searchCount(companyId, firstName, middleName, lastName, screenName, emailAddress, status, params,
				andSearch);
	}

	@Override
	public Map<Long, Integer> searchCounts(long companyId, int status, long[] groupIds) {
		// TODO Auto-generated method stub
		return super.searchCounts(companyId, status, groupIds);
	}

	@Override
	public List<User> searchSocial(long userId, int[] socialRelationTypes, String keywords, int start, int end)
			throws PortalException {
		// TODO Auto-generated method stub
		return super.searchSocial(userId, socialRelationTypes, keywords, start, end);
	}

	@Override
	public List<User> searchSocial(long companyId, long[] groupIds, String keywords, int start, int end) {
		// TODO Auto-generated method stub
		return super.searchSocial(companyId, groupIds, keywords, start, end);
	}

	@Override
	public List<User> searchSocial(long companyId, long[] groupIds, String keywords, int start, int end,
			OrderByComparator<User> obc) {
		// TODO Auto-generated method stub
		return super.searchSocial(companyId, groupIds, keywords, start, end, obc);
	}

	@Override
	public List<User> searchSocial(long[] groupIds, long userId, int[] socialRelationTypes, String keywords, int start,
			int end) throws PortalException {
		// TODO Auto-generated method stub
		return super.searchSocial(groupIds, userId, socialRelationTypes, keywords, start, end);
	}

	@Override
	public BaseModelSearchResult<User> searchUsers(long companyId, String keywords, int status,
			LinkedHashMap<String, Object> params, int start, int end, Sort sort) throws PortalException {
		// TODO Auto-generated method stub
		return super.searchUsers(companyId, keywords, status, params, start, end, sort);
	}

	@Override
	public BaseModelSearchResult<User> searchUsers(long companyId, String keywords, int status,
			LinkedHashMap<String, Object> params, int start, int end, Sort[] sorts) throws PortalException {
		// TODO Auto-generated method stub
		return super.searchUsers(companyId, keywords, status, params, start, end, sorts);
	}

	@Override
	public BaseModelSearchResult<User> searchUsers(long companyId, String firstName, String middleName, String lastName,
			String screenName, String emailAddress, int status, LinkedHashMap<String, Object> params, boolean andSearch,
			int start, int end, Sort sort) throws PortalException {
		// TODO Auto-generated method stub
		return super.searchUsers(companyId, firstName, middleName, lastName, screenName, emailAddress, status, params,
				andSearch, start, end, sort);
	}

	@Override
	public BaseModelSearchResult<User> searchUsers(long companyId, String firstName, String middleName, String lastName,
			String screenName, String emailAddress, int status, LinkedHashMap<String, Object> params, boolean andSearch,
			int start, int end, Sort[] sorts) throws PortalException {
		// TODO Auto-generated method stub
		return super.searchUsers(companyId, firstName, middleName, lastName, screenName, emailAddress, status, params,
				andSearch, start, end, sorts);
	}

	@Override
	public void sendEmailAddressVerification(User user, String emailAddress, ServiceContext serviceContext)
			throws PortalException {
		// TODO Auto-generated method stub
		super.sendEmailAddressVerification(user, emailAddress, serviceContext);
	}

	@Override
	public boolean sendPassword(long companyId, String emailAddress, String fromName, String fromAddress,
			String subject, String body, ServiceContext serviceContext) throws PortalException {
		// TODO Auto-generated method stub
		return super.sendPassword(companyId, emailAddress, fromName, fromAddress, subject, body, serviceContext);
	}

	@Override
	public boolean sendPasswordByEmailAddress(long companyId, String emailAddress) throws PortalException {
		// TODO Auto-generated method stub
		return super.sendPasswordByEmailAddress(companyId, emailAddress);
	}

	@Override
	public boolean sendPasswordByScreenName(long companyId, String screenName) throws PortalException {
		// TODO Auto-generated method stub
		return super.sendPasswordByScreenName(companyId, screenName);
	}

	@Override
	public boolean sendPasswordByUserId(long userId) throws PortalException {
		// TODO Auto-generated method stub
		return super.sendPasswordByUserId(userId);
	}

	@Override
	public void setGroupUsers(long groupId, long[] userIds) {
		// TODO Auto-generated method stub
		super.setGroupUsers(groupId, userIds);
	}

	@Override
	public void setOrganizationUsers(long organizationId, long[] userIds) {
		// TODO Auto-generated method stub
		super.setOrganizationUsers(organizationId, userIds);
	}

	@Override
	public void setRoleUsers(long roleId, long[] userIds) throws PortalException {
		// TODO Auto-generated method stub
		super.setRoleUsers(roleId, userIds);
	}

	@Override
	public void setTeamUsers(long teamId, long[] userIds) {
		// TODO Auto-generated method stub
		super.setTeamUsers(teamId, userIds);
	}

	@Override
	public void setUserGroupUsers(long userGroupId, long[] userIds) throws PortalException {
		// TODO Auto-generated method stub
		super.setUserGroupUsers(userGroupId, userIds);
	}

	@Override
	public void unsetGroupTeamsUsers(long groupId, long[] userIds) throws PortalException {
		// TODO Auto-generated method stub
		super.unsetGroupTeamsUsers(groupId, userIds);
	}

	@Override
	public void unsetGroupUsers(long groupId, long[] userIds, ServiceContext serviceContext) throws PortalException {
		// TODO Auto-generated method stub
		super.unsetGroupUsers(groupId, userIds, serviceContext);
	}

	@Override
	public void unsetOrganizationUsers(long organizationId, long[] userIds) throws PortalException {
		// TODO Auto-generated method stub
		super.unsetOrganizationUsers(organizationId, userIds);
	}

	@Override
	public void unsetPasswordPolicyUsers(long passwordPolicyId, long[] userIds) {
		// TODO Auto-generated method stub
		super.unsetPasswordPolicyUsers(passwordPolicyId, userIds);
	}

	@Override
	public void unsetRoleUsers(long roleId, List<User> users) throws PortalException {
		// TODO Auto-generated method stub
		super.unsetRoleUsers(roleId, users);
	}

	@Override
	public void unsetRoleUsers(long roleId, long[] userIds) throws PortalException {
		// TODO Auto-generated method stub
		super.unsetRoleUsers(roleId, userIds);
	}

	@Override
	public void unsetTeamUsers(long teamId, long[] userIds) throws PortalException {
		// TODO Auto-generated method stub
		super.unsetTeamUsers(teamId, userIds);
	}

	@Override
	public void unsetUserGroupUsers(long userGroupId, long[] userIds) throws PortalException {
		// TODO Auto-generated method stub
		super.unsetUserGroupUsers(userGroupId, userIds);
	}

	@Override
	public User updateAgreedToTermsOfUse(long userId, boolean agreedToTermsOfUse) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateAgreedToTermsOfUse(userId, agreedToTermsOfUse);
	}

	@Override
	public void updateAsset(long userId, User user, long[] assetCategoryIds, String[] assetTagNames)
			throws PortalException {
		// TODO Auto-generated method stub
		super.updateAsset(userId, user, assetCategoryIds, assetTagNames);
	}

	@Override
	public User updateCreateDate(long userId, Date createDate) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateCreateDate(userId, createDate);
	}

	@Override
	public User updateEmailAddress(long userId, String password, String emailAddress1, String emailAddress2)
			throws PortalException {
		// TODO Auto-generated method stub
		return super.updateEmailAddress(userId, password, emailAddress1, emailAddress2);
	}

	@Override
	public User updateEmailAddress(long userId, String password, String emailAddress1, String emailAddress2,
			ServiceContext serviceContext) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateEmailAddress(userId, password, emailAddress1, emailAddress2, serviceContext);
	}

	@Override
	public User updateEmailAddressVerified(long userId, boolean emailAddressVerified) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateEmailAddressVerified(userId, emailAddressVerified);
	}

	@Override
	public User updateFacebookId(long userId, long facebookId) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateFacebookId(userId, facebookId);
	}

	@Override
	public User updateGoogleUserId(long userId, String googleUserId) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateGoogleUserId(userId, googleUserId);
	}

	@Override
	public void updateGroups(long userId, long[] newGroupIds, ServiceContext serviceContext) throws PortalException {
		// TODO Auto-generated method stub
		super.updateGroups(userId, newGroupIds, serviceContext);
	}

	@Override
	public User updateIncompleteUser(long creatorUserId, long companyId, boolean autoPassword, String password1,
			String password2, boolean autoScreenName, String screenName, String emailAddress, long facebookId,
			String openId, Locale locale, String firstName, String middleName, String lastName, long prefixId,
			long suffixId, boolean male, int birthdayMonth, int birthdayDay, int birthdayYear, String jobTitle,
			boolean updateUserInformation, boolean sendEmail, ServiceContext serviceContext) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateIncompleteUser(creatorUserId, companyId, autoPassword, password1, password2, autoScreenName,
				screenName, emailAddress, facebookId, openId, locale, firstName, middleName, lastName, prefixId, suffixId, male,
				birthdayMonth, birthdayDay, birthdayYear, jobTitle, updateUserInformation, sendEmail, serviceContext);
	}

	@Override
	public User updateJobTitle(long userId, String jobTitle) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateJobTitle(userId, jobTitle);
	}

	@Override
	public User updateLastLogin(long userId, String loginIP) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateLastLogin(userId, loginIP);
	}

	@Override
	public User updateLockout(User user, boolean lockout) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateLockout(user, lockout);
	}

	@Override
	public User updateLockoutByEmailAddress(long companyId, String emailAddress, boolean lockout)
			throws PortalException {
		// TODO Auto-generated method stub
		return super.updateLockoutByEmailAddress(companyId, emailAddress, lockout);
	}

	@Override
	public User updateLockoutById(long userId, boolean lockout) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateLockoutById(userId, lockout);
	}

	@Override
	public User updateLockoutByScreenName(long companyId, String screenName, boolean lockout) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateLockoutByScreenName(companyId, screenName, lockout);
	}

	@Override
	public User updateModifiedDate(long userId, Date modifiedDate) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateModifiedDate(userId, modifiedDate);
	}

	@Override
	public User updateOpenId(long userId, String openId) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateOpenId(userId, openId);
	}

	@Override
	public void updateOrganizations(long userId, long[] newOrganizationIds, ServiceContext serviceContext)
			throws PortalException {
		// TODO Auto-generated method stub
		super.updateOrganizations(userId, newOrganizationIds, serviceContext);
	}

	@Override
	public User updatePassword(long userId, String password1, String password2, boolean passwordReset)
			throws PortalException {
		// TODO Auto-generated method stub
		return super.updatePassword(userId, password1, password2, passwordReset);
	}

	@Override
	public User updatePassword(long userId, String password1, String password2, boolean passwordReset,
			boolean silentUpdate) throws PortalException {
		// TODO Auto-generated method stub
		return super.updatePassword(userId, password1, password2, passwordReset, silentUpdate);
	}

	@Override
	public User updatePasswordManually(long userId, String password, boolean passwordEncrypted, boolean passwordReset,
			Date passwordModifiedDate) throws PortalException {
		// TODO Auto-generated method stub
		return super.updatePasswordManually(userId, password, passwordEncrypted, passwordReset, passwordModifiedDate);
	}

	@Override
	public User updatePasswordReset(long userId, boolean passwordReset) throws PortalException {
		// TODO Auto-generated method stub
		return super.updatePasswordReset(userId, passwordReset);
	}

	@Override
	public User updatePortrait(long userId, byte[] bytes) throws PortalException {
		// TODO Auto-generated method stub
		return super.updatePortrait(userId, bytes);
	}

	@Override
	public User updateReminderQuery(long userId, String question, String answer) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateReminderQuery(userId, question, answer);
	}

	@Override
	public User updateScreenName(long userId, String screenName) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateScreenName(userId, screenName);
	}

	@Override
	public User updateStatus(long userId, int status, ServiceContext serviceContext) throws PortalException {
		// TODO Auto-generated method stub
		return super.updateStatus(userId, status, serviceContext);
	}

	@Override
	public User updateUser(long userId, String oldPassword, String newPassword1, String newPassword2,
			boolean passwordReset, String reminderQueryQuestion, String reminderQueryAnswer, String screenName,
			String emailAddress, long facebookId, String openId, boolean hasPortrait, byte[] portraitBytes,
			String languageId, String timeZoneId, String greeting, String comments, String firstName, String middleName,
			String lastName, long prefixId, long suffixId, boolean male, int birthdayMonth, int birthdayDay,
			int birthdayYear, String smsSn, String facebookSn, String jabberSn, String skypeSn, String twitterSn,
			String jobTitle, long[] groupIds, long[] organizationIds, long[] roleIds,
			List<UserGroupRole> userGroupRoles, long[] userGroupIds, ServiceContext serviceContext)
			throws PortalException {
		// TODO Auto-generated method stub
		return super.updateUser(userId, oldPassword, newPassword1, newPassword2, passwordReset, reminderQueryQuestion,
				reminderQueryAnswer, screenName, emailAddress, facebookId, openId, hasPortrait, portraitBytes, languageId,
				timeZoneId, greeting, comments, firstName, middleName, lastName, prefixId, suffixId, male, birthdayMonth,
				birthdayDay, birthdayYear, smsSn, facebookSn, jabberSn, skypeSn, twitterSn, jobTitle, groupIds, organizationIds,
				roleIds, userGroupRoles, userGroupIds, serviceContext);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return super.updateUser(user);
	}

	@Override
	public void verifyEmailAddress(String ticketKey) throws PortalException {
		// TODO Auto-generated method stub
		super.verifyEmailAddress(ticketKey);
	}

	@Override
	public UserLocalService getWrappedService() {
		// TODO Auto-generated method stub
		return super.getWrappedService();
	}

	@Override
	public void setWrappedService(UserLocalService userLocalService) {
		// TODO Auto-generated method stub
		super.setWrappedService(userLocalService);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	
	
	


}