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
        this.shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                TileRenderer tileRenderer = new TileRenderer(board.getTile(i,j));
                tileRenderer.setX(i*20);
                tileRenderer.setY(j*20);
                tileRenderer.setShapeRenderer(this.shapeRenderer);
                tileRenderer.draw(camera);
            }
        }
        this.shapeRenderer.end();
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
