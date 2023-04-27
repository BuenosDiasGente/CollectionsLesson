package pro.sky.cours2.collectionsLesson.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pro.sky.cours2.collectionsLesson.Employee;
import pro.sky.cours2.collectionsLesson.exceptions.EmployeeStorageIsFullException;
import pro.sky.cours2.collectionsLesson.service.EmployeeServiceInterface;

@RestController()
@RequestMapping(path="/employee")
public class EmployeeController {
  private final EmployeeServiceInterface employeeService;

  public EmployeeController(EmployeeServiceInterface employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping(path = "/add")
  @ResponseStatus()
  public String addEmployee(@RequestParam("firstName")String firstName,
                            @RequestParam("lastName")String lastName){
    Employee employee=new Employee(firstName, lastName);
     return employeeService.addEmployee(employee);

  }
  @GetMapping(path = "/remove")
  @ResponseStatus()
    public String removeEmployee(@RequestParam("firstName")String firstName,
                                 @RequestParam("lastName")String lastName){
    Employee employee=new Employee(firstName, lastName);
    employeeService.removeEmployee(employee);
      return "Employee removed ";
  }
  @GetMapping(path = "/find")
  @ResponseStatus()
    public  String findEmployee(@RequestParam("firstName")String firstName,
                                @RequestParam("lastName")String lastName){
    Employee employee=new Employee(firstName, lastName);
    return employeeService.findEmployee(employee);

  }

}
