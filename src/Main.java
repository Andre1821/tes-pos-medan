import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Soal Nomor 1");
        String input1 = "We Always Mekar";
        System.out.println("Input: \"" + input1 + "\"");
        System.out.println("Expected Output: \"" + noOne(input1) + "\"");

        String input2 = "coding is fun”";
        System.out.println("Input: \"" + input2 + "\"");
        System.out.println("Expected Output: \"" + noOne(input2) + "\"");

        System.out.println("\nSoal Nomor 2");
        String[] arr1 = {"Abc", "bCd"};
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Expected Output: " + noTwo(arr1));

        String[] arr2 = {"Oke", "One"};
        System.out.println("\nInput: " + Arrays.toString(arr2));
        System.out.println("Expected Output: " + noTwo(arr2));
    }

    public static String noOne(String input){
        input = input.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : input.toCharArray()){
            if (Character.isLetter(c)){
                map.put(c, map.getOrDefault(c,0) + 1);
            }
        }

        StringBuilder res = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            res.append(entry.getKey()).append("=").append(entry.getValue()).append(", ");
        }

        if (res.length() > 0){
            res.delete(res.length() - 2, res.length());
        }

        return res.toString();
    }

    public static String noTwo(String[] input){
        Map<Character, Integer> map = new HashMap<>();

        for (String word : input) {
            for (char c : word.toCharArray()){
                if (Character.isLetter(c)){
                    map.put(c, map.getOrDefault(c,0) + 1);
                }
            }
        }

        String sort = map.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().equals(e1.getValue()) ? Character.compare(e1.getKey(), e2.getKey()) : e2.getValue() - e1.getValue())
                .map(entry -> entry.getKey().toString())
                .collect(Collectors.joining(""));
        return sort;
    }
}