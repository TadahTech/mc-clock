package com.tadahtechnologies.mctest.world;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tadahtechnologies.mctest.block.BlockFormat;
import com.tadahtechnologies.mctest.block.Letters;
import com.tadahtechnologies.mctest.util.DirectionHelper;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class BlockClock {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss");
    private Map<Integer, WorldLetter> letters;

    private String lastDateTime;
    private ZonedDateTime dateTime;
    private Location location;
    private DirectionHelper directionHelper;

    public BlockClock(ZonedDateTime dateTime, Location location) {
        this.dateTime = dateTime;
        this.location = location;
        this.letters = Maps.newHashMap();
        this.lastDateTime = FORMAT.format(dateTime);
        this.directionHelper = new DirectionHelper();

        this.directionHelper.setDirection(location);
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
        updateClock();
    }

    public void updateClock() {
        String newString = FORMAT.format(this.dateTime);
        int index = StringUtils.indexOfDifference(newString, this.lastDateTime);

        if (index == -1) {
            //No change;
            return;
        }
        
        //Clear previous
        WorldLetter letter = this.letters.get(index);

        letter.getLocations().forEach(location1 -> {
            Block block = location1.getBlock();
            block.setType(Material.AIR);
        });

        //Hours / Minutes / Seconds change
        if(index == 17 || index == 15 || index == 14 || index == 12 || index == 11)  {
            for(int i = 0; i < (18 - index); i++) {
                this.letters.get(index + i).getLocations().forEach(location1 -> {
                    Block block = location1.getBlock();
                    block.setType(Material.AIR);
                });
            }
        }

        writeText(newString);
        this.lastDateTime = newString;
    }

    public void spawnClock() {
        String dateToShow = FORMAT.format(this.dateTime);
        writeText(dateToShow);
    }

    private List<Location> writeLetter(Location placeAt, BlockFormat format) {
        List<Location> locations = Lists.newArrayList();

        for (Integer[] path : format.getFormat()) {
            Location clone = placeAt.clone();
            this.directionHelper.move(clone, path[0], path[1]);

            Block block = clone.getBlock();
            block.setType(Material.DIAMOND_BLOCK);
            locations.add(clone);
        }

        return locations;
    }

    private void writeText(String text) {
        this.directionHelper = new DirectionHelper();
        this.directionHelper.setDirection(this.location);

        Location placeAt = location.clone();
        placeAt.setX(location.getX());
        placeAt.setY(location.getY());
        placeAt.setZ(location.getZ());

        Location temp = this.location.clone();

        int width = 0;
        int letterCount = 0;
        // Get a total width

        for (int i = 0; i < text.length(); i++) {
            String c = text.substring(i, i + 1);

            BlockFormat format = Letters.get(c);

            letterCount++;
            width += format.getWidth();

            // The gap between letters
            width += letterCount - 1;
            this.directionHelper.move(temp, -width / 2, 0);
        }

        for (int i = 0; i < text.length(); i++) {
            String c = text.substring(i, i + 1);
            BlockFormat format = Letters.get(c);

            WorldLetter letter = new WorldLetter(i, c, writeLetter(placeAt, format));
            this.letters.put(i, letter);

            this.directionHelper.move(placeAt, format.getWidth() + 1, 0);
        }
    }

}
