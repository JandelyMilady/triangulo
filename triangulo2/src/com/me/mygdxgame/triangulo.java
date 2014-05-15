package com.me.mygdxgame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class triangulo implements ApplicationListener {

	private Texture texture;
	Stage stage;
	Image triangulo;
	
	boolean izq = false;
	
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
	
		
		texture = new Texture(Gdx.files.internal("data/triangulo.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 128, 128);
		
		stage = new Stage();
		triangulo= new Image(texture);
		
		stage.addActor(triangulo);
		
	}

	@Override
	public void dispose() {
		
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.draw();
		
		if (triangulo.getX()>300)
		{
			izq=true;
		}
		if (triangulo.getX()<1)
		{
			izq=false;
		}
		if (izq==true)
		{
			triangulo.setX(triangulo.getX()-1);
		}
		else
		{
			triangulo.setX(triangulo.getX()+1);
		}
		
		
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
