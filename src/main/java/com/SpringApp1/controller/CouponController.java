package com.SpringApp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.SpringApp1.exception.CouponsNotFoundException;
import com.SpringApp1.model.Coupons;
import com.SpringApp1.service.CouponService;

@Controller
public class CouponController {

	@Autowired
	private CouponService service;
	
	@GetMapping("/admin/coupons")
	public String showCouponList(Model model) {
		List<Coupons> listCoupons = service.listAll();
		model.addAttribute("listCoupons", listCoupons);
		return "coupons";
	}
	
	@GetMapping("/admin/coupons/new")
	public String showNewForm(Model model) {
		model.addAttribute("coup", new Coupons());
		model.addAttribute("pageTitle","Add New Coupons");
		return "coup_form";
	}
	
	@PostMapping("/admin/coupons/save")
	public String saveCoupon(Coupons coup, RedirectAttributes ra) {
		service.save(coup);
		ra.addAttribute("message","The coupon has benn added successfully");
		return "redirect:/admin/coupons";
	}
	
	@GetMapping("/admin/coupons/edit/{Cid}")
	public String showEditForm(@PathVariable("Cid") int Cid, Model model, RedirectAttributes ra) {
		try {
			Coupons coup = service.get(Cid);
			model.addAttribute("coup",coup);
			model.addAttribute("pageTitle", "Edit Coupon (Id: "+Cid+")");
			return "coup_form";
		}
		catch(CouponsNotFoundException e) {
			ra.addFlashAttribute("message","The coupon has been saved successfully");
			return "redirect:/admin/coupons";
		}
	}
	
	@GetMapping("/admin/coupons/delete/{Cid}")
	public String deleteCoupons(@PathVariable("Cid") int Cid,Model model, RedirectAttributes ra) {
		try {
			service.delete(Cid);
		}
		catch(CouponsNotFoundException e) {
			ra.addAttribute("message",e.getMessage());
		}
		return "redirect:/admin/coupons";
	}
}
