package pl.slcieslar.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.slcieslar.company.model.Employee;
import pl.slcieslar.company.repository.EmployeeRepository;
import pl.slcieslar.company.repository.EmployeeRepositoryImp;

@SpringBootApplication
public class CompanyApplication {

    public static void main(String[] args) {
        Employee employee = new Employee();
        EmployeeRepository employeeRepository = new EmployeeRepositoryImp();
        employeeRepository.create(employee);
        employee.setName("Mike");
        employee.setName("Anna Kowalska");
        employee.setId(1L);
        Employee employee2 = new Employee();
        employee2.setId(1L);
        employee2.setName("Anna Kowalska-Nowak");
        System.out.println(employee.equals(employee2));
    }

}
