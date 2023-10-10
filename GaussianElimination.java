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
    double[][] coeffArr;
    int[] indexArr;
    double[] scaleVectorArr;

    public GaussianElimination(int n, double[][] coeffArr)  {
        this.n = n;
        this.coeffArr = coeffArr;
        indexArr = new int[n];
        scaleVectorArr = new double[n];
        getScaleVectors();
    }

    private void getScaleVectors() {

        for(int i = 0; i < n; i++) {
            indexArr[i] = i; 
            double maxCoeff = coeffArr[i][0];
            
            for(int j = 0; j < n; j++) {
                if( maxCoeff < Math.abs(coeffArr[i][j]))
                    maxCoeff = coeffArr[i][j];
            }
            scaleVectorArr[i] = (maxCoeff); 
        }

    }

    private String getCurrentMatrix() {
        String output = "\nCurrent Matrix = \n[";
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < (n+1); j++) {
                if(i == (n-1) && j == (n)) {
                    output += coeffArr[i][j] + "]\n"; 
                }
                else if(j == (n)) {
                    output += coeffArr[i][j] + ",\n";
                }
                else {
                    output += coeffArr[i][j] + ", ";
                }
            }
        }
        return output;
    }


    public String getSolvedMatrix() {

        String output = "";

        output += getCurrentMatrix(); 
        for (int i = 0; i < (n-1); i++) {

            output += "\nScale Ratios = [";
            int pivotRowIndex = i;
            double maxRatio = 0; 

            for(int k = i; k < n; k++) {

                int currRow = k;
                double currRatio = Math.abs(coeffArr[currRow][k] / (double)scaleVectorArr[currRow]);

                if(k != n-1)
                    output += currRatio + ", ";
                else
                    output += currRatio + "]\n"; 

                if(currRatio > maxRatio) {
                    maxRatio = currRatio;
                    pivotRowIndex = k;
                }

            }
            
            output += "The pivot row = " + (indexArr[pivotRowIndex] + 1) + "\n";

            int pivotRow = indexArr[pivotRowIndex];
            indexArr[pivotRowIndex] = indexArr[i];
            indexArr[i] = pivotRow;
            
            for(int k = i + 1; k < n; k++) {
                int currRow = indexArr[k];
                double xMult = (coeffArr[currRow][i]/coeffArr[pivotRow][i]);

                coeffArr[currRow][i] = 0;

                for(int j = i + 1; j < (n+1); j++) {
                    coeffArr[currRow][j] = coeffArr[currRow][j] - xMult*(coeffArr[pivotRow][j]);
                }
            }

            output += getCurrentMatrix();

        }

        return output; 
    }

    public double[] getSolution(){
        double[] solution = new double[n];
        solution[n-1] = (coeffArr[indexArr[n-1]][n])/(coeffArr[indexArr[n-1]][n-1]);
        
        for (int i = n-2; i >= 0; i--){
            double sum = coeffArr[indexArr[i]][n];
            for (int j = i+1; j < n ; j++) {
                sum -= (coeffArr[indexArr[i]][j]*solution[j]); 
            }
            solution[i] = sum/coeffArr[indexArr[i]][i]; 
        }

        return solution;
    }
}
