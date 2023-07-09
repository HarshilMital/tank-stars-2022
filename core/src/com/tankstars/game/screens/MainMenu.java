package com.tankstars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.tankstars.game.TankStars;
import org.w3c.dom.Text;

public class MainMenu implements Screen {
    final private TankStars game;
//    private BitmapFont font;
//    private GlyphLayout glyphLayout = new GlyphLayout();
//    private String menuTextNewGame;
//    private String menuTextResumeGame;
//    private String menuTextExitGame;

    private Sprite backgroundSprite;
    private Texture backgroundTexture;

    private Texture logo;
    private Texture tank;

    private Texture menuButtonNewGameActive;
    private Texture menuButtonNewGameInactive;
    private Texture menuButtonResumeGameActive;
    private Texture menuButtonResumeGameInactive;
    private Texture menuButtonExitGameActive;
    private Texture menuButtonExitGameInactive;

    private final float scaleFactor = 4f/5f;
    private float padding = 32;

    private final float menuButtonWidth = 400f*scaleFactor;
    private final float menuButtonActiveHeight = 160f*scaleFactor;
    private final float menuButtonInactiveHeight = 169f*scaleFactor;

    private final float logoHeight = 9*32;
    private final float logoWidth = 16*32;

    public MainMenu(TankStars game) {
        this.game = game;
        loadTextures();
//        font = new BitmapFont(Gdx.files.internal("gothicW.fnt"));
//        menuTextNewGame = "New Game";
//        menuTextResumeGame = "Resume Game";
//        menuTextExitGame = "Exit";
    }

    private void loadTextures() {
        backgroundTexture = new Texture("bg1TS.png");
        backgroundSprite = new Sprite(backgroundTexture);

        logo = new Texture("logo.png");
        tank = new Texture("mainMenuTank.png");

        menuButtonNewGameActive = new Texture("MenuButtons/NewGame_Active.png");
        menuButtonNewGameInactive = new Texture("MenuButtons/NewGame_Inactive.png");
        menuButtonResumeGameActive = new Texture("MenuButtons/ResumeGame_Active.png");
        menuButtonResumeGameInactive = new Texture("MenuButtons/ResumeGame_Inactive.png");
        menuButtonExitGameActive = new Texture("MenuButtons/ExitGame_Active.png");
        menuButtonExitGameInactive = new Texture("MenuButtons/ExitGame_Inactive.png");
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
        game.batch.draw(tank, Gdx.graphics.getWidth()/2, 128, 1920/3, 1080/3);
        game.batch.draw(new Texture("mainMenuBox.png"),532f, 900-844f, 376f, 524f);


        game.batch.draw(logo, Gdx.graphics.getWidth() / 2 - logoWidth / 2, Gdx.graphics.getHeight()*2/3, logoWidth, logoHeight);


        if ((Gdx.input.getX()<(Gdx.graphics.getWidth() / 2 - menuButtonWidth / 2)) || (Gdx.input.getX()>(Gdx.graphics.getWidth() / 2 + menuButtonWidth / 2)) || (Gdx.input.getY()<(Gdx.graphics.getHeight() / 2 - padding - menuButtonInactiveHeight / 2)) || (Gdx.input.getY()>(Gdx.graphics.getHeight() / 2 - padding + menuButtonInactiveHeight / 2))) {
            game.batch.draw(menuButtonNewGameInactive, Gdx.graphics.getWidth() / 2 - menuButtonWidth / 2, Gdx.graphics.getHeight() / 2 + padding - menuButtonInactiveHeight / 2, menuButtonWidth, menuButtonInactiveHeight);
        } else {
            game.batch.draw(menuButtonNewGameActive, Gdx.graphics.getWidth() / 2 - menuButtonWidth / 2, (Gdx.graphics.getHeight() / 2 - menuButtonActiveHeight / 2) - 4.5f*scaleFactor + padding , menuButtonWidth, menuButtonActiveHeight);
            if (Gdx.input.isTouched()) {
//                this.dispose();
                game.setScreen(new TankSelection(game));
            }
        }

        if ((Gdx.input.getX()<(Gdx.graphics.getWidth() / 2 - menuButtonWidth / 2)) || (Gdx.input.getX()>(Gdx.graphics.getWidth() / 2 + menuButtonWidth / 2)) || (Gdx.input.getY()<(Gdx.graphics.getHeight() / 2 - 2*padding + menuButtonInactiveHeight)) || (Gdx.input.getY()>(Gdx.graphics.getHeight() / 2 - 2*padding + menuButtonInactiveHeight*2))) {
            game.batch.draw(menuButtonResumeGameInactive, Gdx.graphics.getWidth() / 2 - menuButtonWidth / 2, Gdx.graphics.getHeight() / 2 + 2*padding - menuButtonInactiveHeight*2f, menuButtonWidth, menuButtonInactiveHeight);
        } else {
            game.batch.draw(menuButtonResumeGameActive, Gdx.graphics.getWidth() / 2 - menuButtonWidth / 2, (Gdx.graphics.getHeight() / 2 + 2*padding - menuButtonActiveHeight*2f) - 18f*scaleFactor, menuButtonWidth, menuButtonActiveHeight);
            if (Gdx.input.isTouched()) {
//                this.dispose();
                game.setScreen(new LoadsScreen(game));
            }
        }

        if ((Gdx.input.getX()<(Gdx.graphics.getWidth() / 2 - menuButtonWidth / 2)) || (Gdx.input.getX()>(Gdx.graphics.getWidth() / 2 + menuButtonWidth / 2)) || (Gdx.input.getY()<(Gdx.graphics.getHeight() / 2 - padding + menuButtonInactiveHeight*2)) || (Gdx.input.getY()>(Gdx.graphics.getHeight() / 2 - padding + menuButtonInactiveHeight*3))) {
            game.batch.draw(menuButtonExitGameInactive, Gdx.graphics.getWidth() / 2 - menuButtonWidth / 2, Gdx.graphics.getHeight() / 2 + padding - menuButtonInactiveHeight*3f, menuButtonWidth, menuButtonInactiveHeight);
        } else {
            game.batch.draw(menuButtonExitGameActive, Gdx.graphics.getWidth() / 2 - menuButtonWidth / 2, (Gdx.graphics.getHeight() / 2 + padding - menuButtonActiveHeight*3f) - 27f*scaleFactor, menuButtonWidth, menuButtonActiveHeight);
            if (Gdx.input.isTouched()) {
                Gdx.app.exit();
            }
        }

//        glyphLayout.setText(font, menuTextNewGame);
//        font.draw(game.batch, menuTextNewGame, Gdx.graphics.getWidth()/2 - glyphLayout.width/2, Gdx.graphics.getHeight()/2 - glyphLayout.height/2);
//        glyphLayout.setText(font, menuTextResumeGame);
//        font.draw(game.batch, menuTextResumeGame, Gdx.graphics.getWidth()/2 - glyphLayout.width/2, Gdx.graphics.getHeight()/2 - glyphLayout.height*4);
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
