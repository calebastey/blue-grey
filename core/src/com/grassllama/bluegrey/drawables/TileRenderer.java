package com.grassllama.bluegrey.drawables;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
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
        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        switch (this.tile.getType()) {
            case EASY:  this.shapeRenderer.setColor(Color.GREEN);
                break;
            case MEDIUM: this.shapeRenderer.setColor(Color.YELLOW);
                break;
            case HARD: this.shapeRenderer.setColor(Color.RED);
                break;
            case IMPASSABLE: this.shapeRenderer.setColor(Color.WHITE);
                break;
            default: this.shapeRenderer.setColor(Color.BLACK);
        }

        this.shapeRenderer.rect(x+1,y+1,19,19);
        this.shapeRenderer.end();

        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        this.shapeRenderer.setColor(Color.BLACK);
        this.shapeRenderer.rect(x ,y, 20, 20);
        this.shapeRenderer.end();
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
