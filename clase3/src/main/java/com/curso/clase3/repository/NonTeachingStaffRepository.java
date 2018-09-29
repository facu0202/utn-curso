package com.curso.clase3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.clase3.model.NonTeachingStaff;

@Repository
public interface NonTeachingStaffRepository extends CrudRepository<NonTeachingStaff, Long> {

	 @Override
	 List<NonTeachingStaff> findAll();
}
