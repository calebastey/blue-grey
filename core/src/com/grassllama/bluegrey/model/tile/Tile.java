package com.grassllama.bluegrey.model.tile;

/**
 * @author Caleb
 */
public interface Tile {

    public enum TILE_TYPE { EASY, MEDIUM, HARD, IMPASSABLE }

    TILE_TYPE getType();

    void setType(TILE_TYPE tile_type);

}
