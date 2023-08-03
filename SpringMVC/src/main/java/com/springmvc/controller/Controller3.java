package com.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.model.UserCredentials;
import com.springmvc.model.UserDetails;
import com.springmvc.service.UserServices;

@Controller
@RequestMapping("registration")
public class Controller3 {
	@Autowired
	UserServices us;

	@PostMapping
	public String register(@Valid @ModelAttribute("user_d") UserDetails details, BindingResult result,
			@Valid @ModelAttribute("user_c") UserCredentials credentials, BindingResult result2, Model m,
			Controller2 c2, RedirectAttributes ra) {
		if (result2.hasErrors() || result.hasErrors()) {
			ra.addFlashAttribute("org.springframework.validation.BindingResult.user_d", result);
			ra.addFlashAttribute("org.springframework.validation.BindingResult.user_c", result2);
			ra.addFlashAttribute("user_d", details);
			ra.addFlashAttribute("user_c", credentials);
			return "redirect:/signup";
		} else {
			us.saveUser(credentials);
			us.saveUser(details);
			ra.addFlashAttribute("id", credentials.getId());
			ra.addFlashAttribute("password", credentials.getPassword());
			return "redirect:/login";
		}
	}
}
