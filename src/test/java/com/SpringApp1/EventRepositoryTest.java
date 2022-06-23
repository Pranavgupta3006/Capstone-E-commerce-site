package com.SpringApp1;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.SpringApp1.repository.EventRepository;
import com.SpringApp1.model.Events;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class EventRepositoryTest {

	@Autowired
	private EventRepository repo;
	
	@Test
	public void testAddNew() {
		Events ev = new Events();
		ev.setEname("Diwali");
		ev.setEstartdate("2022-06-12");
		ev.setEenddate("2022-07-30");
		
		Events savedEvents = repo.save(ev);
		
		Assertions.assertThat(savedEvents).isNotNull();
		Assertions.assertThat(savedEvents.getEid()).isGreaterThan(0);
	}
	
	@Test
	public void testListAll() {
		
		Iterable<Events> evs = repo.findAll();
		Assertions.assertThat(evs).hasSizeGreaterThan(0);
		
		for(Events ev : evs) {
			System.out.println(ev);
		}
		
	}
	
	@Test
	public void testUpdate() {
		Integer Eid = 2;
		Optional<Events> optionalEvents = repo.findById(Eid);
		Events ev = optionalEvents.get();
		ev.setEname("Sankranthi");
		repo.save(ev);
		
		Events updateEvents = repo.findById(Eid).get();
		Assertions.assertThat(updateEvents.getEname()).isEqualTo("Sankranthi");
	}
	
	@Test
	public void testGet() {
		Integer Eid = 2;
		Optional<Events> optionalEvents = repo.findById(Eid);
		Assertions.assertThat(optionalEvents).isPresent();
		System.out.println(optionalEvents.get());
	}
	
	@Test
	public void testDelete() {
		Integer Eid = 4;
		repo.deleteById(Eid);
		
		Optional<Events> optionalEvents = repo.findById(Eid);
		Assertions.assertThat(optionalEvents).isNotPresent();	
	}
}
