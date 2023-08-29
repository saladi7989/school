package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.school.entity.StudentEntity;
import com.school.pojo.Student;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer>{
	
@Query(value="select * from student where sid =?1",nativeQuery = true)
	public StudentEntity getStudentbyID(Integer id);


@Query("SELECT * FROM student  WHERE " +
	    " sid LIKE CONCAT('%',:query, '%')"+
        "or sname LIKE CONCAT('%',:query, '%')" +
        "Or address LIKE CONCAT('%', :query, '%')"+
        "Or emailId LIKE CONCAT('%', :query, '%')"+
        "or mobilenumber LIKE CONCAT('%', :query, '%') ")

public StudentEntity searchStudentDetails(String query);
	

}