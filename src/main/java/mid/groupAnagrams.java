package mid;

import java.util.*;

/**
 * 字母异位词分组
 */
public class groupAnagrams {
    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = new char[26];
            for (char c : str.toCharArray()) ch[c - 'a']++;
            String keyStr = String.valueOf(ch);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[n];
        String[] inputStrs = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            strs[i] = inputStrs[i];
        }
        System.out.println(groupAnagrams(strs));
    }
}
