package pro.sky.cours2.collectionsLesson.service;

import org.springframework.stereotype.Service;
import pro.sky.cours2.collectionsLesson.Employee;
import pro.sky.cours2.collectionsLesson.exceptions.EmployeeAlreadyAddedException;
import pro.sky.cours2.collectionsLesson.exceptions.EmployeeNotFoundException;
import pro.sky.cours2.collectionsLesson.exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService implements EmployeeServiceInterface {


    public  Map<String,Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firsName,String lastName) {
        Employee employee=new Employee(firsName,lastName);
        if(employees.containsKey(employee.getKey())){
            throw new EmployeeAlreadyAddedException(" Добавляемый сотрудник имеется в коллекции");
        }
        employees.put(employee.getKey(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String fistName,String lastName) {
        Employee employee=new Employee(fistName,lastName);
                if(employees.containsKey(employee.getKey())){
                    employees.remove(employee.getKey());
                    return employee;}
        throw new EmployeeNotFoundException(" Удаляемый сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String fistName,String lastName) {
        Employee employee=new Employee(fistName,lastName);
        if(employees.containsKey(employee.getKey())){
            return employees.get(employee.getKey());
        }
        throw new EmployeeNotFoundException(" Сотрудник не найден");
    }
    @Override
    public Collection<Employee>findAll(){
        return Collections.unmodifiableCollection(employees.values());


    }

    }



