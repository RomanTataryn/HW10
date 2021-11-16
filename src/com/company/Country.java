package com.company;

public enum Country {
    UKRAINE(Continent.EUROPE),
    POLAND(Continent.EUROPE),
    SPAIN(Continent.EUROPE),
    USA(Continent.NORTH_AMERICA),
    BOLIVIA(Continent.SOUTH_AMERICA),
    AUSTRALIA(Continent.OCEANIA),
    JAPAN(Continent.ASIA),
    ZAIR(Continent.AFRICA);


    public final Continent continent;

    Country(Continent continent) {

        this.continent = continent;

    }

    public Continent getContinent() {

        return continent;
    }


}
