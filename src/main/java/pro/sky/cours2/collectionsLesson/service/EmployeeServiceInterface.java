package pro.sky.cours2.collectionsLesson.service;

import pro.sky.cours2.collectionsLesson.Employee;

public interface EmployeeServiceInterface {

   String addEmployee(Employee employee);

   String  removeEmployee(Employee employee);

   String findEmployee(Employee employee);
}
