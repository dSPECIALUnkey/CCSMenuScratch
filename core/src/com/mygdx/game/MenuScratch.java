package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public class MenuScratch extends ApplicationAdapter {
	SpriteBatch batch;
	Texture splash;
	TextureAtlas taPlay;
	ImageButton.ImageButtonStyle ibsPlay;
	ImageButton ibPlay;
	Skin skPlay;
	Stage stage;
	
	@Override
	public void create () {
		stage = new Stage();
		batch = new SpriteBatch();
		splash = new Texture("MainMenu.png");
		taPlay = new TextureAtlas("Buttons/Buttons.atlas");
		skPlay = new Skin();
		skPlay.addRegions(taPlay);
		ibsPlay = new ImageButton.ImageButtonStyle();
		ibsPlay.up = skPlay.getDrawable("PBTNUp");
		ibsPlay.down = skPlay.getDrawable("PBTNDown");
		ibsPlay.checked = skPlay.getDrawable("PBTNUp");
		ibPlay = new ImageButton(ibsPlay);
		ibPlay.setSize(250, 100);
		ibPlay.setOrigin(ibPlay.getWidth()/2, ibPlay.getHeight()/2);
		ibPlay.setPosition(Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth()/2);
		ibPlay.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("PLAY");
			}
		});
	stage.addActor(ibPlay);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(splash, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
}
