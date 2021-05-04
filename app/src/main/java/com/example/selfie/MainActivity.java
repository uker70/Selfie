package com.example.selfie;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements MainView.MainViewInterface {

    MainView mv;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.pictureView);
    }

    public MainActivity(){
        mv = new MainView(this, this);
    }

    /**
     * Method that runs when the user presses the "take picture" button
     * @param v the view that started the method
     */
    @Override
    public void capturePictureIntent(View v) {
        mv.capturePictureIntent();
    }

    /**
     * Method that runs when startActivityForResult ends
     * Starts a method with the same name, that handles the result output
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mv.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * Method that changes what the ImageView is showing
     * @param bm the new image to show
     */
    @Override
    public void setImageView(Bitmap bm) {
        iv.setImageBitmap(bm);
    }
}