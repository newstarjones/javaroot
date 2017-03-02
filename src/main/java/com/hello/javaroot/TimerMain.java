package com.hello.javaroot;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {

	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new TimerTask(){

			@Override
			public void run() {
				System.out.println("123");
				
			}};
		timer.schedule(task, 3000);
	}
}
