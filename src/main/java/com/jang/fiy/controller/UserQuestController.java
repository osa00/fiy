package com.jang.fiy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jang.fiy.logic.DquestService;
import com.jang.fiy.logic.QuestService;
import com.jang.fiy.logic.UserService;
import com.jang.fiy.model.Quest;
import com.jang.fiy.model.User;

@Controller
public class UserQuestController {
	
	@Resource(name = "userService")
	private UserService userService;
	
	@Resource(name = "questService")
	private QuestService questService;
	
	@Resource(name = "dquestService")
	private DquestService dquestService;

	@Resource(name = "messageSource")
	private MessageSource messageSource;
	
	@ModelAttribute
	public User setUpForm(HttpServletRequest request) {
		// 리퀘스트 url이 들어왔다.

		User user = new User(); // command (전달) 객체 생성
			return user; // post방식이면 아무것도 수행하지 않고 바로 리퀘스트(리퀘스트메핑)로 넘어간다.
		}
	@ModelAttribute
	public Quest setUpForm2(HttpServletRequest request) {

		Quest quest = new Quest();

		return quest;
	}

	//--------------리스트페이지 매칭--------------------------
	@RequestMapping(value = "/questlistForm1", method = RequestMethod.GET)
	public String toQuestEntryView1() {
		return "Q_list1";
	}
	
	@RequestMapping(value = "/questlistForm2", method = RequestMethod.GET)
	public String toQuestEntryView2() {
		return "Q_list2";
	}
	@RequestMapping(value = "/questlistForm3", method = RequestMethod.GET)
	public String toQuestEntryView3() {
		return "Q_list3";
	}
	@RequestMapping(value = "/questlistForm4", method = RequestMethod.GET)
	public String toQuestEntryView4() {
		return "Q_list4";
	}
	@RequestMapping(value = "/questlistForm5", method = RequestMethod.GET)
	public String toQuestEntryView5() {
		return "Q_list5";
	}
	@RequestMapping(value = "/questlistForm6", method = RequestMethod.GET)
	public String toQuestEntryView6() {
		return "Q_list6";
	}
//--------------장지훈소스
	@RequestMapping(value = "/questForm", method = RequestMethod.GET)
	public String toUserEntryView(HttpServletRequest request, ModelMap model, Quest quest, User user)  {
		

		if(request.getMethod().equalsIgnoreCase("GET")){
			int q_no = Integer.parseInt(request.getParameter("q_no"));
			
			ModelAndView modelAndView = new ModelAndView();
			
			
			quest = this.questService.get(q_no);
			System.out.println("quest.getQ_name();:"+quest.getQ_name());
			model.addAttribute("q_name", quest.getQ_name());
			model.addAttribute("q_answer", quest.getQ_answer());
			return "quest_event";
			}
		return "quest_event";
	}
	
	@RequestMapping(value = "/quest_event", method = RequestMethod.POST)
	public ModelAndView onSubmit(
			@RequestParam(value = "m_no") int m_no,
			@ModelAttribute @Valid Quest quest,
			BindingResult bindingResult) throws Exception {
		System.out.println("안녕1 = " + m_no);
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasFieldErrors("answer"))  { //pass가 입력되지않은 경우
			modelAndView.getModel().putAll(bindingResult.getModel());
			
			return modelAndView;
		}		
		try {
			System.out.println("안녕2 = " + m_no);
			this.userService.pupdate(m_no);
			System.out.println("안녕3 = " + m_no);
			modelAndView.setViewName("Q_list1");//성공화면으로 넘김
			modelAndView.addObject("m_no", m_no);
			return modelAndView;
						
		} catch (EmptyResultDataAccessException e) { 

			bindingResult.reject("error.point.user");
			modelAndView.getModel().putAll(bindingResult.getModel());
			
			return modelAndView;
		}
	}
	
	
	//-----------리스트버튼 누르면 페이지 넘어가게------------------- 
	@RequestMapping(value = "/next_dquest", method = RequestMethod.POST)
	public String form(
			@RequestParam(value = "sam", required = false, defaultValue = "0") int q_no,
			ModelMap model) throws Exception {
		System.out.println("안녕" + q_no);
		ModelAndView modelAndView = new ModelAndView();
		Quest quest2 = new Quest();
		try {
			System.out.println("try문안1 = " + q_no);
			if (q_no == 11) {
				System.out.println("if문안 = " + q_no);
				Quest dtail = this.questService.get(q_no);
				System.out.println(dtail.getQ_hint1());
				quest2 = dtail;
			
			}else if (q_no == 12) {
				System.out.println("if문안 = " + q_no);
				Quest dtail = this.questService.get(q_no);
				System.out.println(dtail.getQ_hint1());
				quest2 = dtail;
			
			}else if (q_no == 13) {
				System.out.println("if문안 = " + q_no);
				Quest dtail = this.questService.get(q_no);
				System.out.println(dtail.getQ_hint1());
				quest2 = dtail;

			
			}else if (q_no == 14) {
				System.out.println("if문안 = " + q_no);
				Quest dtail = this.questService.get(q_no);
				System.out.println(dtail.getQ_hint1());
				quest2 = dtail;

			
			}else if (q_no == 15) {
				System.out.println("if문안 = " + q_no);
				Quest dtail = this.questService.get(q_no);
				System.out.println(dtail.getQ_hint1());
				quest2 = dtail;

			
			}else{

				System.out.println("else문 실행됨. ");
				model.addAttribute("ss", "오류");
			
		} 
			model.addAttribute("hint1", quest2.getQ_hint1());
			model.addAttribute("hint2", quest2.getQ_hint2());
			model.addAttribute("hint3", quest2.getQ_hint3());;
			model.addAttribute("q_no", quest2.getQ_no());;
			
			System.out.println("if문 끝" + quest2.getQ_no());
			return "test";
			
		}	catch (EmptyResultDataAccessException e) {
			return "test";
		}
	}

}
