package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    // TODO add more properties here
    private List<Genre> genres;

    public Movie(String title, String description, List<Genre> genres) {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof Movie other)) {
            return false;
        }
        return this.title.equals(other.title) && this.description.equals(other.description) && this.genres.equals(other.genres);
    }

    public String getTitle() {

        return title;
    }

    public String getDescription() {

        return description;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here
        movies.add(new Movie(
                "The Godfather",
                "The aging patriarch of an organized crime dynasty in postwar New York City transfers control of his clandestine empire to his reluctant youngest son.",
                Arrays.asList(Genre.CRIME, Genre.DRAMA)
        ));
        movies.add(new Movie(
                "Forrest Gump",
                "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man with an IQ of 75, whose only desire is to be reunited with his childhood sweetheart.",
                Arrays.asList(Genre.DRAMA, Genre.ROMANCE)
        ));
        movies.add(new Movie(
                "Matrix",
                "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.",
                Arrays.asList(Genre.ACTION, Genre.SCIENCE_FICTION)
        ));
        movies.add(new Movie(
                "Minions",
                "Minions Stuart, Kevin, and Bob are recruited by Scarlet Overkill, a supervillain who, alongside her inventor husband Herb, hatches a plot to take over the world.",
                Arrays.asList(Genre.ANIMATION, Genre.ADVENTURE, Genre.COMEDY)
        ));
        movies.add(new Movie(
                "Harry Potter and the Sorcerer's Stone",
                "An orphaned boy enrolls in a school of wizardry, where he learns the truth about himself, his family and the terrible evil that haunts the magical world.",
                Arrays.asList(Genre.ADVENTURE, Genre.FAMILY,Genre.FANTASY)
        ));
        movies.add(new Movie(
                "Annabelle",
                "A couple begins to experience terrifying supernatural occurrences involving a vintage doll shortly after their home is invaded by satanic cultists.",
                Arrays.asList(Genre.HORROR, Genre.MYSTERY,Genre.THRILLER)
        ));
        movies.add(new Movie(
                "The Hangover",
                "Three buddies wake up from a bachelor party in Las Vegas, with no memory of the previous night and the bachelor missing. They make their way around the city in order to find their friend before his wedding.",
                Arrays.asList(Genre.COMEDY)
        ));
        movies.add(new Movie(
                "Braveheart",
                "Scottish warrior William Wallace leads his countrymen in a rebellion to free his homeland from the tyranny of King Edward I of England.",
                Arrays.asList(Genre.BIOGRAPHY, Genre.DRAMA, Genre.HISTORY)
        ));
        movies.add(new Movie(
                "Hacksaw Ridge",
                "World War II American Army Medic Desmond T. Doss, who served during the Battle of Okinawa, refuses to kill people and becomes the first man in American history to receive the Medal of Honor without firing a shot.",
                Arrays.asList(Genre.BIOGRAPHY, Genre.DRAMA, Genre.HISTORY)
        ));
        movies.add(new Movie(
                "The Greatest Showman",
                "Celebrates the birth of show business and tells of a visionary who rose from nothing to create a spectacle that became a worldwide sensation.",
                Arrays.asList(Genre.BIOGRAPHY, Genre.DRAMA, Genre.MUSICAL)
        ));
        movies.add(new Movie(
                "Les Misérables",
                "In 19th-century France, Jean Valjean, who for decades has been hunted by the ruthless policeman Javert after breaking parole, agrees to care for a factory worker's daughter. The decision changes their lives forever.",
                Arrays.asList(Genre.DRAMA, Genre.MUSICAL,Genre.ROMANCE)
        ));
        movies.add(new Movie(
                "Hotel Rwanda",
                "Paul Rusesabagina, a hotel manager, houses over a thousand Tutsi refugees during their struggle against the Hutu militia in Rwanda, Africa.",
                Arrays.asList(Genre.BIOGRAPHY, Genre.DRAMA, Genre.HISTORY)
        ));
        movies.add(new Movie(
                "All Quiet on the Western Front",
                "A young German soldier's terrifying experiences and distress on the western front during World War I.",
                Arrays.asList(Genre.ACTION, Genre.DRAMA, Genre.WAR)
        ));
        movies.add(new Movie(
                "Dirty Harry",
                "When a madman calling himself \"the Scorpio Killer\" menaces the city, tough-as-nails San Francisco Police Inspector \"Dirty\" Harry Callahan is assigned to track down and ferret out the crazed psychopath.",
                Arrays.asList(Genre.ACTION, Genre.CRIME, Genre.THRILLER)
        ));
        movies.add(new Movie(
                "The Magnificent Seven",
                "Seven gunmen from a variety of backgrounds are brought together by a vengeful young widow to protect her town from the private army of a destructive industrialist.",
                Arrays.asList(Genre.ACTION, Genre.ADVENTURE, Genre.WESTERN)
        ));
        movies.add(new Movie(
                "Ravenous",
                "In a remote military outpost in the 19th century, Captain John Boyd and his regiment embark on a rescue mission which takes a dark turn when they are ambushed by a sadistic cannibal.",
                Arrays.asList(Genre.ADVENTURE, Genre.HORROR, Genre.WESTERN)
        ));
        movies.add(new Movie(
                "Formula 1: Drive to Survive",
                "Docuseries following the FIA Formula One World Championship across multiple seasons.",
                Arrays.asList(Genre.DOCUMENTARY, Genre.SPORT)
        ));
        movies.add(new Movie(
                "Ancient Aliens",
                "Science and mythology - and how they are the same thing.",
                Arrays.asList(Genre.DOCUMENTARY, Genre.HISTORY, Genre.SCIENCE_FICTION)
        ));
        movies.add(new Movie(
                "The Nightmare Before Christmas",
                "Jack Skellington, king of Halloween Town, discovers Christmas Town, but his attempts to bring Christmas to his home causes confusion.",
                Arrays.asList(Genre.ANIMATION, Genre.FAMILY, Genre.FANTASY)
        ));
        movies.add(new Movie(
                "They Shall Not Grow Old",
                "A documentary about World War I with never-before-seen footage to commemorate the centennial of the end of the war.",
                Arrays.asList(Genre.DOCUMENTARY, Genre.HISTORY, Genre.WAR)
        ));
        movies.add(new Movie(
                "Signs of the Time",
                "A documentary based on how hand signals came about in baseball. Who initiated them and their usefulness.",
                Arrays.asList(Genre.DOCUMENTARY, Genre.MYSTERY, Genre.SPORT)
        ));
        movies.add(new Movie(
                "Minions",
                "",
                Arrays.asList(Genre.ROMANCE, Genre.DRAMA)
        ));


        return movies;
    }
}
