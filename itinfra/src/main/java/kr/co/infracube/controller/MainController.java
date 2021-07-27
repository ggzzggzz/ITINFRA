package kr.co.infracube.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.infracube.dto.AdminDto;
import kr.co.infracube.dto.CodeDto;
import kr.co.infracube.dto.CustomerDto;
import kr.co.infracube.dto.DeliveryDto;
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
		session.setAttribute("Email", email);
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
		return groupCode("all",request);
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
		mv.addObject("Email", session.getAttribute("Email"));
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
	public ModelAndView groupCode(@RequestParam(value="searchOption", defaultValue="all") String searchOption, HttpServletRequest request) throws Exception {
		CodeDto dto = new CodeDto();
		dto.setTitle(searchOption);
		List<CodeDto> grouplist = mainservice.getGroupCode(dto);
		List<CodeDto> searchgrouplist = mainservice.selectAllGTitle();
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		mv.addObject("groupList", grouplist);
		mv.addObject("searchOption", searchOption);
		mv.addObject("searchgrouplist", searchgrouplist);
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		mv.setViewName("code_group");
		return mv;
	}
	
	//그룹코드등록
	@RequestMapping("/insertGroup.do")
	public void insertGroup(CodeDto dto, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		CodeDto selectcode = mainservice.selectCode(dto);
		if(selectcode == null) {
			mainservice.insertCode(dto);
			pw.println("<script>alert('등록완료');location.href='/groupCode.do';</script>");
			pw.flush();
		} else {
			pw.println("<script>alert('이미 존재하는 그룹코드입니다.');history.go(-1);</script>");
			pw.flush();
		}
	}
	
	//그룹코드수정
	@RequestMapping("/updateGroup.do")
	public void updateGroup(CodeDto dto, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		CodeDto selectcode = mainservice.selectCode(dto);
		if(selectcode == null) {
			mainservice.updateCode(dto);
			pw.println("<script>alert('수정완료');location.href='/groupCode.do';</script>");
			pw.flush();
		} else {
			pw.println("<script>alert('이미 존재하는 그룹코드입니다.');history.go(-1);</script>");
			pw.flush();
		}
	}
	
	//기초코드
	@RequestMapping("/baseCode.do")
	public ModelAndView baseCode(@RequestParam(value="searchOption", defaultValue="all") String searchOption, HttpServletRequest request) throws Exception{
		CodeDto dto = new CodeDto();
		dto.setTitle(searchOption);
		List<CodeDto> searchgrouplist = mainservice.selectAllBTitle();
		List<CodeDto> baselist = mainservice.getBaseCode(dto);
		List<CodeDto> groupinfolist = mainservice.groupInfo(); // 등록화면에서 그룹코드값을 가져옴
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		mv.addObject("baseList", baselist);
		mv.addObject("groupInfoList", groupinfolist);
		mv.addObject("searchgrouplist", searchgrouplist);
		mv.addObject("searchOption", searchOption);
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		mv.setViewName("code_base");
		return mv;
	}
	
	//기초코드등록
	@RequestMapping("/insertBase.do")
	public void insertBase(CodeDto dto, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		CodeDto selectcode = mainservice.selectCode(dto);
		if(selectcode == null) {
			mainservice.insertCode(dto);
			pw.println("<script>alert('등록완료');location.href='/baseCode.do';</script>");
			pw.flush();
		} else {
			pw.println("<script>alert('이미 존재하는 그룹코드입니다.');history.go(-1);</script>");
			pw.flush();
		}		
	}
		
	//그룹코드수정
	@RequestMapping("/updateBase.do")
	public void updateBase(CodeDto dto, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		CodeDto selectcode = mainservice.selectCode(dto);
		if(selectcode == null) {
			mainservice.updateCode(dto);
			pw.println("<script>alert('수정완료');location.href='/baseCode.do';</script>");
			pw.flush();
		} else {
			pw.println("<script>alert('이미 존재하는 그룹코드입니다.');history.go(-1);</script>");
			pw.flush();
		}
	}
	
	//고객
	@RequestMapping("/customer.do")
	public ModelAndView customer(@RequestParam HashMap<String, String> paramMap, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer");
		HttpSession session = request.getSession();
		System.out.println(paramMap);
		HashMap<String, String> hashMap = new HashMap<String, String>();
		if(paramMap.containsKey("searchKeyword")) {
			hashMap.put("searchKeyword", paramMap.get("searchKeyword"));
		} else {
			hashMap.put("searchKeyword", "");
		}
		System.out.println(hashMap);
		List<CustomerDto> list = mainservice.listCustomers(hashMap);
		System.out.println(list);
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		mv.addObject("paramMap", paramMap);
		mv.addObject("hashMap", hashMap);
		mv.addObject("list", list);
		return mv;
	}

	//insertCustomer.do
	@RequestMapping("/insertCustomer.do")
	public void insertCustomer(CustomerDto dto, HttpServletRequest request, HttpServletResponse response) throws Exception{
		mainservice.insertCustomer(dto);
		System.out.println(dto);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script> alert('등록완료'); location.href='customer.do'; </script>");
	}

	//updateCustomer.do
	@RequestMapping("/updateCustomer.do")
	public void updateCustomer(CustomerDto dto, HttpServletRequest request, HttpServletResponse response) throws Exception{
		mainservice.updateCustomer(dto);
		System.out.println(dto);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script> alert('수정완료'); location.href='customer.do'; </script>");
	}
	
	//excelCustomer.do
	@RequestMapping("/excelCustomer.do")
	public void excelCustomer(HttpServletResponse response) throws Exception{
		mainservice.excelCustomer(response);
	}
	
	//납품
	@RequestMapping("/delivery.do")
	public ModelAndView delivery(@RequestParam HashMap<String, String> paramMap, HttpServletRequest request) throws Exception{
		System.out.println(paramMap);
		HashMap<String, String> hashMap = new HashMap<String, String>();
		if(paramMap.containsKey("checkEndDate")) {
			hashMap.put("checkEndDate", paramMap.get("checkEndDate"));
		} else {
			hashMap.put("checkEndDate", "");
		}
		if(paramMap.containsKey("startDate")) {
			hashMap.put("startDate", paramMap.get("startDate"));
		} else {
			hashMap.put("startDate", "");
		}
		if(paramMap.containsKey("endDate")) {
			hashMap.put("endDate", paramMap.get("endDate"));
		} else {
			hashMap.put("endDate", "");
		}
		if(paramMap.containsKey("searchWord")) {
			hashMap.put("searchWord", paramMap.get("searchWord"));
		} else {
			hashMap.put("searchWord", "");
		}
		System.out.println(hashMap);
		List<DeliveryDto> deliverylist = mainservice.getDelivery(hashMap);
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		mv.addObject("deliveryList", deliverylist);
		mv.addObject("hashMap",hashMap);
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		mv.setViewName("delivery");
		return mv;
	}
	
	//납품등록
	@RequestMapping("/deliveryNew.do")
	public ModelAndView deliveryNew(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		List<CustomerDto> customerinfolist = mainservice.customerInfo();
		mv.addObject("customerInfoList", customerinfolist); // 고객정보 리스트
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		mv.setViewName("delivery_new");
		return mv;
	}
	@RequestMapping("/processInsertDelivery.do")
	public void processInsertDelivery(DeliveryDto dto, HttpServletResponse response) throws Exception{
		mainservice.processInsertDelivery(dto);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("<script>alert('등록완료');location.href='/delivery.do';</script>");
		pw.flush();
	}
	
	//납품수정
	@RequestMapping("/deliveryEdit.do")
	public ModelAndView deliveryEdit(DeliveryDto dto, HttpServletRequest request) throws Exception{
		List<CustomerDto> customerinfolist = mainservice.customerInfo();
		dto = mainservice.deliveryInfo(dto);
		System.out.println(dto.toString());
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		mv.addObject("customerInfoList", customerinfolist);
		mv.addObject("dto", dto);
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		mv.setViewName("delivery_edit");
		return mv;
	}
	@RequestMapping("/processUpdateDelivery.do")
	public void processUpdateDelivery(DeliveryDto dto, HttpServletResponse response) throws Exception{
		mainservice.processUpdateDelivery(dto);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		pw.println("<script>alert('수정완료');location.href='/delivery.do';</script>");
		pw.flush();
	}
	
	@PostMapping("/deliveryCustomerSearch.do")
	@ResponseBody
	public String deliveryCustomerSearch (@RequestParam HashMap<String, String> search) throws Exception{
		HashMap<String, String> paramMap = new HashMap<String, String>();
		if(search.get("search") != "") {
			paramMap.put("search", search.get("search"));
		} else {
			paramMap.put("search", "");
		}
		List<Map<String,String>> customerinfolist = mainservice.selectCustomerInfo(paramMap);
		System.out.println(customerinfolist);
		String str = "";
		str += "[";
		for(int i=0; i<customerinfolist.size(); i++) {
			str += "{";
			str += "'ccode':";
			str += "'" + customerinfolist.get(i).get("ccode") + "', ";
			str += "'cname':";
			str += "'" + customerinfolist.get(i).get("cname") + "', ";
			str += "'mphone':";
			str += "'" + customerinfolist.get(i).get("mphone") + "', ";
			str += "'mname':";
			str += "'" + customerinfolist.get(i).get("mname") + "'";
			str += "}";
			if(i < customerinfolist.size()-1) {
				str += ", ";
			}
		}
		str += "]";
		System.out.println(str);
		
		return str;
	}
	
	//excelDelivery.do
	@RequestMapping("/excelDelivery.do")
	public void excelDelivery(HttpServletResponse response) throws Exception{
		mainservice.excelDelivery(response);
	}
	
	//관리자
	@RequestMapping("/systemset.do")
	public ModelAndView systemset(@RequestParam(value="searchKeyword", defaultValue="") String searchKeyword, HttpServletRequest request) throws Exception{
		ModelAndView mv = new ModelAndView();
		AdminDto dto = new AdminDto();
		dto.setAName(searchKeyword);
		mv.setViewName("systemset");
		HttpSession session = request.getSession();
		List<AdminDto> list = mainservice.listAdmins(dto);
		System.out.println(searchKeyword);
		System.out.println(list);
		mv.addObject("sessionId", session.getAttribute("sessionId"));
		mv.addObject("sessionName", session.getAttribute("sessionName"));
		mv.addObject("searchKeyword", searchKeyword);
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
		return systemset("", request);
	}

	//updateAdmin.do
	@RequestMapping("/updateAdmin.do")
	public ModelAndView updateAdmin(AdminDto dto, HttpServletRequest request) throws Exception{
		mainservice.updateAdmin(dto);
		System.out.println(dto.getEmail());
		return systemset("", request);
	}
	//excelAdmin.do
	@RequestMapping("/excelAdmin.do")
	public void excelAdmin(HttpServletResponse response) throws Exception{
		mainservice.excelAdmin(response);
	}
}
