package com.gsix.covid.infrastructure.cases;

public class CovidDataNotFetchedException extends RuntimeException {

    public CovidDataNotFetchedException(Throwable error) {
        super("Could not fetch COVID data", error);
    }

}
