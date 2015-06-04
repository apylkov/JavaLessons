package com.rs.mvis;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController
{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private Map<String, User> users = new HashMap<String, User>();

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model)
	{
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.ENGLISH);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("users", users);

		return "home";
	}

	@RequestMapping(value = "/healthcheck", produces = "application/json", method = { RequestMethod.GET })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ModelMap healthcheck()
	{
		long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

		ModelMap map = new ModelMap();
		map.put("Status", "Ok");
		map.put("Memory Used(bytes)", memoryUsed);
		return map;
	}

	@RequestMapping(value = "/users", produces = "application/json", method = { RequestMethod.POST })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody OperationStatus addUser(@RequestBody User user)
	{
		if (users.get(user.getName()) != null)
		{
			return new OperationStatus("Failed");
		}
		users.put(user.getName(), user);
		return new OperationStatus("Success");
	}

	@RequestMapping(value = "/users/{name}", produces = "application/json", method = { RequestMethod.GET })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody User getUser(@PathVariable("name") String name)
	{
		if (users.get(name) != null)
		{
			return users.get(name);
		}
		return null;
	}

	@RequestMapping(value = "/users/{name}", produces = "application/json", method = { RequestMethod.POST })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody OperationStatus changeUser(@PathVariable("name") String name, @RequestBody User user)
	{
		User existUser = users.get(name);
		if (existUser != null)
		{
			existUser.setDescription(user.getDescription());
			existUser.setPwd(user.getPwd());
			return new OperationStatus("User has been changed");
		}
		return new OperationStatus("Such user " + name + " does not exist");
	}
}
