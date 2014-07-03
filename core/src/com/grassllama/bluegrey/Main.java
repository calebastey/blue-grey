package com.grassllama.bluegrey;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.grassllama.bluegrey.drawables.BoardRenderer;
import com.grassllama.bluegrey.drawables.Drawable;
import com.grassllama.bluegrey.model.Board;
import com.grassllama.bluegrey.utils.TextBasedBoardBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main implements ApplicationListener {
    SpriteBatch batch;
    OrthographicCamera camera;
    Board board;

    @Override
    public void create() {
        // create the camera and the SpriteBatch
        int width = Gdx.graphics.getWidth();
        int height = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
        camera.update();

        batch = new SpriteBatch();

        // create the raindrops array and spawn the first raindrop
        this.board = new TextBasedBoardBuilder().createBoard("simple.txt");
    }

    @Override
    public void render() {
        handleInput();

        // clear the screen with a dark blue color. The
        // arguments to glClearColor are the red, green
        // blue and alpha component in the range [0,1]
        // of the color to be used to clear the screen.
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell the camera to update its matrices.
        camera.update();

        // tell the SpriteBatch to render in the
        // coordinate system specified by the camera.
        batch.setProjectionMatrix(camera.combined);

        List<Drawable> drawables = new ArrayList<Drawable>();
        drawables.add(new BoardRenderer(this.board));

        for(Drawable drawable : drawables) {
            drawable.draw(camera);
        }

    }

    private void handleInput() {
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            camera.translate(-2,0,0);
            camera.update();
        }
        if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            camera.translate(2,0,0);
            camera.update();
        }
        if(Gdx.input.isKeyPressed(Keys.DOWN)) {
            camera.translate(0,2,0);
            camera.update();
        }
        if(Gdx.input.isKeyPressed(Keys.UP)) {
            camera.translate(0,-2,0);
            camera.update();
        }
        if(Gdx.input.isKeyPressed(Keys.A)) {
            camera.zoom += .02;
            camera.update();
        }
        if(Gdx.input.isKeyPressed(Keys.S)) {
            camera.zoom -= .02;
            camera.update();
        }

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
