package com.iankoulski;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Structure Examples
 *
 */
public class StructureExamples
{
    public static void main( String[] args )
    {
        System.out.println( "\n\nvvvvvvvvvvvvvvvvvvvvvvvvv Structure Examples vvvvvvvvvvvvvvvvvvvvvvvvv \n");

        System.out.println("Testing collections ...");
	t o = new t("name","alex");
	List al = new ArrayList();
	al.add("S1");
	al.add("S1");
	al.add("s2");
	al.add(null);
	al.add("");
	al.add("s_3");
	al.add(5);
	al.add(o);
	System.out.println("ArrayList: " + al.toString());

        Set ss = new HashSet();
	ss.add("S1");
	ss.add("S1");
	ss.add("s2");
	ss.add(null);
	ss.add("");
	ss.add("s_3");
	ss.add(5);
	ss.add(o);
	System.out.println("HashSet: " + ss.toString());
        
	System.out.println( "\n^^^^^^^^^^^^^^^^^^^^^^^ End Structure Examples ^^^^^^^^^^^^^^^^^^^^^^^ \n\n");

    }

    static class t {
        String name;
	String value;
	public t(String n, String v){
		this.name=n;
		this.value=v;
	}

	public String toString(){
		String s = "{\""+this.name+"\":"+this.value+"\"}";
		return s;
	}
    }

}
