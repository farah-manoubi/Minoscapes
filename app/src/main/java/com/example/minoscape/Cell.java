package com.example.minoscape;

public class Cell{
    boolean
            topWall=true,
            leftWall=true,
            bottomWall=true,
            rightWall=true,
            visited = false;

    int col, row;
    public Cell(int col, int row){
        this.col=col;
        this.row=row;
    }
}