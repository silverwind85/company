package pl.slcieslar.company.repository;

import com.google.gson.Gson;
import pl.slcieslar.company.model.Employee;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeRepositoryImp implements EmployeeRepository {

    private List<Employee> employeeList = new ArrayList<>();
    private  Gson gson = new Gson();
    private Long autoIncrement =0L;
    @Override
    public Employee create(Employee employee) {
        autoIncrement++;
        employee.setId(autoIncrement);
        employeeList.add(employee);
        String s = gson.toJson(employee);
        return gson.fromJson(s,Employee.class);
    }
    @Override
    public Employee get(Long id) {
        Employee employee = employeeList.stream().filter(e->e.getId().equals(id)).findAny().orElse(null);
        String s = gson.toJson(employee);
         return gson.fromJson(s,Employee.class);
    }
    @Override
    public void delete(Long id) {
        Employee employee = employeeList.stream().filter(e->e.getId().equals(id)).findAny().orElse(null);
        employeeList.remove(employee);
    }
    @Override
    public Employee update(Employee employee) {
        Employee employee1 = employeeList.stream().filter(e->e.getId().equals(employee.getId())).findAny().orElse(null);
        employeeList.set(employeeList.indexOf(employee1),employee1);
        String s = gson.toJson(employee);
        return gson.fromJson(s,Employee.class);
    }
    @Override
    public List<Employee> getAll() {
        String s = gson.toJson(employeeList);
        return Arrays.asList(gson.fromJson(s,Employee[].class));
    }
    @Override
    public void deletAll() {
        employeeList.removeAll(employeeList);

    }
}
