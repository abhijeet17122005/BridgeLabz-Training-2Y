import java.util.*;

public class OnlineStreamingWatchHistory {
    static class Movie {
        final String id; final String title; final String genre;
        Movie(String id, String title, String genre){ this.id=id; this.title=title; this.genre=genre; }
        public String toString(){ return title + "(" + genre + ")"; }
    }

    public static void main(String[] args) {
        Stack<Movie> watchHistory = new Stack<>();
        List<Movie> allMovies = new ArrayList<>();
        Set<String> genresWatched = new HashSet<>();
        Queue<Movie> upNext = new LinkedList<>();

        // catalog
        allMovies.add(new Movie("M1","ActionOne","Action"));
        allMovies.add(new Movie("M2","RomCom","Romance"));

        // queue up next
        upNext.add(allMovies.get(0));
        upNext.add(allMovies.get(1));

        // play movies
        while (!upNext.isEmpty()) {
            Movie current = upNext.poll();
            System.out.println("Now playing: " + current);
            // push to history when completed
            watchHistory.push(current);
            genresWatched.add(current.genre);
        }

        System.out.println("Unique genres watched: " + genresWatched);
        // recommendations (very simple): list movies with same genres not yet watched
        System.out.println("Recommendations based on genres: ");
        for (Movie m : allMovies) {
            if (!genresWatched.contains(m.genre)) continue;
            System.out.println(" - " + m);
        }

        System.out.println("Recently watched (stack top first): " + watchHistory);
    }
}
