package com.example.memorygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class newGame extends AppCompatActivity {

    Handler handler = new Handler();
    int total = 0;
    int [] randomImg = new int[12];
    String [] idImg = {"img1","img2","img3","img4","img5","img6","img7","img8","img9","img10",
    "img11","img12"};

    int [] imges = {R.drawable.banana,R.drawable.candy,R.drawable.cocktail,R.drawable.fire,
            R.drawable.hamburger,R.drawable.watermelon,R.drawable.banana,R.drawable.candy,
            R.drawable.cocktail,R.drawable.fire,
            R.drawable.hamburger,R.drawable.watermelon};


    // Fill array in random img.
    public static int [] randomImges(int [] arr){
        Random rnd = new Random();
        int xImg ,temp, k =0;
        int [] res = new int[12];

        for(int i = arr.length-1; i >= 0; i--){
            if (i ==0){
                res[k++] = arr[i];
            }
            else {
                xImg = rnd.nextInt(i);
                temp = arr[xImg];
                arr[xImg] = arr[i];
                arr[i] = temp;

                res[k++] = arr[i];
            }

        }

        return  res;
    }

    // Return index of img id.
    public static int indexOfImg(String [] s, String str){

        int index = -1;

        for (int i = 0; i < s.length && index == -1; i++)
             index = (s[i].equals(str))?i:index;


        return  index;
    }

    public String viewToIdString(View view){
        String res = getResources().getResourceEntryName(view.getId());
        return res;
    }

     View img1,img2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);


        randomImg = randomImges(imges);

    }

    public void img_1(View view) {
        if (total == 2)
            total=0;

        int res;
        String viewId = (getResources().getResourceEntryName(view.getId()));

       res = indexOfImg(idImg,viewId);

       ((ImageView)view).setImageResource(randomImg[res]);

       if (total == 0){
           img1 = view;
           img1.setEnabled(false);       }
       else if (total == 1 && viewToIdString(img1).equals(viewId) != true){


           img2 = view;
           if (randomImg[indexOfImg(idImg, viewToIdString(img1))]  == randomImg[res]){
               img1.setEnabled(false);
               img2.setEnabled(false);
           }
           else {
               getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                       WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
               handler.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       ((ImageView)img1).setImageResource(R.drawable.question);
                       ((ImageView)img2).setImageResource(R.drawable.question);

                       getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                   }
               },1000);
               img1.setEnabled(true);

           }

       }
       total++;

    }

}