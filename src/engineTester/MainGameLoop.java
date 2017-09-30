package engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.Entity;
import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.OBJLoader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);
		
		RawModel model = OBJLoader.loadObjModel("untitled", loader);
		ModelTexture texture = new ModelTexture(loader.loadTexture("textureConcrete1"));
		TexturedModel staticModel = new TexturedModel(model, texture);
		
		Entity entity = new Entity(staticModel, new Vector3f(0, 0, -50), 0, 180, 0, 1);
		
		Camera camera = new Camera();
		
		while(!Display.isCloseRequested()) {
			//prepare render
			renderer.prepare();
			//start shader program
			shader.start();
			//game logic
			camera.move();
			//render
			shader.loadViewMatrix(camera);
			renderer.render(entity, shader);
			//stop shader program
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
