package pl.slcieslar.company.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.slcieslar.company.model.Employee;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class JsonPersistance<T> {

   private String pathJsonFile;

    public JsonPersistance(String pathJsonFile) {
        this.pathJsonFile = pathJsonFile;
    }

    private Gson gson = new GsonBuilder().create();
    private Writer writer;
    private Reader reader;

    public void persist(T t) throws IOException {
        writer = new FileWriter(pathJsonFile);
        String json = gson.toJson(t);

        gson.toJson(t,writer);
        writer.close();
    }
    public Employee find(Long id ) throws FileNotFoundException, UnsupportedEncodingException {
        Reader reader = new InputStreamReader(new FileInputStream(pathJsonFile),"UTF-8");
        Employee [] e = gson.fromJson(reader, Employee[].class);
        List<Employee> employeeList = Arrays.asList(e);
        return employeeList.stream().filter(emp->emp.getId().equals(id)).findAny().orElse(null);


    }

}
