package com.jang.fiy.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jang.fiy.logic.UserService;
import com.jang.fiy.model.User;
	
@Controller
public class FindPassController {
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping(value = "/findPassform", method = RequestMethod.GET)
	public String toFindIdView() {
		return "findPass"; // findPass.jsp실행
	}
	
	@ModelAttribute("user")
	public User setUpForm() {
		return new User();
	}
	
	@RequestMapping(value = "/findPass", method = RequestMethod.POST)
	public ModelAndView onSubmit(@Valid @ModelAttribute("user") User user/*
																		 * 폼에있는
																		 * USER내용을
																		 * 불러온다
																		 */,
			BindingResult bindingResult/* 에러메시지를 불러온다 */) {

		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasFieldErrors("m_email") || bindingResult.hasFieldErrors("m_name")) 
		{ 													// id이나 email이
															// 입력되지않은 경우
			modelAndView.getModel().putAll(bindingResult.getModel());

			return modelAndView;
		}

		try {

			User findPass = this.userService.getUserPass(user.getM_email(), user.getM_name());

			modelAndView.setViewName("findPassSuccess");
			modelAndView.addObject("findPass", findPass);
			modelAndView.addObject("EMAIL", user.getM_email());
			return modelAndView;

		} catch (EmptyResultDataAccessException e) { // 이름과 이메일이 입력되었으나 틀린 경우

			bindingResult.reject("error.find.user");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}

	}
}
