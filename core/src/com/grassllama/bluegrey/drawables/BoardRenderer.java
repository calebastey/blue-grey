package com.grassllama.bluegrey.drawables;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.grassllama.bluegrey.model.Board;

/**
 * @author Caleb
 */
public class BoardRenderer implements Drawable {

    private Board board;
    private ShapeRenderer shapeRenderer;

    public BoardRenderer(Board board) {
        this.board = board;
        this.shapeRenderer = new ShapeRenderer();
    }

    @Override
    public void draw(Camera camera) {
        this.shapeRenderer.setProjectionMatrix(camera.combined);
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                TileRenderer tileRenderer = new TileRenderer(board.getTile(i,j));
                tileRenderer.setX(j*20);
                tileRenderer.setY(i*20);
                tileRenderer.setShapeRenderer(this.shapeRenderer);
                tileRenderer.draw(camera);
            }
        }
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
