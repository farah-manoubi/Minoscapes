package com.example.minoscape;

public class Cell{

    /* Cette classe correspond à la création d'une cellule */

    boolean topWall=true, leftWall=true, bottomWall=true, rightWall=true, visited = false;
    int col, row;

    public Cell(int col, int row){
        this.col=col;
        this.row=row;
    }
    public int getCol() {
        return this.col;
    }
    public int getRow() {
        return this.row;
    }
}