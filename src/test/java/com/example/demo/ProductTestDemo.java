package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.enitity.Product;
import com.example.demo.repository.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductTestDemo {

	@Autowired
	private ProductRepository repository;

	@Test
	@Rollback(false)
	public void testCreateProduct() {
		Product savedProduct = repository.save(new Product("iPhone 10", 789));

		assertThat(savedProduct.getId()).isGreaterThan(0);
	}

	@Test
	public void testFindProductByName() {
		Product product = repository.findByName("iPhone 10");
		assertThat(product.getName()).isEqualTo("iPhone 10");
		System.out.println("success");
	}

	@Test
	public void testListProducts() {
		List<Product> products = (List<Product>) repository.findAll();
		assertThat(products).size().isGreaterThan(0);
	}

}