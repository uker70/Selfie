package com.example.selfie;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import static android.app.Activity.RESULT_OK;

public class MainView {

    MainViewInterface mvi;
    MainActivity ma;

    public interface MainViewInterface{
        void capturePictureIntent(View v);
        void setImageView(Bitmap bm);
    }

    public MainView(MainViewInterface mvi, MainActivity ma){
        this.mvi = mvi;
        this.ma = ma;
    }

    //the request number for image
    private static final int REQUEST_IMAGE_CAPTURE = 1888;
    /**
     * @author Mr. Benjimoin
     * Method that runs when the user wants to take a picture
     * It makes an intent for taking a picture and then starts it
     */
    public void capturePictureIntent(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            ma.startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e){

        }
    }

    /**
     * Gets the output data of the activity, gets the data and converts it to an image
     *
     * @param requestCode The request code that was used in the activity
     * @param resultCode The result code of the activity
     * @param data The output data of the intent activity
     */
    public void onActivityResult(Integer requestCode, Integer resultCode, Intent data){
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap)extras.get("data");
            mvi.setImageView(imageBitmap);
        }
    }
}
