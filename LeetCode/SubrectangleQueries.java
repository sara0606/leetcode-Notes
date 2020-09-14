package com.training.org.controller;

/**
 * 说明:
 *
 * @author kz
 * @date 2020/6/13 23:07
 * <p>
 * <br>UpdateNote:
 * <br>UpdateTime:
 * <br>UpdateUser:
 *
 * 5422. 子矩形查询
 *
 */
public class SubrectangleQueries {

    int[][] m;

    public SubrectangleQueries(int[][] rectangle) {
        this.m = rectangle;

    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {

        for(int r = row1; r <= row2; r++){
            for(int c = col1; c <= col2; c++){
                m[r][c] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return m[row][col];
    }
}
