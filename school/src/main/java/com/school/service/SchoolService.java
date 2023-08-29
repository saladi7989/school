package com.school.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.StudentEntity;
import com.school.pojo.Student;

import com.school.repository.StudentRepository;

@Service
public class SchoolService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getStudentDetails() {
		List<Student> stlist = new ArrayList<>();
		List<StudentEntity> stdlist = studentRepository.findAll();
		//stdlist.forEach(x->{
			for(StudentEntity x:stdlist) {
			Student st = new Student();
			st.setSid(x.getSid());
			st.setSname(x.getSname());
			st.setMobilenumber(x.getMnumber());
			st.setEmailId(x.getEmail());
			st.setAddress(x.getAddress());
			stlist.add(st);
			}
		//});
		return stlist;
	}

	public void save(Student std) {
		
		
		StudentEntity stEntity = new StudentEntity();
		stEntity.setSid(std.getSid());
		stEntity.setSname(std.getSname());
		stEntity.setEmail(std.getEmailId());
		stEntity.setAddress(std.getAddress());
		stEntity.setMnumber(std.getMobilenumber());
		
		studentRepository.save(stEntity);
		
		
	}
	
	public StudentEntity getStudentById(Integer id) {
	StudentEntity st= studentRepository.findById(id).get();
		
		return st;

	}
	 public StudentEntity searchStudentData(String query) {
		 StudentEntity searchStudent = studentRepository.searchStudentDetails(query);
	        return searchStudent;
}
}
