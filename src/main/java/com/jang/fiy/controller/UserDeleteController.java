package com.jang.fiy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
public class UserDeleteController {

	@Resource(name = "userService")
	// (==@Autowired), userService가 있으면 그 객체를 아래줄 userService에 집어넣어라.(아버지서비스안에
	// 자식서비스 삽입)
	private UserService userService;

	@ModelAttribute
	public User setUpForm(HttpServletRequest request) {
		// 리퀘스트 url이 들어왔다.

		User user = new User(); // command (전달) 객체 생성

		if (request.getMethod().equalsIgnoreCase("GET")) { // 메소드가 get방식이면 대소문자를
			// 구문하지 말고 실행해라.
			// equalsIgnoreCase = 대소문자를 구분하지 마라.

			String m_email = request.getParameter("m_email"); // userid를 읽어서
			// string userid에 잡아
			// 넣어라.
			try {
				user = this.userService.findUser(m_email);// userid 정보를 이용하여
				// user정보 전체를 읽어옴.
				return user; // 읽어온걸 모델 리퀘스트(리퀘스트메핑)로 넘어간다.
			} catch (EmptyResultDataAccessException e) {
				return user; // 해당 객체를 읽었는대 없으면 여기로 반환됨
			}
		} else {
			return user; // post방식이면 아무것도 수행하지 않고 바로 리퀘스트(리퀘스트메핑)로 넘어간다.
		}
	}

	@RequestMapping(value = "/userDeleteForm", method = RequestMethod.GET)
	public String toFindIdView() {
		return "userDelete"; // delete실행
	}

	// @RequestMapping(value = "/deleteMember", method = RequestMethod.POST)
	// public ModelAndView onSubmit(@Valid @ModelAttribute("user") User user/*
	// * 폼에있는
	// * USER내용을
	// * 불러온다
	// */,
	// BindingResult bindingResult/* 에러메시지를 불러온다 */) {
	//
	// // *****비밀번호를 체크하여 에러메시지 출력 ******
	// ModelAndView modelAndView = new ModelAndView();
	//
	// System.out.println("여기까지 뿌려집니까 ?");
	//
	// if (bindingResult.hasFieldErrors("pass")) { // pass가 입력되지않은 경우
	// modelAndView.getModel().putAll(bindingResult.getModel());
	//
	// return modelAndView;
	// }
	// User getUser = this.userService.getUser(user.getId());
	// int no = getUser.getNo();
	// try {
	// this.userService.deleteUser(no);
	//
	// modelAndView.setViewName("deleteSuccess");
	// System.out.println(no);
	// modelAndView.addObject("deleteUser", "삭제가 완료되었습니다");
	// modelAndView.addObject("user", user);
	//
	// return modelAndView;
	//
	// } catch (EmptyResultDataAccessException e) { // id 이메일이 입력되었으나 틀린 경우
	//
	// bindingResult.reject("error.find.user");
	// modelAndView.getModel().putAll(bindingResult.getModel());
	//
	// return modelAndView;
	// }
	// // *****deleteMember 실행시 ******
	//
	// }

	@RequestMapping(value = "/userDelete", method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute @Valid User deleteUser,
			BindingResult bindingResult) throws Exception {

		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasFieldErrors("m_password"))  { //pass가 입력되지않은 경우
			modelAndView.getModel().putAll(bindingResult.getModel());
			
			return modelAndView;
		}		
		try {
			this.userService.delete(deleteUser);			
			modelAndView.setViewName("userDeleteSuccess");
			System.out.println(deleteUser);
			modelAndView.addObject("deleteUser", "삭제가 완료되었습니다");
			modelAndView.addObject("user",deleteUser);
	
			return modelAndView;
						
		} catch (EmptyResultDataAccessException e) { //pass가 입력되었으나 틀린 경우

			bindingResult.reject("error.find.user");
			modelAndView.getModel().putAll(bindingResult.getModel());
			
			return modelAndView;
		}
	}
}

// if (bindingResult.hasErrors()) {
// modelAndView.getModel().putAll(bindingResult.getModel());
// return modelAndView; //벨리데이터로 에러 검증한 후 에러가 없으면 다음으로 넘어감.
// }
// try {
// this.userService.delete(userId, password);
// modelAndView.setViewName("userDeleteSuccess");//성공화면으로 넘김
// modelAndView.addObject("deleteUser", "삭제가 완료되었습니다");
// modelAndView.addObject("user", user); //정한한 user객체를 가지고 모델엔 뷰로 보냄
// return modelAndView;
// } catch (DataIntegrityViolationException e) {
// bindingResult.reject("error.find.user"); //트라이 설명의 반대
// modelAndView.getModel().putAll(bindingResult.getModel());
// return modelAndView;
// }