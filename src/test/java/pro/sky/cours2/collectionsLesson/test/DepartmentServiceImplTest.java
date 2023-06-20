package pro.sky.cours2.collectionsLesson.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.cours2.collectionsLesson.Employee;
import pro.sky.cours2.collectionsLesson.service.DepartmentServiceImpl;
import pro.sky.cours2.collectionsLesson.service.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    private final List<Employee> employees=new ArrayList<>(List.of(
            new Employee("Sergei","Petrov",1,50000),
            new Employee("Denis","Ivanov",1,60000),
            new Employee("Dmitrii","Ivanov",2,35000)

    ));

    @Test
    void shouldReturnEmployeeWithMinSalary() {
        final int departmentId=1;
        final Map<String,Employee> employeesMap=new HashMap<>();
        for(Employee employee:employees) {
            employeesMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        when(employeeService.getAllEmployees()).thenReturn(employeesMap);
        // when
       Employee employeeWithMinSalary =departmentService.calculatinMinSalary(departmentId);
        //then
        assertEquals(employees.get(0),employeeWithMinSalary);
        Mockito.verify(employeeService,times(1)).getAllEmployees();

    }
    @Test
    void shouldReturnWhenEmployeeDepartmentNull(){
        final int departmentId=3;
        final Map<String,Employee> employeesMap=new HashMap<>();
        for(Employee employee:employees) {
            employeesMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        when(employeeService.getAllEmployees()).thenReturn(employeesMap);
        // when
        Employee employeeWithMinSalary =departmentService.calculatinMinSalary(departmentId);
        //then
        assertNull(employeeWithMinSalary);
        Mockito.verify(employeeService,times(1)).getAllEmployees();

    }
    @Test
    void shouldReturnEmployeeWithMaxSalary() {
        // given
        final int departmentId=1;
        final Map<String,Employee> employeesMap=new HashMap<>();
        for(Employee employee:employees) {
            employeesMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        when(employeeService.getAllEmployees()).thenReturn(employeesMap);
        // when
       Employee employeeWithMaxSalary=departmentService.calculatinMaxSalary(departmentId);
        //then
        assertEquals(employees.get(1),employeeWithMaxSalary);
        Mockito.verify(employeeService,times(1)).getAllEmployees();
    }
    @Test
    void shouldReturnWhenEmployeeDepartmentIdNull(){
        final int departmentId=3;
        final Map<String,Employee> employeesMap=new HashMap<>();
        for(Employee employee:employees) {
            employeesMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        when(employeeService.getAllEmployees()).thenReturn(employeesMap);
        // when
        Employee employeeWithMaxSalary =departmentService.calculatinMaxSalary(departmentId);
        //then
        assertNull(employeeWithMaxSalary);
        Mockito.verify(employeeService,times(1)).getAllEmployees();

    }
    @Test
    void shouldReturnAllEmployees() {
        // given
        final Map<String,Employee> employeesMap=new HashMap<>();
        for(Employee employee:employees) {
            employeesMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        final List<Employee> employees1=new ArrayList<>(List.of(
                new Employee("Sergei","Petrov",1,50000)
        ));
        final List<Employee> employees2=new ArrayList<>(List.of(
                new Employee("Denis","Ivanov",1,60000)
        ));
        final List<Employee> employees3=new ArrayList<>(List.of(
                new  Employee("Dmitrii","Ivanov",2,35000)
        ));

        final Map<Integer,List<Employee>> expectedAllEmployees=new HashMap<>();
            expectedAllEmployees.put(employees.get(0).getDepartmentId(), (List<Employee>) employees1);
            expectedAllEmployees.put(employees.get(1).getDepartmentId(), (List<Employee>) employees2);
            expectedAllEmployees.put(employees.get(2).getDepartmentId(), (List<Employee>) employees3);

        when(employeeService.getAllEmployees()).thenReturn(employeesMap);
        // when
        Map<Integer, List<Employee>> actualAllEmployeeInDepartment= departmentService.allEmployeesDepartment();
        //then
        assertEquals(expectedAllEmployees,actualAllEmployeeInDepartment);
        Mockito.verify(employeeService,times(1)).getAllEmployees();
    }

    @Test
    void shouldReturnAllEmployeesInDepartment() {
        // given
        final int departmentId=1;
        final Map<String,Employee> employeesMap=new HashMap<>();
        for(Employee employee:employees) {
            employeesMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        final List<Employee> employees1=new ArrayList<>(List.of(
                new Employee("Sergei","Petrov",1,50000)
        ));
        final List<Employee> employees2=new ArrayList<>(List.of(
                new Employee("Denis","Ivanov",1,60000)
        ));
        final List<Employee> employees3=new ArrayList<>(List.of(
                new  Employee("Dmitrii","Ivanov",2,35000)
        ));

        final Map<Integer,List<Employee>> expectedAllEmployeesInDepartment=new HashMap<>();
        expectedAllEmployeesInDepartment.put(employees.get(0).getDepartmentId(), (List<Employee>) employees1);
        expectedAllEmployeesInDepartment.put(employees.get(1).getDepartmentId(), (List<Employee>) employees2);
        expectedAllEmployeesInDepartment.put(employees.get(2).getDepartmentId(), (List<Employee>) employees3);


        when(employeeService.getAllEmployees()).thenReturn(employeesMap);
        // when
       Map<Integer, List<Employee>> actualAllEmployeeInDepartment= departmentService.allEmployeesInDepartment(departmentId);
        //then
        assertEquals(expectedAllEmployeesInDepartment,actualAllEmployeeInDepartment);
        Mockito.verify(employeeService,times(1)).getAllEmployees();
    }
    @Test
    void shouldReturnAllEmployeesInDepartmentNull() {
        // given
        final int departmentId=3;
        final Map<String,Employee> employeesMap=new HashMap<>();
        for(Employee employee:employees) {
            employeesMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        final List<Employee> employees1=new ArrayList<>(List.of(
                new Employee("Sergei","Petrov",1,50000)
        ));
        final List<Employee> employees2=new ArrayList<>(List.of(
                new Employee("Denis","Ivanov",1,60000)
        ));
        final List<Employee> employees3=new ArrayList<>(List.of(
                new  Employee("Dmitrii","Ivanov",2,35000)
        ));

        final Map<Integer,List<Employee>> expectedAllEmployeesInDepartment=new HashMap<>();
        expectedAllEmployeesInDepartment.put(employees.get(0).getDepartmentId(), (List<Employee>) employees1);
        expectedAllEmployeesInDepartment.put(employees.get(1).getDepartmentId(), (List<Employee>) employees2);
        expectedAllEmployeesInDepartment.put(employees.get(2).getDepartmentId(), (List<Employee>) employees3);

        when(employeeService.getAllEmployees()).thenReturn(employeesMap);
        // when
        Map<Integer, List<Employee>> actualAllEmployeeInDepartment= departmentService.allEmployeesInDepartment(departmentId);
        //then
        assertNotNull(actualAllEmployeeInDepartment);
        Mockito.verify(employeeService,times(1)).getAllEmployees();
    }

    @Test
    void shouldReturnSumSalaryInDepartment() {
        // given
        final int departmentId=1;
        final Map<String,Employee> employeesMap=new HashMap<>();
        for(Employee employee:employees) {
            employeesMap.put(employee.getFirstName() + employee.getLastName(), employee);
        }
        when(employeeService.getAllEmployees()).thenReturn(employeesMap);
        // when
        Map<Integer, Integer> employeeSumSalary =departmentService.sumSalaryInDepartment(departmentId);
        Map<Integer, Integer> sumSalaryExpected=new HashMap<>();
        sumSalaryExpected.put(1,110000);
        //then
        assertEquals(sumSalaryExpected,employeeSumSalary);
        Mockito.verify(employeeService,times(1)).getAllEmployees();
    }
}