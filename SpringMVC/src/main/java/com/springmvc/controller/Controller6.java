package com.springmvc.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.model.UserContact;
import com.springmvc.service.UserServices;

@Controller
public class Controller6 {

	@Autowired
	UserServices services;

	@RequestMapping("/submitcontact")
	public String contactForm(@Valid @ModelAttribute("contact") UserContact contact, BindingResult result,
			RedirectAttributes ra, Model m) {
		if (result.hasErrors()) {
			System.out.println("This is having error or any issue");
			ra.addFlashAttribute("org.springframework.validation.BindingResult.contact", result);
			ra.addFlashAttribute("contact", contact);
			ra.addFlashAttribute("doq", new Date());
			return "redirect:/contact";
		} else {
			int ack = services.saveUserQuery(contact);
			System.out.println(ack);
			ra.addFlashAttribute("ack", "We will shortly reach you , hope your query will be resolved");
			return "redirect:/";
		}
	}
}