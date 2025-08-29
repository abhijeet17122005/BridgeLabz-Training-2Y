import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for student " + (i + 1));

            System.out.print("Physics: ");
            physics[i] = getValidMarks(sc);

            System.out.print("Chemistry: ");
            chemistry[i] = getValidMarks(sc);

            System.out.print("Maths: ");
            maths[i] = getValidMarks(sc);

            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;
            grade[i] = calculateGrade(percentage[i]);
        }

        System.out.println("\nStudent Report:");
        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d: Physics=%d, Chemistry=%d, Maths=%d, Percentage=%.2f%%, Grade=%c\n",
                    (i + 1), physics[i], chemistry[i], maths[i], percentage[i], grade[i]);
        }
        sc.close();
    }

    public static int getValidMarks(Scanner sc) {
        int marks = sc.nextInt();
        while (marks < 0 || marks > 100) {
            System.out.print("Enter valid marks (0-100): ");
            marks = sc.nextInt();
        }
        return marks;
    }

    public static char calculateGrade(double percentage) {
        if (percentage >= 80) return 'A';
        else if (percentage >= 70) return 'B';
        else if (percentage >= 60) return 'C';
        else if (percentage >= 50) return 'D';
        else if (percentage >= 40) return 'E';
        else return 'R';
    }
}
