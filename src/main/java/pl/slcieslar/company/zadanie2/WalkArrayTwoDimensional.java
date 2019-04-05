package pl.slcieslar.company.zadanie2;

public class WalkArrayTwoDimensional<T> implements ArrayIterator {
    private T[][] array;
    private int row = 0;
    private int col = 1;


    public WalkArrayTwoDimensional(T[][] array) {
        this.array = array;

    }

    @Override
    public boolean hasNext() {
        if (row == array.length){
            System.out.println("false");
            return false;
        }
        System.out.println("true");
        return true;
    }

    @Override
    public Object next() {
        if (col == array[row].length-1) {
            if (row == array.length) {
                throw new IndexOutOfBoundsException("Bum! Bum!:)");
            }
            T tmpArray = array[row][col];
            col = 0;
            row++;
            return tmpArray;
        }
        T tmpArray = array[row][col];
        col++;
        return tmpArray;
    }
}
