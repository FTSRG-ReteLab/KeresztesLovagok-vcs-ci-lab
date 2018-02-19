package hu.bme.mit.train.tachometer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.*;
import hu.bme.mit.train.user.TrainUserImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TrainTachoMeterTest {

	TrainSensor sensor;
	TachoMeterImpl tachoMeter;
	TrainController controller;
	TrainUser user;
	
    @Before
    public void before() {
    	
		controller = new TrainControllerImpl();
		controller.setJoystickPosition(2);
		user = new TrainUserImpl(controller);
		user.overrideJoystickPosition(3);
		tachoMeter = new TachoMeterImpl(controller, user);
    	 
    }

    @Test
    public void isEmpty() {
        Assert.assertEquals(0, tachoMeter.getSize());
    }

}
