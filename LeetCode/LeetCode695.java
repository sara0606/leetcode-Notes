package com.huibur.ass.hwserver.ayuan;

import java.util.Stack;

/**
 * @date 2020/5/28 16:12
 */
public class LeetCode695 {

    public static int maxAreaOfIsland(int[][] g) {

        //边界
        if (g == null || g.length == 0) return 0;
        //结果
        int ret = 0;
        //遍历
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == 0) continue;
                //等于1，算入面积
                ret = Math.max(ret, getArea(g, i, j));
            }
        }
        return ret;
    }

    public static int getArea(int[][] g, int i, int j) {
        //边界
        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length || g[i][j] == 0) return 0;
        //符合计算面积的，计入数量，并还原成0，防止下次被重复计算
        g[i][j] = 0;
        //当前1 +上+下+左+右
        return 1 + getArea(g, i - 1, j) + getArea(g, i + 1, j) + getArea(g, i, j - 1) + getArea(g, i, j + 1);
    }


    public static void main(String[] args) {
        int[][] a = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        int ret = maxAreaOfIsland_tuantuan(a);
        System.out.println(ret);

    }

    public static int maxAreaOfIsland_tuantuan(int[][] G) {

        if (G == null || G.length == 0) return 0;

        int ans = 0;

        for (int r = 0; r < G.length; r++) {

            for (int c = 0; c < G[0].length; c++) {

                if (G[r][c] == 0) continue;

                ans = Math.max(ans, dfs(G, r, c));
            }
        }

        return ans;

    }

    private static int dfs(int[][] G, int r, int c) {

        if (r < 0 || r >= G.length || c < 0 || c >= G[0].length || G[r][c] == 0) return 0;

        G[r][c] = 0;

        return 1 + dfs(G, r - 1, c) + dfs(G, r + 1, c) + dfs(G, r, c - 1) + dfs(G, r, c + 1);
    }
}


