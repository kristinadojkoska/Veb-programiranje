package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Movie> movies = new ArrayList<>();

    @PostConstruct
    public void init(){
        movies.add(new Movie("How I Met Your Mother", "A father recounts to his children - through a series of flashbacks - the journey he and his four best friends took leading up to him meeting their mother.", 8.3));
        movies.add(new Movie("Friends", "Follows the personal and professional lives of six twenty to thirty year-old friends living in the Manhattan borough of New York City.", 8.9));
        movies.add(new Movie("Brooklyn Nine-Nine", "Comedy series following the exploits of Det. Jake Peralta and his diverse, lovable colleagues as they police the NYPD's 99th Precinct.", 8.4));
        movies.add(new Movie("Stranger Things", "When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces and one strange little girl.", 8.7));
        movies.add(new Movie("Cunk on Earth", "Follows Philomena Cunk as she comically tells the story of our greatest inventions and asks experts hard-hitting questions about humanity's progress.", 8.1));
        movies.add(new Movie("Money Heist", "An unusual group of robbers attempt to carry out the most perfect robbery in Spanish history - stealing 2.4 billion euros from the Royal Mint of Spain.", 8.2));
        movies.add(new Movie("The Office", "A mockumentary on a group of typical office workers, where the workday consists of ego clashes, inappropriate behavior, and tedium.", 9.0));
        movies.add(new Movie("Sex and the City", "Four female New Yorkers gossip about their sex lives (or lack thereof) and find new ways to deal with being a woman in the late 1990s.", 7.3));
        movies.add(new Movie("Daisy Jones & The Six", "Following the rise of rock band Daisy Jones and The Six through the 1970s Los Angeles music scene on their quest for worldwide icon status.", 8.1));
        movies.add(new Movie("The White Lotus", "The exploits of various guests and employees of a tropical resort over the span of a week.", 7.1));
    }
}
