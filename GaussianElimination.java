/* 
 * Class: Gaussian Elimination
 * Author: Thomas Tejedor
 * 
 * Purpose: Create a program that solves a set of linear equations
 *    using Gaussian elimination. The list of 
 * 
 */

import java.lang.Math;

public class GaussianElimination {

    int n;
    int[][] coeffArr;
    int[] indexArr;
    int[] scaleVectorArr;

    public GaussianElimination(int n, int[][] coeffArr)  {
        this.n = n;
        this.coeffArr = coeffArr;
        indexArr = new int[n];
        scaleVectorArr = new int[n];
        getScaleVectors();
    }

    private void getScaleVectors() {

        for(int i = 0; i < n; i++) {
            indexArr[i] = i; 
            int maxCoeff = coeffArr[i][0];
            
            for(int j = 0; j < n; j++) {
                if( maxCoeff < Math.abs(coeffArr[i][j]))
                    maxCoeff = coeffArr[i][j];
            }
            scaleVectorArr[i] = (maxCoeff); 
        }

    }

    private String getCurrentMatrix() {
        String output = "Current Matrix = \n[";
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < (n+1); j++) {
                if(i == (n-1) && j == (n-1)) {
                    output += coeffArr[i][j] + "]\n"; 
                }
                else if(j == (n-1)) {
                    output += coeffArr[i][j] + ",\n";
                }
                else {
                    output += coeffArr[i][j] + ",";
                }
            }
        }
        return output;
    }


    public String getSolvedMatrix() {

        String output = "";

        for (int i = 0; i < (n-1); i++) {
            output += getCurrentMatrix();

            output = "Scale Ratios = [";
            int pivotRow = 0;
            int maxRatio = 0; 

            for(int k = i; k < n; k++) {

                int currRow = indexArr[k];
                int currRatio = Math.abs(coeffArr[currRow][k] / scaleVectorArr[currRow]);


                if(k != n-1)
                    output += currRatio + ", ";
                else
                    output += currRatio + "]\n"; 


                if(currRatio > maxRatio) {
                    maxRatio = currRatio;
                    pivotRow = currRow;
                }

            }

            output += "The pivot row = " + (pivotRow + 1);

            indexArr[pivotRow] = indexArr[i];
            indexArr[i] = pivotRow;

            for(int currIndex: indexArr) {
                System.out.print(currIndex + ", ");
            }

            
            for(int k = i + 1; k < n; k++) {
                int currIndex = indexArr[k];
                System.out.println(coeffArr[currIndex][i]);
                int xMult = (coeffArr[pivotRow][k]/coeffArr[currIndex][i]);

                coeffArr[currIndex][k] = xMult;

                for(int j = i + 1; j < n; j++) {
                    coeffArr[currIndex][j] = coeffArr[currIndex][j] - xMult*(coeffArr[currIndex][k]);
                }
            }
            System.out.println("yo");



        }

        return output; 
    }
}
