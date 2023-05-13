package pro.sky.cours2.collectionsLesson.service;

import org.springframework.stereotype.Service;
import pro.sky.cours2.collectionsLesson.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final EmployeeService employeeService;
    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee calculatinMinSalary(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee calculatinMaxSalary(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Map<Integer, List<Employee>> allEmployeesDepartment() {
        return  employeeService.getAllEmployees().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }

    @Override
    public Map<Integer,List<Employee>> allEmployeesInDepartment(Integer departmentId) {

        return employeeService.getAllEmployees().values().stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                        .collect(Collectors.groupingBy(Employee::getDepartmentId));

    }
}
