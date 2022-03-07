package com.lewis.springdemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lewis.springdemo.entity.Seller;



public interface SellerDAO {

	public List<Seller> getSellers();

	public void saveSeller(Seller theSeller);

	public Seller getSeller(int theId);

	public void deleteSeller(int theId);
}
