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
    int[] scaleFactorArr;

    public GaussianElimination(int n, int[][] coeffArr)  {
        this.n = n;
        this.coeffArr = coeffArr;
        indexArr = new int[n];
        scaleFactorArr = new int[n];
        getScaleFactors();
    }

    private void getScaleFactors() {

        for(int i = 0; i < n; i++) {
            indexArr[i] = i; 
            int currCoeff = coeffArr[i][0];
            
            for(int j = 0; j < n; i++) {
                if(currCoeff > Math.abs(coeffArr[i][j]))
                    currCoeff = coeffArr[i][j];
            }
            scaleFactorArr[i] = currCoeff; 
        }

    }
    private void printOutput() {

    }

    private void printScaledRatios() {

    }
}
