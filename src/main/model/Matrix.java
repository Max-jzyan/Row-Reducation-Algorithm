package main.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Matrix {
    private List<Row> matrix;
    
    public Matrix() {
        matrix = new ArrayList<>();
    }

    

    // EFFECTS: swap the order of two row; Note that rowOne and rowTwo are zero-based
    public void swap(int rowOne, int rowTwo) {
        Row temp = matrix.get(rowTwo);
        matrix.set(rowTwo,matrix.get(rowOne));
        matrix.set(rowOne,temp);
    }

    // EFFECTS: return the index of the row with leftmost non zero entry; if two rows' first non zero entry have the same entry, then the first appeared goes first
    public int findLeftmostNonZeroEntry() {
        List<Integer> arr = new ArrayList<>();
        for(Row r: matrix) {
            arr.add(r.findIndexNonZero());
        }

        int minIndex = arr.indexOf(Collections.min(arr));
        return minIndex;
    }

    public void reduction() {
        reduction(matrix.size(), matrix);
    }

    public List<Row> reduction(int n, List<Row> m) {
        if (n <= 1) {
            return m;
        }

        // find
        List<Integer> arr = new ArrayList<>();
        for(Row r: m) {
            arr.add(r.findIndexNonZero());
        }
        int leftmostNonZeroEntry = arr.indexOf(Collections.min(arr));
        // swap
        Row temp = m.get(leftmostNonZeroEntry);
        m.set(leftmostNonZeroEntry,m.get(0));
        m.set(0,temp);
        // scale
        m.get(0).scale();
        // row replacement
        int indexNonZeroInFirstRow = m.get(0).findIndexNonZero();
        for (Row r : m.subList(1,m.size())) {
            if (r.get(indexNonZeroInFirstRow) != 0) {
                double firstNum = r.get(indexNonZeroInFirstRow);

                for(int i = 0;i < r.size();i++) {
                    double difference = firstNum * m.get(0).get(i);
                    r.set(i,r.get(i)-difference);
                }
            }
        }
        
        return reduction(n-1, m.subList(1, m.size()));
    }


}
