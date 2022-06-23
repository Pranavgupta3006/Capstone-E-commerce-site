package com.SpringApp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.SpringApp1.repository.EventRepository;
import com.SpringApp1.exception.EventsNotFoundException;
import com.SpringApp1.model.Events;

@Service
public class EventService {

	@Autowired
	private EventRepository repo;
	
	public List<Events> ListAll(){
		return (List<Events>) repo.findAll();
	}
	
	public void save(Events ev) {
		repo.save(ev);
	}
	
	public Events get(int Eid) throws EventsNotFoundException{
		Optional<Events> result = repo.findById(Eid);
		if(result.isPresent()) {
			return result.get();
		}
		throw new EventsNotFoundException("Could not find any event with Eid"+Eid);
	}
	
	public void delete(int Eid) throws EventsNotFoundException{
		repo.deleteById(Eid);
	}
	
}
