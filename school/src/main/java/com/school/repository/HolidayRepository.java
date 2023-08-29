package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.HolidaysEntity;

@Repository
public interface HolidayRepository extends JpaRepository<HolidaysEntity, Integer>{

}
