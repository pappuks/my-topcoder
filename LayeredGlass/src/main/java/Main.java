public class Main {

    public static void main(String[] args) {
        Main main = new Main();
		System.out.println(main.minDefects(new String[]{"X.",".."}, new String[]{"..",".X"}));
		System.out.println(main.minDefects(new String[]{"XX..","X...","XX..","X..."}, new String[]{"XXXX","X.X.","....","...."}));
    }

    public int minDefects(String[] a, String[] b) {
    	int len = a.length;
    	int[] defects = new int[8];

		
		for (int i = 0; i < len; i++) {
			for(int j = 0; j < len; j++) {
				char ca = a[i].charAt(j);
				if (ca == 'X' || b[i].charAt(j) == 'X') {
					defects[0]++;
				}
				if (ca == 'X' || b[i].charAt(len-1-j) == 'X') {
					defects[1]++;
				}
				if (ca == 'X' || b[len-1-i].charAt(j) == 'X') {
					defects[2]++;
				}
				if (ca == 'X' || b[len-1-i].charAt(len-1-j) == 'X') {
					defects[3]++;
				}
				if (ca == 'X' || b[j].charAt(i) == 'X') {
					defects[4]++;
				}
				if (ca == 'X' || b[j].charAt(len-1-i) == 'X') {
					defects[5]++;
				}
				if (ca == 'X' || b[len-1-j].charAt(i) == 'X') {
					defects[6]++;
				}
				if (ca == 'X' || b[len-1-j].charAt(len-1-i) == 'X') {
					defects[7]++;
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 8; i++) {
			if (defects[i] < min) {
				min = defects[i];
			}
		}

        return min;
    }
}
