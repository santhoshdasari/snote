package com.sermon.mynote.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




import com.google.common.collect.Lists;
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
	
	@RequestMapping(value = "/rest/users", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<User> getAllUsers() {	 
		logger.info("Listing contacts");	
		
		List<User> users = userService.findAll();
		return users;
	}
	

	
}
