package com.school.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.HolidaysEntity;
import com.school.pojo.Holidays;
import com.school.repository.HolidayRepository;

@Service
public class HolidaysService {
	
	@Autowired
	HolidayRepository holidayRepository;
	
	public List<Holidays> getHolidays() {
		List<HolidaysEntity> entitylist= holidayRepository.findAll();
		List<Holidays> hm = new ArrayList<>();
		for(HolidaysEntity en:entitylist) {
			Holidays h = new Holidays();
			h.setName(en.getName());
			h.setReason(en.getReason());
			h.setType(en.getType());
			hm.add(h);
		}
		return hm;
	 }

}
