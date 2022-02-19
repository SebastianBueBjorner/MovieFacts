package com.example.moviefacts.controllers;

import com.example.moviefacts.services.IndexPage;
import com.example.moviefacts.services.MovieHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    @ResponseBody
    @GetMapping("/")
    public String index() {
        IndexPage indexPage = new IndexPage();
        return indexPage.indexPageSetup();
    }

    @ResponseBody
    @GetMapping("/getFirst")
    public String getFirst() {
        MovieHandler mh = new MovieHandler();
        return mh.getTitleOfFirstMovie();
    }

    @ResponseBody
    @GetMapping("/getRandom")
    public String getRandom() {
        MovieHandler mh = new MovieHandler();
        return mh.getTitleOfRandomMovie();
    }

    @ResponseBody
    @GetMapping("/getTenSortByPopularity")
    public String getTenSortByPopularity() {
        MovieHandler mh = new MovieHandler();
        return mh.getTenRandomMovies();
    }

    @ResponseBody
    @GetMapping("/howManyWonAnAward")
    public int howManyWonAnAward() {
        MovieHandler mh = new MovieHandler();
        return mh.getHowManyWonAnAward();
    }


    @ResponseBody
    @GetMapping("/filterchar={someChar}amount={someAmount}")
    public String printMoviesWithSomeCharAndSomeAmount (@PathVariable String someChar, @PathVariable int someAmount) {
        MovieHandler mh = new MovieHandler();
        return mh.getMoviesWithSomeCharAndSomeAmount(someChar, someAmount);
    }


    @ResponseBody
    @GetMapping("/longestg1={genreOne}g2={genreTwo}")
    public String findGenreWithLongestMoviesOnAverage (@PathVariable String genreOne, @PathVariable String genreTwo) {
        MovieHandler mh = new MovieHandler();
        return mh.getGenreWithLongestMoviesOnAverage(genreOne, genreTwo);
    }



}
