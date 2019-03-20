package pl.slcieslar.company.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.slcieslar.company.model.Employee;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class JsonPersistanceTest {
    private Employee employee ;
    static final String FILE_PATH = "Output.json";
    List<Employee> employees;

    @Before
    public void setUp() throws Exception {
        employee = new Employee();
        employee.setId(1L);
        employee.setName("Mike");
        employees= new ArrayList<>();
        employees.add(employee);

    }

    @After
    public void tearDown() throws Exception {
        Files.deleteIfExists(Paths.get(FILE_PATH));
    }

    @Test
    public void persist() throws IOException {
        JsonPersistance jsonPersistance = new JsonPersistance(FILE_PATH);
        jsonPersistance.persist(employees);

        Reader reader = new InputStreamReader(new FileInputStream(FILE_PATH),"UTF-8");
        Gson gson = new GsonBuilder().create();
        Employee [] e = gson.fromJson(reader, Employee[].class);
        List<Employee> eResult = Arrays.asList(e);
        Assert.assertEquals(eResult.get(0).getId(),employees.get(0).getId());
    }
    @Test
    public void find() throws IOException {
        JsonPersistance jsonPersistance = new JsonPersistance(FILE_PATH);
        jsonPersistance.persist(employees);
        Employee e = jsonPersistance.find(1L);
        Assert.assertEquals(e.getId(),employees.get(0).getId());

    }
}