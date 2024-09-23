package main.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import main.model.Matrix;
import main.model.Row;

public class Main {
    public static void main (String[] args){
        Matrix matrix;
        matrix = new Matrix();
        System.out.println("Please input how many rows?");
        Scanner scanner = new Scanner(System.in);
        int rowNum = scanner.nextInt();
        System.out.println("Please input how many columns?");
        int colNum = scanner.nextInt();

        for(int i = 0;i < rowNum;i++) {
            Row temp = new Row();
            for(int j = 0;j < colNum;j++) {
                System.out.println("Please input the value of "+ i +" row " + j + " column.");
                int val = scanner.nextInt();
                temp.add((double) val);
            }
            matrix.add(temp);
        }

        matrix.reduction();
        matrix.display();
    }
}
