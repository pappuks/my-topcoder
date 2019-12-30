import java.util.*;
public class FibonacciSequence {
	
	public static void main(String[] args) {
		FibonacciSequence fs = new FibonacciSequence();
		System.out.println("Ex: 3 " + fs.numFibs(377, 987));
		System.out.println(fs.numFibs(12, 13));
		System.out.println(fs.numFibs(13, 13));
		System.out.println(fs.numFibs(2, 144));
		System.out.println(fs.numFibs(233, 233));
		System.out.println(fs.numFibs(5, 377));
		System.out.println("Ex: 0 " + fs.numFibs(14, 14));
		System.out.println("Ex: 1 " + fs.numFibs(986, 988));
		System.out.println("Ex: 14 " + fs.numFibs(2, 1000));
	}
	
	List<Integer> list = new ArrayList<>(Arrays.asList(1, 1));
	
	public int findFib(int n) {
		if (list.size() > n) return list.get(n);
		int val = findFib(n - 1) + findFib(n - 2);
		list.add(n, val);
		return val;
	}
	
	public int findNumOfFib(int val) {
		int lastVal = list.get(list.size() - 1);
		int numOfFib = 0;
		if (lastVal == val) return list.size();
		while(lastVal < val) {
			lastVal = findFib(list.size());
		}
		int i = 0;
		for (; i < list.size(); i++) {
			if (list.get(i) >= val) break;
		}
		return (list.get(i) == val) ? i + 1 : i;
	}
	
	public boolean isFib(int val) {
		return list.indexOf(val) != -1;
	}
	
	public int numFibs(int a, int b) {
		int aNum = findNumOfFib(a);
		System.out.println("a: " + a + " Num: " + aNum + " isFib : " + isFib(a));
		int bNum = findNumOfFib(b);
		System.out.println("b: " + b + " Num: " + bNum + " isFib : " + isFib(b));
		int diff = Math.abs(aNum - bNum);
		if (isFib(a)) {
			diff++;
		}
	for(int i = 0; i < list.size(); i++) System.out.print("[" + i + "]" + list.get(i) + " ");
		System.out.println();
		return diff;
	}
	
}