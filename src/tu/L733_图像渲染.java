package tu;

import java.util.Arrays;

public class L733_图像渲染 {
    public static void main(String[] args) {
        L733_图像渲染 a = new L733_图像渲染();
        int[][] img = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        System.out.println(Arrays.deepToString(a.floodFill(img, 1, 1, 2)));
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }


    public void checkAndSet(int x, int y, int[][] image, int oc, int nc) {
        // 检查没有越界,并且是和旧颜色一样的颜色,并且新旧不一样,一样就不用改了
        if (x >= 0 && y >= 0 && x < image.length && y < image[0].length && image[x][y] == oc && oc != nc) {
            image[x][y] = nc;
            checkAndSet(x, y + 1, image, oc, nc);
            checkAndSet(x, y - 1, image, oc, nc);
            checkAndSet(x + 1, y, image, oc, nc);
            checkAndSet(x - 1, y, image, oc, nc);
        }

    }


    public void dfs(int[][] image, int i, int j,int oldColor, int newColor) {
        int m = image.length;
        int n = image[0].length;


        if (i + 1 < m && image[i+1][j] == oldColor) {
            image[i + 1][j] = newColor;
            dfs(image, i+1, j, oldColor, newColor);
        }
        if (i - 1 >=0 && image[i-1][j] == oldColor) {
            image[i - 1][j] = newColor;
            dfs(image, i-1, j, oldColor, newColor);

        }
        if (j + 1 < n && image[i][j + 1] == oldColor) {
            image[i][j + 1] = newColor;
            dfs(image, i, j+1, oldColor, newColor);
        }
        if (j - 1 >= 0 && image[i][j - 1] == oldColor) {
            image[i][j - 1] = newColor;
            dfs(image, i, j-1, oldColor, newColor);
        }

    }

}
