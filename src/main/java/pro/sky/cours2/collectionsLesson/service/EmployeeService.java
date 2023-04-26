package pro.sky.cours2.collectionsLesson.service;

import org.springframework.stereotype.Service;
import pro.sky.cours2.collectionsLesson.Employee;
import pro.sky.cours2.collectionsLesson.exceptions.EmployeeAlreadyAddedException;
import pro.sky.cours2.collectionsLesson.exceptions.EmployeeNotFoundException;
import pro.sky.cours2.collectionsLesson.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ivan", "Petrov"),
            new Employee("Sergei", "Ivanov"),
            new Employee("Ivan","Ivanov")
    ));

    @Override
    public String addEmployee(Employee employee) {
          if (employees.size() > 10) {
                throw new EmployeeStorageIsFullException(" Коллекция переполнена");
            } else if (employees.contains(employee)) {
              throw new EmployeeAlreadyAddedException(" Добавляемый сотрудник имеется в коллекции");
          }
          else {
                employees.add(employee);
            }return employee.getFirstName() + employee.getLastName();
    }

    @Override
    public String removeEmployee(Employee employee) {
        for (Employee employee1 : employees) {
            if (!employee1.getFirstName().equals(employee.getFirstName())|| !employee1.getLastName().equals(employee.getLastName())){
            throw new EmployeeNotFoundException(" Удаляемый сотрудник не найден");}
        } employees.remove(employee);
        return employee.getFirstName()+employee.getLastName();
    }

    @Override
    public String findEmployee(Employee employee) {
        for (Employee employee1 : employees) {
            if (!employee1.getFirstName().equals(employee.getFirstName())
                    || !employee1.getLastName().equals(employee.getLastName())) {
                throw new EmployeeNotFoundException(" Сотрудник не найден");
            }
        }
        return employee.getFirstName()+employee.getLastName();
    }

    }



