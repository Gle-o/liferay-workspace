
package fr.smile.training.faq.service.permission;

import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import fr.smile.training.faq.model.Faq;
import fr.smile.training.faq.model.FaqModel;

/**
 * Gradebook assignments permission checker interface.
 * 
 * @author liferay
 *
 */
public interface FaqPermissionChecker
	extends ModelResourcePermission<FaqModel> {
	
	public static final String RESOURCE_NAME = Faq.class.getName();
	
	public static final String TOP_LEVEL_RESOURCE =
			Faq.class.getName().substring(
			0, Faq.class.getName().lastIndexOf("."));

	public void check(
		PermissionChecker permissionChecker, long groupId, long assignmentId,
		String actionId)
		throws AuthException;

	public void checkTopLevel(
		PermissionChecker permissionChecker, long groupId, String actionId)
		throws AuthException;

	public boolean contains(
		PermissionChecker permissionChecker, long groupId, long assignmentId,
		String actionId);

	public boolean containsTopLevel(
		PermissionChecker permissionChecker, long groupId, String actionId);
}
