package com.grassllama.bluegrey.model;

import com.grassllama.bluegrey.model.tile.DefaultTile;
import com.grassllama.bluegrey.model.tile.Tile;

import java.util.List;

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

    public Board(List<List<Integer>> intBoard) {
        this.width = intBoard.get(0).size();
        this.height = intBoard.size();
        this.tile = new DefaultTile[this.height][this.width];

        for (int i = 0; i < intBoard.size(); i++) {
            for (int j = 0; j < intBoard.get(i).size(); j++) {
                this.tile[i][j] = new DefaultTile();
                switch (intBoard.get(i).get(j)) {
                    case 0: this.tile[i][j].setType(Tile.TILE_TYPE.IMPASSABLE);
                        break;
                    case 1: this.tile[i][j].setType(Tile.TILE_TYPE.EASY);
                        break;
                    case 2: this.tile[i][j].setType(Tile.TILE_TYPE.MEDIUM);
                        break;
                    case 3: this.tile[i][j].setType(Tile.TILE_TYPE.HARD);
                        break;
                    default: this.tile[i][j].setType(Tile.TILE_TYPE.IMPASSABLE);
                }

            }
            System.out.println();
        }
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
