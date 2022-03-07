package com.lewis.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lewis.springdemo.entity.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO{

	@Autowired
	private SessionFactory factory;
	
	@Override
	public List<Department> getDepartments() {
			Session session = factory.getCurrentSession();
			
			Query<Department> theQuery = session.createQuery("from Department order by name",Department.class);
			
			List<Department> departments = theQuery.getResultList();
			
		return departments;
	}

}
