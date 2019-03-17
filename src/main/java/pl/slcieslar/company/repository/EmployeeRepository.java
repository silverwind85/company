package pl.slcieslar.company.repository;

import pl.slcieslar.company.model.Employee;

import java.util.List;

public interface EmployeeRepository  {

     Employee create (Employee employee);
     Employee get (Long id);
     Employee delete (Long id );
     Employee update(Employee employee);
     List<Employee> getAll();
     List<Employee> deletAll();



}
