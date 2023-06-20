package pro.sky.cours2.collectionsLesson.service;

import pro.sky.cours2.collectionsLesson.Employee;

import java.util.Map;

public interface EmployeeService {
   // Map convertListBefore(List list);

    Employee addEmployee(String firstName, String lastName,Integer departmentId,Integer salary);
     Employee removeEmployee(String firstName,String lastName);
    Employee findEmployee(String firstName,String lastName);
    Map <String,Employee>getAllEmployees();

}
