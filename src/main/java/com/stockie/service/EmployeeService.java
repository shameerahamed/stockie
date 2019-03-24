package com.stockie.service;

import java.util.List;

import com.stockie.bean.EmployeeBean;

/**
 * @author Shameer Ahamed
 *
 */
public interface EmployeeService {
	
	public void addEmployee(EmployeeBean employeeBean);

	public List<EmployeeBean> listEmployees();
	
	public EmployeeBean getEmployee(Long empId);
	
	public void deleteEmployee(Long empId);
}
