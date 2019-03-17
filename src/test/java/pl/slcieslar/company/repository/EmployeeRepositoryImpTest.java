package pl.slcieslar.company.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.slcieslar.company.model.Employee;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class EmployeeRepositoryImpTest {

    private  EmployeeRepository employeeRepository = new EmployeeRepositoryImp();
    static final String NAME_TEST = "Mike";
    static final Long ID_TEST = 1L;

    @Before
    public void setup(){
          Employee employee = new Employee();
        employee.setId(ID_TEST );
          employee.setName(NAME_TEST );
          employeeRepository.create(employee);

    }
    @After
    public void after(){
        employeeRepository.deletAll();

    }

    @Test
    public void create() {
        Assert.assertEquals(1,employeeRepository.getAll().size());
        Assert.assertEquals(NAME_TEST ,employeeRepository.getAll().get(0).getName());
    }

    @Test
    public void get() {

        Employee resultTest = employeeRepository.get(ID_TEST);

        Assert.assertEquals(resultTest.getName(),employeeRepository.getAll().get(0).getName());
    }

    @Test
    public void delete() {

        Employee resultTest = employeeRepository.delete(ID_TEST);
        Assert.assertEquals(0,employeeRepository.getAll().size());

    }

    @Test
    public void update() {

        Employee resultEmployee = employeeRepository.getAll().get(0);
        resultEmployee.setCreated(LocalDate.now());
        Employee resultTest = employeeRepository.update(resultEmployee);
        Assert.assertEquals(resultTest.getCreated(),employeeRepository.getAll().get(0).getCreated());

    }
}