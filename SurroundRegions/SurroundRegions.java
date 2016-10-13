package SurroundRegions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二位字符串数组下标
 */
class Tuple {
    private int x;
    private int y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tuple add(Tuple t) {
        int new_x = this.x + t.getX();
        int new_y = this.y +t.getY();
        return new Tuple(new_x, new_y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class SurroundRegions {
    private int row_num = 0;
    private int col_num = 0;

    private ArrayList<Tuple> dirs = new ArrayList();

    public SurroundRegions() {
        super();
        dirs.add(new Tuple(1,0));
        dirs.add(new Tuple(-1,0));
        dirs.add(new Tuple(0,-1));
        dirs.add(new Tuple(0,1));
    }

    public void dealMatrix(String[][] matrix) throws Exception {
        row_num = matrix.length;
        col_num = matrix[0].length;

        int[][] flag = new int[row_num][col_num];

        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < col_num; j++) {
                flag[i][j] = 0;
            }
        }

        for (int i = 0; i < row_num; i++) {
            for (int j = 0; j < col_num; j++) {
                if (matrix[i][j].equals("O") && flag[i][j] == 0) {
                    traverseAndChange(matrix, flag, i, j);
                }
            }
        }

    }

    private void traverseAndChange(String[][] matrix, int[][] flag, int x, int y) throws Exception {
        Queue<Tuple> que = new LinkedList();
        Tuple cur_tuple = new Tuple(x, y);
        que.add(cur_tuple);
        flag[x][y] = 1;
        boolean isSur = true;
        while (!que.isEmpty()) {
            Tuple first = que.remove();
            for (Tuple tp : dirs) {

                Tuple new_tp = first.add(tp);

                if (new_tp.getX() == -1 || new_tp.getY() == -1
                        || new_tp.getX() == col_num || new_tp.getY() == row_num) {
                    isSur = false;
                    continue;
                }

                if (flag[new_tp.getX()][new_tp.getY()] == 0
                        && matrix[new_tp.getX()][new_tp.getY()].equals("O")) {
                    que.add(new_tp);
                    flag[new_tp.getX()][new_tp.getY()] = 1;
                }
            }
        }

        if (!isSur) {
            return;
        }
        que.clear();
        que.add(cur_tuple);
        flag[cur_tuple.getX()][cur_tuple.getY()] = 2;
        while (!que.isEmpty()) {
            Tuple first = que.remove();

            matrix[first.getX()][first.getY()] = "X";

            for (Tuple tp : dirs) {
                Tuple new_tp = first.add(tp);

                if (new_tp.getX() == -1 || new_tp.getY() == -1
                        || new_tp.getX() == col_num || new_tp.getY() == row_num) {
                    ;
                } else {
                    if (matrix[new_tp.getX()][new_tp.getY()].equals("O") && flag[new_tp.getX()][new_tp.getY()] == 1) {
                        que.add(new_tp);
                        flag[new_tp.getX()][new_tp.getY()] = 2;
                     }
                }
            }

        }
    }

    public void printBorder(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        String[][] matrix1 = {
                {"X","O","X","X","X"},
                {"O","X","O","O","X"},
                {"X","O","O","X","X"},
                {"X","O","O","X","X"},
                {"X","X","X","O","O"},
        };
        String[][] matrix2 = {
                {"X","X","X","X","X"},
                {"X","X","X","X","X"},
                {"X","X","X","X","X"},
                {"X","X","X","X","X"},
                {"X","X","X","X","X"},
        };
        String[][] matrix3 = {
                {"O","O","O","O","O"},
                {"O","O","O","O","O"},
                {"O","O","O","O","O"},
                {"O","O","O","O","O"},
                {"O","O","O","O","O"},
        };
        SurroundRegions sr = new SurroundRegions();
        System.out.println("Input");
        sr.printBorder(matrix1);
        sr.dealMatrix(matrix1);
        System.out.println("Output");
        sr.printBorder(matrix1);
    }
}