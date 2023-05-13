package pro.sky.cours2.collectionsLesson.service;

import pro.sky.cours2.collectionsLesson.Employee;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {
   // Map convertListBefore(List list);

    Employee addEmployee(String firsName, String lastName,Integer departmentId,Integer salary);
     Employee removeEmployee(String fistName,String lastName);
    Employee findEmployee(String fistName,String lastName);
    Map <String,Employee>getAllEmployees();

}
