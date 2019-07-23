package com.iankoulski.problems.playground;

/**
 *
 * Code testing playground
 *
*/
public class Misc 
{
	static Misc m = new Misc();

	public static void main( String[] args )
	{
		System.out.println("\n\nvvvvvvvvvvvvvvvvvvvvvvvvv Miscellaneous vvvvvvvvvvvvvvvvvvvvvvvvvv \n");
		System.out.println(m.sayHello("Alex"));
		m.play();
		System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^ Miscellaneous ^^^^^^^^^^^^^^^^^^^^^^^^^^ \n");
		
	}

	public String sayHello(String name) {
 		return name == null ? "Hello!" : "Hello, "+name+"!";
	}

	public void play(){
		System.out.println("Play with Java.");

	}

}
