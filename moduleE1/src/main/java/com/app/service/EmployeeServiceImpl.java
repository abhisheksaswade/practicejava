package com.app.service;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Employee;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmpDetails() {
		return empRepo.findAll();
	}

	@Override
	public Employee addEmpDetails(Employee transientEmp) {
		return empRepo.save(transientEmp);
	}

	@Override
	public Employee updateEmpDetails(Employee detachedEmp) {
		return empRepo.save(detachedEmp);
	}

	@Override
	public String deleteEmpDetails(Long empId) {
		if(empRepo.existsById(empId))
		{
			empRepo.deleteById(empId);
			return "Succesfully deleted";
		}
		return "failed to delete....";
	}

	@Override
	public Employee fetchEmpDetails(Long empId) {
		
		if(empRepo.existsById(empId))
		{
			return empRepo.findById(empId).orElseThrow();
		}
		return new Employee();
	}

}
