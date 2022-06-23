package com.SpringApp1.global;

import java.util.ArrayList;
import java.util.List;

import com.SpringApp1.model.Products;

public class GlobalCartData {
	public static List<Products> cart;
	static {
		cart = new ArrayList<Products>();
	}

}