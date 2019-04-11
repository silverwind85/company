package pl.slcieslar.company;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.slcieslar.company.model.Employee;
import pl.slcieslar.company.repository.EmployeeRepositoryImp;

import java.io.IOException;
import java.time.LocalDate;

@SpringBootApplication
public class CompanyApplication {


    public static void main(String[] args) throws IOException {


        EmployeeRepositoryImp employeeRepositoryImp = new EmployeeRepositoryImp();
        employeeRepositoryImp.loadFromFile();
        for (int i = 0;i <10 ; i++){
            employeeRepositoryImp.create(new Employee("Maria " +i, LocalDate.of(2012,12,1 +i),LocalDate.of(2013,12,1 +i) ));
        };
        employeeRepositoryImp.saveToFile();

        System.out.println(employeeRepositoryImp.get(1L));



    }

}
