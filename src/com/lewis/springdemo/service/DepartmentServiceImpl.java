package com.lewis.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lewis.springdemo.dao.DepartmentDAO;
import com.lewis.springdemo.entity.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentDAO depService;
	
	
	
	@Transactional
	@Override
	public List<Department> getDepartments()
	{
		return depService.getDepartments();
	}

}
