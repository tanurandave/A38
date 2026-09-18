

// 1)WAP to print length of an string without using length() and length variable

public class StringDriver{
	public static void main(String[] args){
		String s = new String("Demo");
s
		System.out.println(printLength(s));
	}
	public static int printLength(String s){
		char[] ch = s.toCharArray();
		int count=0;
		for(char c:ch){
			count++;
		}
		return count;
	}
}