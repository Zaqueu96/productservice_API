package com.productserver.main.filters;

import java.util.ArrayList;

import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.productserver.main.model.Product;

@PersistenceContext
public class ProductFilterSpecification {
	
	
	public static Specification<Product> filter(ProductFilter filter) {
		return new Specification<Product> () {
			/**
			 * 
			 */
			private static final long serialVersionUID = -7928464770110943245L;

			@Override
			public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				
				ArrayList<Predicate> predicates = new  ArrayList<Predicate>();
				if(filter.getQ() != null || filter.getQ() != null){
					Predicate nameCompare = cb.like(root.get("name"), "%"+filter.getQ()+"%");
					Predicate descriptionCompare = cb.like(root.get("description"), "%"+filter.getQ()+"%");
					predicates.add(cb.or(nameCompare,descriptionCompare));
				}
				if(filter.getMin_price() != null)
					predicates.add(cb.greaterThan(root.get("price"), filter.getMin_price()));
				if(filter.getMax_price() != null)
					predicates.add(cb.lessThan(root.get("price"), filter.getMax_price()));

				
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
			
			}
		
		;
	}

}
