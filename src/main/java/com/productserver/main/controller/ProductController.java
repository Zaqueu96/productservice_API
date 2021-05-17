package com.productserver.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productserver.main.filters.ProductFilter;
import com.productserver.main.model.Product;
import com.productserver.main.service.ProductService;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
	
	@Autowired
	ProductService service;

	@GetMapping
	public ResponseEntity<List<Product>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@PostMapping
	public ResponseEntity<Product> create(@Valid @RequestBody Product product){
		return ResponseEntity.ok(service.createOrUpdate(product));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> show(@PathVariable Long id){
		return ResponseEntity.ok(service.show(id));
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Product>> search(ProductFilter filter){
		return ResponseEntity.ok(service.search(filter));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> show(@Valid @RequestBody Product product,@PathVariable Long id){
		product.setId(id);
		return ResponseEntity.ok(service.createOrUpdate(product));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){;
			this.service.delete(id);
	}
}
