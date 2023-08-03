package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.model.UserCredentials;
import com.springmvc.model.UserDetails;
import com.springmvc.service.UserServices;

@Controller
@RequestMapping("validate")
public class Controller2 {

	@Autowired
	UserServices us;
	UserCredentials credentials;
	UserDetails details;

	@PostMapping
	public String verify(@RequestParam("id") int id, @RequestParam("password") String password, Model m, HttpSession hs,
			HttpServletRequest req, RedirectAttributes ra, HttpServletResponse response) {
		response.setHeader("Cache-Control", "private , no-cache , no-store");
		response.setHeader("Pragma", "no-cache");
		credentials = us.get_User_Credentail_By_Id(id);
		if (credentials != null) {
			if (credentials != null && credentials.getPassword().equals(password)) {
				hs = req.getSession();
				details = us.get_User_Details_By_Id(credentials.getEmail());
				hs.setAttribute("detail", details);
				hs.setAttribute("credential", credentials);
				hs.setAttribute("id", credentials.getId());
				hs.setAttribute("email", credentials.getEmail());
				m.addAttribute("title", "Home");
				return "redirect:/home";
			} else {
				ra.addFlashAttribute("ack", "Invalid ID or PASSWORD");
			}
		} else {
			ra.addFlashAttribute("ack", "User doesn't exists");
		}
		return "redirect:/login";
	}
}
