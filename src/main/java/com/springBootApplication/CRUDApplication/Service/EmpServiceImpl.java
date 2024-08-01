package com.springBootApplication.CRUDApplication.Service;
import com.springBootApplication.CRUDApplication.Model.Employee;
import com.springBootApplication.CRUDApplication.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<Employee> getAllEmp() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> getEmpByID(Long id) {
        return employeeRepo.findById(id);
    }


    @Override
    public String updateEmp(Employee employee) {
        if (employeeRepo.existsById(employee.getEmpId())){
            Employee oldDetails = employeeRepo.findById(employee.getEmpId()).orElse(employee);
            oldDetails.setName(employee.getName());
            oldDetails.setPrimarySkill(employee.getPrimarySkill());
            oldDetails.setSecondarySkill(employee.getSecondarySkill());
            employeeRepo.save(oldDetails);
            return "Details updated for Employee -: "+employee.getName();
        }
        employeeRepo.save(employee);
        return "Details updated for Employee: "+employee.getName();
    }

    @Override
    public String removeEmp(Long id) {
        employeeRepo.deleteById(id);
        return "Employee with EmpID: "+id+" is removed to the Database";
    }

    @Override
    public String addEmp(Employee employee) {
        employeeRepo.save(employee);
        return "Employee: "+employee.getName()+" is added to the Database";
    }

}
