package in.net.kuldeep;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(main.minimizeCost(new int[]{1, 3, 10, 20}, new int[]{2, 2, 5, 3}));
        System.out.println(main.minimizeCost(new int[]{100, 50, 1},new int[] {10, 2, 1}));
        System.out.println(main.minimizeCost(new int[]{4, 10, 100, 13, 80}, new int[]{5, 3, 42, 40, 9}));
        System.out.println(main.minimizeCost(new int[]{5606451, 63581020, 81615191, 190991272, 352848147, 413795385, 468408016, 615921162, 760622952, 791438427}, new int[] {42643329, 9909484, 58137134, 99547272, 39849232, 15146704, 144630245, 604149, 15591965, 107856540}));
    }

    public long minimizeCost(int[] positions, int[] lengths) {

        TreeMap<Integer, Integer> cars = new TreeMap<>();

        for (int i = 0; i < positions.length; i++) {
            cars.put(positions[i], lengths[i]);
        }

        List<Long> gaps = new ArrayList<>();

        Map.Entry<Integer, Integer> prev = null;

        for (Map.Entry<Integer, Integer> entry : cars.entrySet()) {
            if (prev == null) {
                prev = entry;
                continue;
            } else {
                gaps.add((long)entry.getKey() - (long)(prev.getKey() + prev.getValue()));
                prev = entry;
            }
        }
        long cost = 0;
        if (gaps.size() % 2 == 0) {
            int mid = gaps.size() / 2;
            for (int i = 0; i < mid; i++) {
                cost += gaps.get(mid - i - 1) * (mid - i);
                cost += gaps.get(mid + i) * (mid - i);
            }
        } else {
            int mid = (gaps.size()) / 2;
            cost += gaps.get(mid) * (mid + 1);
            for (int i = 0; i < mid; i++) {
                cost += gaps.get(mid - i - 1) * (mid - i);
                cost += gaps.get(mid + i) * (mid - i);
            }
        }
        return cost;
    }
}
