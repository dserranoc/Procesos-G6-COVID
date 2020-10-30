package com.gsix.covid.infrastructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CovidDataNotFetchedExceptionTest {

    @Test(expected = CovidDataNotFetchedException.class)
    public void shouldThrowException() {
        throw new CovidDataNotFetchedException(Mockito.mock(Exception.class));
    }

}
