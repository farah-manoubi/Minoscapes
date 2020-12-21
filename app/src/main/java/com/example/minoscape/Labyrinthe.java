package com.example.minoscape;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class Labyrinthe extends View{
    private Cell[][] cells;
    private Cell player, exit, minos, coins1, coins2, coins3, coins4, coins5; //Ajout
    private static final int COLS=14, ROWS=9;
    private static final float WALL_THICKNESS=4;
    private float cellSize, hMargin, vMargin;
    private Paint wallPaint, playerPaint, exitPaint; //Ajout des 2 dernier
    private Random random;

    private Bitmap hiro;

    private Bitmap minotaur;

    private Bitmap coin1;
    private Bitmap coin2;
    private Bitmap coin3;
    private Bitmap coin4;

    private Bitmap coin5;



    public Labyrinthe (Context context, AttributeSet attrs){
        super(context, attrs);

        wallPaint= new Paint();
        wallPaint.setColor(Color.BLACK);
        wallPaint.setStrokeWidth(WALL_THICKNESS);

        hiro = BitmapFactory.decodeResource(getResources(), R.drawable.hiro);
        minotaur = BitmapFactory.decodeResource(getResources(), R.drawable.minotaur);
        coin1 = BitmapFactory.decodeResource(getResources(), R.drawable.coin);
        coin2 = BitmapFactory.decodeResource(getResources(), R.drawable.coin);
        coin3 = BitmapFactory.decodeResource(getResources(), R.drawable.coin);
        coin4 = BitmapFactory.decodeResource(getResources(), R.drawable.coin);
        coin5 = BitmapFactory.decodeResource(getResources(), R.drawable.coin);

        random = new Random();

        creatMaze();
    }

    private Cell getNeighbour(Cell cell) {
        ArrayList<Cell> neighbours = new ArrayList<>();

        //left neighbour
        if(cell.col > 0) {
            if(!cells[cell.col-1][cell.row].visited) {
                neighbours.add(cells[cell.col-1][cell.row]);
            }
        }

        //right neighbour
        if(cell.col < COLS-1) {
            if(!cells[cell.col+1][cell.row].visited) {
                neighbours.add(cells[cell.col+1][cell.row]);
            }
        }

        //top neighbour
        if(cell.row>0) {
            if(!cells[cell.col][cell.row-1].visited) {
                neighbours.add(cells[cell.col][cell.row-1]);
            }
        }

        //bottom neighbour
        if(cell.row < ROWS-1) {
            if(!cells[cell.col][cell.row+1].visited) {
                neighbours.add(cells[cell.col][cell.row+1]);
            }
        }

        if(neighbours.size() > 0) {
            int index = random.nextInt(neighbours.size());
            return neighbours.get(index);
        }

        return null;
    }

    private void removeWall(Cell current, Cell next) {
        if(current.col == next.col && current.row == next.row+1) {
            current.topWall = false;
            next.bottomWall = false;
        }

        if(current.col == next.col && current.row == next.row-1) {
            current.bottomWall = false;
            next.topWall = false;
        }

        if(current.col == next.col+1 && current.row == next.row) {
            current.leftWall = false;
            next.rightWall = false;
        }

        if(current.col == next.col-1 && current.row == next.row) {
            current.rightWall = false;
            next.leftWall = false;
        }
    }

    private void creatMaze(){

        Stack<Cell> stack = new Stack<>();
        Cell current, next;

        cells=new Cell[COLS][ROWS];

        for(int x=0; x<COLS; x++){
            for(int y=0; y<ROWS; y++){
                cells[x][y]=new Cell(x,y);
            }
        }

        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        Boolean bool = false;

        player = cells[0][0]; //AJOUT
        hm.put(0,0);
        exit = cells[COLS-1][ROWS-1]; //AJOUT
        Random rdm1 = new Random();
        int x = rdm1.nextInt(COLS-1);
        int y = rdm1.nextInt(ROWS-1);

        while(bool==false) {
            if(hm.containsKey(x)) {
                if(hm.get(x)==y) {
                    x = rdm1.nextInt(COLS-1);
                    y = rdm1.nextInt(ROWS-1);
                }
                else {
                    bool = true;
                    minos = cells[x][y];
                    hm.put(x,y);
                }
            }
            else {
                bool = true;
                minos = cells[x][y];
                hm.put(x,y);
            }
        }
        bool = false;
        while(bool==false) {
            if(hm.containsKey(x)) {
                if(hm.get(x)==y) {
                    x = rdm1.nextInt(COLS-1);
                    y = rdm1.nextInt(ROWS-1);
                }
                else {
                    bool = true;
                    coins1 = cells[x][y];
                    hm.put(x,y);
                }
            }
            else {
                bool = true;
                coins1 = cells[x][y];
                hm.put(x,y);
            }
        }
        bool = false;
        while(bool==false) {
            if(hm.containsKey(x)) {
                if(hm.get(x)==y) {
                    x = rdm1.nextInt(COLS-1);
                    y = rdm1.nextInt(ROWS-1);
                }
                else {
                    bool = true;
                    coins2 = cells[x][y];
                    hm.put(x,y);
                }
            }
            else {
                bool = true;
                coins2 = cells[x][y];
                hm.put(x,y);
            }
        }
        bool = false;
        while(bool==false) {
            if(hm.containsKey(x)) {
                if(hm.get(x)==y) {
                    x = rdm1.nextInt(COLS-1);
                    y = rdm1.nextInt(ROWS-1);
                }
                else {
                    bool = true;
                    coins3 = cells[x][y];
                    hm.put(x,y);
                }
            }
            else {
                bool = true;
                coins3 = cells[x][y];
                hm.put(x,y);
            }
        }
        bool = false;
        while(bool==false) {
            if(hm.containsKey(x)) {
                if(hm.get(x)==y) {
                    x = rdm1.nextInt(COLS-1);
                    y = rdm1.nextInt(ROWS-1);
                }
                else {
                    bool = true;
                    coins4 = cells[x][y];
                    hm.put(x,y);
                }
            }
            else {
                bool = true;
                coins4 = cells[x][y];
                hm.put(x,y);
            }
        }
        bool = false;
        while(bool==false) {
            if(hm.containsKey(x)) {
                if(hm.get(x)==y) {
                    x = rdm1.nextInt(COLS-1);
                    y = rdm1.nextInt(ROWS-1);
                }
                else {
                    bool = true;
                    coins5 = cells[x][y];
                    hm.put(x,y);
                }
            }
            else {
                bool = true;
                coins5 = cells[x][y];
                hm.put(x,y);
            }
        }

        /*coins1 = cells[rdm1.nextInt(COLS-1)][rdm1.nextInt(ROWS-1)];
        coins2 = cells[rdm1.nextInt(COLS-1)][rdm1.nextInt(ROWS-1)];
        coins3 = cells[rdm1.nextInt(COLS-1)][rdm1.nextInt(ROWS-1)];
        coins4 = cells[rdm1.nextInt(COLS-1)][rdm1.nextInt(ROWS-1)];
        coins5 = cells[rdm1.nextInt(COLS-1)][rdm1.nextInt(ROWS-1)];*/



        current = cells[0][0];
        current.visited = true;

        do {
            next = getNeighbour(current);

            if(next != null) {
                removeWall(current, next);
                stack.push(current);
                current = next;
                current.visited = true;
            }

            else {
                current = stack.pop();
            }
        } while(!stack.empty());
    }

    public Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
    }

    protected void onDraw(Canvas canvas){
        canvas.drawColor(Color.GRAY);
        int width=getWidth();
        int height=getHeight();

        if(width/height<COLS/ROWS){
            cellSize=width/(COLS+1);
        }
        else{
            cellSize=height/(ROWS+1);
        }

        hMargin=(width-COLS*cellSize)/2;
        vMargin=(height-ROWS*cellSize)/2;

        canvas.translate(hMargin, vMargin);

        for(int x=0; x<COLS; x++){
            for(int y=0; y<ROWS; y++){
                if(cells[x][y].topWall){
                    canvas.drawLine(x*cellSize, y*cellSize,(x+1)*cellSize,y*cellSize, wallPaint);
                }
                if(cells[x][y].leftWall){
                    canvas.drawLine(x*cellSize, y*cellSize,x*cellSize,(y+1)*cellSize, wallPaint);
                }
                if(cells[x][y].bottomWall){
                    canvas.drawLine(x*cellSize,(y+1)*cellSize,(x+1)*cellSize,(y+1)*cellSize, wallPaint);
                }
                if(cells[x][y].rightWall){
                    canvas.drawLine((x+1)*cellSize, y*cellSize,(x+1)*cellSize,(y+1)*cellSize, wallPaint);
                }
            }
        }

        float margin = cellSize/10;

        hiro = getResizedBitmap(hiro, (int)((player.col+1)*cellSize-(margin*2)), (int)((player.row+1)*cellSize-(margin)));
        canvas.drawBitmap(hiro, player.col*cellSize+margin, player.row*cellSize+margin, null);

        minotaur = getResizedBitmap(minotaur, (int)((player.col+1)*cellSize-margin), (int)((player.row+1)*cellSize-margin));
        canvas.drawBitmap(minotaur,minos.col*cellSize+margin, minos.row*cellSize+margin, null);
        //Ici "minos" est une cellule ou il y a le minotaure

        coin1 = getResizedBitmap(coin1, (int)((player.col+1)*cellSize-margin), (int)((player.row+1)*cellSize-margin));
        coin2 = getResizedBitmap(coin2, (int)((player.col+1)*cellSize-margin), (int)((player.row+1)*cellSize-margin));
        coin3 = getResizedBitmap(coin3, (int)((player.col+1)*cellSize-margin), (int)((player.row+1)*cellSize-margin));
        coin4 = getResizedBitmap(coin4, (int)((player.col+1)*cellSize-margin), (int)((player.row+1)*cellSize-margin));
        coin5 = getResizedBitmap(coin5, (int)((player.col+1)*cellSize-margin), (int)((player.row+1)*cellSize-margin));

        canvas.drawBitmap(coin1,coins1.col*cellSize+margin, coins1.row*cellSize+margin, null);
        canvas.drawBitmap(coin2,coins2.col*cellSize+margin, coins2.row*cellSize+margin, null);
        canvas.drawBitmap(coin3,coins3.col*cellSize+margin, coins3.row*cellSize+margin, null);
        canvas.drawBitmap(coin4,coins4.col*cellSize+margin, coins4.row*cellSize+margin, null);
        canvas.drawBitmap(coin5,coins5.col*cellSize+margin, coins5.row*cellSize+margin, null);


        //canvas.drawRect(player.col*cellSize+margin, player.row*cellSize+margin, (player.col+1)*cellSize-margin, (player.row+1)*cellSize-margin, playerPaint); //AJOUT

        //canvas.drawRect(exit.col*cellSize+margin, exit.row*cellSize+margin, (exit.col+1)*cellSize-margin, (exit.row+1)*cellSize-margin, exitPaint); //AJOUT
    }
}