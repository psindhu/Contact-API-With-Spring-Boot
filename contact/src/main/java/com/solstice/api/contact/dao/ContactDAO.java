package com.solstice.api.contact.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solstice.api.contact.entity.Contact;

@Transactional
@Repository
public class ContactDAO implements IContactDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getAllContacts() {
		String hql = "FROM Contact as cnt ORDER BY cnt.id";
		return (List<Contact>) entityManager.createQuery(hql).getResultList();
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteAllContacts() {
		String hql = "delete FROM Contact";
		entityManager.createQuery(hql).executeUpdate();
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteContactByID(Long id) {
		String hql = "delete FROM Contact where id = "+id;
		entityManager.createQuery(hql).executeUpdate();
	}	
	
} 
