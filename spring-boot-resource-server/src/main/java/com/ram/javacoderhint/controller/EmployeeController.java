package com.ram.javacoderhint.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {


	@Autowired
	EmployeeRepository repository;
	
	@GetMapping("/me")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Principal> get(final Principal principal) {
		return ResponseEntity.ok(principal);
	}	

	@PreAuthorize("permitAll()")  
	@GetMapping("/employees")
	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> employeeList = repository.findAll();

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}	
	@PreAuthorize("permitAll()")  
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
		EmployeeEntity employee = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		return new ResponseEntity<EmployeeEntity>(employee, new HttpHeaders(), HttpStatus.OK);

	}
		
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/employees")
	ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@RequestBody EmployeeEntity newEmployee) {
		return repository.findById(newEmployee.getId()).map(employee -> {
			employee.setFirstName(newEmployee.getFirstName());
			employee.setLastName(newEmployee.getLastName());
			employee.setEmail(newEmployee.getEmail());
			EmployeeEntity employeeEntity = repository.save(employee);
			return new ResponseEntity<EmployeeEntity>(employeeEntity, new HttpHeaders(), HttpStatus.OK);
		}).orElseGet(() -> {
			newEmployee.setId(newEmployee.getId());
			EmployeeEntity employeeEntity = repository.save(newEmployee);
			return new ResponseEntity<EmployeeEntity>(employeeEntity, new HttpHeaders(), HttpStatus.OK);
		});
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
		repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		repository.deleteById(id);
	}

}
