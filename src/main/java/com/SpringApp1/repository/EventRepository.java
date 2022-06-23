package com.SpringApp1.repository;

import org.springframework.data.repository.CrudRepository;

import com.SpringApp1.model.Events;

public interface EventRepository extends CrudRepository<Events, Integer> {

	

//	public Long countById(Long Pid);
}
