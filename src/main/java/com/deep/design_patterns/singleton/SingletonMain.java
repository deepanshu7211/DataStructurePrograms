package com.deep.design_patterns.singleton;

public class SingletonMain {
	public static void main(String[] args) {
		/*
		 * Singleton instance = Singleton.getInstance();
		 * 
		 * System.out.println("instance 1 :: " +
		 * System.identityHashCode(instance));
		 * 
		 * Singleton instance2 = Singleton.getInstance();
		 * System.out.println("instance 2  :: " +
		 * System.identityHashCode(instance2));
		 */

		// For Thread

		Thread t1 = new Thread(new SingletonThread(), "t1");
		Thread t2 = new Thread(new SingletonThread(), "t2");
		t1.start();
		t2.start();
	}
}
