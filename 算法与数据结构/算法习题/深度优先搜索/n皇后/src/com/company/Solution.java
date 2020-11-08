package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: n皇后
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-08 11:03
 **/
public class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (n == 0) {
            return result;
        }
        List<Integer> columns = new ArrayList<>();
        search(n, result, columns);
        return result;
    }

    private void search(int n, List<List<String>> result, List<Integer> columns) {
        if (columns.size() == n) {
            result.add(drawChessboard(columns));
        }
        for (int columnIndex = 0; columnIndex < n; columnIndex++) {
            if (!isValid(columnIndex, columns)) {
                continue;
            }
            columns.add(columnIndex);
            search(n, result, columns);
            columns.remove(columns.size() - 1);
        }
    }

    private List<String> drawChessboard(List<Integer> columns) {
        List<String> chessboard = new ArrayList<>();
        for (int row = 0; row < columns.size(); row++) {
            StringBuilder sb = new StringBuilder();
            for (int column = 0; column < columns.size(); column++) {
                sb.append(columns.get(row) == column ? 'Q' : '.');
            }
            chessboard.add(sb.toString());
        }
        return chessboard;
    }

    private boolean isValid(int columnIndex, List<Integer> columns) {
        int row = columns.size();
        for (int rowIndex = 0; rowIndex < columns.size(); rowIndex++) {
            if (columns.get(rowIndex) == columnIndex) {
                return false;
            }
            if (rowIndex - columnIndex == row - columns.get(rowIndex)) {
                return false;
            }
            if (rowIndex + columnIndex == row + columns.get(rowIndex)) {
                return false;
            }
        }
        return true;
    }
}
