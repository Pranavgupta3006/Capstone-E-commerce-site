package com.SpringApp1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SpringApp1.exception.CartItemNotFoundException;
import com.SpringApp1.exception.CouponsNotFoundException;
import com.SpringApp1.global.GlobalCartData;
import com.SpringApp1.model.CartItem;
import com.SpringApp1.model.Coupons;
import com.SpringApp1.model.Products;
import com.SpringApp1.service.CartService;
import com.SpringApp1.service.ProductService;

@Controller
public class CartController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/addToCart/{id}")
	public String addToCart(@PathVariable int id)
	{
		GlobalCartData.cart.add(productService.getProductById(id).get());
		return "redirect:/shop";
	}
//	
	@GetMapping("/cart")
	public String cartGet(Model model)
	{
		model.addAttribute("cartCount", GlobalCartData.cart.size());
		model.addAttribute("total", GlobalCartData.cart.stream().mapToDouble(Products::getPrice).sum());
		model.addAttribute("cart", GlobalCartData.cart);
		return "cart";
	}
//	
	@GetMapping("/cart/removeItem/{index}")
	public String cartItemRemove(@PathVariable int index)
	{
		GlobalCartData.cart.remove(index);
		return "redirect:/cart";
	}
	
	@GetMapping("/checkout")
	public String checkout(Model model)
	{
		model.addAttribute("total", GlobalCartData.cart.stream().mapToDouble(Products::getPrice).sum());
		return "checkout";
	}
//	@Autowired
//	private CartService service;
//	@GetMapping("/cart")
//	public String showCartList(Model model) {
//		List<CartItem> listCartItem = service.listAll();
//		model.addAttribute("listCartItem",listCartItem);
//		return "cart";
//	}
	
//	@GetMapping("/addToCart")
//	public String showNewForm(Model model) {
//		model.addAttribute("cart", new CartItem());
//		model.addAttribute("pageTitle","Add New Coupons");
//		return "cart";
//	}
	
//	@PostMapping("/cart/save")
//	public String saveCart(@PathVariable int id) {
//		service.save(productService.getProductById(id).get());
//		ra.addAttribute("message","The CartItem got added successfully!");
//		return "redirect:/cart";
//	}
	
//	@GetMapping("/admin/coupons/edit/{Cid}")
//	public String showEditForm(@PathVariable("Cid") int Cid, Model model, RedirectAttributes ra) {
//		try {
//			Coupons coup = service.get(Cid);
//			model.addAttribute("coup",coup);
//			model.addAttribute("pageTitle", "Edit Coupon (Id: "+Cid+")");
//			return "coup_form";
//		}
//		catch(CouponsNotFoundException e) {
//			ra.addFlashAttribute("message","The coupon has been saved successfully");
//			return "redirect:/admin/coupons";
//		}
//	}
	
//	@GetMapping("/cart/delete/{id}")
//	public String deleteCoupons(@PathVariable("id") int id,Model model, RedirectAttributes ra) {
//		try {
//			service.delete(id);
//		}
//		catch(CartItemNotFoundException e) {
//			ra.addAttribute("message",e.getMessage());
//		}
//		return "redirect:/cart";
//	}
}
