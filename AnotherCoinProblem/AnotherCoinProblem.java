public class AnotherCoinProblem {
	public static void main(String[] args) {
		//System.out.println(minimiumCoins(47));
		//System.out.println(minimiumCoins(9));
		//System.out.println(minimiumCoins(250111));
		//System.out.println(minimiumCoins(76540123));
		long t = 123455463457651L;
		System.out.println(minimiumCoins(t));
		System.out.println(minimiumCoins(131679235679767L));
		System.out.println(minimiumCoins(83000000000000L));
	}
	
	public static int minimiumCoins(long cost) {
		long divCost = cost;
		int pwrHund = 0;
		int totalCoins = 0;
		while(divCost / 100 > 0) {
			divCost /= 100;
			pwrHund++;
		}
		System.out.println("Input : "+ cost +" pwrHund : " + pwrHund);
		while(cost > 0 && pwrHund >= 0) {
			long hund = (long)Math.pow(100L, pwrHund);
			if ((cost / (25L * hund)) > 0) {
				totalCoins += cost / (25L * hund);
				cost = cost % (25L * hund);
			}
			System.out.println(25L * hund + " cost : " + cost + " coins: " + totalCoins);
			if ((cost / (10L * hund)) > 0) {
				totalCoins += cost / (10L * hund);
				cost = cost % (10L * hund);
			}
			System.out.println(10L * hund + " cost : " + cost +  " coins: " + totalCoins);
			if ((cost / hund) > 0) {
				totalCoins += cost / hund;
				cost = cost % hund;
			}
			System.out.println(hund + " cost : " + cost + " coins: " + totalCoins);
			pwrHund--;
		}
		if (cost > 0) {
			System.out.println("Error: Cost = " + cost);
		}
		return totalCoins;
	}

}