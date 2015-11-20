package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScratch extends ApplicationAdapter {
	SpriteBatch batch;
	Texture splash;
	TextureAtlas taButtons;
	ImageButton.ImageButtonStyle ibsPlay, ibsHelp;
	ImageButton ibPlay, ibHelp;
	Skin skButtons;
	Stage stage;

	@Override
	public void create() {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		batch = new SpriteBatch();
		splash = new Texture("MainMenu.png");
		taButtons = new TextureAtlas("Buttons/Buttons.atlas");
		skButtons = new Skin();
		skButtons.addRegions(taButtons);

		ibsPlay = new ImageButton.ImageButtonStyle();
		ibsPlay.up = skButtons.getDrawable("PBTNUp");
		ibsPlay.down = skButtons.getDrawable("PBTNDown");
		ibsPlay.checked = skButtons.getDrawable("PBTNUp");
		ibPlay = new ImageButton(ibsPlay);
		
		ibsHelp = new ImageButton.ImageButtonStyle();
		ibsHelp.up = skButtons.getDrawable("IBTNUp");
		ibsHelp.down = skButtons.getDrawable("IBTNDown");
		ibsHelp.checked = skButtons.getDrawable("IBTNUp");
		ibHelp = new ImageButton(ibsHelp);
		
		//ibPlay.setSize(203, 100); // Sizing for Desktop Launcher
		ibPlay.setSize(814, 160); // Sizing for Android
		ibHelp.setSize(124, 124); // Sizing for Android
		ibPlay.setPosition((Gdx.graphics.getWidth() / 2) - ibPlay.getWidth() / 2,
				(Gdx.graphics.getHeight() / 2 - 300) - ibPlay.getHeight() / 2);

		ibPlay.addListener(new InputListener() {//http://gamedev.stackexchange.com/questions/60123/registering-inputlistener-in-libgdx

			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("Play");
				return false;
			}
		});

		ibHelp.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				System.out.println("Help");
				return false;
			}
		});

		stage.addActor(ibPlay);
		stage.addActor(ibHelp);

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(splash, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
}


