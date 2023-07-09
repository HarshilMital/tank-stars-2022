package com.tankstars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.tankstars.game.TankStars;
import jdk.tools.jmod.Main;

public class PauseMenu implements Screen{
    final private TankStars game;
    final private GameScreen gameScreen;
    public PauseMenu(TankStars game, GameScreen gameScreen) {
        this.game = game;
        this.gameScreen = gameScreen;
        loadTextures();
    }

    private Sprite backgroundSprite;
    private Texture backgroundTexture;

    private Texture pauseMenuBox;
    private Texture buttonInactiveContinue;
    private Texture buttonInactiveRestart;
    private Texture buttonInactiveSave;
    private Texture buttonActiveContinue;
    private Texture buttonActiveRestart;
    private Texture buttonActiveSave;

    private void loadTextures() {
        backgroundTexture = new Texture("bg2TS.png");
        backgroundSprite = new Sprite(backgroundTexture);

        pauseMenuBox = new Texture("pauseBox2x.png");

        buttonInactiveContinue = new Texture("PauseButtons/continueInactive.png");
        buttonActiveContinue = new Texture("PauseButtons/continueActive.png");
        buttonInactiveRestart = new Texture("PauseButtons/restartInactive.png");
        buttonActiveRestart = new Texture("PauseButtons/restartActive.png");
        buttonInactiveSave = new Texture("PauseButtons/saveInactive.png");
        buttonActiveSave = new Texture("PauseButtons/saveActive.png");
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
        game.batch.draw(pauseMenuBox, 532f, 188f, 376, 524);

        if ((Gdx.input.getX()<865) && (Gdx.input.getX()>574) && (Gdx.input.getY()>229) && (Gdx.input.getY()<352)) {
            game.batch.draw(buttonActiveContinue, 574f, 900f-352f, 291f, 116f);
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(gameScreen);
            }
        } else {
            game.batch.draw(buttonInactiveContinue, 574f, 900f - 352f, 291f, 123f);
        }

        if ((Gdx.input.getX()<865) && (Gdx.input.getX()>574) && (Gdx.input.getY()>388) && (Gdx.input.getY()<511)) {
            game.batch.draw(buttonActiveSave, 574f, 900f-511f, 291f, 116f);
            if (Gdx.input.isTouched()) {
//                this.dispose();
                game.setScreen(new MainMenu(game));
            }
        } else {
            game.batch.draw(buttonInactiveSave, 574f, 900f - 511f, 291f, 123f);
        }

        if ((Gdx.input.getX()<865) && (Gdx.input.getX()>574) && (Gdx.input.getY()>548) && (Gdx.input.getY()<671)) {
            game.batch.draw(buttonActiveRestart, 574f, 900f-671f, 291f, 116f);
            if (Gdx.input.isTouched()) {
                this.dispose();
                game.setScreen(new GameScreen(game));
            }
        } else {
            game.batch.draw(buttonInactiveRestart, 574f, 900f - 671f, 291f, 123f);
        }
        game.batch.end();
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

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
