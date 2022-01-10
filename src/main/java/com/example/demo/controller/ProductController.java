package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enitity.Product;
import com.example.demo.services.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@PostMapping("/productcreate")
	private int saveProduct(@RequestBody Product product) {
		productService.saveOrUpdate(product);
		return product.getId();

	}

	@GetMapping("/productget/{id}")
	private Product getProduct(@PathVariable int id) {
		return productService.getProductById(id);
	}

	@GetMapping("/productallget")
	private List<Product> getAllProducts() {
		return productService.findAll();
	}

	@DeleteMapping("/productdelete/{id}")
	private void deleteProduct(@PathVariable int id) {

		productService.delete(id);

	}

}
