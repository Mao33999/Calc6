package Test_Work;

import java.util.HashMap;
import java.util.Scanner;

public class Roman_Numerals {
    public static void main(String[] args) {
        Roman_Numerals roman = new Roman_Numerals();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: ");
        String string = scanner.nextLine();
        System.out.println("Result is : " + roman.RomanToInt2(string));

    }
    public static int RomanToInt2 (String s){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int end = s.length()-1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = map.get(arr[end]);
        for (int i = end-1; i>=0; i--){
                arabian = map.get(arr[i]);

                if(arabian < map.get(arr[i+1])){
                    result -= arabian;
                } else {
                    result += arabian;
                }
        }
        return result;
    }
}
