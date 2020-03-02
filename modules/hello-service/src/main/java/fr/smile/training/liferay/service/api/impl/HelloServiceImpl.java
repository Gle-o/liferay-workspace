package fr.smile.training.liferay.service.api.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import fr.smile.training.liferay.service.api.api.HelloService;
import org.osgi.service.component.annotations.Deactivate;

@Component(immediate = true,
		service = HelloService.class)
public class HelloServiceImpl implements HelloService {

	private static final Log _log = LogFactoryUtil.getLog(
			HelloServiceImpl.class);
	@Activate
	public void start(BundleContext bundleContext) throws Exception {
		_log.info("########### Service Registered Successfully ##############");
	}

	@Deactivate
	public void stop(BundleContext bundleContext) throws Exception {
		_log.info("########### Service Unregistered Successfully ##############");
	}

	@Override
	public String sayHello(String firstName) {
		return "firstName " + firstName;
	}

	@Override
	public String sayHello(String firstName, String lastname) {
		return "firstName " + firstName + "lastname " + lastname;
	}
	
}
