package com.lewis.springdemo.service;

import java.util.List;

import com.lewis.springdemo.entity.Seller;

public interface SellerService {
	
	public List<Seller> getSellers();

	public void saveSeller(Seller theSeller);

	public  Seller getSeller(int theId);

	public void deleteSeller(int theId);
	
	

}
