package com.jang.fiy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
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
public class UserEditController {

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "messageSource")
	private MessageSource messageSource;

	@ModelAttribute
	public User setUpForm(HttpServletRequest request) {
		// 리퀘스트 url이 들어왔다.

		User user = new User(); // command (전달) 객체 생성

		MessageSourceAccessor accessor = new MessageSourceAccessor(
				this.messageSource);
		user.setM_email(accessor.getMessage("user.userId.default"));
		user.setM_name(accessor.getMessage("user.userName.default"));

		// get이 아니거나 데이터가 없을 경우 기본값 출력
		if (request.getMethod().equalsIgnoreCase("GET")) { // 메소드가 get방식이면 대소문자를
															// 구문하지 말고 실행해라.
			// equalsIgnoreCase = 대소문자를 구분하지 마라.

			String m_email = request.getParameter("m_email"); // userid를 읽어서
															// string userid에 잡아
															// 넣어라.
			try {
				user = this.userService.getUser(m_email); // userid 정보를 이용하여
															// user정보 전체를 읽어옴.
				return user; // 읽어온걸 모델 리퀘스트(리퀘스트메핑)로 넘어간다.
			} catch (EmptyResultDataAccessException e) {
				return user; // 해당 객체를 읽었는대 없으면 여기로 반환됨
			}
		} else {
			return user; // post방식이면 아무것도 수행하지 않고 바로 리퀘스트(리퀘스트메핑)로 넘어간다.
		}

	}

	@RequestMapping(value = "/userEditForm", method = RequestMethod.GET) //userEditForm으로 들어오면 해당 리퀘스트 매핑 클래스를 실행시켜
	public String toUserEditView() {									//모델 어트리뷰트를 실행 한 후 리퀘스트 매핑이 실행된다.
		return "userEdit"; //userEdit로 가는대 전달객체(커멘드객체)를 대리로 가라.(ViewResolver로 가서 나머지 url을 완성 시킴)
	}

	@RequestMapping(value = "/userEdit", method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute @Valid User user,
			BindingResult bindingResult) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView; //벨리데이터로 에러 검증한 후 에러가 없으면 다음으로 넘어감.
		}
		try {
			this.userService.updateUser(user); // user data 수정 //에러가 발생하면 캐치로 넘어감.
			modelAndView.setViewName("userEntrySuccess");//성공화면으로 넘김
			modelAndView.addObject("user", user); //정한한 user객체를 가지고 모델엔 뷰로 보냄
			return modelAndView;
		} catch (DataIntegrityViolationException e) {
			bindingResult.reject("error.duplicate.user"); //트라이 설명의 반대
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
	}
}
