package fr.smile.training.web.portlet.action;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.PrintWriter;
import java.util.stream.Stream;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import fr.smile.training.web.portlet.constants.AdvancedWebPortletKeys;

/**
 * @author guillaumelenoir
 *
 */
@Component(
		property = {
				"javax.portlet.name=" + AdvancedWebPortletKeys.ADVANCEDWEB,
				"mvc.command.name=/blade/education"
		},
		service = MVCResourceCommand.class
		)
public class EducationMVCResourceCommand extends BaseMVCResourceCommand {


	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand#doServeResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_log.info("Executing serveResource method");

		// get writer for write data
		PrintWriter out = resourceResponse.getWriter();

		// Get name from request
		String name = resourceRequest.getResourceParameters().getValue("name");
		
		JSONArray educationArray = getEducationDetails(name);

		_log.info("Education array size" + educationArray.length());
		out.println(educationArray.toString());
		_log.info("End serveResource method");
	}

	/**
	 * Get array of education degrees and standard name
	 *
	 * @return
	 */
	public static JSONArray getEducationDetails(String name) {
		// just a mock
		_log.info("Executing getEducationDetails method");

		// array to store education names
		JSONArray educationArray = JSONFactoryUtil.createJSONArray();

		int limit = 10;

		_log.info("Education list" + limit);

		Stream.iterate(0, n -> n + 1)
		.limit(limit)
		.forEach(number -> {
			JSONObject educationJSON = JSONFactoryUtil.createJSONObject();
			educationJSON.put("name", "name " + name + number);
			educationJSON.put("education_degrees", "education degree " + number);
			educationArray.put(educationJSON);
		});

		_log.info("End getEducationDetails method");
		return educationArray;
	}

	/**
	 * The logger
	 */
	private static final Log _log = LogFactoryUtil.getLog(
			EducationMVCResourceCommand.class);

}
