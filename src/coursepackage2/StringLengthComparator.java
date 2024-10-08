package coursepackage2;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {

	public int compare(String a, String b) {
		if (a.length() < b.length())
			return -1;
		else if (a.length() == b.length())
			return 0;
		else
			return 1;
	}

	public static void main(String[] args) {
		String data[] = { "Apple", "Banana", "Grape", "Grapefruit", "Plum", "Raspberry", "Strawberry" };
		java.util.Arrays.sort(data, new StringLengthComparator());
		System.out.println("data: " + java.util.Arrays.toString(data));
	}

}
