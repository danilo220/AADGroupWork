package com.aadgroup.aadgroupwork;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.*;

public class DotCancellation extends AppCompatActivity implements View.OnClickListener
{
    ArrayList<ArrayList<Tile>> allTiles = new ArrayList<ArrayList<Tile>>();
    ArrayList<Tile> testTiles = new ArrayList<>();
    ArrayList<ArrayList<String>> fileNames = new ArrayList<ArrayList<String>>();
    ArrayList<String> allFileNames = new ArrayList<>();
    ListView listoffiles;


    //Number of images for esch number of dots
    //There are no 0 dot, 1 dot or 2 dot images, so these are set to zero
    int[] numberOfEachImage = {0, 0, 0, 9, 6, 14};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dot_cancellation);

        GridLayout gridLayout = findViewById(R.id.gridLayout);

        listoffiles = findViewById(R.id.listView);

        fillFileList();

        ArrayAdapter<String> myAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, allFileNames);
        listoffiles.setAdapter(myAdapter);

        //add tiles to grid
        gridLayout.addView(AddNewTile("tile_5_0", 5));
        gridLayout.addView(AddNewTile("tile_4_2", 4));
        gridLayout.addView(AddNewTile("tile_3_3", 3));
        gridLayout.addView(AddNewTile("tile_3_6", 3));
        gridLayout.addView(AddNewTile("tile_3_1", 3));
        gridLayout.addView(AddNewTile("tile_5_6", 5));
        gridLayout.addView(AddNewTile("tile_4_0", 4));
        gridLayout.addView(AddNewTile("tile_5_3", 5));
        gridLayout.addView(AddNewTile("tile_5_9", 5));
        gridLayout.addView(AddNewTile("tile_5_14", 5));
    }

    private void fillFileList()
    {
        //Starts at 0 even though there are no 0 dot images
        //This is so the program can be changed later to include 0 dot images.
        for (int i = 0; i < numberOfEachImage.length; i++)
        {
            if (numberOfEachImage[i] > 0)
            {
                for (int j = 0; j <= numberOfEachImage[i]; j++)
                {
                    String fileName = "tile_" + Integer.toString(i) + "_" + Integer.toString(j);
                    //fileNames.get(i).set(j, fileName);
                    allFileNames.add(fileName);
                }
            }
        }
    }

    private Tile AddNewTile(String fileName, int dots)
    {
        Tile tempTile = new Tile(this, dots);
        tempTile.setImageResource(GetImage(this, fileName));
        tempTile.setOnClickListener(this);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, 200);
        tempTile.setLayoutParams(params);

        return tempTile;
    }

    // Solution from https://stackoverflow.com/questions/22664938/get-drawable-by-string/22665046
    public static int GetImage(Context c, String ImageName) {
        return c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName());
    }

    @Override
    public void onClick(View v) {
        Tile t = (Tile)v;
        t.toggleActive();
        Toast toast = Toast.makeText(this, Integer.toString(t.getNumberOfDots()), Toast.LENGTH_SHORT);
        toast.show();
    }
}
