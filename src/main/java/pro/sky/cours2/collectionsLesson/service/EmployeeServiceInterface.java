package pro.sky.cours2.collectionsLesson.service;

import pro.sky.cours2.collectionsLesson.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeServiceInterface {
   // Map convertListBefore(List list);

    Employee addEmployee(String firsName, String lastName);
     Employee removeEmployee(String fistName,String lastName);
    Employee findEmployee(String fistName,String lastName);
    Collection<Employee> findAll();

}
