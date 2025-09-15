import java.util.Scanner;

public class StudentScoreCard {

    public static int[][] generateMarks(int n) {
        int[][] marks = new int[n][3];
        for (int i = 0; i < n; i++) {
            marks[i][0] = (int)(Math.random() * 50 + 50);
            marks[i][1] = (int)(Math.random() * 50 + 50);
            marks[i][2] = (int)(Math.random() * 50 + 50);
        }
        return marks;
    }

    public static double[][] calculateScores(int[][] marks) {
        double[][] scores = new double[marks.length][3];
        for (int i = 0; i < marks.length; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = Math.round((total / 300.0) * 10000.0) / 100.0;
            scores[i][0] = total;
            scores[i][1] = average;
            scores[i][2] = percentage;
        }
        return scores;
    }

    public static String[] assignGrades(double[][] scores) {
        String[] grades = new String[scores.length];
        for (int i = 0; i < scores.length; i++) {
            double p = scores[i][2];
            if (p >= 80) grades[i] = "A";
            else if (p >= 70) grades[i] = "B";
            else if (p >= 60) grades[i] = "C";
            else if (p >= 50) grades[i] = "D";
            else grades[i] = "F";
        }
        return grades;
    }

    public static void displayScoreCard(int[][] marks, double[][] scores, String[] grades) {
        System.out.println("Student\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        for (int i = 0; i < marks.length; i++) {
            System.out.println((i + 1) + "\t" + marks[i][0] + "\t" + marks[i][1] + "\t" + marks[i][2] + "\t" +
                    (int)scores[i][0] + "\t" + String.format("%.2f", scores[i][1]) + "\t" +
                    String.format("%.2f", scores[i][2]) + "\t" + grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int students = 10;
        int[][] marks = generateMarks(students);
        double[][] scores = calculateScores(marks);
        String[] grades = assignGrades(scores);
        displayScoreCard(marks, scores, grades);
    }
}