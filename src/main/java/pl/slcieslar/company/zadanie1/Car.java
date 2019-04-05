package pl.slcieslar.company.zadanie1;

import java.util.Collections;

public class Car extends VehicleComponent {

    @Override
    protected Iterable<? extends Environement> getEnviroment() {
        return Collections.singletonList(Environement.GROUND);
    }

    @Override
    public void move() {
        System.out.print("car output " ) ; super.move();
    }
}
