import java.util.Scanner;

public class Project1{

    private static Scanner scnr = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Would you like to test linear equations?");
        int userInt;

        do {
            System.out.println("1. Through a given file\n2. Input coefficients");
            userInt = scnr.nextInt(); 
        } while(userInt != 1 && userInt != 2);

        if(userInt == 1) {
            fileInput();
        }
        else {
            userInput();
        }
    }

    private static void fileInput() {

    }

    private static void userInput() {

        System.out.println("How many equations being evaluated?");
        int n = scnr.nextInt();
        double[][] userMatrix = new double[n][n + 1]; 

        for(int i = 0; i < userMatrix.length; i++) {
            System.out.println("Insert the coefficients for row " + (i + 1));
            for(int k = 0; k < userMatrix[i].length; k++) {
                if (k == n) {
                    System.out.println("Solution for row " + (k+1) + ": ");
                } 
                else {
                    System.out.print("Coeff x" + (k+1) + ": ");
                }
                userMatrix[i][k] = scnr.nextInt();
            }
        }

        GaussianElimination userEquations = new GaussianElimination(n, userMatrix);

        System.out.println(userEquations.getSolvedMatrix());
        double[] solutions = userEquations.getSolution();

        for(int i = 0; i < solutions.length; i++) {
            System.out.println("x" + (i+1) + "=" + (int)solutions[i]);
        }

    }

}
