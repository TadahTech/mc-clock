package com.tadahtechnologies.mctest.util;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class DirectionHelper {

    private double xAdd;
    private double zAdd;

    public void setDirection(Location location) {
        Vector direction = location.getDirection();

        direction.setY(0);

        if (Math.abs(direction.getX()) < Math.abs(direction.getZ())) {
            xAdd = direction.getZ() > 0 ? -1 : 1;
            zAdd = 0;
        } else {
            zAdd = direction.getX() < 0 ? -1 : 1;
            xAdd = 0;
        }
    }

    public void move(Location loc, int xoff, int yoff) {
        loc.setX(loc.getX() + xoff * xAdd);
        loc.setZ(loc.getZ() + xoff * zAdd);
        loc.setY(loc.getY() + yoff);
    }

}
