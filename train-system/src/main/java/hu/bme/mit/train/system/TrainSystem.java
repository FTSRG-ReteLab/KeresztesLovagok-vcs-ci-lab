package hu.bme.mit.train.system;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.tachometer.TachoMeterImpl;
import hu.bme.mit.train.user.TrainUserImpl;
import hu.bme.mit.train.interfaces.TrainTachoMeter;

public class TrainSystem {

	private TrainController controller = new TrainControllerImpl();
	private TrainUser user = new TrainUserImpl(controller);
	private TrainSensor sensor = new TrainSensorImpl(controller, user);
	private TachoMeterImpl tachoMeter = new TachoMeterImpl(controller,user);

	public TrainController getController() {
		return controller;
	}

	public TrainSensor getSensor() {
		return sensor;
	}

	public TrainUser getUser() {
		return user;
	}
	
	public TrainTachoMeter getTachoMeter() {
		return tachoMeter;
	}


}
