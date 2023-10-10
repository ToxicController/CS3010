import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Project1{

    private static Scanner scnr = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("How would you like to test your linear eqations");

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

    private static void fileInput(){
        
        boolean fileExists = false; 
        String fileName = ""; 

        while(!fileExists) {
            fileName = scnr.nextLine();
            System.out.print("Enter the name of an existing text file: ");
            File tempFile = new File(fileName + ".txt");
            if(tempFile.exists())
                fileExists = true;
        }

        File userFile = new File(fileName + ".txt");
        try {
            scnr = new Scanner(userFile);
        } catch(FileNotFoundException e) {}

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
