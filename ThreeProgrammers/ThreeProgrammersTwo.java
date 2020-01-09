public class ThreeProgrammersTwo {
    
	public String validCodeHistory(String code) {
		int aCount = 0;
		int bCount = 0;
		int cCount = 0;
		
		for (char c : code.toCharArray()) {
			if (c == 'A') aCount++;
			if (c == 'B') bCount++;
			if (c == 'C') cCount++;				
		}
		
		return check(aCount, bCount, cCount, 0, 0);
	}
	
	private String check(int a, int b, int c, int bYes, int cYes) {
		if (a == 0 && b == 0 && c ==0) return "";
		
		if (c > 0 && cYes == 0) {
			String s = check(a, b, c - 1, Math.max(0, bYes - 1), 2);
			if (s != "impossible") {				
				return 'C' + s;
			}
		}
		if (b > 0 && bYes == 0) {
			String s = check( a, b - 1, c, 1, Math.max(0, cYes - 1));
			if (s != "impossible") {
				return 'B' + s;
			}
		}
		if (a > 0) {
			String s = check(a - 1, b, c, Math.max(0, bYes - 1), Math.max(0, cYes - 1));
			if (s != "impossible") {
				return 'A' + s;
			}
		}		
		
		return "impossible";
	}

}