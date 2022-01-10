package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enitity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public void saveOrUpdate(Product product) {
		productRepository.save(product);
	}

	public Product getProductById(int id) {
		return productRepository.findById(id).get();
	}

	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		productRepository.findAll().forEach(x -> products.add(x));
		return products;
	}

	public void delete(int id) {
		Optional<Product> product = productRepository.findById(id);

		if (product.isPresent()) {
			productRepository.deleteById(id);

		}
	}
}
