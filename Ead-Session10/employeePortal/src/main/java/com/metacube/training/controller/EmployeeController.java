package com.metacube.training.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.ConfirmPassword;
import com.metacube.training.model.Employee;
import com.metacube.training.model.ForgetPasswordToken;
import com.metacube.training.model.User;
import com.metacube.training.service.EmailService;
import com.metacube.training.service.interfaces.EmployeeService;
import com.metacube.training.service.interfaces.TokenService;

@Controller
@RequestMapping("/employee")

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private TokenService tokenService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute(new Employee());
		return "employee/login";
	}
	
	@RequestMapping(path = "/back", method = RequestMethod.GET)
	public String backToDashboard() {
		return "employee/dashboard";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String empCode,
			@RequestParam(name = "password") String password,
			HttpServletRequest request) {
		try {
			Employee employee = new Employee();
			employee.setEmpCode(empCode);
			employee.setPassword(password);

			Employee empData = employeeService.getEmployeeById(employee);
			request.getSession().setAttribute("empCode", empData.getEmpCode());
			request.getSession()
					.setAttribute("password", empData.getPassword());

			return new ModelAndView("employee/dashboard", "username", empCode);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("employee/error");
		}

	}

	@RequestMapping(path = "/showProfile", method = RequestMethod.GET)
	public String getAllprojects(Model model, HttpServletRequest request) {
		Employee employee = new Employee();
		employee.setEmpCode(request.getSession().getAttribute("empCode")
				.toString());
		employee.setPassword(request.getSession().getAttribute("password")
				.toString());
		model.addAttribute("employees",
				employeeService.getEmployeeById(employee));

		return "employee/profile";
	}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
		public String logout(HttpServletRequest request){
			request.getSession().invalidate();
			return "employee/login";
	}

	@RequestMapping(path = "/searchEmployee", method = RequestMethod.GET)
	public String search( Model model) {
		return "employee/search";
	}
	
	@RequestMapping(path = "/searchEmployee", method = RequestMethod.POST)
	public String search(@RequestParam(name = "search") String searchString,  Model model) {
		try{
		Employee employee = employeeService.getEmployeeByIdString(searchString);
		
		
		model.addAttribute("employees",employee);
		return "employee/profile";
		}catch(Exception e){
			return "employee/error2";
		}
	}
	
	@RequestMapping(path = "/forgetPassword", method = RequestMethod.GET)
	public String forgetPassword() {
		return "employee/forget";
	}
	
	@RequestMapping(path = "/forgetPassword", method = RequestMethod.POST)
	public ModelAndView generatePasswordLink(@RequestParam(name = "forget") String empCode,ModelAndView modelAndView,HttpServletRequest request) {
		try{
		Employee employee = employeeService.getEmployeeByIdString(empCode);
		String forgetPasswordTokenString = UUID.randomUUID().toString();
		ForgetPasswordToken forgetPasswordToken = new ForgetPasswordToken();
		forgetPasswordToken.setEmpCode(employee.getEmpCode());
		forgetPasswordToken.setToken(forgetPasswordTokenString);
		tokenService.insertToken(forgetPasswordToken);
		
		User user  = new User();
		user.setFirstName(employee.getFirstName());
		user.setEmailAddress(employee.getEmailId());
		user.setPassword(employee.getPassword());
		user.setLastname(employee.getLastName());
		user.setEmpCode(employee.getEmpCode());
		user.setAppUrl(request.getScheme() + "://" + request.getServerName() + ":8080/employeePortal/employee/reset?token=" + forgetPasswordTokenString + "&empCode=" + employee.getEmpCode());
		emailService.sendEmail(user);
		
		modelAndView.addObject("message", "an email has been sent to your existing email id: ");
		}catch(Exception e){
			modelAndView.addObject("message", "invalid employee code");
		}
		modelAndView.setViewName("employee/login");
		return modelAndView;
	}
	
	@RequestMapping(path = "/reset",method = RequestMethod.GET)
	public ModelAndView resetPassword(@RequestParam(name = "token") String token, @RequestParam(name = "empCode") String empCode, ModelAndView modelAndView){
		ConfirmPassword confirmPassword = new  ConfirmPassword();
		confirmPassword.setEmpCode(empCode);
		confirmPassword.setTokenId(token);
		modelAndView.addObject("confirmPassword",confirmPassword);
		modelAndView.setViewName("employee/reset");
		return modelAndView;
	}
	
	@RequestMapping(path = "/reset",method  = RequestMethod.POST)
	public ModelAndView updateResetPassword(ModelAndView modelAndView, ConfirmPassword confirmPassword){
		ForgetPasswordToken forgetPasswordToken = tokenService.getToken(confirmPassword.getEmpCode());
		if(forgetPasswordToken!=null){
			employeeService.updateEmployeePassword(confirmPassword.getNewPassword(), confirmPassword.getEmpCode());
			tokenService.deleteToken(confirmPassword.getEmpCode());
			modelAndView.addObject("message", "your password has been updated ");
		}else{
			modelAndView.addObject("message","your link is expired");
		}
		modelAndView.setViewName("employee/login");
		return modelAndView;
	}
	
}
