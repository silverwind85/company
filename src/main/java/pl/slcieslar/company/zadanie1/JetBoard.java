package pl.slcieslar.company.zadanie1;

import java.util.Arrays;

    public class JetBoard extends VehicleComponent {
        @Override
        protected Iterable<? extends Environement> getEnviroment() {
            return Arrays.asList(Environement.values());
        }
    }

