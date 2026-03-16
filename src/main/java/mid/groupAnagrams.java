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
            for (char s : str.toCharArray()) ch[s - 'a']++;
            String keyStr = String.valueOf(ch);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        System.out.println(groupAnagrams(split));
    }
}
