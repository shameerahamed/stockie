package com.stockie.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stockie.bean.EmployeeBean;
import com.stockie.dao.EmployeeDao;
import com.stockie.model.Employee;
import com.stockie.service.EmployeeService;

/**
 * @author Shameer Ahamed
 *
 */
@Service("employeeService")
@Transactional(propagation = Propagation.SUPPORTS)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public void addEmployee(EmployeeBean employeeBean) {
		employeeDao.addEmployee(prepareModel(employeeBean));
	}
	
	public List<EmployeeBean> listEmployees() {
		return prepareListofBean(employeeDao.listEmployees());
	}

	public EmployeeBean getEmployee(Long empid) {
		Employee employee = employeeDao.getEmployee(empid);		
		return prepareEmployeeBean(employee);
	}
	
	public void deleteEmployee(Long empId) {
		employeeDao.deleteEmployee(empId);
	}
	
	private Employee prepareModel(EmployeeBean employeeBean){
		Employee employee = new Employee();
		employee.setAddress(employeeBean.getAddress());
		employee.setAge(employeeBean.getAge());
		employee.setName(employeeBean.getName());
		employee.setDesignation(employeeBean.getDesignation());
		employee.setSalary(employeeBean.getSalary());
		employee.setEmpId(employeeBean.getEmpId());
		employee.setDob(employeeBean.getDob());
		employee.setDoj(employeeBean.getDoj());
		employee.setPhoneNo(employeeBean.getPhoneNo());
		employeeBean.setEmpId(null);
		return employee;
	}
	
	private List<EmployeeBean> prepareListofBean(List<Employee> employees){
		List<EmployeeBean> beans = null;
		if(employees != null && !employees.isEmpty()){
			beans = new ArrayList<EmployeeBean>();
			EmployeeBean bean = null;
			for(Employee employee : employees){
				bean = new EmployeeBean();
				bean.setName(employee.getName());
				bean.setEmpId(employee.getEmpId());
				bean.setAddress(employee.getAddress());
				bean.setSalary(employee.getSalary());
				bean.setAge(employee.getAge());
				bean.setDesignation(employee.getDesignation());
				bean.setDob(employee.getDob());
				bean.setDoj(employee.getDoj());
				bean.setPhoneNo(employee.getPhoneNo());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	private EmployeeBean prepareEmployeeBean(Employee employee){
		EmployeeBean bean = new EmployeeBean();
		bean.setName(employee.getName());
		bean.setEmpId(employee.getEmpId());
		bean.setAddress(employee.getAddress());
		bean.setSalary(employee.getSalary());
		bean.setAge(employee.getAge());
		bean.setDesignation(employee.getDesignation());
		bean.setDob(employee.getDob());
		bean.setDoj(employee.getDoj());
		bean.setPhoneNo(employee.getPhoneNo());
		return bean;
	}

}
