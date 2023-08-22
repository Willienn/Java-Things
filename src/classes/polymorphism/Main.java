package classes.polymorphism;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Adventure theMovie = (Adventure) Movie.getMovie("Science", "Star Wars");
        theMovie.watchMovie();
        /////////////
        ScienceFiction theOtherMovie = new ScienceFiction( "Star Wars");
        theOtherMovie.watchMovie();

    }
}

