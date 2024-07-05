package net.javaguides.ms.controller;

//contoller layer is depend on service layer


import lombok.AllArgsConstructor;
import net.javaguides.ms.dto.EmployeeDto;
import net.javaguides.ms.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*") //* means all the client can able to call emp related

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")

public class EmployeeController { //capable of handle HTTP request next

    private EmployeeService employeeService;
    //build add emp rest API

    @PostMapping //spring annotation to map the incoming Http post request to this method
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){ //@RequestBody =add body annotation to extract Json from the http request it convert Json into emp2 object
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED); //value to the constructor,value as a constructor
    }

    //build get emp rest API
    @GetMapping("{id}") //to map the incoming http request to this method  //the id is url temp method
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){ //its generic  //employeeId method nm
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId); //getEmployeeById this will return Empduto
        return ResponseEntity.ok(employeeDto); //url template var nm is id  & the method argument is empid so both var nm is different so we need to pass url temp variable annoatatio to pathvariable
    }

    //built get all employee rest APT
    @GetMapping //make this method as a RTP by using spring annotation
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List <EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    //build update emp REST API
    @PutMapping("{id}")
    public  ResponseEntity<EmployeeDto> updatedEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updatedEmployee){ //arguments pass

        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee); //parameter pass
        return ResponseEntity.ok(employeeDto);
    }
    //build delete emp REST API
    @DeleteMapping("{id}") //to delete incoming http delete request to this method
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")  Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee delete successfully.");
    }
}
