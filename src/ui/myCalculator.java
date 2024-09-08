package ui;

import model.*;

public class myCalculator {
    private Matrix matrix;

    public myCalculator(Matrix matrix) {
        this.matrix = matrix;
        matrix.reduction();
    }


    
}
