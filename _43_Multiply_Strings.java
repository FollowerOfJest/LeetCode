package LeetCode;


public class _43_Multiply_Strings{
    public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		int length1 = num1.length();
		int length2 = num2.length();
		StringBuilder str = new StringBuilder();
        //使用数组表示结果的每一位
		int[] arrayInt = new int[length1 + length2];
        //后边的小位
		for (int i = length1 - 1; i >= 0; i--) {
			for (int z = length2 - 1; z >= 0; z--) {
				int number1 = num1.charAt(i) - '0';
				int number2 = num2.charAt(z) - '0';
                arrayInt[i + z] += number1 * number2;
                //进位
				if (arrayInt[i + z] >= 10 && (i + z) != 0) {
					arrayInt[i + z - 1] += arrayInt[i + z] / 10;
					arrayInt[i + z] = arrayInt[i + z] % 10;
				}
			}
		}

		for (int i = 0; i <= length1 + length2 - 2; i++) {
			str.append(arrayInt[i]);
		}

		return str.toString();
	}
}