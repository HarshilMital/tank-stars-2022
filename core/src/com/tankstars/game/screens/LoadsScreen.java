package com.tankstars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.tankstars.game.TankStars;

public class LoadsScreen implements Screen {
    final private TankStars game;

//    private TextureRegion backgroundRegion1;
    private Sprite backgroundSprite;
    private Texture backgroundTexture;
//    private TextureRegion backgroundRegion2;
    private Texture mainMenuButtonInactive;
    private Texture mainMenuButtonActive;
    private Texture loads;
//    private Texture startButtonInactive;
//    private Texture startButtonActive;
//    private Texture frost;
//    private Texture helios;
//    private Texture frostStats;
//    private Texture heliosStats;


    private final float menuButtonWidth = 400;
    private final float menuButtonActiveHeight = 160;
    private final float menuButtonInactiveHeight = 169;




    public LoadsScreen(TankStars game) {

        this.game = game;
        loadTextures();
    }
    private void loadTextures() {
        backgroundTexture = new Texture("bg1TS.png");
        backgroundSprite = new Sprite(backgroundTexture);
//        backgroundRegion1 = new TextureRegion(backgroundTexture1, 0, 0 , 1440, 500);
//        backgroundTexture2 = new Texture(("bg2TS.png"));
//        backgroundRegion2 = new TextureRegion(backgroundTexture2, 0, 0 , 1440, 400);

        mainMenuButtonInactive = new Texture("TankSelectionButtons/BackToMainMenu_Inactive.png");
        mainMenuButtonActive = new Texture("TankSelectionButtons/BackToMainMenu_Active.png");


        loads = new Texture("loads.png");
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

        if ((Gdx.input.getX() < 25) || (Gdx.input.getX() > 25 + menuButtonWidth / 2) || (Gdx.input.getY() < 40) || (Gdx.input.getY() > 40 + menuButtonInactiveHeight / 2)) {
            game.batch.draw(mainMenuButtonInactive, 25, 900 - ( 40 + menuButtonInactiveHeight / 2), menuButtonWidth / 2, menuButtonInactiveHeight / 2);
        }
        else{
            game.batch.draw(mainMenuButtonActive, 25, 900 - ( 40 + menuButtonInactiveHeight / 2), menuButtonWidth / 2, menuButtonActiveHeight / 2);
            if (Gdx.input.isTouched()) {
                game.setScreen(new MainMenu(game));
            }
        }
        if ((Gdx.input.getX() > 1150) && (Gdx.input.getX() < 1230) && (Gdx.input.getY() > 281) && (Gdx.input.getY() < 361)){
            if (Gdx.input.isTouched()) {
                game.setScreen(new MainMenu(game));
            }
        }
//        game.batch.draw(startButtonInactive, 1415 - menuButtonWidth / 2, 650, menuButtonWidth / 2, menuButtonInactiveHeight / 2);
        game.batch.draw(loads, 206, 100);


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
