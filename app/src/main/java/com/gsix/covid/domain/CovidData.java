package com.gsix.covid.domain;

import java.util.Date;

public class CovidData {

    private final String country;
    private final int activeCases;
    private final int criticalCases;
    private final int recoveredCases;
    private final int totalCases;
    private final int todayCases;
    private final int totalDeceases;
    private final int population;
    private final Date lastUpdated;

    public CovidData(String country,
                     int activeCases,
                     int criticalCases,
                     int recoveredCases,
                     int totalCases,
                     int todayCases,
                     int totalDeceases,
                     int population,
                     Date lastUpdated) {
        this.country = country;
        this.activeCases = activeCases;
        this.criticalCases = criticalCases;
        this.recoveredCases = recoveredCases;
        this.totalCases = totalCases;
        this.todayCases = todayCases;
        this.totalDeceases = totalDeceases;
        this.population = population;
        this.lastUpdated = lastUpdated;
    }

    public String getCountry() {
        return country;
    }

    public int getActiveCases() {
        return activeCases;
    }

    public int getCriticalCases() {
        return criticalCases;
    }

    public int getRecoveredCases() {
        return recoveredCases;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public int getTodayCases() {
        return todayCases;
    }

    public int getTotalDeceases() {
        return totalDeceases;
    }

    public int getPopulation() {
        return population;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    @Override
    public String toString() {
        return "CovidData{" +
                "country='" + country + '\'' +
                ", activeCases=" + activeCases +
                ", criticalCases=" + criticalCases +
                ", recoveredCases=" + recoveredCases +
                ", totalCases=" + totalCases +
                ", todayCases=" + todayCases +
                ", totalDeceases=" + totalDeceases +
                ", population=" + population +
                ", lastUpdated=" + lastUpdated +
                '}';
    }

}
