package com.jang.fiy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jang.fiy.logic.UserService;
import com.jang.fiy.model.User;

@Controller
public class UserEntryController {

	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "messageSource")
	private MessageSource messageSource;

	@ModelAttribute
	public User setUpForm(HttpServletRequest request) {

		User user = new User();

		return user;
	}

	@RequestMapping(value = "/userEntryForm", method = RequestMethod.GET)
	public String toUserEntryView() {
		return "userEntry";
	}
	
	@RequestMapping(value = "/userEntry", method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute @Valid User user,
			BindingResult bindingResult) throws Exception {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView; // ���������ͷ� ���� ������ �� ������ ������ �������� �Ѿ.
		}
		try {
			this.userService.insertUser(user); // user data ���� //������ �߻��ϸ� ĳġ��
												// �Ѿ.
			modelAndView.setViewName("userEntrySuccess");// ����ȭ������ �ѱ�
			modelAndView.addObject("user", user); // ������ user��ü�� ������ �𵨿� ��� ����
			return modelAndView;
		} catch (DataIntegrityViolationException e) {
			bindingResult.reject("error.duplicate.user"); // Ʈ���� ������ �ݴ�
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
	}
	
	// ******id중복검사호출시**********
	@RequestMapping(value = "/checkemailBean", method = RequestMethod.GET) //checkidBean으로 url이 들어오면 다음 클래스를 실행 한다.
	public String checkid(
			@RequestParam(value = "m_email", required = false, defaultValue = "0") String m_email,
			ModelMap model) throws Exception { //@RequestParam을 사용 하여 id값을 불러와 선헌된 String형태의 id객체 변수에 넣어준다.

		System.out.println("컨트롤러 채크 email: " + m_email);

		ModelAndView modelAndView = new ModelAndView(); //ModelAndView 객체 생성
		try {
			int checknum = this.userService.checkemail(m_email);
			//userDao에 String checkID = "select count(*) from member_tbl where id=?";를 실행하여 카운트로 받아 
			//int형인 checknum에 해당 값을 넣어준다.
			modelAndView.setViewName("userEntry"); // jsp파일 이름은 userEntry (성공시 목표 뷰네임)

			if (checknum > 0) { // 상위에 담아 둔 id 값이 0보다  클때
				model.addAttribute("check", null); // check전달 객체에 null을 입력
				model.addAttribute("msg", "아이디가 중복되었습니다."); //msg라는 전달 객체에 해당 매세지 입력
				System.out.println("아이디가 중복 됩니다.");

			} else {

				System.out.println("아이디를 사용 가능 합니다."); // 아이디중복 아닐때

				model.addAttribute("check", m_email); //전달객체 check에 해당 id를 넣어줌 
				model.addAttribute("msg", "가능한아이디입니다.");//  //msg라는 전달 객체에 해당 매세지 입력
			}

			return "userEntry"; // userEntry로 리턴
		} catch (EmptyResultDataAccessException e) { // 입력된 정보가 틀린 경우

			return "userEntry";// userEntry로 리턴
		}

	}

}
