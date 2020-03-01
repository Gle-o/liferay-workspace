package fr.smile.training.faq.service.permission.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.faq.model.Faq;
import fr.smile.training.faq.model.FaqModel;
import fr.smile.training.faq.service.FaqLocalService;
import fr.smile.training.faq.service.permission.FaqPermissionChecker;

/**
 * Faq permission checker implementation.
 * 
 * @author guillaume lenoir
 *
 */
@Component(
		immediate = true,
		property = {
			"model.class.name=fr.smile.training.faq.model.Faq"
		},
		service = FaqPermissionChecker.class 
	)
public class FaqPermissionCheckerImpl implements FaqPermissionChecker {
	
	@Override
	public void check(PermissionChecker permissionChecker, long primaryKey, String actionId) throws PortalException {
		Faq faq = _faFaqLocalService.getFaq(primaryKey);
		check(permissionChecker, faq, actionId);
	}

	@Override
	public void check(PermissionChecker permissionChecker, FaqModel model, String actionId) throws PortalException {
		check(permissionChecker, model.getGroupId(), model.getPrimaryKey(), actionId);
		
	}
	
	@Override
	public void check(PermissionChecker permissionChecker, long groupId, long primaryKey, String actionId)
			throws AuthException {
		
		if (!contains(permissionChecker, groupId, primaryKey, actionId)) {
			throw new AuthException();
		}
		
	}

	@Override
	public boolean contains(PermissionChecker permissionChecker, long primaryKey, String actionId)
			throws PortalException {

		Faq faq = _faFaqLocalService.getFaq(primaryKey);
		return contains(permissionChecker, faq, actionId);
	}

	@Override
	public boolean contains(PermissionChecker permissionChecker, FaqModel model, String actionId)
			throws PortalException {
		return contains(permissionChecker, model.getGroupId(), model.getPrimaryKey(), actionId);
	}
	
	@Override
	public boolean contains(PermissionChecker permissionChecker, long groupId, long primaryKey, String actionId) {
		return permissionChecker.hasPermission(groupId, RESOURCE_NAME, primaryKey, actionId);
	}

	@Override
	public String getModelName() {
		return Faq.class.getName();
	}

	@Override
	public PortletResourcePermission getPortletResourcePermission() {
		// TODO Auto-generated method stub ???
		return null;
	}

	@Override
	public void checkTopLevel(PermissionChecker permissionChecker, long groupId, String actionId) throws AuthException {
		if (!containsTopLevel(permissionChecker, groupId, actionId)) {
			throw new AuthException();
		}
	}

	@Override
	public boolean containsTopLevel(PermissionChecker permissionChecker, long groupId, String actionId) {
		return permissionChecker.hasPermission(groupId, TOP_LEVEL_RESOURCE, groupId, actionId);
	}

	@Reference
	protected FaqLocalService _faFaqLocalService;

}

