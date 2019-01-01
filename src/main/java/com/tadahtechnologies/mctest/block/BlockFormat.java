package com.tadahtechnologies.mctest.block;

import com.google.common.collect.Lists;

import java.util.List;

public class BlockFormat {

    private List<Integer[]> format;
    private int width;

    public BlockFormat(String... rows) {
        this.format = Lists.newArrayList();
        for (int i = 0; i < rows.length; i++) {
            String row = rows[rows.length - i - 1];

            for (int j = 0; j < row.length(); j++) {
                if (j >= width) {
                    width = j + 1;
                }

                char dot = row.charAt(j);
                if (dot != ' ') {
                    format.add(new Integer[]{j, i});
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public List<Integer[]> getFormat() {
        return format;
    }

}
