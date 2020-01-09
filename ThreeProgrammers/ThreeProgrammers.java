import java.util.*;
public class ThreeProgrammers {
	
	private final String impossible = "impossible";
	
	private List<MyKey> cache = new ArrayList<>();
	
	public static class MyKey {
		private String code;
		private int a;
		private int b;
		private int c;
		public MyKey(String str, int aA, int bB, int cC) {
			code = str;
			a = aA;
			b = bB;
			c = cC;
		}
		
		@Override
		public boolean equals(Object bO) {
			if (!(bO instanceof MyKey)) {
				return false;
			}
			MyKey bC = (MyKey)bO; 
			if (bC.code.equals(code) && bC.a == a && bC.b == b && bC.c == c) {
				return true;
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		ThreeProgrammers tp = new ThreeProgrammers();
		System.out.println(tp.validCodeHistory("CAB"));
		System.out.println(tp.validCodeHistory("BB"));
		System.out.println(tp.validCodeHistory("CBB"));
		System.out.println(tp.validCodeHistory("CAC"));
		System.out.println(tp.validCodeHistory("ACAC"));
		System.out.println(tp.validCodeHistory("ACABC"));
		System.out.println(tp.validCodeHistory("BAABCABBCCACBAACABAABABBCCAACABCCAACCABCACACCBABAB"));
	}
	
	public String validCodeHistory(String code) {
		int a = 0;
		int b = 0;
		int c = 0;
		for (int i = 0; i < code.length(); i++) {
			char d = code.charAt(i);
			if (d == 'A') a++;
			if (d == 'B') b++;
			if (d == 'C') c++;
		}
		return check("",a,b,c);
	}
	
	public String check(String code, int a, int b, int c) {
		if (a == 0 && b == 0 && c == 0) {
			return code;
		}
		if (code.length() > 2) {
			MyKey mk = new MyKey(code.substring(code.length() - 2), a, b, c);
			if (cache.contains(mk)) {
				return impossible;
			}
		}
		String retValA = impossible;
		String retValB = impossible;
		String retValC = impossible;
		if (a > 0) {
			retValA = check(code + "A", a - 1, b, c);
		}
		if (retValA.equals(impossible) && b > 0 && (code.length() == 0 || (code.length() > 0 && code.charAt(code.length() - 1) != 'B'))) {
			retValB = check(code + "B", a, b - 1, c);
		}
		if (retValA.equals(impossible) && retValB.equals(impossible) && c > 0 && (code.length() == 0 || 
			(code.length() == 1 && code.charAt(code.length() - 1) != 'C') ||
			(code.length() > 1 && code.charAt(code.length() - 1) != 'C' && code.charAt(code.length() - 2) != 'C'))) {
			retValC = check(code + "C", a,b,c - 1);
		}
		
		if (!retValA.equals(impossible)) {
			//System.out.println(" code:" + code + " A:" + a + " B:" + b + " C:" + c);
			//System.out.println("	retValB:" + retValB);
			//System.out.println("	retValC:" + retValC);
			return retValA;
		}
		if (!retValB.equals(impossible)) {
			//System.out.println(" code:" + code + " A:" + a + " B:" + b + " C:" + c);
			//System.out.println("	retValA:" + retValA);
			//System.out.println("	retValC:" + retValC);
			return retValB;
		}
		if (!retValC.equals(impossible)) {
			//System.out.println(" code:" + code + " A:" + a + " B:" + b + " C:" + c);
			//System.out.println("	retValA:" + retValA);
			//System.out.println("	retValB:" + retValB);
			return retValC;
		}
		//System.out.println(" code:" + code + " A:" + a + " B:" + b + " C:" + c);
		if (code.length() > 2) {
			MyKey mk = new MyKey(code.substring(code.length() - 2), a, b, c);
			cache.add(mk);
		}
		return impossible;
		
	}
}