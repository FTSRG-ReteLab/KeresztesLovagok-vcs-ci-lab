package hu.bme.mit.train.tachometer;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainTachoMeter;
import hu.bme.mit.train.interfaces.TrainUser;


public class TachoMeterImpl implements TrainTachoMeter {

	TrainController beTC;
	TrainUser user;
	Table<Long, Integer, Integer> tabla;
	
	public TachoMeterImpl(TrainController c, TrainUser u){
		beTC = c;
		user = u;
		tabla = HashBasedTable.create();	
	}
	
	public void update() {
		long ct = System.currentTimeMillis();
		int pos = user.getJoystickPosition();
		int refSpeed = beTC.getReferenceSpeed();
		tabla.put(ct, pos, refSpeed);
	}
	
	
	public int getSize(){		
		return tabla.size();
		
	}
}
