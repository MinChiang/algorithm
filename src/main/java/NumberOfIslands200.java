/**
 * @author MinChiang
 * @version 1.0.0
 * @date 2021-09-27 18:10
 */
public class NumberOfIslands200 {

    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            char[] tmp = grid[i];
            for (int j = 0; j < tmp.length; j++) {
                char c = tmp[j];
                if (c == '0') {
                    continue;
                }
                dfs(grid, i, j);
                result++;
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (grid[x][y] == '0') {
            return;
        }
        // 把当前的各自记录为已经走过
        grid[x][y] = '0';
        // 遍历左边
        if (y - 1 >= 0) {
            dfs(grid, x, y - 1);
        }
        // 遍历右边
        if (y + 1 < grid[0].length) {
            dfs(grid, x, y + 1);
        }
        // 遍历上边
        if (x - 1 >= 0) {
            dfs(grid, x - 1, y);
        }
        // 遍历下边
        if (x + 1 < grid.length) {
            dfs(grid, x + 1, y);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                new char[]{'1', '1', '1'},
                new char[]{'0', '1', '0'},
                new char[]{'1', '1', '1'},
        };
        System.out.println(new NumberOfIslands200().numIslands(grid));
    }

}
