package com.springBootApplication.CRUDApplication.Controller;
import com.springBootApplication.CRUDApplication.Model.Employee;
import com.springBootApplication.CRUDApplication.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/home")
public class EmpController {
   @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public List<Employee> allEmployees(){
        return this.empService.getAllEmp();
    }

    @GetMapping("/emp/{empID}")

    public Optional<Employee> employeeById(@PathVariable("empID") String s){
        return this.empService.getEmpByID(Long.parseLong(s));
    }
    @PostMapping("/addemp")
    public String addEmployee(@RequestBody Employee emp){
        return this.empService.addEmp(emp);
    }

    @PostMapping("/update")
    public String updateDetails(@RequestBody Employee emp){
        return this.empService.updateEmp(emp);
    }

    @DeleteMapping("/del/{id}")
    public String removeDetails(@PathVariable("id") Long id){
        return this.empService.removeEmp(id);
    }


    }

