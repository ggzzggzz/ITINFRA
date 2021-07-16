package kr.co.infracube.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.infracube.dto.AdminDto;
import kr.co.infracube.dto.CustomerDto;
import kr.co.infracube.service.MainService;

@Controller
public class MainController {
	@Autowired
	MainService mainservice;
	
	@Autowired
	private JavaMailSender mailSender;
	
	// sendmail 코드
	@RequestMapping("/sendmail.do")
	public ModelAndView sendmail(@RequestParam("email") String email, HttpServletRequest request) {
		Random rd = new Random();
		int number = rd.nextInt(999999);
		String setfrom = "ggzz553@gmail.com";
		String tomail = email; // 받는 사람 이메일
		String title = "비밀번호 재설정"; // 제목
		String content = "OTP : " + String.format("%06d", number); // 내용

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,
					true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(content); // 메일 내용

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
			return login(request);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("sessionId", email);
		session.setAttribute("OTP", String.format("%06d", number));

		return passwordReset(request);
	}
	
	//로그인
	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping("/processLogin.do")
	public ModelAndView processLogin(AdminDto admin, HttpServletRequest request, HttpServletResponse response) throws Exception{
		AdminDto dto = mainservice.processLogin(admin);
		System.out.println(dto);
		if(dto == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('이메일과 비밀번호가 맞는지 확인해주세요.'); </script>");
			out.flush();
			return login(request);
		}
		HttpSession session = request.getSession();
		session.setAttribute("sessionId", dto.getEmail());
		session.setAttribute("sessionName", dto.getAName());
		return groupCode(request);
	}
	
	//logout.do
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return login(request);
	}
	
	//비밀번호 재설정
	@RequestMapping("/passwordReset.do")
	public ModelAndView passwordReset(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("apass_reset");
		HttpSession session = request.getSession();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("OTP", session.getAttribute("OTP"));
		return mv;
	}
	
	//passwordChange.do
	@RequestMapping("/passwordChange.do")
	public ModelAndView passwordChange(AdminDto dto, HttpServletRequest request) throws Exception{
		mainservice.passwordChange(dto);
		HttpSession session = request.getSession();
		session.invalidate();
		System.out.println(dto);
		return login(request);
	}
	
	//그룹코드
	@RequestMapping("/groupCode.do")
	public ModelAndView groupCode(HttpServletRequest request) throws Exception{
		//CodeDto dto = new CodeDto();
		//dto = mainservice.getGroupCode(dto);
		ModelAndView mv = new ModelAndView();
		//mv.addObject("groupCode", dto);
		mv.setViewName("code_group");
		HttpSession session = request.getSession();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		return mv;
	}
	
	//기초코드
	@RequestMapping("/baseCode.do")
	public ModelAndView baseCode(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("code_base");
		HttpSession session = request.getSession();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		return mv;
	}
	
	//고객
	@RequestMapping("/customer.do")
	public ModelAndView customer(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer");
		HttpSession session = request.getSession();
		List<CustomerDto> list = mainservice.listCustomers(null);
		System.out.println(list);
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		mv.addObject("list", list);
		return mv;
	}
	
	//insertCustomer.do
	@RequestMapping("/insertCustomer.do")
	public ModelAndView insertCustomer(CustomerDto dto, HttpServletRequest request) throws Exception{
		mainservice.insertCustomer(dto);
		System.out.println(dto);
		return customer(request);
	}
	
	//updateCustomer.do
	@RequestMapping("/updateCustomer.do")
	public ModelAndView updateCustomer(CustomerDto dto, HttpServletRequest request) throws Exception{
		mainservice.updateCustomer(dto);
		System.out.println(dto);
		return customer(request);
	}
	
	//납품
	@RequestMapping("/delivery.do")
	public ModelAndView delivery(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delivery");
		HttpSession session = request.getSession();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		return mv;
	}
	@RequestMapping("/deliveryEdit.do")
	public ModelAndView deliveryEdit(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delivery_edit");
		HttpSession session = request.getSession();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		return mv;
	}
	@RequestMapping("/deliveryNew.do")
	public ModelAndView deliveryNew(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("delivery_new");
		HttpSession session = request.getSession();
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		return mv;
	}
	
	//관리자
	@RequestMapping("/systemset.do")
	public ModelAndView systemset(HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("systemset");
		HttpSession session = request.getSession();
		List<AdminDto> list = mainservice.listAdmins(null);
		System.out.println(list);
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		mv.addObject("list", list);
		return mv;
	}
	
	//insertAdmin.do
	@RequestMapping("/insertAdmin.do")
	public ModelAndView insertAdmin(AdminDto dto, HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			System.out.println(dto);
			mainservice.insertAdmin(dto);
		} catch (Exception e){
			e.printStackTrace();
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script> alert('이메일이 이미 존재합니다.'); </script>");
			out.flush();
		}
		System.out.println(dto);
		return systemset(request);
	}
	
	//updateAdmin.do
	@RequestMapping("/updateAdmin.do")
	public ModelAndView updateAdmin(AdminDto dto, HttpServletRequest request) throws Exception{
		mainservice.updateAdmin(dto);
		System.out.println(dto.getEmail());
		return systemset(request);
	}
}
