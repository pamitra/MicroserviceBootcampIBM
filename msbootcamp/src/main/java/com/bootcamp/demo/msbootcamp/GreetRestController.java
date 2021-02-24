package com.bootcamp.demo.msbootcamp;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetRestController {

	@RequestMapping(path="/greet", method=RequestMethod.GET)
	public String defaultGreeting() {
		return "Hello to bootcamp!";
	}
	
	@RequestMapping(path="/greet/{name}", method=RequestMethod.GET)
	public String greetByName(@PathVariable String name) {
		return "Hello "+name+ " !";
	}
}
