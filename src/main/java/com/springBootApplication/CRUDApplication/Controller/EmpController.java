package com.springBootApplication.CRUDApplication.Controller;
import com.springBootApplication.CRUDApplication.Model.Employee;
import com.springBootApplication.CRUDApplication.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class EmpController {
   @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public ResponseEntity<List<Employee>> allEmployees(){
        List<Employee> resultList = new ArrayList<>();
        resultList = this.empService.getAllEmp();
        if (resultList.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(resultList));
    }

    @GetMapping("/emp/{empID}")
    public ResponseEntity<Employee> employeeById(@PathVariable("empID") String s){
        Employee result = new Employee();
        result = empService.getEmpByID(s);
        if (result==null){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.of(Optional.of(result));
    }
    @PostMapping("/addemp")
    public ResponseEntity<String> addEmployee(@RequestBody Employee emp){
        Employee result = new Employee();
        result = empService.addEmp(emp);
        if(result!=null){
            return  ResponseEntity.status(HttpStatus.CREATED).body("The Employee "+ result.getName()+" added successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Addition of employee details has been failed");

    }

    @PutMapping("/update")
    public ResponseEntity<String> updateDetails(@RequestBody Employee emp){
        if(empService.updateEmp(emp)!=null){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Details for Employee ID: "+emp.getEmpId()+" updated successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such employee exist - update failed");
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> removeDetails(@PathVariable("id") String id){
        String result = empService.removeEmp(id);
        if (result.equalsIgnoreCase("failed")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such employee exist - failed to delete");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Employee (ID: "+id+") deleted successfully");
    }

    @PostMapping("/search")
    public ResponseEntity<List<Employee>> searchByKeyword(@RequestParam String keyword){
        List<Employee> resultList = new ArrayList<>();
        resultList = empService.searchByKeyword(keyword);
        if(resultList.size()<=0){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.of(Optional.of(resultList));
    }

    }

