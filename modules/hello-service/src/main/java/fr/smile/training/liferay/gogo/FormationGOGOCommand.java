package fr.smile.training.liferay.gogo;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import fr.smile.training.liferay.service.api.api.HelloService;

/**
 * @author guillaumelenoir
 *
 */
@Component(
		immediate = true,
		property = {
			"osgi.command.scope=formation",
			"osgi.command.function=hello"
		},
		service = Object.class
	)
public class FormationGOGOCommand {

	public HelloService getHelloService() {
		return helloService;
	}

	/**
	 * Reference our HelloService via a @Reference annotation on setter
	 * 
	 * @param helloService hello service from api
	 */
	@Reference
	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}

	/**
	 * Say Hello
	 */
	public void hello() {
		System.out.println(
			"# of Hello : " + helloService.sayHello("test"));
	}

	/**
	 * helloService
	 */
	private HelloService helloService;
}
