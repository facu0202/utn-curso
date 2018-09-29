package com.curso.clase2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.curso.clase2.domain.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Customer findById(Long id){
		return entityManager.find(Customer.class, id);
	}
	
	public Customer save(Customer customer){
		Customer result = customer;
		if (customer.getId() == null) {
			entityManager.persist(customer);
		} else {
			if (!entityManager.contains(customer)) {
				result = entityManager.merge(customer);
			}
		}
		return result;
	}

	@Override
	public List<Customer> findAll() {
		// Creo un query builder
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		// digo que mis query van a ser del objeto customer
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        // idem pero que root voy a tomar
        Root<Customer> rootEntry = cq.from(Customer.class);
        // armar el SQL
        CriteriaQuery<Customer> all = cq.select(rootEntry);
        TypedQuery<Customer> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
	}

	@Override
	public List<Customer> findAll(int page, int pageSize) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> rootEntry = cq.from(Customer.class);
        CriteriaQuery<Customer> all = cq.select(rootEntry);
        TypedQuery<Customer> allQuery = entityManager.createQuery(all);
        //Paginacion
        allQuery.setFirstResult((page-1) * pageSize); 
        allQuery.setMaxResults(pageSize);
        return allQuery.getResultList();
	}
	
	@Override
	public List<Customer> findByFirstname(String firstname) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> rootEntry = cq.from(Customer.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        CriteriaQuery<Customer> all = cq.select(rootEntry).where(cb.equal(rootEntry.get("firstname"), p));
        TypedQuery<Customer> allQuery = entityManager.createQuery(all).setParameter(p, firstname);
        return allQuery.getResultList();
	}
	
	
}