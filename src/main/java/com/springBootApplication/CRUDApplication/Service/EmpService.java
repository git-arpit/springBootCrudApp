package com.springBootApplication.CRUDApplication.Service;
import com.springBootApplication.CRUDApplication.Model.Employee;
import java.util.List;

public interface EmpService {

    public List<Employee> getAllEmp();
    public Employee getEmpByID(Long id);
    public Employee updateEmp(Employee employee);
    public String removeEmp(Long id);
    public Employee addEmp(Employee employee);


}
