package com.gsix.covid.infrastructure;

import com.gsix.covid.domain.CovidData;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class CovidDataGatewayTest {

    @Mock
    private CovidDataGateway covidDataGateway;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void successfulFetchCovidData() {
        Mockito.when(covidDataGateway.fetchCovidData()).thenReturn(Mockito.mock(CovidData.class));
        CovidData data = covidDataGateway.fetchCovidData();
        assertNotNull(data);
    }

    @Test(expected = CovidDataNotFetchedException.class)
    public void unsuccessfulFetchCovidData() {
        Mockito.when(covidDataGateway.fetchCovidData())
                .thenThrow(new CovidDataNotFetchedException(Mockito.mock(Exception.class)));
        covidDataGateway.fetchCovidData();
    }

}
