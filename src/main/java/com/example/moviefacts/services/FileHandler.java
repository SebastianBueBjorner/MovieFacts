package com.example.moviefacts.services;

import com.example.moviefacts.models.Movie;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class FileHandler {

    public List<Movie> getListOfMovies() {
        File imdbDataFile = new File("src/main/java/com/example/moviefacts/repositories/imdb-data.csv");
        List<Movie> movies= new LinkedList<>();
        try{
            Scanner sc = new Scanner(imdbDataFile);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] movieData = line.split(";");

                int year = Integer.parseInt(movieData[0]);
                int length = Integer.parseInt(movieData[1]);
                String title = movieData[2];
                String subject = movieData[3];
                int popularity = Integer.parseInt(movieData[4]);

                String awardsData = movieData[5];
                boolean awards = true;
                if (awardsData.equalsIgnoreCase("no")) {
                    awards = false;
                }

                Movie currentMovie = new Movie(year, length, title, subject, popularity, awards);
                movies.add(currentMovie);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return movies;
    }



}
