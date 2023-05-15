package pro.sky.cours2.collectionsLesson.service;

import org.springframework.stereotype.Service;
import pro.sky.cours2.collectionsLesson.Employee;
import pro.sky.cours2.collectionsLesson.exceptions.EmployeeAlreadyAddedException;
import pro.sky.cours2.collectionsLesson.exceptions.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final  Map<String,Employee> employees;

    public EmployeeServiceImpl() {

        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName,String lastName,Integer departmentId,Integer salary) {
        String key=new String(getEmployeeKey(firstName, lastName));
        if(employees.containsKey(key)){
            throw new EmployeeAlreadyAddedException(" Добавляемый сотрудник имеется в коллекции");
        }
        employees.put(key, new Employee(firstName,lastName,departmentId,salary));
        return employees.get(key);
    }

    @Override
    public Employee removeEmployee(String firstName,String lastName) {
        String key=new String(getEmployeeKey(firstName, lastName));
        if(employees.containsKey(key))
        {
                    employees.remove(key);
                    return employees.get(key);
        }
        throw new EmployeeNotFoundException(" Удаляемый сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String firstName,String lastName) {
        String key=new String(getEmployeeKey(firstName, lastName));
        if(employees.containsKey(key))
        {
            return employees.get(key);
        }
        throw new EmployeeNotFoundException(" Сотрудник не найден");
    }

    @Override
    public Map<String, Employee> getAllEmployees() {

        return employees;
    }
    private String getEmployeeKey(String firstName,String lastName){
        return firstName+lastName;

    }



    }



