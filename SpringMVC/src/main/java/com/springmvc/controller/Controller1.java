package com.springmvc.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.springmvc.service.UserServices;

@Controller
public class Controller1 {
	@Autowired
	UserServices userServices;

	@SuppressWarnings("deprecation")
	@ModelAttribute
	public void wishMessageHandler(Model m) {
		Date date = new Date();
		String message = null;
		if (date.getHours() >= 4 && date.getHours() < 12) {
			message = "Good Morning";
		} else if (date.getHours() >= 12 && date.getHours() < 17) {
			message = " Good AfterNoon";
		} else if (date.getHours() >= 17 && date.getDay() < 21) {
			message = "Good evening";
		} else {
			message = "Good night";
		}
		m.addAttribute("message", message);
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/login")
	public String login(Model m) {
		m.addAttribute("title", "Login");
		return "login";
	}

	@RequestMapping("/signup")
	public String signup(Model m) {
		m.addAttribute("title", "Sign Up");
		return "signup";
	}

	@RequestMapping("/home")
	public String home(Model m, HttpServletRequest req, RedirectAttributes ra) {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("email")
				.equals(userServices.get_User_Credentail_By_Id((Integer) session.getAttribute("id")).getEmail())) {
			m.addAttribute("title", "HOME");
			return "home";
		} else {
			ra.addFlashAttribute("ack", "Login required");
			return "redirect:/login";
		}
	}

	@RequestMapping("/error")
	public String error(Model m) {
		m.addAttribute("title", "Error");
		return "error";
	}

	@RequestMapping("/about")
	public String about(Model m) {
		m.addAttribute("title", "About Us");
		return "about";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest req, HttpSession session) {
		session = req.getSession(false);
		if (session != null && session.getAttribute("email")
				.equals(userServices.get_User_Credentail_By_Id((Integer) session.getAttribute("id")).getEmail())) {
			req.getSession(false).removeAttribute("check");
		}
		req.getSession(false).invalidate();
		return "redirect:/login";
	}

	@RequestMapping(path = "/contact", method = RequestMethod.GET)
	public String contact(Model m) {
		m.addAttribute("title", "Contact Us");
		m.addAttribute("doq", new Date());
		return "contact";
	}

}
