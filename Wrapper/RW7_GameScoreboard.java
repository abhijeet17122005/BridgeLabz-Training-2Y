/**
 * Real-World Q7. Game Scoreboard
 * Scenario: In a multiplayer game, scores are stored as Integer objects
 *           so they can be null when a player hasn't played yet.
 * Task:
 *  - Given an array of Integer scores, count how many players have not
 *    played (score == null).
 *  - Calculate the total of valid scores using auto-unboxing.
 */

public class RW7_GameScoreboard {
    public static void main(String[] args) {
        // null means the player hasn't played yet
        Integer[] scores = {150, null, 200, 90, null, 310, null, 75};

        int notPlayed = 0;
        int totalScore = 0;

        for (Integer score : scores) {
            if (score == null) {
                notPlayed++;
            } else {
                totalScore += score;   // auto-unboxing: Integer -> int
            }
        }

        System.out.println("Scoreboard: ");
        for (int i = 0; i < scores.length; i++) {
            String entry = (scores[i] == null) ? "Not played" : scores[i].toString();
            System.out.println("  Player " + (i + 1) + ": " + entry);
        }

        System.out.println("\nPlayers who haven't played: " + notPlayed);
        System.out.println("Total valid score         : " + totalScore);
    }
}

/*
 Expected Output:
 Scoreboard:
   Player 1: 150
   Player 2: Not played
   Player 3: 200
   Player 4: 90
   Player 5: Not played
   Player 6: 310
   Player 7: Not played
   Player 8: 75

 Players who haven't played: 3
 Total valid score         : 825
*/
