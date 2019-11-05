package com.app.coni.Service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.app.coni.model.CurrentTime;

@Service
public class CurrentTimeServiceImpl implements CurrentTimeService {

	@Override
	public CurrentTime getCurrentTime() {
		CurrentTime curTime = new CurrentTime();
		LocalTime localTime = LocalTime.now();
		curTime.setCurrentTime(localTime);

		return curTime;
	}

}
