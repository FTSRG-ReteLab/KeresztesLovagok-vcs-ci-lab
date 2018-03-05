package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainSensor;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

	TrainSensor sensor;
	int value1;
    int value2;
    @Before
    public void before() {
    	value1=2;
    	value2=3;
        // TODO Add initializations
    	 
    }

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

}
