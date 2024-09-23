package test.model;



import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.model.Row;


public class testRow {
    private Row r1;
    private Row r2;
    private Row scaledR1;


    @BeforeEach
    void setup() {
        r1 = new Row();
        r2 = new Row();
        scaledR1 = new Row();
    }

    @Test
    void testAll() {
        r1.add(0.0);
        r1.add(4.0);
        r1.add(8.0);

        r2.add(0.0);
        r2.add(0.0);

        scaledR1.add(0.0);
        scaledR1.add(1.0);
        scaledR1.add(2.0);
        
        assertEquals(1,r1.findIndexNonZero());
        assertEquals(99,r2.findIndexNonZero());

        r1.scale();
        assertEquals(scaledR1,r1);
    }
}
