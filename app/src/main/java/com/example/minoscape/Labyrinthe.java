package com.example.minoscape;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import static android.content.Context.SENSOR_SERVICE;
import static androidx.constraintlayout.motion.utils.Oscillator.TAG;
import static androidx.core.content.ContextCompat.getSystemService;

public class Labyrinthe extends View implements SensorEventListener{
    private Cell[][] cells;
    private Cell player, exit, minos, coins1, coins2, coins3, coins4, coins5; //Ajout
    private static final int COLS=14, ROWS=9;
    private static final float WALL_THICKNESS=4;
    private float cellSize, hMargin, vMargin;
    private Paint wallPaint, playerPaint, exitPaint; //Ajout des 2 dernier
    private Random random;

    private Bitmap hiro, minotaur, heart;

    private Bitmap coin1, coin2, coin3, coin4, coin5;
    public static boolean Bcoin1 = true, Bcoin2 = true, Bcoin3 = true, Bcoin4 = true, Bcoin5 = true, BMinos=true;



    private HashMap<Float, Float> lastValues = new HashMap<Float, Float>();
    private float lastX, lastY, deltaX, deltaY;
    private ArrayList<Long> al = new ArrayList<Long>();
    public static int ABSCURRENT, ORDCURRENT, ABSNEXT, ORDNEXT;
    public static int piece = 0;
    public static int vie = 3;
    public boolean stop = false;
    int currentX, currentY;



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
        heart = BitmapFactory.decodeResource(getResources(), R.drawable.heart);

        random = new Random();


