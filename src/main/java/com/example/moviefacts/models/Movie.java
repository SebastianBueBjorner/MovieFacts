package com.example.moviefacts.models;

public class Movie implements Comparable<Movie> {
    private int year;            //Fx 1996
    private int length;           //Minutes
    private String title;
    private String subject;
    private int popularity;
    private boolean awards;      //Yes/No

    //Constructor
    public Movie(int year, int lengt, String title, String subject, int popularity, boolean awards) {
        this.year = year;
        this.length = lengt;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;
    }

    //Getters
    public int getYear() {
        return year;
    }
    public int getLength() {
        return length;
    }
    public String getTitle() {
        return title;
    }
    public String getSubject() {
        return subject;
    }
    public int getPopularity() {
        return popularity;
    }
    public boolean isAwards() {
        return awards;
    }

    public int compareTo(Movie otherMovie) {
        if (this.popularity == otherMovie.popularity) {
            return 0;
        } else if (this.popularity > otherMovie.popularity) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return "<b>Title: </b>" + this.title + "<br>" + "<b>Popularity: </b>" + this.popularity + "<br>" + "<b>Year: </b>" + this.year + "<br>" +
                "<b>Subject: </b>" + this.subject + "<br>" + "<b>Lenght: </b>" + this.length + " minutes<br>";
    }

}
