package com.stockie.dao;

import java.util.List;

import com.stockie.model.Employee;

/**
 * @author Shameer Ahamed
 *
 */
public interface EmployeeDao {
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployees();
	
	public Employee getEmployee(Long empId);
	
	public void deleteEmployee(Long empId);
}
