package fr.smile.training.liferay.service.hello.module;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import fr.smile.training.liferay.service.api.api.HelloService;
import fr.smile.training.liferay.service.api.impl.HelloServiceImpl;

/**
 * @author guillaumelenoir
 */
public class HelloActivator implements BundleActivator {

	/**
	 * https://portal.liferay.dev/docs/7-1/tutorials/-/knowledge_base/t/implementing-logging
	 * https://portal.liferay.dev/docs/7-0/tutorials/-/knowledge_base/t/configuring-dependencies
	 * https://www.sitepoint.com/how-to-inject-osgi-dependencies-in-custom-portlets-in-liferay-7/
	 * 
	 */
	private static final Log _log = LogFactoryUtil.getLog(
			HelloActivator.class);

	@SuppressWarnings("rawtypes")
	private ServiceRegistration _serviceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		_serviceRegistration = bundleContext.registerService(HelloService.class, new HelloServiceImpl(), null);
		_log.info("########### Service Registered Successfully ##############");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		_serviceRegistration.unregister();
		_serviceRegistration = null;
		_log.info("########### Service Unregistered ##############");
	}

}