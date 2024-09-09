package main.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Row implements Iterable<Double>{
    private List<Double> row;

    public Row() {
        row = new ArrayList<>();
    }

    public Row(List<Double> row) {
        this.row = row;
    }

    public void add(Double element) {
        row.add(element);
    }

    // EFFECTS: find the index of first non-zero entry(i.e. [0,0,6,3,5] return 2),return the index if find one, else return 99;
    public int findIndexNonZero() {
        int pos = 0;
        for (Double num : row) {
            if (num != 0) {
                return pos;
            }
            pos++;
        }
        return 99;
    }

    public void scale() {
        int tempPos = findIndexNonZero();
        if (99 != tempPos) {
            double scalar = row.get(tempPos);
            for (int i = 0;i < row.size();i++) {
                row.set(i,row.get(i)/scalar);
            }
        }
    }

    public Double get(int index) {
        return row.get(index);
    }

    public int size() {
        return row.size();
    }

    public void set(int index, double num) {
        row.set(index,num);
    }

    @Override
    public Iterator<Double> iterator() {
        return row.iterator();
    }

}
