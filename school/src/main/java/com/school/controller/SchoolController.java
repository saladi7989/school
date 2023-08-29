package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.school.entity.StudentEntity;
import com.school.pojo.Student;
import com.school.service.SchoolService;

@Controller
public class SchoolController {
	
	@Autowired
    SchoolService schoolService;
	
	
	 @RequestMapping(value={"home"},method = RequestMethod.GET)
	    public String displayHomePage(Model model) {
		// model.addAttribute("username", "brahma");
	        return "home.html";
	    }

	
	@RequestMapping(value="/studentDetails1",method = RequestMethod.GET)
	public ModelAndView getStudent() {
		ModelAndView mvc = new ModelAndView("index");
		List std= schoolService.getStudentDetails();
		mvc.addObject("stdlist", std);
		
		return mvc;
		
		
	}
	
	
	@RequestMapping(value="/saveStudent",method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute Student std) {
		
		schoolService.save(std);
	
		
		return "redirect:/studentDetails1";
		
		
	}
	
	    @GetMapping("/addnewStudent")
		public ModelAndView studentform(Model model) {
			Student st = new Student();
			ModelAndView mvc = new ModelAndView("studentform");
			mvc.addObject("student", st);
			return mvc;
		}
	    
	    @RequestMapping(value="/studentById",method=RequestMethod.GET)
	    @ResponseBody
	    public StudentEntity getStudentById(@RequestParam Integer studentid) {
	    	StudentEntity st=schoolService.getStudentById(studentid);
	    	return st;
	    }
	    
	    @GetMapping("/search")
		 public StudentEntity searchProducts(@RequestParam("query") String query){
		         StudentEntity search=schoolService.searchStudentData(query);
				return search;

	}


		
		


}
