package com.leapfrog.jre.entity;

import com.leapfrog.jre.entity.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-29T13:35:26")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile ListAttribute<Department, Employee> employeeList;
    public static volatile SingularAttribute<Department, String> name;
    public static volatile SingularAttribute<Department, Integer> id;

}