        creatMaze();
    }

    public Labyrinthe (Context context, Bitmap hiro){
        super(context);
        hiro = BitmapFactory.decodeResource(getResources(), R.drawable.hiro);

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
       ABSCURRENT = player.getCol();
       ORDCURRENT = player.getRow();
       ABSNEXT = player.getCol();
       ORDNEXT = player.getRow();
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
        super.onDraw(canvas);
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

        int diffabs = ABSCURRENT - ABSNEXT;
        int difford = ORDCURRENT - ORDNEXT;

        if(diffabs != 0) {
            if(diffabs < 0) {
                if(!cells[ABSCURRENT][ORDCURRENT].rightWall) {
                    ABSCURRENT = ABSNEXT;
                }
                else {
                    ABSNEXT= ABSCURRENT;
                }
            }
            else if(diffabs > 0) {
                if(!cells[ABSCURRENT][ORDCURRENT].leftWall) {
                    ABSCURRENT = ABSNEXT;
                }
                else {
                    ABSNEXT= ABSCURRENT;
                }
            }
        }
        if(difford != 0) {
            if(difford < 0) {
                if(!cells[ABSCURRENT][ORDCURRENT].bottomWall) {
                    ORDCURRENT = ORDNEXT;
                }
                else {
                    ORDNEXT = ORDCURRENT;
                }
            }
            else if(difford>0) {
                if(!cells[ABSCURRENT][ORDCURRENT].topWall) {
                    ORDCURRENT = ORDNEXT;
                }
                else {
                    ORDNEXT = ORDCURRENT;
                }
            }

        }



        hiro = getResizedBitmap(hiro, (int)((player.col+1)*cellSize-(margin*2)), (int)((player.row+1)*cellSize-(margin)));
        canvas.drawBitmap(hiro, ABSCURRENT*cellSize+margin, ORDCURRENT*cellSize+margin, null);

        minotaur = getResizedBitmap(minotaur, (int)((player.col+1)*cellSize-margin), (int)((player.row+1)*cellSize-margin));
        canvas.drawBitmap(minotaur,minos.col*cellSize+margin, minos.row*cellSize+margin, null);
        //Ici "minos" est une cellule ou il y a le minotaure

        if(ABSCURRENT == coins1.col && ORDCURRENT == coins1.row && Bcoin1) {
            Bcoin1 = false;
            piece+=1;
        }
        if(ABSCURRENT == coins2.col && ORDCURRENT == coins2.row && Bcoin2) {
            Bcoin2 = false;
            piece+=1;
        }
        if(ABSCURRENT == coins3.col && ORDCURRENT == coins3.row && Bcoin3) {
            Bcoin3 = false;
            piece+=1;
        }
        if(ABSCURRENT == coins4.col && ORDCURRENT == coins4.row && Bcoin4) {
            Bcoin4 = false;
            piece+=1;
        }
        if(ABSCURRENT == coins5.col && ORDCURRENT == coins5.row && Bcoin5) {
            Bcoin5 = false;
            piece+=1;
        }
        if(ABSCURRENT == minos.col && ORDCURRENT == minos.row && BMinos) {

            if(vie > 0) {
                BMinos = false;
                vie -= 1;
            }
        }
        else if(ABSCURRENT != minos.col || ORDCURRENT != minos.row && vie<3) {
            BMinos = true;
        }


        if(Bcoin1) {
            coin1 = getResizedBitmap(coin1, (int)((player.col+1)*cellSize-margin), (int)((player.row+1)*cellSize-margin));
            canvas.drawBitmap(coin1,coins1.col*cellSize+margin, coins1.row*cellSize+margin, null);
        }
        if(Bcoin2) {
            coin2 = getResizedBitmap(coin2, (int)((player.col+1)*cellSize-margin), (int)((player.row+1)*cellSize-margin));
            canvas.drawBitmap(coin2,coins2.col*cellSize+margin, coins2.row*cellSize+margin, null);
        }
        if(Bcoin3) {
            coin3 = getResizedBitmap(coin3, (int)((player.col+1)*cellSize-margin), (int)((player.row+1)*cellSize-margin));
            canvas.drawBitmap(coin3,coins3.col*cellSize+margin, coins3.row*cellSize+margin, null);
        }
        if(Bcoin4) {
            coin4 = getResizedBitmap(coin4, (int)((player.col+1)*cellSize-margin), (int)((player.row+1)*cellSize-margin));
            canvas.drawBitmap(coin4,coins4.col*cellSize+margin, coins4.row*cellSize+margin, null);
        }
        if(Bcoin5) {
            coin5 = getResizedBitmap(coin5, (int)((player.col+1)*cellSize-margin), (int)((player.row+1)*cellSize-margin));
            canvas.drawBitmap(coin5,coins5.col*cellSize+margin, coins5.row*cellSize+margin, null);
        }


        Paint paint = new Paint();

        paint.setColor(Color.BLACK);
        paint.setTextSize(35);
        canvas.drawBitmap(coin1,510, 615, null);
        canvas.drawText(" : " + nbPiece(), 550, 650, paint);

        heart = getResizedBitmap(heart, (int)((player.col+1)*cellSize-margin), (int)((player.row+1)*cellSize-margin));
        canvas.drawBitmap(heart,80, 615, null);
        canvas.drawText(" : " + nbVie(), 120, 650, paint);

        canvas.drawText(EThread.minute + "min  " + EThread.seconde + "sec", 275, 650, paint);


        //System.out.println("Player[" + player.getCol() + "][" + player.getRow() + "]");
        //canvas.drawRect(player.col*cellSize+margin, player.row*cellSize+margin, (player.col+1)*cellSize-margin, (player.row+1)*cellSize-margin, playerPaint); //AJOUT

        //canvas.drawRect(exit.col*cellSize+margin, exit.row*cellSize+margin, (exit.col+1)*cellSize-margin, (exit.row+1)*cellSize-margin, exitPaint); //AJOUT

        invalidate();
    }

    public int nbPiece() {
        return piece;
    }
    public int nbVie() { return vie;}



   private void moveImage(float deltaX, float deltaY, float x, float y, float lastX, float lastY) {
       int abs = ABSCURRENT;
       int ord = ORDCURRENT;
       if(deltaX != 0) {
           if(lastX - x < 0 && abs != COLS-1) { //droite
               //player = cells[abs+1][ord];
               ABSNEXT += 1;
           }
           if(lastX - x > 0 && abs != 0) { //Gauche
               //player = cells[abs-1][ord];
               ABSNEXT -= 1;
           }
       }
       else if(deltaY != 0) {
           if(lastY - y < 0 && ord != 0) { //Haut
               //player = cells[abs][ord+1];
               ORDNEXT -= 1;
           }
           if(lastY - y > 0 && ord != ROWS-1) { //Bas
               //player = cells[abs][ord-1];
               ORDNEXT += 1;
           }
       }

   }



   @RequiresApi(api = Build.VERSION_CODES.N)
   @Override
   public void onSensorChanged(SensorEvent event) {

       if(al.isEmpty()) {
           al.add((long) 0);
       }
       else {
           long curTime = System.currentTimeMillis();
           long lastUpdate = al.get(0);
           if ((curTime - lastUpdate) > 500) {
               long diffTime = (curTime - lastUpdate);
               lastUpdate = curTime;
               al.remove(0);
               al.add(lastUpdate);
               float x = event.values[0];
               float y = event.values[1];
               Boolean bool = false;
               if (!lastValues.isEmpty()) {
                   for (Map.Entry mapentry : lastValues.entrySet()) {
                       lastX = (float) mapentry.getKey();
                       lastY = (float) mapentry.getValue();
                   }
                   lastValues.remove(lastX, lastY);

                  // lastValues.put(x, y);
                    lastValues.put(0f,0f);
                   deltaX = Math.abs(lastX - x);
                   deltaY = Math.abs(lastY - y);

                   if (deltaX < 1) {
                       deltaX = 0;
                   }
                   if (deltaY < 1) {
                       deltaY = 0;
                   }
                  // System.out.println("Les valeurs sont x =" + x + "    y =" + y);
                   //System.out.println("LastX = " + lastX + "      LastY = " + lastY);
                   //System.out.println("DeltaX = " + deltaX + "      DeltaY =" + deltaY);

                   try {
                     //  System.out.println("Player[" + ABSCURRENT + "][" + ORDCURRENT + "]");
                   } catch (NullPointerException e) {
                       //System.out.println("Le player n'existe pas");
                   }

                   //System.out.println(" ");
                   this.moveImage(deltaX,deltaY, x, y, lastX, lastY);
                   //System.out.println("PlayerNEXT["+ ABSNEXT + "][" + ORDNEXT + "]");

                   invalidate();

               } else {
                   lastValues.put(x, y);
                   System.out.println("Les valeurs sont x =" + x + "    y =" + y);
               }
           }

       }
   }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}