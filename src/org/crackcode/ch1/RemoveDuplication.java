package org.crackcode.ch1;

public class RemoveDuplication {
	
	// Method 1: (Book) no extra buffer, but not correct!!!
	public static char[] removeDuplication(char[] str){
		if (str == null) return null;
		if (str.length < 2) return null;
		System.out.println(str);

		int tail = 1;
		
		for (int i = 1; i < str.length; ++i){
			int j;
			for(j = 0; j < tail; j++){
				if (str[j] == str[i]) {
					System.out.println("i: " + i + "\tj: " + j + "\tstr: " + new String(str));
					break;
				}
			}
			if (j == tail){
				System.out.println("j==tail: j = " + j);
				str[tail] = str[i];
				++tail;
			}
		}
		System.out.println(tail);
		str[tail] = 0;

		return str;
	}
	
	// Method 2: StringBuilder extra buffer?
	public static String removeDuplication2(String str) {
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i < sb.length(); i++){
        	for (int j = i+1; j < sb.length(); j++){
        		if (sb.charAt(i) == sb.charAt(j)){
        			sb.deleteCharAt(j);
        			j--;
        		}
        	}
        }
        
		return sb.toString();
	}
	
	// Method 3: (Book) with additional memory of constant size. not correct???
	public static String removeDuplicatesEff(char[] str) { 
		if (str == null){
			System.out.println("null");
			return null;
		}
	
		int len = str.length;
		if (len < 2) return null;
		boolean[] hit = new boolean[256]; 
		for (int i = 0; i < 256; ++i) {
			hit[i] = false;
		}
		hit[str[0]] = true; 
		int tail = 1;
		for (int i = 1; i < len; ++i){ 
				if (!hit[str[i]]) {
					str[tail] = str[i]; 
					++tail; 
					hit[str[i]] = true;
				} 
		}
		str[tail] = 0; 
		return new String(str);
	}
	// 	Method 5
	public static String removeDuplication5(char[] s) { 
	    int len = s.length;
	    if(len < 2) return null;
	    //int p = 0;
	    for(int i=0; i < len; ++i)
	    {
	        if(s[i] != '\0')
	        {
	            //s[p++] = s[i];
	            for(int j=i+1; j < len; ++j)
	                if(s[j]==s[i])
	                    s[j] = '\0';
	        }
	    }
	    //s[--p] = '\0';
	    
	    return new String(s);
	}
	
	// Method 6
	public static String removeDuplication6(char s[]){
		int len = s.length;
		if(len<1) return null;
		int p=0;
		for(int i=0;i<len;++i){
			if(s[i]!='\0'){
				s[p++]=s[i];
				for(int j=i+1;j<len;++j){
					if(s[j]==s[i]){
						s[j]='\0';
					}
				}
			}
		}
		s[p]='\0';
		
		for(int i=0;i<len&&s[i]!='\0';i++){
			System.out.print(s[i]);
		}
		return new String(s);
	}
	
	public static void main(String[] args){

		String str = "acbaabbbcaac";
		//System.out.println(RemoveDuplication.removeDuplication(str.toCharArray()));
		//System.out.println(RemoveDuplication.removeDuplication2(str));
		//System.out.println(RemoveDuplication.removeDuplicatesEff(str.toCharArray()));
		System.out.println(RemoveDuplication.removeDuplication6(str.toCharArray()));


	}
}
