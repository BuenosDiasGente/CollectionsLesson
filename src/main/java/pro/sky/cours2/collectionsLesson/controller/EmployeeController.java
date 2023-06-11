package pro.sky.cours2.collectionsLesson.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.cours2.collectionsLesson.Employee;
import pro.sky.cours2.collectionsLesson.service.EmployeeService;
import pro.sky.cours2.collectionsLesson.validator.EmployeeValidator;

import java.util.Map;

@RestController()
@RequestMapping("/employee")
public class EmployeeController {
  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {

    this.employeeService = employeeService;
  }

  @GetMapping(path = "/add")

  public ResponseEntity <Employee>addEmployee(@RequestParam("firstName")String firstName,
                                             @RequestParam("lastName")String lastName,
                                             @RequestParam("departmenId")Integer departmentId,
                                             @RequestParam("salary")Integer salary)
  {
    if(EmployeeValidator.validate(firstName,lastName))
     return ResponseEntity.ok(EmployeeService.addEmployee(firstName,lastName));
    else {
      return ResponseEntity.badRequest().build();

    }

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
  public Map<String,Employee> getAllEmployees(){
    return employeeService.getAllEmployees();
  }


}
