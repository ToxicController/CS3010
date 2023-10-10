public class Project1{
    public static void main(String[] args) {
        int[][] testArr = {{2, 3, 0, 8}, {-1, 2, -1, 0}, {3, 0, 2, 9}};
        GaussianElimination test = new GaussianElimination(3, testArr);

        System.out.println(test.getSolvedMatrix());

    }
}
