package Q1_05_One_Away;

public class QuestionA_ {

	public static boolean oneEditReplace(String s1, String s2) {
		boolean foundDifference = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (foundDifference) {
					return false;
				}
				
				foundDifference = true;
			}
		}
		return true;
	}
	
	/* Check if you can insert a character into s1 to make s2. */
	public static boolean oneEditInsert(String s1, String s2) {
		int index1 = 0;
		int index2 = 0;
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				if (index1 != index2) {
					return false;
				}		
				index2++;
			} else {
				index1++;
				index2++;
			}
		}
		return true;
	}	
	
	public static boolean oneEditAwayOrig(String first, String second) {
		if (first.length() == second.length()) {
			return oneEditReplace(first, second);
		} else if (first.length() + 1 == second.length()) {
			return oneEditInsert(first, second);
		} else if (first.length() - 1 == second.length()) {
			return oneEditInsert(second, first);
		} 
		return false;
	}

	public static boolean oneEditAway(String first, String second) {
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		if (second.length() > first.length()) {
			String temp = first;
			first = second;
			second = temp;
		}
		int firstLength = first.length();
		int secondLength = second.length();
		boolean foundDifference = false;
		int secondIdx = 0;
		for (int firstIdx = 0; firstIdx < firstLength; firstIdx++) {
			if (secondIdx >= second.length()) {
				break;
			}
			if (first.charAt(firstIdx) == second.charAt(secondIdx)) {
				secondIdx++; // If matching, move pointer to shorter string
			}
			else if (foundDifference) {
				return false; // Ensure that this is the first difference found
			}
			else {
				if (firstLength == secondLength) {
					secondIdx++; // On replace, move pointer to shorter string
				}
				foundDifference = true;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		String a = "plae";
		String b = "pale";
		boolean isOneEdit = oneEditAway(a, b);
		System.out.println(a + ", " + b + ": " + isOneEdit);
	}

}
