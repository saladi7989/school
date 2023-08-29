package com.school.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.school.entity.HolidaysEntity;
import com.school.pojo.Holidays;
import com.school.service.HolidaysService;

@Controller
public class HolidayController {

	@Autowired
	HolidaysService holidaysService;

	@RequestMapping(value = "/holidays", method = RequestMethod.GET)
	String getHolidays(@RequestParam(required=false) boolean festival,@RequestParam(required=false) boolean nonFestival,Model model) {
		
		List<Holidays> festivallist = new ArrayList<>();
		List<Holidays> nonfestivallist = new ArrayList<>();
		List<Holidays> listentity = holidaysService.getHolidays();
		
		
		for(Holidays hm:listentity) {
			if(hm.getType().equals("FESTIVAL")) {
				festivallist.add(hm);
			}else{
				nonfestivallist.add(hm);
			}
		}
		model.addAttribute("festivaltrue",festival);
		model.addAttribute("nonfestivaltrue",nonFestival);
		model.addAttribute("NONFESTIVAL", nonfestivallist);
		model.addAttribute("FESTIVAL", festivallist);
		return "holidays.html";

	}

}
