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
package actions;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.StrutsAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Liferay
 * 
 */
@Component(
	immediate = true,
	property = {
		"path=/portal/advancedweb"
	},
	service = StrutsAction.class
)
public class AdvancedWebStrutsAction implements StrutsAction  {

	public String execute(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		if (_log.isDebugEnabled()) {
			_log.debug("Processing path /c/portal/advancedweb");
		}

		RequestDispatcher requestDispatcher =
			_servletContext.getRequestDispatcher("/advancedwebstrutsaction/html/portal/advancedweb.jsp");

		requestDispatcher.forward(request, response);

		return null;
	}

	@Reference(target = "(osgi.web.symbolicname=fr.smile.training.web.portlet)")
	protected void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AdvancedWebStrutsAction.class);

	private ServletContext _servletContext;

}