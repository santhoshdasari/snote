package com.sermon.mynote.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sermon.mynote.domain.StatusResponse;
import com.sermon.mynote.domain.User;
import com.sermon.mynote.service.UserService;

/**
 * @author Clarence
 *
 */
@RequestMapping("/userlist")
@Controller
public class UserController {

	final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	MessageSource messageSource;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<User> getAllUsers() {
		logger.info("Listing contacts");

		List<User> users = userService.findAll();
		return users;
	}

	@RequestMapping(value = "/validateUser/{username}/{password}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Integer getValidateUser(@PathVariable String username,
			@PathVariable String password) {
		logger.info("Validating user");

		return userService.validateUser(username, password);

	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody User PostService(@RequestBody User user) {

		System.out.println("user:--" + user.getUserName());
		logger.debug(user.toString());
		User newUser = userService.save(user);

		return newUser;
	}

	@RequestMapping(value = "/addNewUser", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public @ResponseBody void PostServiceAddNewUser(@RequestBody User user) {

		System.out.println("user:--" + user.getUserName());
		logger.debug(user.toString());
		userService.createUser(user.getUserName(), user.getUserEmail(),
				user.getUserPwd());

	}

	/* update */
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateUserFavorite(@RequestBody User user, @PathVariable Long id) {

		User usertemp = userService.findById(id.intValue());
		user = usertemp;

		logger.info("Updating user : " + user);
		userService.save(user);
		logger.info("Contact updated successfully with info: " + userService);
	}

	// update users password
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	@ResponseBody
	public StatusResponse updateUserPassword(@RequestBody User user) {

		int result = userService.updateUserPassword(user.getUserId(),
				user.getUserPwd());

		StatusResponse response = new StatusResponse();

		if (result == 0)
			response.setStatus(true);
		else
			response.setStatus(false);

		return response;
	}

	@RequestMapping(value = "/checkUserNameAvailability/{username}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public StatusResponse checkUserNameAvailability(
			@PathVariable String username) {
		logger.info("check username availability");

		int result = userService.checkUserNameAvailability(username);

		StatusResponse response = new StatusResponse();

		if (result > 0)
			response.setStatus(false);
		else
			response.setStatus(true);

		return response;
	}
	
	
	@RequestMapping(value = "/checkUserEmailAvailability", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public StatusResponse checkUserEmailAvailability(
			@RequestBody User user) {
		logger.info("check username availability");

		int result = userService.checkUserEmailAvailability(user.getUserEmail());

		StatusResponse response = new StatusResponse();

		if (result > 0)
			response.setStatus(false);
		else
			response.setStatus(true);

		return response;
	}


}
