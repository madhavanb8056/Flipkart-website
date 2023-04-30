package com.flipkart.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.flipkart.dao.ProductDao;
import com.flipkart.model.Catagory;
import com.flipkart.model.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Product> getAllProducts() {
          
		String sql = "SELECT * FROM products";
		Query query = entityManager.createNativeQuery(sql, Product.class);
		return query.getResultList();

       }
	

	public List<Catagory> getAllCatagories() {
        String sql = "SELECT * FROM product_catagory";
        Query query = entityManager.createNativeQuery(sql, Catagory.class);
		return query.getResultList();
		
	}
	
	public List<Product> searchProducts(String search) {
		String sql = "SELECT * FROM products p left join product_catagory pc on pc.id = p.catagory_id WHERE p.product_name LIKE '%"+search+"%' or pc.name like '%"+search+"%'";
		Query query = entityManager.createNativeQuery(sql, Product.class);
		
		try {
            return query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
	}
	
	public List<Product> getProductsByCatagoryId(int id) {
        String sql = "select * from products p where p.catagory_id = :id";
        Query query = entityManager.createNativeQuery(sql, Product.class);
        query.setParameter("id", id);
        
    	try {
            return query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
		
		
		
	}
	public Product getProductById(int id){
		String sql = "select * from products p where p.id = :id";
		Query query = entityManager.createNativeQuery(sql, Product.class);
		query.setParameter("id", id);
		try {
            return (Product) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
		
		
	}

}
