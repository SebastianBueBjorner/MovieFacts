package com.example.moviefacts.services;

import com.example.moviefacts.models.Movie;

import java.util.*;


public class MovieHandler {
    List<Movie> movies;
    String[] numberWords = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Tenth"};

    public MovieHandler() {
        FileHandler fh = new FileHandler();
        this.movies = fh.getListOfMovies();
    }

    public String getTitleOfFirstMovie() {
        return movies.get(0).getTitle();
    }

    public String getTitleOfRandomMovie() {
        Random r = new Random();
        int index = r.nextInt(movies.size());
        return movies.get(index).getTitle();
    }

    public String getTenRandomMovies() {
        List<Movie> tenRandomMovies = new LinkedList<>();
        Random r = new Random();

        for (int i=0; i < 10; i++) {
            int index = r.nextInt(movies.size());
            Movie randomMovie = movies.get(index);
            tenRandomMovies.add(randomMovie);
        }

        Collections.sort(tenRandomMovies);

        StringBuilder str = new StringBuilder();
        int count = 0;

        for (Movie movie : tenRandomMovies) {
            str.append("<b><big>" + "Movie " + numberWords[count] + "</big></b></br>");
            str.append(movie.toString());
            str.append("<br></br>");
            count++;
        }

        return str.toString();
    }

    public int getHowManyWonAnAward() {
        int count = 0;

        for (Movie movie : movies) {
            if (movie.isAwards() == true) {
                count++;
            }
        }

        return count;
    }

    public String getMoviesWithSomeCharAndSomeAmount(String someChar, int someAmount) {
        List<Movie> moviesWithSomeCharAndSomeAmount = new LinkedList<>();

        for (Movie movie : movies) {
            String movieTitle = movie.getTitle();
            String[] movieTitleInArray = movieTitle.split("");
            int someCharCount = 0;

            for (int i = 0; i < movieTitleInArray.length; i++) {
               if (movieTitleInArray[i].equalsIgnoreCase(someChar)) {
                   someCharCount++;
               }
            }

            if (someCharCount == someAmount) {
                moviesWithSomeCharAndSomeAmount.add(movie);
            }
        }

        StringBuilder str = new StringBuilder();

        for (Movie movie : moviesWithSomeCharAndSomeAmount) {
            str.append(movie.toString());
            str.append("<br></br>");
        }

        return str.toString();
    }

    public String getGenreWithLongestMoviesOnAverage(String genreOne, String genreTwo) {
        int genreOneMovieCount = 0;
        int genreOneTotalMovieTime = 0;

        int genreTwoMovieCount = 0;
        int genreTwoTotalMovieTime = 0;

        for (Movie movie : movies) {
            if (movie.getSubject().equalsIgnoreCase(genreOne)) {
                genreOneTotalMovieTime += movie.getLength();
                genreOneMovieCount++;

            } else if (movie.getSubject().equalsIgnoreCase(genreTwo)) {
                genreTwoTotalMovieTime += movie.getLength();
                genreTwoMovieCount++;
            }
        }

        double averageMovieTimeOfGenreOne = getAverageMovieTimeOfGenre(genreOneTotalMovieTime, genreOneMovieCount);
        double averageMovieTimeOfGenreTwo = getAverageMovieTimeOfGenre(genreTwoTotalMovieTime, genreTwoMovieCount);


        StringBuilder str = new StringBuilder();

        if (averageMovieTimeOfGenreOne > averageMovieTimeOfGenreTwo) {
            str.append("Genre: " + genreOne + " has on average " + Math.round(averageMovieTimeOfGenreOne) + " minutes of screen time, and is therefore longer than");
            str.append("<br>");
            str.append("Genre: " + genreTwo + " that on average has a screen time of " + Math.round(averageMovieTimeOfGenreTwo) + " minutes.");


        } else if (averageMovieTimeOfGenreOne < averageMovieTimeOfGenreTwo) {
            str.append("Genre: " + genreTwo + " has on average " + Math.round(averageMovieTimeOfGenreTwo) + " minutes of screen time, and is therefore longer than");
            str.append("<br>");
            str.append("Genre: " + genreOne + " that on average has a screen time of " + Math.round(averageMovieTimeOfGenreOne) + " minutes.");

        } else {
            str.append("Genre: " + genreOne + " and genre: " + genreTwo + " both has an average screentime of " + Math.round(averageMovieTimeOfGenreTwo) + " minutes.");

        }



        return str.toString();
    }

    public double getAverageMovieTimeOfGenre (int totalMovieTime, int totalMovies) {
        double totalMovieMinutes = totalMovieTime;
        double totalMoviesInGenre = totalMovies;


        return totalMovieMinutes/totalMoviesInGenre;
    }

}
