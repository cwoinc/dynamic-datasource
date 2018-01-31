package com.wantdo.rest;

import com.wantdo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinxl
 * @version 1.0 on 2018/1/30
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public Object index() {
		return userService.getAll();
	}

	@RequestMapping("/test")
	public Object index2() {
		return userService.getAllTest();
	}

	@RequestMapping("/insert")
	public Object insert(String name) {
		return userService.insert(name);
	}

	@RequestMapping("/inserts")
	public Object inserts(String name) {
		return userService.insertS(name);
	}

}
