package week.wk7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L5203_统计可以提取的工件 {

    public static void main(String[] args) {
        int[][] artifacts = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 1, 1}
        };
        int[][] dig = {
                {0, 0},
                {0,1},
                {1,1}
        };


        L5203_统计可以提取的工件 a = new L5203_统计可以提取的工件();
        System.out.println(a.digArtifacts(2,artifacts,dig));
    }

    public int digArtifacts2(int n, int[][] artifacts, int[][] dig) {
        int res = 0;
        boolean[] f = new boolean[n * n];
        //降维
        for (int[] d : dig) {
            int idx = n * d[0] + d[1];
            f[idx] = true;
        }
        for (int[] artifact : artifacts) {
            boolean flag = true;
            for (int i = artifact[0]; i <= artifact[2] && flag; i++) {
                for (int j = artifact[1]; j <= artifact[3] && flag; j++) {
                    int idx = i * n + j;
                    flag = f[idx];
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }






        public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int res = 0;
        //根据2点计算所有下表
        for (int[] artifact : artifacts) {
            int x1 = artifact[0];
            int y1 = artifact[1];
            int x2 = artifact[2];
            int y2 = artifact[3];
            List<Pair> pairList = new ArrayList<>();
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    pairList.add(new Pair(i,j));
                }
            }
            if (isCover(pairList, dig)) {
                res++;
            }
        }
        return res;
    }

    public boolean isCover( List<Pair> pairList, int[][] dig) {
        int len = pairList.size();
        Set<Pair> set = new HashSet<>(pairList);
        List<Pair> list = new ArrayList<>();
        for (int[] nums : dig) {
            list.add(new Pair(nums[0],nums[1]));
        }
        for (Pair pair : list) {
            if (set.contains(pair)) {
                len--;
            }
        }

        return len == 0;
    }

    class Pair {
        Integer x;
        Integer y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Pair  pair = (Pair) obj;
            return (this.x == pair.x) && (this.y == pair.y);
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + (x.hashCode());
            result = 31 * result + (y.hashCode());
            return result;
        }
    }
}
