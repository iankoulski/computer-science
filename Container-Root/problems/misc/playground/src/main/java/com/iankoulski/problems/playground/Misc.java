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

	public void playHRAnagrams(){
		System.out.println("Play with HackerRank Anagrams.");
		String s = new String("abba");
        java.util.Hashtable<String,Integer> ht = new java.util.Hashtable<String,Integer>(s.length());
        for (int start = 0; start < s.length(); start++){
            for (int end = start+1; end <= s.length(); end++){
                String substr = s.substring(start,end);
                String sig = m.getSig(substr);
                Integer count = ht.get(sig);
                if (count==null) count = new Integer(0);
                count = new Integer(count.intValue() + 1);
                ht.put(sig,count);
            }
        }
        int anagrams=0;
        //System.out.println(ht.keySet());
        System.out.println(ht.values());
        for (Integer count : ht.values()){
            int cnt = count.intValue();
            anagrams+=cnt*(cnt-1)/2;
        }
        System.out.println(anagrams);
    }

    private String getSig(String s){
		int[] sig = new int[26];
		String strSig = "";
        for (int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            int index = c - 'a';
            sig[index]++;
		}
		strSig = java.util.Arrays.toString(sig);
        System.out.println(s);
        System.out.println(strSig);
        return strSig;
    } 

}
