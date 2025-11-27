import java.util.*;

public class SportsTournamentScheduler {
    static class Team {
        final String name;
        int points;
        Team(String name){ this.name=name; this.points=0; }
        @Override public boolean equals(Object o){ return o instanceof Team && ((Team)o).name.equals(name); }
        @Override public int hashCode(){ return name.hashCode(); }
        public String toString(){ return name + "(" + points + ")"; }
    }

    static class Match { final String id; final Team a, b; Match(String id, Team a, Team b){ this.id=id; this.a=a; this.b=b; } public String toString(){ return id + ":" + a.name + " vs " + b.name; } }
    static class Result { final Match m; final Team winner; Result(Match m, Team w){ this.m=m; this.winner=w; } public String toString(){ return m.id + " -> " + winner.name; } }

    public static void main(String[] args) {
        Set<Team> teams = new HashSet<>();
        Team t1 = new Team("Tigers"), t2 = new Team("Lions"), t3 = new Team("Bulls");
        teams.add(t1); teams.add(t2); teams.add(t3);

        Queue<Match> matchQueue = new LinkedList<>();
        matchQueue.add(new Match("M1", t1, t2));
        matchQueue.add(new Match("M2", t2, t3));

        List<Result> results = new ArrayList<>();

        // process matches
        while (!matchQueue.isEmpty()) {
            Match m = matchQueue.poll();
            // simulate winner = team a
            Team winner = m.a;
            winner.points += 3;
            results.add(new Result(m, winner));
            System.out.println("Processed " + m + ", winner " + winner.name);
        }

        // TreeSet leaderboard sorted by points desc
        TreeSet<Team> leaderboard = new TreeSet<>((a,b) -> {
            int cmp = Integer.compare(b.points, a.points);
            return cmp != 0 ? cmp : a.name.compareTo(b.name);
        });
        leaderboard.addAll(teams);

        System.out.println("Leaderboard:");
        leaderboard.forEach(System.out::println);
        System.out.println("Results: " + results);
    }
}
