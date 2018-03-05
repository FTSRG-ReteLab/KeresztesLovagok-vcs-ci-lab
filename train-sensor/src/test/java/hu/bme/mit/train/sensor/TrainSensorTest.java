package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

	TrainSensor sensor;
	int value1;
    int value2;
    TrainController mockController;
    TrainUser mockUser;
    
    TrainSensorImpl trainSensor;
    
    @Before
    public void before() {
    	value1=2;
    	value2=3;
        // TODO Add initializations
    	
    	mockController = mock(TrainController.class);
    	mockUser = mock(TrainUser.class);
    	trainSensor = new TrainSensorImpl(mockController, mockUser);	
    	 
    }
/*
    @Test
    public void ThisIsAnExampleTestStub() {
        // TODO Delete this and add test cases based on the issues
    }
    @Test
    public void ThisIsANewTest() {
        // TODO Delete this and add test cases based on the issues
    	int result = value1 + value2;
        assertTrue(result == 5);
    }
  */  
    @Test
    public void negativeSpeedLimit() {	
    	trainSensor.overrideSpeedLimit(-1);
    	verify(mockUser, times(1)).setAlarmState(true);   	
   	
    }
    @Test
    public void bigSpeedLimit() {	
    	trainSensor.overrideSpeedLimit(501);
    	verify(mockUser, times(1)).setAlarmState(true);   	
   	
    }
    
    @Test
    public void smallerThanHalfRefSpeed() {
    	when(mockController.getReferenceSpeed()).thenReturn(100);
    	
    	trainSensor.overrideSpeedLimit((int)(mockController.getReferenceSpeed()*0.4));
    	verify(mockUser, times(1)).setAlarmState(true);   	
   	
    }
    @Test
    public void equalHalfRefSpeed() {	
    	when(mockController.getReferenceSpeed()).thenReturn(100);
    	
    	trainSensor.overrideSpeedLimit((int)(mockController.getReferenceSpeed()*0.5));
    	verify(mockUser, times(0)).setAlarmState(false);   	
   	
    }

}
