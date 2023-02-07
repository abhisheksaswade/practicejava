package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmpDetails();
	public Employee addEmpDetails(Employee transientEmp);
	public Employee updateEmpDetails(Employee detachedEmp);
	public String deleteEmpDetails(Long empId);
	public Employee fetchEmpDetails(Long empId);
	
	

}
