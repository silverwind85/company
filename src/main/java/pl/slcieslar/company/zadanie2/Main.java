package pl.slcieslar.company.zadanie2;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
       Integer[][] table = {{1, 2, 3}, {4, 5, 6,9}, {8, 9, 10}};
        WalkArrayTwoDimensional<Integer> walkArrayTwoDimensional = new WalkArrayTwoDimensional(table);
        walkArrayTwoDimensional.hasNext();
        walkArrayTwoDimensional.hasNext();
        System.out.println(walkArrayTwoDimensional.next());
        walkArrayTwoDimensional.hasNext();
        System.out.println(walkArrayTwoDimensional.next());
        walkArrayTwoDimensional.hasNext();
        System.out.println(walkArrayTwoDimensional.next());
        walkArrayTwoDimensional.hasNext();
        System.out.println(walkArrayTwoDimensional.next());
        walkArrayTwoDimensional.hasNext();
        System.out.println(walkArrayTwoDimensional.next());
        walkArrayTwoDimensional.hasNext();
        System.out.println(walkArrayTwoDimensional.next());
        walkArrayTwoDimensional.hasNext();
        System.out.println(walkArrayTwoDimensional.next());
        walkArrayTwoDimensional.hasNext();
        System.out.println(walkArrayTwoDimensional.next());
        walkArrayTwoDimensional.hasNext();
        System.out.println(walkArrayTwoDimensional.next());
        walkArrayTwoDimensional.hasNext();


    }
}
