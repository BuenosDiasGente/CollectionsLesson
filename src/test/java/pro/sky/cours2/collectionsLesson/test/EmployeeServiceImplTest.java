package pro.sky.cours2.collectionsLesson.test;

import org.junit.jupiter.api.Test;
import pro.sky.cours2.collectionsLesson.Employee;
import pro.sky.cours2.collectionsLesson.service.EmployeeServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeServiceImplTest {
   private  final EmployeeServiceImpl employeeService= new EmployeeServiceImpl();


    @Test
   public void shouldReturnAddEmployee() {
        Employee employee=new Employee("Sergei","Petrov",1,45000);
        employeeService.addEmployee("Sergei","Petrov",1,45000);
        Map<String,Employee> actual=employeeService.getAllEmployees();
        Map<String, Employee> expected=new HashMap<>();
        expected.put(employee.getFirstName()+employee.getLastName(),employee);
         assertEquals(expected,actual);

    }

    @Test
    public void shouldReturnRemoveEmployee() {
        Employee employee=new Employee("Sergei","Petrov",1,45000);
        employeeService.addEmployee("Sergei","Petrov",1,45000);
        employeeService.removeEmployee(employee.getFirstName(),employee.getLastName());
        Map<String,Employee> actual=employeeService.getAllEmployees();
        Map<String, Employee> expected=new HashMap<>();
        assertEquals(expected,actual);
    }
    @Test
    public void shouldReturnEmployeeAlreadyAddedException(){
        Employee employee=new Employee("Sergei","Petrov",1,45000);
        employeeService.addEmployee("Sergei","Petrov",1,45000);
        assertThrows(RuntimeException.class,
                ()->
                    employeeService.addEmployee("Sergei", "Petrov", 1, 45000)
                );
    }
    @Test
    public  void shouldReturnEmployeeNotFoundException(){
        Employee employee=new Employee("Sergei","Petrov",1,45000);
      assertThrows(RuntimeException.class,
              ()->employeeService.removeEmployee("Sergei","Petrov"));
    }

    @Test
    public void shouldReturnFindEmployee() {
       // Employee employee=new Employee("Sergei","Petrov",1,45000);
        employeeService.addEmployee("Alex","Petrov",2,45000);
        Employee actual=employeeService.findEmployee("Alex","Petrov");
        Employee expected=new Employee("Alex","Petrov",2,45000);
        assertEquals(expected,actual);

    }
    @Test
    public void shouldReturnNotFoundExceptionInEmployee() {

        assertThrows(RuntimeException.class,
                ()->employeeService.findEmployee("Sergei","Petrov"));

    }
}