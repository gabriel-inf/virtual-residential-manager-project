package com.vrm.data;

import java.util.ArrayList;

import com.vrm.model.Camera;

import com.vrm.systemexceptions.RegisterNotFoundException;

public class CameraDAO {
	public Camera getCameraById(int cameraId) throws Exception {
		ArrayList<Camera> systemCameras = new ArrayList<Camera>();
		systemCameras.addAll(Database.getInstance().getAllCameras());
		
		for (Camera camera : systemCameras) {
			if(camera.getId() == cameraId)
				return camera;
		}
		throw new RegisterNotFoundException();
	}
}
