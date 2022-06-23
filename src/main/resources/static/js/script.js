function add_to_cart(id,name,price){
	
	let cart = localStorage.getItem("cart");
	if(cart == null){
		
		let products=[];
		let product = {productId : id, productName: name, productQuantity:1, productPrice: price}
		products.push(product);
		localStoage.setItem("cart", JSON.stringify(products));
		
	}else
	{
		//Cart is already present
	}
	
}