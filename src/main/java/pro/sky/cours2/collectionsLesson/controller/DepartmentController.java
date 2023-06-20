package pro.sky.cours2.collectionsLesson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.sky.cours2.collectionsLesson.Employee;
import pro.sky.cours2.collectionsLesson.service.DepartmentService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {

        this.departmentService = departmentService;
    }


    @GetMapping(path = "/{id}/salary/max")

    public Employee calculatinMaxSalary(@PathVariable Integer departmentId){
        return departmentService.calculatinMaxSalary(departmentId);

    }
    @GetMapping(path = "/{id}/salary/min")

    public Employee calculatinMinSalary(@PathVariable Integer departmentId){
        return departmentService.calculatinMinSalary(departmentId);
    }

    @GetMapping(path = "/{id}/salary/sum")
    public Map<Integer, Integer> sumSalaryInDepartment(@PathVariable Integer departmentId){
        return departmentService.sumSalaryInDepartment(departmentId);
    }

    @GetMapping(path = "/{id}/employees")

    public Map<Integer, List<Employee>> allEmployeesInDepartment(@PathVariable Integer departmentId){
        return departmentService.allEmployeesInDepartment(departmentId);
    }
    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> allEmployeesDepartment(){

        return departmentService.allEmployeesDepartment();
    }


}
