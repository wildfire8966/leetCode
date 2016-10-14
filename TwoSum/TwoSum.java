package TwoSum;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
		int len = numbers.length;
		int[] index = new int[2];

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < len; i++) {
			if (!map.containsKey(numbers[i])) {
				map.put(target - numbers[i], i);
			} else {
				index[0] = map.get(numbers[i]);
				index[1] = i;
			}
		}

		return index;
	}

	public static void main(String[] args) {
		int[] a = {3,2,4,3,3};
		int[] b = new TwoSum().twoSum(a, 6);
		System.out.println(b[0] + " " + b[1]);
	}
}
