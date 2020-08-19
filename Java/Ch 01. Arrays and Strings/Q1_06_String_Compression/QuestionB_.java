package Q1_06_String_Compression;

public class QuestionB_ {
	public static String compress(String str) {
		StringBuilder compressedString = new StringBuilder();
		int groupSize = 0;
		for (int i = 0; i < str.length(); i++) {
			groupSize++;
			if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
				compressedString.append(str.charAt(i));
				compressedString.append(groupSize);
				groupSize = 0;
			}
		}
		return compressedString.length() < str.length() ? compressedString.toString() : str;
	}
	
	public static void main(String[] args) {
		String str = "aabbbcccc";
		System.out.println(str);
		System.out.println(compress(str));
	}
}
