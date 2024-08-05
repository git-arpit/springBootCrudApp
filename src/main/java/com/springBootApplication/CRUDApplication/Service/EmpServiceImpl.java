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
    public Employee getEmpByID(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }


    @Override
    public Employee updateEmp(Employee employee) {
        if(!employeeRepo.existsById(employee.getEmpId())){ return null;}
        return employeeRepo.save(employee);
    }

    @Override
    public String removeEmp(Long id) {
        if(employeeRepo.existsById(id)){
            employeeRepo.deleteById(id);
        return "success";}
        return "failed";
    }

    @Override
    public Employee addEmp(Employee employee) {
        if (employeeRepo.existsById(employee.getEmpId())){
            return null;
        }
       return employeeRepo.save(employee);

    }

}
