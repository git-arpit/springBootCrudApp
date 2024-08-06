package com.springBootApplication.CRUDApplication.Service;
import com.springBootApplication.CRUDApplication.Model.Employee;
import com.springBootApplication.CRUDApplication.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmp() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmpByID(String id) {
        return employeeRepo.findById(Long.valueOf(id)).orElse(null);
    }


    @Override
    public Employee updateEmp(Employee employee) {
        if(!employeeRepo.existsById(Long.parseLong(employee.getEmpId()))){ return null;}
        return employeeRepo.save(employee);
    }

    @Override
    public String removeEmp(String id) {
        if(employeeRepo.existsById(Long.parseLong(id))){
            employeeRepo.deleteById(Long.parseLong(id));
            return "success";}
        return "failed";
    }

    public Employee addEmp(Employee employee) {
        if (employeeRepo.existsById(Long.parseLong(employee.getEmpId()))){
            return null;
        }

        return employeeRepo.saveAndFlush(employee);

    }

    @Override
    public List<Employee> searchByKeyword(String key) {
       return employeeRepo.findByCommentsContainingIgnoreCase(key);
    }

}
