/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jre.DAOImpl;

import com.leapfrog.jre.DAO.EmployeeDAO;
import com.leapfrog.jre.entity.Department;
import com.leapfrog.jre.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Narayan
 */
public class EmployeeDAOImpl implements EmployeeDAO{
    
    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction trans;

    public EmployeeDAOImpl() {
        
        emf=Persistence.createEntityManagerFactory("JAXPU");
        em=emf.createEntityManager();
        
    }
    
    

    @Override
    public List<Employee> getAll() {

        List<Employee> empList= em.createQuery("SELECT e FROM Employee e").getResultList();
        
        return empList;
    
    }

    @Override
    public Employee getById(int id) {
       
        Employee e=(Employee)em.find(Employee.class, id);
        em.close();
        return e;
    }

    @Override
    public void insert(Employee t) {
        if(!trans.isActive()){
        trans=em.getTransaction();
        }
        em.persist(t);
        em.flush();
        trans.commit();
        em.close();
        
    }

    @Override
    public void update(Employee t) {
        trans=em.getTransaction();
        if(!trans.isActive()){
        trans.begin();
        }
        em.merge(t);
        em.flush();
        trans.commit();
    em.close();
    
    }

    @Override
    public void delete(Employee t) {
        trans=em.getTransaction();
        if(!trans.isActive()){
        trans.begin();
        }
        em.remove(t);
        trans.commit();
    em.close();
    }
    
}
