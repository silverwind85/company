package pl.slcieslar.company.zadanie1;

public abstract class VehicleComponent implements  Vehicle{

    @Override
    public void move() {
        getEnviroment().forEach(e-> System.out.println("moving on " + e.name()   ));
    }
    protected abstract Iterable<? extends Environement> getEnviroment();
}
