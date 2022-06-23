package com.SpringApp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SpringApp1.exception.EventsNotFoundException;
import com.SpringApp1.model.Events;
import com.SpringApp1.service.EventService;

@Controller
public class EventController {
	
	@Autowired
	private EventService service;
	
	
	@GetMapping("/admin/events")
	public String showEventsList(Model model) {
		List<Events> listEvents = service.ListAll();
		model.addAttribute("listEvents", listEvents);
		
		return "events";
	}
	
	@GetMapping("/admin/events/new")
	public String showNewForm(Model model) {
		model.addAttribute("ev",new Events());
		model.addAttribute("pageTitle", "Add New Product");
		return "ev_form";
	}
	
	@PostMapping("/admin/events/save")
	public String saveEvent(Events ev,RedirectAttributes ra) {
		service.save(ev);
		ra.addAttribute("message","The event has been added successfully.");
		return "redirect:/admin/events";
	}
	
	@GetMapping("/admin/events/edit/{Eid}")
	public String showEditForm(@PathVariable("Eid") int Eid, Model model, RedirectAttributes ra) {
		try {
			Events ev = service.get(Eid);
			model.addAttribute("ev",ev);
			return "ev_form";
		}
		catch(EventsNotFoundException e) {
			ra.addFlashAttribute("message", "The event has been saved successfully.");
			return "redirect:/admin/events";
		}
	}
	
	@GetMapping("/admin/events/delete/{Eid}")
	public String deleteEvents(@PathVariable("Eid") int Eid, Model model, RedirectAttributes ra) {
		try {
			service.delete(Eid);
		}
		catch(EventsNotFoundException e) {
			ra.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/events";
	}
}
