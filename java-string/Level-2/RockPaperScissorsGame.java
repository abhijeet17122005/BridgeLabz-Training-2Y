import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String getComputerChoice() {
        int choice = (int)(Math.random() * 3);
        if (choice == 0) return "rock";
        if (choice == 1) return "paper";
        return "scissors";
    }

    public static String getWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if ((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("paper") && computer.equals("rock")) ||
            (user.equals("scissors") && computer.equals("paper"))) return "User";
        return "Computer";
    }

    public static String[][] calculateStats(String[][] results, int totalGames) {
        int userWins = 0, computerWins = 0, draws = 0;
        for (int i = 0; i < totalGames; i++) {
            if (results[i][2].equals("User")) userWins++;
            else if (results[i][2].equals("Computer")) computerWins++;
            else draws++;
        }
        String[][] stats = new String[3][2];
        stats[0][0] = "User";
        stats[0][1] = (userWins * 100 / totalGames) + "%";
        stats[1][0] = "Computer";
        stats[1][1] = (computerWins * 100 / totalGames) + "%";
        stats[2][0] = "Draws";
        stats[2][1] = (draws * 100 / totalGames) + "%";
        return stats;
    }

    public static void displayResults(String[][] results, String[][] stats) {
        System.out.println("Game\tUser\tComputer\tWinner");
        for (int i = 0; i < results.length; i++) {
            System.out.println((i + 1) + "\t" + results[i][0] + "\t" + results[i][1] + "\t\t" + results[i][2]);
        }
        System.out.println("\nWin Percentages:");
        System.out.println("Player\tPercentage");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int games = sc.nextInt();
        sc.nextLine();
        String[][] results = new String[games][3];
        for (int i = 0; i < games; i++) {
            String user = sc.nextLine().toLowerCase();
            String computer = getComputerChoice();
            String winner = getWinner(user, computer);
            results[i][0] = user;
            results[i][1] = computer;
            results[i][2] = winner;
        }
        String[][] stats = calculateStats(results, games);
        displayResults(results, stats);
    }
}