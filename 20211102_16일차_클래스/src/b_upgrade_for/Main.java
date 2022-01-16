package b_upgrade_for;

class Main {
	public static void main(String[] args) {
		int n1 = 10;
		int n2 = 20;
		int n3 = 30;

		// 배열 생성
		int[] all = new int[] { n1, n2, n3 };

		System.out.println("== 일반 반복 ==");
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}

		System.out.println("== 향상된 반복 ==");
		for (int n : all) {
			System.out.println(n);
		}
	}
}
