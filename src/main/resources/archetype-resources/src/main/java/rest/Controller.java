package ${package}.rest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * The purpose of this class is to quickly test the api's once the archtype project is created.
 * 
 * @author Praveen Malla
 *
 */
@RestController
public class Controller {

	private static Logger logger = LoggerFactory.getLogger(Controller.class);

	@Autowired
	Environment env;

	/**
	 * The purpose of this method is to say "Hello ${app-name}".
	 * 
	 * @return "Hello ${app-name}" string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "say hello")
	public String sayHello() {
		return "Hello ${app-name}";
	}

	@RequestMapping(value = "/env", method = RequestMethod.GET)
	@ApiOperation(value = "say hello")
	public Map<String, String> printEnv() {
		Map<String, String> mapEnvVariables = System.getenv();
		logger.info("Environment variables are as follows:");
		mapEnvVariables.forEach((key, value) -> logger.info(key + " = " + value));

		return mapEnvVariables;
	}
}