package com.lewis.springdemo.controller;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lewis.springdemo.dao.SellerDAO;
import com.lewis.springdemo.entity.Department;
import com.lewis.springdemo.entity.Seller;
import com.lewis.springdemo.service.DepartmentService;
import com.lewis.springdemo.service.SellerService;

@Controller
@RequestMapping("/seller")
public class CustomerController {

	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private DepartmentService depService;
	
	@RequestMapping("/list")
	public String listSellers(Model model)
	{
		List<Seller> theSellers = sellerService.getSellers();
		
	model.addAttribute("sellers",theSellers);
		
		return "list-sellers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Seller theSeller = new Seller();
		List<Department> theDep = depService.getDepartments();
		theModel.addAttribute("seller",theSeller);
		theModel.addAttribute("Dep",theDep);
		
		return "seller-form";
	}
	
	@PostMapping("/saveSeller")
	public String saveSeller(@ModelAttribute("seller") Seller theSeller)
	{
		
		sellerService.saveSeller(theSeller);
		return "redirect:/seller/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId, Model theModel)
	{
		//get the Seller from our service
		Seller theSeller = sellerService.getSeller(theId);
		List<Department> theDep = depService.getDepartments();
		
		//set the seller as a model attribute to pre-populate the form
		theModel.addAttribute("seller",theSeller);
		theModel.addAttribute("Dep",theDep);
		
		return "seller-form";
		
	}
	
	
	@GetMapping("/delete")
	public String Delete(@RequestParam("id") int theId)
	{ 
		sellerService.deleteSeller(theId);
		return "redirect:/seller/list";
	}
}
