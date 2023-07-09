package com.tankstars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.tankstars.game.TankStars;

public class GameScreen implements Screen {
    final private TankStars game;
    public GameScreen(TankStars game) {
        this.game = game;
        loadTextures();
    }

    private Sprite backgroundSprite;
    private Texture backgroundTexture;
    private Texture terrain;

    private Texture pauseButtonInactive;
    private Texture pauseButtonActive;

    private Texture healthBarP1;
    private Texture healthBarP2;

    private Texture tankP1;
    private Texture tankP2;

    private void loadTextures() {
        backgroundTexture = new Texture("bg2TS.png");
        backgroundSprite = new Sprite(backgroundTexture);

        terrain = new Texture("terrain.png");
        pauseButtonInactive = new Texture("GameScreenButtons/pauseInactive.png");
        pauseButtonActive = new Texture("GameScreenButtons/pauseActive.png");

        healthBarP1 = new Texture("p1Health.png");
        healthBarP2 = new Texture("p2Health.png");

        tankP1 = new Texture("helios1.png");
        tankP2 = new Texture("rotFrost.png");
    }

    private void renderBackground() {
        backgroundSprite.draw(game.batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        renderBackground();
        game.batch.draw(terrain, 0f, 0f, 1440f, 404f);

        if ((Gdx.input.getX()>27) && (Gdx.input.getX()<(27f+56.33f)) && (Gdx.input.getY()>21) && (Gdx.input.getY()<(21f+56.33f))) {
            game.batch.draw(pauseButtonActive, 27f, 900f - 77f, 56.33f, 53f);
            if (Gdx.input.isTouched()) {
                this.pause();
            }
        } else {
            game.batch.draw(pauseButtonInactive, 27f, 900f - 77f, 56.33f, 56.33f);
        }

        game.batch.draw(healthBarP1, 27f, 32f, 992f/2f, 106f/2f);
        game.batch.draw(healthBarP2, 917f, 32f, 992f/2f, 106f/2f);

        game.batch.draw(tankP1, 27f, 900f-595f, 100f, 46.31f);
        game.batch.draw(tankP2, 1303f, 300f, 109.88f, 109.88f);

        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {
        game.setScreen(new PauseMenu(game, this));
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
