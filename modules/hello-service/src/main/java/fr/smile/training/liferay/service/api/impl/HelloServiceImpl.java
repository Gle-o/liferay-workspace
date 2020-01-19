package fr.smile.training.liferay.service.api.impl;

import fr.smile.training.liferay.service.api.api.HelloService;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(String firstName) {
		return "firstName " + firstName;
	}

	@Override
	public String sayHello(String firstName, String lastname) {
		return "firstName " + firstName + "lastname " + lastname;
	}
	
}
