package com.example.moviefacts.services;


public class IndexPage {

    public String indexPageSetup() {

        StringBuilder str = new StringBuilder();

        str.append("<h3>This application provides information to the user through some different endpoint </h3>");

        str.append("Endpoint One: <b>/getFirst</b>");
        str.append("<br>");
        str.append("<i>Calls a service that finds the first movie from the list and displays the title.</i>");
        str.append("<br></br>");

        str.append("Endpoint Two: <b>/getRandom</b>");
        str.append("<br>");
        str.append("<i>Calls a service that finds a single random movie and displays the title.</i>");
        str.append("<br></br>");

        str.append("Endpoint Three: <b>/getTenSortByPopularity</b>");
        str.append("<br>");
        str.append("<i>Calls a service that fetches 10 random movies and displays them in ascending order by popularity.</i>");
        str.append("<br></br>");

        str.append("Endpoint Four: <b>/howManyWonAnAward</b>");
        str.append("<br>");
        str.append("<i>Shows the number for how many movies in the dataset that has won an award.</i>");
        str.append("<br></br>");

        str.append("Endpoint Five: <b>/filterchar='x'amount='n'</b>");
        str.append("<br>");
        str.append("<i>Calls a service that prints all movies, but only if they contain x character n amount of times.</i>");
        str.append("<br></br>");

        str.append("Endpoint Six: <b>/longestg1='x'g2='y'</b>");
        str.append("<br>");
        str.append("<i>Calls a service that compares two genres and finds what genre on average, has the longest movies.</i>");
        str.append("<br></br>");

        return str.toString();
    }

}
