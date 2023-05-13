package pro.sky.cours2.collectionsLesson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    @GetMapping(path = "/max-salary")

    public Employee calculatinMaxSalary(@RequestParam("departmentId")Integer departmentId){
        return departmentService.calculatinMaxSalary(departmentId);

    }
    @GetMapping(path = "/min-salary")

    public Employee calculatinMinSalary(@RequestParam("departmentId")Integer departmentId){
        return departmentService.calculatinMinSalary(departmentId);
    }
    @GetMapping(path = "/all")

    public Map<Integer, List<Employee>> allEmployeesInDepartment(@RequestParam("departmentId")Integer departmentId){
        return departmentService.allEmployeesInDepartment(departmentId);
    }
    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> allEmployeesDepartment(){

        return departmentService.allEmployeesDepartment();
    }



}
