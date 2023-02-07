package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.EmployeeService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping
	public List<Employee> getAllEmps()
	{
		return empService.getAllEmpDetails();
	}
	
	@GetMapping("/{empId}")
	public Employee getById(@PathVariable Long empId)
	{
		return empService.fetchEmpDetails(empId);
	}
	
	@PostMapping
	public Employee saveEmpDetails(@RequestBody Employee transientEmp)
	{
		return empService.addEmpDetails(transientEmp);
	}
	
	@PutMapping
	public Employee updateEmpDetails(@RequestBody Employee detachedEmp)
	{
		return empService.updateEmpDetails(detachedEmp);
	}
	
	@DeleteMapping("/{empId}")
	public String deleteEmpDetails(@PathVariable Long empId)
	{
		return empService.deleteEmpDetails(empId);
	}

}
