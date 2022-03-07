package com.lewis.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lewis.springdemo.entity.Seller;


@Repository
public class SellerDAOImpl implements SellerDAO{

	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<Seller> getSellers() {
		 
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Seller> theQuery = session.createQuery("from Seller order by name",Seller.class);
		
		List<Seller>  sellers = theQuery.getResultList();
		return sellers;
	}


	@Override
	public void saveSeller(Seller theSeller) {
 
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer ... finally LOL
		currentSession.saveOrUpdate(theSeller);
		
	}


	@Override
	public Seller getSeller(int theId) {
		 
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		Seller theSeller = currentSession.get(Seller.class, theId);
		
		return theSeller;
	}


	@Override
	public void deleteSeller(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = 
				currentSession.createQuery("delete from Seller where id=:sellerId");
		theQuery.setParameter("sellerId", theId);
		
		
		
		 theQuery.executeUpdate();
	}

}
