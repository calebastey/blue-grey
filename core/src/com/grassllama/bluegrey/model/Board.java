package com.grassllama.bluegrey.model;

import com.grassllama.bluegrey.model.tile.DefaultTile;
import com.grassllama.bluegrey.model.tile.Tile;

/**
 * @author Caleb
 */
public class Board {

    private Tile tile[][];
    private int width;
    private int height;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.tile = new DefaultTile[this.width][this.height];
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public Tile[][] getTiles() {
        return this.tile;
    }

    public Tile getTile(int i, int j) {
        return tile[i][j];
    }
}
