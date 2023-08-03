package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/file")
public class Controller4 {

	@RequestMapping("/upload")
	public String uploadPhoto() {
		return "upload";
	}

	@RequestMapping(value = "/savefile")
	public String savefile(@RequestParam("d") CommonsMultipartFile datafile) {
//		System.out.println(value);
		System.out.println(datafile.getContentType());
		System.out.println(datafile.getName());
		System.out.println(datafile.getOriginalFilename());
		return "home";
	}
}
