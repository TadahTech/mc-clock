package com.tadahtechnologies.mctest.world;

import org.bukkit.Location;

import java.util.List;

public class WorldLetter {

    private int index;
    private String letter;
    private List<Location> locations;

    public WorldLetter(int index, String letter, List<Location> locations) {
        this.index = index;
        this.letter = letter;
        this.locations = locations;
    }

    public int getIndex() {
        return index;
    }

    public String getLetter() {
        return letter;
    }

    public List<Location> getLocations() {
        return locations;
    }

}
