package pl.slcieslar.company.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.slcieslar.company.model.Employee;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

public class EmployeeRepositoryImpTest {
    private final String FILE_PATH = "Output";
    private EmployeeRepository employeeRepository = new EmployeeRepositoryImp();
    static final String NAME_TEST = "Mike";
    static final Long ID_TEST = 1L;
    private Employee employee;

    public EmployeeRepositoryImpTest() throws IOException {
    }

    @Before
    public void setup() {
        employee = new Employee();
        employee.setId(ID_TEST);
        employee.setName(NAME_TEST);
        employeeRepository.create(employee);

    }

    @After
    public void after() {

        employeeRepository.deletAll();
    }

    @Test
    public void create() {
        Assert.assertEquals(1, employeeRepository.getAll().size());
        Assert.assertEquals(NAME_TEST, employeeRepository.getAll().get(0).getName());
    }

    @Test
    public void get() {

        Employee resultTest = employeeRepository.get(ID_TEST);

        Assert.assertEquals(resultTest.getName(), employeeRepository.getAll().get(0).getName());
    }

    @Test
    public void delete() {
        Assert.assertEquals(0, employeeRepository.getAll().size());

    }

    @Test
    public void update() {

        Employee resultEmployee = employeeRepository.getAll().get(0);
        resultEmployee.setCreated(LocalDate.now());
        Employee resultTest = employeeRepository.update(resultEmployee);
        Assert.assertEquals(resultTest.getCreated(), employeeRepository.getAll().get(0).getCreated());

    }

    @Test
    public void saveToFile() throws IOException {
        employeeRepository.create(employee);
        employeeRepository.saveToFile();
        List<Employee> result = employeeRepository.getAll();
        Assert.assertEquals(employee.getId(),result.get(0).getId());
    }

    @Test
    public void loadFromFile() throws IOException {
        employeeRepository.create(employee);
        employeeRepository.saveToFile();
        employeeRepository.loadFromFile();
        List<Employee> result = employeeRepository.getAll();
        Assert.assertEquals(employee.getId(),result.get(0).getId());
    }
}