package com.mygdx.game;

import com.badlogic.gdx.Game;

/**
 * Created by Ariana on 11/24/2015.
 */
public class ScreenHandler extends Game {
    BombermanScreen bombermanScreen;
    MenuScratch menuScratch;
    Instructionpage instructionpage;

    @Override
    public void create() {
        menuScratch = new MenuScratch(this);
        bombermanScreen = new BombermanScreen(this);
        instructionpage = new Instructionpage(this);
        setScreen(menuScratch);
    }

    public void screenChange(String sBtn) {
        if (sBtn.equalsIgnoreCase("play")) {
            setScreen(bombermanScreen);
        }else if (sBtn.equalsIgnoreCase("help")){
            setScreen(instructionpage);
        }
    }
}
