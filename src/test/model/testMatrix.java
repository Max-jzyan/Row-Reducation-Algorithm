package test.model;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Matrix;
import main.model.Row;

public class testMatrix {
    private Row rowOne;
    private Row rowTwo;
    private Matrix matrix;
    private Matrix temp;

    private Matrix answer;
    private Row one;
    private Row two;

    @BeforeEach
    public void setup() {
        matrix = new Matrix();
        temp = new Matrix();
        rowOne = new Row();
        rowTwo = new Row();
        answer = new Matrix();
        one = new Row();
        two = new Row();

        matrix.add(rowOne);
        matrix.add(rowTwo);
        temp.add(rowTwo);
        temp.add(rowOne);

        rowOne.add(0.0);
        rowOne.add(5.0);
        rowTwo.add(2.0);
        rowTwo.add(3.0);

        one.add(1.0);
        one.add(1.5);
        two.add(0.0);
        two.add(1.0);
        answer.add(one);
        answer.add(two);
        
    }

    @Test
    public void testSwap() {
        

        matrix.swap(0,1);
        assertEquals(temp,matrix);
    }

    @Test
    public void testFindLeftMost() {
        assertEquals(1,matrix.findLeftmostNonZeroEntry());
    }

    @Test
    public void testReduction() {
        matrix.reduction();
        assertEquals(answer,matrix);
    }

    
}
