package logic;

public class Sorting {

	public static void sort(int[] arr) {

		int n = arr.length;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
	}

	public static int max(int[] arr) {
		return arr[2];
	}

	public static int min(int[] arr) {
		return arr[0];
	}

}
