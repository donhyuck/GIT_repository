public class Main {
	public static void main(String[] args) {
		boolean[] arr1 = new boolean[3];
		arr1[0] = true;
		arr1[1] = true;
		arr1[2] = false;

		double[] arr2 = { 3.14, 5.55, 10.0 };
		// double[] arr2 = new double[3];
		// arr2[0] = 3.14;
		// arr2[1] = 5.55;
		// arr2[2] = 10.0;

		int[] arr3 = new int[10];

		for (int i = 0; i < 10; i++) {
			arr3[i] = i + 1;
		}

		System.out.printf("arr1[0] : %b\n", arr1[0]);
		System.out.printf("arr2[2] : %.2f\n", arr2[2]);
		System.out.printf("arr3[4] : %d\n", arr3[4]);
		System.out.print(arr2);
	}
}