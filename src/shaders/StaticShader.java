package shaders;

import org.lwjgl.util.vector.Matrix4f;

import entities.Camera;
import tools.Maths;

public class StaticShader extends ShaderProgram {
	
	private static final String VERTEXfILE = "src/shaders/vertexShader.txt";
	private static final String FRAGMENTfILE = "src/shaders/fragmentShader.txt";
	
	private int locationTransformationMatrix;
	private int locationViewMatrix;
	private int locationProjectionMatrix;
	
	public StaticShader() {
		super(VERTEXfILE, FRAGMENTfILE);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1, "textureCoords");
	}

	@Override
	protected void getAllUniformLocations() {
		locationTransformationMatrix = super.getUniformLocation("transformationMatrix");
		locationViewMatrix = super.getUniformLocation("viewMatrix");
		locationProjectionMatrix = super.getUniformLocation("projectionMatrix");
	}
	
	public void loadTransformationMatrix(Matrix4f matrix) {
		super.loadMatrix(locationTransformationMatrix, matrix);
	}
	
	public void loadViewMatrix(Camera camera) {
		Matrix4f matrix = Maths.createViewMatrix(camera);
		super.loadMatrix(locationViewMatrix, matrix);
	}
	
	public void loadProjectionMatrix(Matrix4f matrix) {
		super.loadMatrix(locationProjectionMatrix, matrix);
	}
}
