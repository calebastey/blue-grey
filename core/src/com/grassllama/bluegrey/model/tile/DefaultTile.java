package com.grassllama.bluegrey.model.tile;

/**
 * @author Caleb
 */
public class DefaultTile extends AbstractTile {

    TILE_TYPE type;

    @Override
    public TILE_TYPE getType() {
        return this.type;
    }

    public void setType(TILE_TYPE tile_type) {
        this.type = tile_type;
    }
}
