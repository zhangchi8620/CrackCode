package org.crackcode.ch1;

public class CompressBad {
	// Book Method 1: O(p+k^2), p: length of string, k: # of char sequence.
	// Doesn't consider length
	public static String compressBad(String str){
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == last){
				count++;
			}
			else{
				mystr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		mystr += last + "" + count;

		return mystr;
	}
	
	// Method 2: StringBuffer, extra space. Consider length
	public static String compressBad2(String str){
		// check original str size and compressed str size
		int size = countCompression(str);
		//System.out.println(size);
		if(size > str.length())
			return str;
		
		StringBuffer sb = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); i++){
			if(last == str.charAt(i)){
				count++;
			}
			else{
				sb.append(last+""+count);
				last = str.charAt(i);
				count = 1;
			}
		}
		sb.append(last+""+count);

		return sb.toString();
	}
	
	static int countCompression(String str){
		int count = 1;
		int size = 0;
		char last = str.charAt(0);
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == last){
				count++;
			}
			else{
				last = str.charAt(i);
				// Important!!! NOT count+1
				size += String.valueOf(count).length() + 1;
				count = 1;
			}
		}
		
		size += String.valueOf(count).length() + 1;
		return size;
	}
	
	//Method 3: No extra buffer. Consider length
	static String compressBad3(String str){
		// check original str size and compressed str size
		int size = countCompression(str);
		//System.out.println(size);
		if(size > str.length())
			return str;
		char[] mystr = new char[size];
		int index = 0;
		char last = str.charAt(index);
		int count = 1;
		for(int i = 1; i < str.length(); i++){
			if(last == str.charAt(i)){
				count++;
			}
			else{
				index = setChar(mystr, last, count, index);
				last = str.charAt(i);
				count = 1;
			}
		}
		index = setChar(mystr, last, count, index);
		return new String(mystr);
	}
	static int setChar(char[] mystr, char last, int count, int index){
		mystr[index] = last;
		index++;
		
		char[] tmp = String.valueOf(count).toCharArray();
		for(char t : tmp){
			mystr[index++] = t;
		}
		return index;
	}
	
	public static void main(String[] args){
		String str = "aabcccccdx";
		System.out.println("Input string:\n" + str);
		//System.out.println(compressBad(str));
		//System.out.println(compressBad2(str));
		System.out.println(compressBad3(str));
	}
}
