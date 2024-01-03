package com.jspiders.smswithspringrest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.smswithspringrest.pojo.Admin;

@Repository
public class AdminRespository {

	@Autowired
	private EntityManager entityManager;

	public Admin addAdmin(Admin admin) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
		return admin;
	}

	@SuppressWarnings("unchecked")
	public List<Admin> getAllAdmins() {
		Query query = entityManager.createQuery("SELECT admin FROM Admin admin");
		return query.getResultList();
	}

}
