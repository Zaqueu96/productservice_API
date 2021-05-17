package com.productserver.main.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productserver.main.filters.ProductFilter;
import com.productserver.main.filters.ProductFilterSpecification;
//import com.productserver.main.filters.ProductFilter;
import com.productserver.main.model.Product;
import com.productserver.main.repository.ProductRepository;



@Service
public class ProductService {

	@Autowired
	ProductRepository repository;
	
	/**
	 * List All Products 
	 * @return
	 */
	public List<Product> getAll(){
		return this.repository.findAll();
	}
	
	/**
	 * Create Product to Database
	 * @param product
	 * @return
	 */
	public Product createOrUpdate(Product product) {
		return this.repository.save(product);
	}
	
	/**
	 * Search Products 
	 * @return
	 */
	public List<Product> search(ProductFilter filter){			
		return this.repository.findAll(ProductFilterSpecification.filter(filter));
	}

	/**
	 * Show One Product
	 * @param id
	 * @return
	 */
	public Product show(Long id) {
		if(this.repository.existsById(id)) return this.repository.getOne(id);
		throw new EntityNotFoundException("Entity Not Found!!");
	}
	
	/**
	 * Delete Product
	 * @param id
	 */
	public void delete(Long id) {
		this.repository.delete(this.show(id));
	}
	
}
