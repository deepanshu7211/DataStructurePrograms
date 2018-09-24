package com.deep.design_patterns.singleton;

public class SingletonThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Singleton instance1 = Singleton.getInstance();
		System.out.println("instance Id :: " + System.identityHashCode(instance1));

	}

}
