package com.flipkart.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.flipkart.dao.CustomerDao;
import com.flipkart.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@PersistenceContext
	private EntityManager entityManager;
    
	public Customer getCustomerByPhnNumAndPassword(Long phnNum, String password) {

		String sql = "SELECT cs.* FROM customers cs WHERE cs.mobile_number = :num and cs.password = :pass";
		Query query = entityManager.createNativeQuery(sql, Customer.class);
		query.setParameter("num", phnNum);
		query.setParameter("pass", password);
		try {
            return (Customer) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
		
		
	}
    @org.springframework.transaction.annotation.Transactional
	public void createNewCustomer(Customer customer) {
		
		String sql = "insert into customers ( mobile_number, user_name, email, address, password ) value (:num, :name, :email, :address, :pass)";
		Query query = entityManager.createNativeQuery(sql, Customer.class);
		query.setParameter("num", customer.getMobileNumber());
		query.setParameter("name", customer.getUserName());
		query.setParameter("email", customer.getEmail());
		query.setParameter("address", customer.getAddress());
		query.setParameter("pass", customer.getPassword());
		query.executeUpdate();

	}
}
