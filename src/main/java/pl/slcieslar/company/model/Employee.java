package pl.slcieslar.company.model;


import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private Long id;
    private  String name;
    private LocalDate created;
    private LocalDate update;

    public Employee() {
    }

    public Employee(String name, LocalDate created, LocalDate update) {
        this.name = name;
        this.created = created;
        this.update = update;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getUpdate() {
        return update;
    }

    public void setUpdate(LocalDate update) {
        this.update = update;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(created, employee.created) &&
                Objects.equals(update, employee.update);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, created, update);
    }



}
