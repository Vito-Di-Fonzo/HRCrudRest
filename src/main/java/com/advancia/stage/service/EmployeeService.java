package com.advancia.stage.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.advancia.stage.dao.Dao;
import com.advancia.stage.model.Employee;

@Path("/employees")
public class EmployeeService {

	// URI:
	// /contextPath/servletPath/employees
	@GET
	@Produces({ MediaType.APPLICATION_JSON }) // eliminare xml e lasciare solo i file di messaggi di JSON
	public List<Employee> getEmployees_JSON() {
		List<Employee> listOfCountries = Dao.getAllEmployees();
		return listOfCountries;
	}

	// URI:
	// /contextPath/servletPath/employees/{empNo}
	@GET
	@Path("/{empNo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Employee getEmployee(@PathParam("EMPLOYEE_ID") int EMPLOYEE_ID) {
		return Dao.getEmployee(EMPLOYEE_ID);
	}

	// URI:
	// /contextPath/servletPath/employees
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	public Employee addEmployee(Employee emp) {
		return Dao.addEmployee(emp);
	}

	// URI:
	// /contextPath/servletPath/employees
	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	public Employee updateEmployee(Employee emp) {
		return Dao.updateEmployee(emp);
	}

	@DELETE
	@Path("/{empNo}")
	@Produces({ MediaType.APPLICATION_JSON })
	public void deleteEmployee(@PathParam("EMPLOYEE_ID") String EMPLOYEE_ID) {
		Dao.deleteEmployee(EMPLOYEE_ID);
	}

}