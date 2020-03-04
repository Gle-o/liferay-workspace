/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.smile.training.action;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import javax.servlet.http.HttpServletRequest;

/**
 * @author guillaumelenoir
 *
 */
@Component(
	immediate = true,
	property = {
		"key=login.events.pre"
	},
	service = LifecycleAction.class
)
public class LogUserLoginAction implements LifecycleAction {

	private static final Log _log = LogFactoryUtil.getLog(LogUserLoginAction.class);
	
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException {
		
		// Get user
		HttpServletRequest httpServletRequest =  lifecycleEvent.getRequest();
		Optional<User> user = Optional.empty();
		
		try {
			// Use portal Util, convenient way to get user
			user =  Optional.of(PortalUtil.getUser(httpServletRequest));
		} catch (PortalException e) {
			_log.error("PortalException unable to get current user ");
		}
		
		_log.info("Login Pre Action lifecycleEvent " + lifecycleEvent);
		_log.info("User is " + user.orElse(null));
		
	}

}