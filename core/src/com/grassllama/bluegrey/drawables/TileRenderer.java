package com.grassllama.bluegrey.drawables;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.grassllama.bluegrey.model.tile.Tile;

/**
 * @author Caleb
 */
public class TileRenderer implements Drawable {

    private Tile tile;
    private int x;
    private int y;
    private ShapeRenderer shapeRenderer;

    public TileRenderer(Tile tile) {
        this.tile = tile;
    }

    @Override
    public void draw(Camera camera) {
        this.shapeRenderer.setColor(1, 1, 0, 1);
        this.shapeRenderer.rect(x ,y, 20, 20);
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setShapeRenderer(ShapeRenderer shapeRenderer) {
        this.shapeRenderer = shapeRenderer;
    }
}
