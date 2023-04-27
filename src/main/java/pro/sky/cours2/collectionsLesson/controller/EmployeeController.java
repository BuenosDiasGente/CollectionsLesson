package pro.sky.cours2.collectionsLesson.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pro.sky.cours2.collectionsLesson.Employee;
import pro.sky.cours2.collectionsLesson.exceptions.EmployeeStorageIsFullException;
import pro.sky.cours2.collectionsLesson.service.EmployeeServiceInterface;

import java.util.Collection;

@RestController()
@RequestMapping("/employee")
public class EmployeeController {
  private final EmployeeServiceInterface employeeService;

  public EmployeeController(EmployeeServiceInterface employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping(path = "/add")

  public Employee addEmployee(@RequestParam("firstName")String firstName,
                            @RequestParam("lastName")String lastName){
     return employeeService.addEmployee(firstName,lastName);

  }
  @GetMapping(path = "/remove")

    public Employee removeEmployee(@RequestParam("firstName")String firstName,
                                 @RequestParam("lastName")String lastName){
    return employeeService.removeEmployee(firstName,lastName);

  }
  @GetMapping(path = "/find")

    public  Employee findEmployee(@RequestParam("firstName")String firstName,
                                @RequestParam("lastName")String lastName){
    return employeeService.findEmployee(firstName, lastName);
  }
  @GetMapping
  public Collection<Employee> findAll(){
    return employeeService.findAll();
  }


}
