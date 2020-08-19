package Q1_06_String_Compression;

public class QuestionA_ {
	public static String compressBad(String str) {
		String compressedString = "";
		int groupSize = 0;
		for (int i = 0; i < str.length(); i++) {
			groupSize++;
			if (i == str.length() - 1 || str.charAt(i) != str.charAt(i + 1)) {
				compressedString += "" + str.charAt(i) + groupSize;
				groupSize = 0;
			}
		}
		return compressedString.length() < str.length() ? compressedString : str;
	}
	
	public static void main(String[] args) {
		String str = "aabbbcccc";
		System.out.println(str);
		System.out.println(compressBad(str));
	}
}
