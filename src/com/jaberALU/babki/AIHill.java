package com.jaberALU.babki;

import java.util.ArrayList;
import java.util.Random;
import android.util.Log;


public class AIHill {

    private int[][] cell = new int[8][8];


    public void setTer(int[][] celll) {
        cell = celll;
    }


    public int[][] getter() {
        return cell;
    }


    public int eval() {
        int[][] cell = getter();
        int a = 0;
        for (int n = 0; n < 8; n++) {
            for (int m = 0; m < 8; m++) {
                if (cell[n][m] == 1) {
                    int k = check(n, m, cell);
                    a = a + k;
                }
            }
        }

        return a;
    }


    public int check(int row, int col, int[][] cell) {
        int y = 0;
        //satry
        for (int i = col; i < 8; i++) {
            if (cell[row][i] != 0 && col != i) {
                y++;
            }
        }
        //sotoni
        for (int i = row; i < 8; i++) {
            if (cell[i][col] != 0 && row != i) {
                y++;
            }
        }
        int n = 1;
        n = 1;
        for (int i = row; i < 8; i++) {

            if ((row + n) <= 7 && (col - n) >= 0) {
                if (cell[row + n][col - n] != 0) {
                    y++;
                }
            }
            n++;
        }
        n = 1;
        for (int i = row; i < 8; i++) {
            if ((row + n) <= 7 && (col + n) <= 7) {
                if (cell[row + n][col + n] != 0) {
                    y++;
                }
            }
            n++;
        }

        return y;
    }


    public int[][] heu() {
        int[][] cell = getter();
        int[][] temp = new int[8][8];
        int j = 0;
        int m = 0;
        for (int n = 0; n < 8; n++) {

            for (int u = 0; u <= 7; u++) {
                if (cell[n][u] == 1) {
                    j = u;
                    cell[n][u] = 0;
                }
            }

            for (m = 0; m < 8; m++) {

                if (m != j) {
                    cell[n][m] = 1;
                    setTer(cell);
                    temp[n][m] = eval();
                    cell[n][m] = 0;
                }
            }

            cell[n][j] = 1;
        }

        ArrayList<Integer> maxs = new ArrayList<Integer>();
        ArrayList<Integer> maxs2 = new ArrayList<Integer>();
        ArrayList<Integer> max = new ArrayList<Integer>();
        int[] maxx = new int[8];
        int v = 100;
        int c = 0;
        for (int n = 0; n < 8; n++) {
            for (int b = 0; b < 8; b++) {
                if (temp[n][b] <= v && temp[n][b] != 0) {
                    v = temp[n][b];
                }

            }
            for (int b = 0; b < 8; b++) {
                if (temp[n][b] == v && temp[n][b] != 0) {
                    maxs.add(temp[n][b]);
                    max.add(b);
                }
            }
            Random bb = new Random();
            int i1 = bb.nextInt((maxs.size() - 1) - 0 + 1) + 0;
            maxs2.add(maxs.get(i1));
            maxx[n] = max.get(i1);
            maxs.clear();
            max.clear();

            v = 100;
        }

        v = 100;
        ArrayList<Integer> maxs3 = new ArrayList<Integer>();
        for (int n = 0; n < 8; n++) {

            if (maxs2.get(n) <= v) {
                v = maxs2.get(n);
            }
        }

        for (int n = 0; n < 8; n++) {
            if (maxs2.get(n) == v) {
                maxs3.add(n);
                maxs.add(maxx[n]);
            }
        }

        Random r = new Random();
        int i1 = r.nextInt((maxs3.size() - 1) - 0 + 1) + 0;
        Log.i("h", maxs.get(i1) + "-------------" + maxs3.get(i1));
        for (int n = 0; n < 8; n++) {
            cell[maxs3.get(i1)][n] = 0;
        }

        cell[maxs3.get(i1)][maxs.get(i1)] = 1;
        return cell;

    }

}
