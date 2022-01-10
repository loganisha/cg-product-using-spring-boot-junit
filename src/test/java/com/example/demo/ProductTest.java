package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.demo.enitity.Product;
import com.example.demo.repository.ProductRepository;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductTest {
	@Autowired
	private ProductRepository repo;

	@Order(1)
	@Test
	public void testCreateProduct() {

		Product product = new Product();
		product.setName("testdata1");
		product.setPrice(1234);
		Product savedProduct = repo.save(product);

		assertNotNull(savedProduct);
		System.out.println("tested....");
	}

	@Order(2)
	@Test
	public void testFindProductByNameExist() {
		String name = "testdata1";
		Product product = repo.findByName(name);
		assertThat(product.getName()).isEqualTo(name);
	}
//
//	@Order(3)
//	@Test
//	public void testFindProductByNameNotExist() {
//		String name = ("iPhone22");
//		Product product = repo.findByName(name);
//		assertNull(product);
//	}
//
//	@Order(4)
//	@Test
//	public void testUpdateProduct() {
//		String productName = "Vivo";
//		Product product = new Product(productName, 389);
//		product.setId(4);
//		repo.save(product);
//		Product updateProduct = repo.findByName(productName);
//		assertThat(updateProduct.getName()).isEqualTo(productName);
//	}
//
//	@Test
//	@Order(5)
//	public void testread() {
//		List<Product> products = (List<Product>) repo.findAll();
//		assertThat(products).size().isGreaterThan(0);
//	}
//
//	@Order(6)
//	public void testDeletePRoduct() {
//		Integer id = 2;
//		boolean isExistBeforDelete = repo.findById(id).isPresent();
//		if (isExistBeforDelete = true) {
//			repo.deleteById(id);
//		}
//		boolean NotExistAfterDelete = repo.findById(id).isPresent();
//		assertTrue(isExistBeforDelete);
//		assertFalse(NotExistAfterDelete);
//
//	}
}
