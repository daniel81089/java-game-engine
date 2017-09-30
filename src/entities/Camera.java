package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	//a human is about 1.82 meters tall.
	private Vector3f position = new Vector3f(0,1.82f,0);
	private float pitch;
	private float yaw;
	private float roll;
	
	public Camera() {
		//set this only once, create input class eventually
		Mouse.setGrabbed(true);
	}
	
	public void move() {
		float mouseRelativeX = (float)Mouse.getDX() / Display.getWidth();
		float mouseRelativeY = (float)Mouse.getDY() / Display.getHeight();
		
		yaw += mouseRelativeX * 90;
		pitch += -mouseRelativeY * 90;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)) {
			position.z -= 0.1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) {
			position.z += 0.1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
			position.x -= 0.1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
			position.x += 0.1f;
		}
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}
	
}
