package pl.slcieslar.company.model.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.slcieslar.company.model.Employee;
import pl.slcieslar.company.repository.EmployeeRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/employees")

public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<List<Employee>>(employeeService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> getEmplyee(@PathVariable Long id){
        return  new ResponseEntity<Employee>(employeeService.findById(id));
    }

    @PostMapping
    public  ResponseEntity<Employee> create(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.create(employee);}

    }
    @PutMapping
    public ResponseEntity<Employee>  update(@Valid  @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.update(employee)) ;

    }
    @DeleteMapping
    public void delete(@RequestBody Employee employee) {
        employeeService.delete(employee);
    }


}
