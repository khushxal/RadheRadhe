package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.model.UserCredentials;
import com.springmvc.model.UserDetails;
import com.springmvc.service.UserServices;

@Controller
@RequestMapping("/profile")
public class Controller5 {

	@Autowired
	UserServices us;

	@RequestMapping("user/id={id}")
	public String profile(@PathVariable("id") int id, Model m, HttpSession session, HttpServletRequest req,
			RedirectAttributes ra, HttpServletResponse response) {
		if (us.get_User_Credentail_By_Id(id) != null) {
			session = req.getSession(false);
			UserCredentials credential = us.get_User_Credentail_By_Id(id);
			UserDetails detail = us.get_User_Details_By_Id(credential.getEmail());
			if (session != null && session.getAttribute("email").equals(us.get_User_Credentail_By_Id(id).getEmail())) {
				m.addAttribute("credential", credential);
				m.addAttribute("detail", detail);
				return "profile";
			} else {
				ra.addFlashAttribute("ack", "Login required");
			}
		} else {
			ra.addFlashAttribute("ack", "User doesnt exists");
		}
		return "redirect:/login";
	}

	@RequestMapping("/updateform/user/id={id}")
	public String updateForm(@PathVariable("id") int id, Model m, HttpSession session, HttpServletRequest req,
			RedirectAttributes ra, HttpServletResponse response) {
		if (us.get_User_Credentail_By_Id(id) != null) {
			session = req.getSession(false);
			if (session != null && session.getAttribute("email").equals(us.get_User_Credentail_By_Id(id).getEmail())) {
				UserCredentials credentials = us.get_User_Credentail_By_Id(id);
				UserDetails details = us.get_User_Details_By_Id(us.get_User_Credentail_By_Id(id).getEmail());
				m.addAttribute("detail", details);
				m.addAttribute("credential", credentials);
				return "updateform";
			} else {
				ra.addFlashAttribute("ack", "Login required");
			}
		} else {
			ra.addFlashAttribute("ack", "User doesnt exists");
		}
		return "redirect:/login";

	}

	@RequestMapping("/processform/user/id={id}")
	public String updateDetails(@Valid @ModelAttribute("user_d") UserDetails details, BindingResult result,
			@PathVariable("id") int id, RedirectAttributes ra, HttpServletRequest req, HttpSession session,
			HttpServletResponse response) {
		if (us.get_User_Credentail_By_Id(id) != null) {
			session = req.getSession(false);
			if (session != null && session.getAttribute("email").equals(us.get_User_Credentail_By_Id(id).getEmail())) {
				if (result.hasErrors()) {
					System.out.println(result.getAllErrors());
					ra.addFlashAttribute("org.springframework.validation.BindingResult.user_d", result);
					ra.addFlashAttribute("user_d", details);
					return "redirect:/profile/updateform/user/id=" + id;
				} else {
					us.saveUser(details);
					return "redirect:/profile/user/id=" + id;
				}
			} else {
				ra.addFlashAttribute("ack", "Login required");
			}
		} else {
			ra.addFlashAttribute("ack", "User doesnt exists");
		}
		return "redirect:/login";
	}
}
