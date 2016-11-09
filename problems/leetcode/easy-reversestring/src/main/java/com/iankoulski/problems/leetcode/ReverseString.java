package com.iankoulski.problems.leetcode;

class ReverseString {
	public static void main(String[] args){
		System.out.println("\n\nvvvvvvvvvvvvvvvvvv Reverse String vvvvvvvvvvvvvvvvvvvvv\n");
		String str = args[0];
		if (str==null || str.length()==0){
			str = "string";
		}
		System.out.println("The reverse of string ");
		System.out.println(str);
		System.out.println("is ");
		System.out.println(reverseString(str));
		System.out.println("\n^^^^^^^^^^^^^^^^^^ End Reverse String ^^^^^^^^^^^^^^^^^^^^^\n\n");
	}
    static String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
    }
};
