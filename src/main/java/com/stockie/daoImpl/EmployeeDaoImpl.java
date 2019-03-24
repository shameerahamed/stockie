package com.stockie.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stockie.dao.EmployeeDao;
import com.stockie.model.Employee;

/**
 * @author Shameer Ahamed
 *
 */
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> listEmployees() {
		return (List<Employee>) sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}

	public Employee getEmployee(Long empid) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);
	}

	public void deleteEmployee(Long empid) {
		sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE empId = "+empid).executeUpdate();
	}

}
