package com.gsix.covid.infrastructure;

import org.junit.Test;

public class CovidDataNotFetchedExceptionTest {

    @Test(expected = CovidDataNotFetchedException.class)
    public void shouldThrowException() {
        throw new CovidDataNotFetchedException(null);
    }

}
