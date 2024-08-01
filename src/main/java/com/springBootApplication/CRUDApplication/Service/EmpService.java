package com.springBootApplication.CRUDApplication.Service;
import com.springBootApplication.CRUDApplication.Model.Employee;
import java.util.List;
import java.util.Optional;

public interface EmpService {

    public List<Employee> getAllEmp();
    public Optional<Employee> getEmpByID(Long id);
    public String updateEmp(Employee employee);
    public String removeEmp(Long id);
    public String addEmp(Employee employee);


}
