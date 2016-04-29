/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jre.api;

import com.leapfrog.jre.DAO.EmployeeDAO;
import com.leapfrog.jre.DAOImpl.EmployeeDAOImpl;
import com.leapfrog.jre.entity.Employee;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


/**
 * REST Web Service
 *
 * @author Narayan
 */
@Path( value = "/employee")
public class EmployeeAPI {
    
    EmployeeDAO employees=new EmployeeDAOImpl();
    
    @GET
    @Produces(value = "application/json")
    public List<Employee> index(){
        
        
        
        return employees.getAll();

}
    
}
