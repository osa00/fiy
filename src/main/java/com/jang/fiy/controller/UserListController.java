package com.jang.fiy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jang.fiy.logic.UserService;
import com.jang.fiy.model.User;


@Controller
public class UserListController {

	@Resource(name = "userService")
	private UserService userService;
	
	
	@ModelAttribute
	public User setUpForm(HttpServletRequest request) {
		// 리퀘스트 url이 들어왔다.

		User user = new User(); // command (전달) 객체 생성

		return user;
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(ModelMap model) throws Exception{
		
		List<User> list = this.userService.getAll();
		model.addAttribute("list", list); //"list"-> CardList에서는 list를 "list"라는 이름으로 쓰겠다(바꿀수있음)
		// (= return new ModelAndView("CardList", model))
		return "list"; //view이름
	}
	
}
