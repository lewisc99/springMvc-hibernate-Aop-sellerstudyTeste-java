package com.lewis.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lewis.springdemo.dao.SellerDAO;
import com.lewis.springdemo.entity.Seller;

@Service
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	private SellerDAO sellerDAO;
	
	
	
	@Override
	@Transactional
	public List<Seller> getSellers()
	{
		return sellerDAO.getSellers();
	}



	@Override
	@Transactional
	public void saveSeller(Seller theSeller) {
		 
	sellerDAO.saveSeller(theSeller);

		
	}



	@Override
	@Transactional
	public Seller getSeller(int theId) {
	 
		return sellerDAO.getSeller(theId);
	}



	@Override
	@Transactional
	public void deleteSeller(int theId) { 
		
		 sellerDAO.deleteSeller(theId);
		
	}
	
	

}
