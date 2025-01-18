package Test_Work;

import java.util.Scanner;

public class Calcuator {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your equation: ");
        String s = scanner.nextLine();
        String expression = s.replaceAll(" ", "");
        System.out.println(parse(expression));
    }
    public static String parse(String expression) throws Exception {
        int num1;
        int num2;
        String oper;
        String result;
        boolean isRoman;
        String[] operands = expression.split("[+\\-*/]");
        if (operands.length !=2) throw new Exception("Supposed to be two operands");
        oper = detectOperation(expression);
        if(Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
            num1 = Roman.convertToArabian(operands[0]);
            num2 = Roman.convertToArabian(operands[1]);
            isRoman = true;
        }
        else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }
        else {
            throw new Exception("Numbers should be in a same format");
        }
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Numbers should be 1 to 10");
        }
        int arabian = calc(num1, num2, oper);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Roman numeral should be higher than 0");
            }
            result = Roman.convertToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }
    class Roman {
        static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
                "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI",
                "XXVII", "XXVIII", "XXX", "XXXII", "XXXV", "XXXVI", "XL", "XLII", "XLV", "XLVIII", "XLIX", "L", "LIV", "LVI", "LX", "LXIII",
                "LXXII", "LXXX", "LXXXI", "XC", "C"};

        public static boolean isRoman(String str) {
            for (int i = 0; i < romanArray.length; i++) {
                if (str.equals(romanArray[i])) {
                    return true;
                }
            }
            return false;
        }
        public static int convertToArabian(String roman) {
            for (int i = 0; i < romanArray.length; i++) {
                if (roman.equals(romanArray[i])) {
                    return i;
                }
            }
            return -1;
        }
public static String convertToRoman(int arabian) {
            return romanArray[arabian];
}
    }

    static String detectOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }
    static int calc(int a, int b, String oper) {
        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;
    }

}
