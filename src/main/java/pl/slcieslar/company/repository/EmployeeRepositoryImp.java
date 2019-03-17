package pl.slcieslar.company.repository;

import com.google.gson.Gson;
import pl.slcieslar.company.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeRepositoryImp implements EmployeeRepository {

    private List<Employee> employeeLixt = new ArrayList<>();
    private  Gson gson = new Gson();
    @Override
    public Employee create(Employee employee) {
        employeeLixt.add(employee);
        String s = gson.toJson(employee);
        return gson.fromJson(s,Employee.class);
    }

    @Override
    public Employee get(Long id) {
        Employee employee = employeeLixt.stream().filter(e->e.getId().equals(id)).findAny().orElse(null);
        String s = gson.toJson(employee);
         return gson.fromJson(s,Employee.class);

    }
    @Override
    public Employee delete(Long id) {
        Employee employee = employeeLixt.stream().filter(e->e.getId().equals(id)).findAny().orElse(null);
        employeeLixt.remove(employee);
        String s = gson.toJson(employee);
        return gson.fromJson(s,Employee.class);
    }

    @Override
    public Employee update(Employee employee) {
        Employee employee1 = employeeLixt.stream().filter(e->e.getId().equals(employee.getId())).findAny().orElse(null);
        employeeLixt.set(employeeLixt.indexOf(employee1),employee1);
        String s = gson.toJson(employee);
        return gson.fromJson(s,Employee.class);
    }

    @Override
    public List<Employee> getAll() {

        return employeeLixt;
    }

    @Override
    public List<Employee> deletAll() {
        employeeLixt.removeAll(employeeLixt);
        return employeeLixt;
    }


}
