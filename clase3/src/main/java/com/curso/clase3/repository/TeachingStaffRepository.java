package com.curso.clase3.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.curso.clase3.model.TeachingStaff;

@Repository
public interface TeachingStaffRepository extends CrudRepository<TeachingStaff, Long> {

	 @Override
	 List<TeachingStaff> findAll();
}
