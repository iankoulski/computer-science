package com.iankoulski.problems.playground;

/**
 *
 * Code testing playground
 *
*/
public class Misc 
{

    public static void main( String[] args )
    {
		System.out.println("\n\nvvvvvvvvvvvvvvvvvvvvvvvvv Miscellaneous vvvvvvvvvvvvvvvvvvvvvvvvvv \n");
		Misc m = new Misc();
		System.out.println(m.sayHello("Alex"));
    	System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^ Miscellaneous ^^^^^^^^^^^^^^^^^^^^^^^^^^ \n");
    }

	public String sayHello(String name) {
		return name == null ? "Hello!" : "Hello, "+name+"!";
	}
}
