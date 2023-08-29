package com.school.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.school.pojo.Contact;



@Controller
public class ContactController {
	
	@RequestMapping(value="/contact",method = RequestMethod.GET)
	public String getStudentDetails(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact.html";
		
	}
	
	
	
	/*
	 * @RequestMapping(value = "/saveContact", method = RequestMethod.POST) public
	 * String saveContactDetails(@RequestParam String name, @RequestParam String
	 * mobileNum,
	 * 
	 * @RequestParam String email, @RequestParam String subject, @RequestParam
	 * String message) {
	 * 
	 * System.out.println("name" + name); System.out.println("mobileNum" +
	 * mobileNum); System.out.println("email" + email); System.out.println("subject"
	 * + subject); System.out.println("message" + message);
	 * 
	 * return "redirect:/contact";
	 * 
	 * }
	 */
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public String saveContactDetails(@javax.validation.Valid @ModelAttribute("contact")Contact contact,Errors error) {
		if(error.hasErrors()) {
			System.out.println("error"+error.toString());
			return "redirect:/contact";
		}
	
		System.out.println("mnumber="+contact.getMobileNum());
		System.out.println("email="+contact.getEmail());
		System.out.println("subject="+contact.getSubject());
		System.out.println("message="+contact.getMessage());
		return "redirect:/contact";
	}
	 
	
	
	

}
