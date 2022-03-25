package coursepackage;

public class StringExperiment {

	public static String repeat1(char c, int n) {
		String answer = "";
		for (int j = 0; j < n; j++)
			answer += c;
		return answer;
	}

	public static String repeat2(char c, int n) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < n; j++)
			sb.append(c);
		return sb.toString();
	}

	public static void main(String[] args) {
		int n = 50000; // starting value
		int trials = 10;
		try {
			if (args.length > 0)
				trials = Integer.parseInt(args[0]);
			if (args.length > 1)
				n = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
		}
		int start = n; // remember the original starting value

		// let's run version 2 (the quicker one) first
		System.out.println("Testing repeat2...");
		for (int t = 0; t < trials; t++) {
			long startTime = System.currentTimeMillis();
			String temp = repeat2('-', n);
			long endTime = System.currentTimeMillis();
			long elapsed = endTime - startTime;
			System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
			n *= 2; // double the problem size
		}

		System.out.println("Testing repeat1...");
		n = start; // restore n to its start value
		for (int t = 0; t < trials; t++) {
			long startTime = System.currentTimeMillis();
			String temp = repeat1('-', n);
			long endTime = System.currentTimeMillis();
			long elapsed = endTime - startTime;
			System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
			n *= 2; // double the problem size
		}
	}
}
