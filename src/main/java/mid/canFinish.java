package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class canFinish {
    private static boolean dfs(int x, List<Integer>[] g, int[] colors) {
        colors[x] = 1;
        for (int y : g[x]) {
            if (colors[y] == 1 || colors[y] == 0 && dfs(y, g, colors)) return true;
        }
        colors[x] = 2;
        return false;
    }

    private static boolean canFinish(int numCorses, int[][] prerequisites) {
        List<Integer>[] g = new List[numCorses];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] p : prerequisites) g[p[1]].add(p[0]);
        int[] colors = new int[numCorses];
        for (int i = 0; i < numCorses; i++) {
            if (colors[i] == 0 && dfs(i, g, colors)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCourses = sc.nextInt();
        sc.nextLine();
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] prerequisites = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prerequisites[i][j] = sc.nextInt();
            }
        }
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
