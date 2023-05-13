package pro.sky.cours2.collectionsLesson.service;

import pro.sky.cours2.collectionsLesson.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee calculatinMinSalary(Integer departmentId);

    Employee calculatinMaxSalary(Integer departmentId);

    Map<Integer, List<Employee>>  allEmployeesDepartment();

    Map<Integer, List<Employee>> allEmployeesInDepartment(Integer departmentId);
}
