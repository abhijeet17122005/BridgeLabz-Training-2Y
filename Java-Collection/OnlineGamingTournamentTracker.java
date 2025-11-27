import java.util.*;

public class OnlineGamingTournamentTracker {
    static class Player {
        final String id;
        int score;
        Player(String id){ this.id=id; this.score=0; }
        @Override public boolean equals(Object o){ return o instanceof Player && ((Player)o).id.equals(id); }
        @Override public int hashCode(){ return id.hashCode(); }
        public String toString(){ return id + "(" + score + ")"; }
    }

    static class Match { final String id; Match(String id){ this.id=id; } public String toString(){ return id; } }
    static class Result { final Match m; final String winner; Result(Match m, String w){ this.m=m; this.winner=w; } public String toString(){ return m + " -> " + winner; } }

    public static void main(String[] args) {
        Set<Player> players = new HashSet<>();
        players.add(new Player("P1"));
        players.add(new Player("P2"));
        players.add(new Player("P3"));

        Queue<Match> matchQueue = new LinkedList<>();
        matchQueue.add(new Match("M1"));
        matchQueue.add(new Match("M2"));

        List<Result> results = new ArrayList<>();

        // TreeSet for leaderboard (sort by score desc then id)
        TreeSet<Player> leaderboard = new TreeSet<>((a,b) -> {
            int cmp = Integer.compare(b.score, a.score);
            return cmp != 0 ? cmp : a.id.compareTo(b.id);
        });

        // Schedule/process matches
        System.out.println("Processing matches:");
        while (!matchQueue.isEmpty()) {
            Match m = matchQueue.poll();
            // simple simulation: P1 beats P2, P3 beats P1 alternately
            Player winner = players.stream().findFirst().get();
            winner.score += 10;
            results.add(new Result(m, winner.id));
            System.out.println(m + " winner: " + winner.id);
        }

        // populate leaderboard
        leaderboard.addAll(players);
        System.out.println("Leaderboard (top first):");
        leaderboard.forEach(System.out::println);

        System.out.println("Results list: " + results);
    }
}
