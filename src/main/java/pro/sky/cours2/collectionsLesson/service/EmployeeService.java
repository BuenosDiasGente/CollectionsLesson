package pro.sky.cours2.collectionsLesson.service;

import org.springframework.stereotype.Service;
import pro.sky.cours2.collectionsLesson.Employee;
import pro.sky.cours2.collectionsLesson.exceptions.EmployeeAlreadyAddedException;
import pro.sky.cours2.collectionsLesson.exceptions.EmployeeNotFoundException;
import pro.sky.cours2.collectionsLesson.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private  final List<Employee> employees;

    public EmployeeService(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public Employee addEmployee(String firsName,String lastName) {
        Employee employee=new Employee(firsName,lastName);
        if(employees.contains(employee)){
            throw new EmployeeAlreadyAddedException(" Добавляемый сотрудник имеется в коллекции");
        }
        else if (employees.size() > 10){
            throw new EmployeeStorageIsFullException(" Коллекция переполнена");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String fistName,String lastName) {
        Employee employee=new Employee(fistName,lastName);
                if(employees.contains(employee)){
                    employees.remove(employee);
                    return employee;}
        throw new EmployeeNotFoundException(" Удаляемый сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String fistName,String lastName) {
        Employee employee=new Employee(fistName,lastName);
        if(employees.contains(employee)){
            return employee;
        }
        throw new EmployeeNotFoundException(" Сотрудник не найден");
    }
    @Override
    public Collection<Employee>findAll(){
        return new ArrayList<>(employees);
    }

    }



