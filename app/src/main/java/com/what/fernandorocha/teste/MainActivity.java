package com.what.fernandorocha.teste;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.*;
/*

*/


public class MainActivity extends Activity {
    MusicShare musicShareOne = new MusicShare("salgadin.mp3");
    MusicShare musicShareTwo = new MusicShare("salgadin_dois.mp3");
    MusicShare musicShareThree = new MusicShare("salgadin_tres.mp3");
    MusicShare musicShareFour = new MusicShare("salgadin_hogod.mp3");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Tocar musicas clickadas
        ImageView one = (ImageView)this.findViewById(R.id.buttonChega);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.salgadin);
        one.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                if(mp2.isPlaying())
                    mp2.pause();// If the music is playing
                else
                    mp2.start();
            }
        });

        ImageView two = (ImageView)this.findViewById(R.id.buttonTwo);
        final MediaPlayer musictwo = MediaPlayer.create(this, R.raw.salgadin_dois);
        two.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                if(musictwo.isPlaying())
                    musictwo.pause();// If the music is playing
                else
                    musictwo.start();
            }
        });

        ImageView three = (ImageView)this.findViewById(R.id.buttonThree);
        final MediaPlayer musicthree = MediaPlayer.create(this, R.raw.salgadin_tres);
        three.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                if(musicthree.isPlaying())
                    musicthree.pause();// If the music is playing
                else
                    musicthree.start();
            }
        });

        ImageView four = (ImageView)this.findViewById(R.id.buttonFour);
        final MediaPlayer musicfour = MediaPlayer.create(this, R.raw.salgadin_hogod);
        four.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                if(musicfour.isPlaying())
                    musicfour.pause();// If the music is playing
                else
                    musicfour.start();
            }
        });

        ImageView shareOne = (ImageView)this.findViewById(R.id.buttonShareOne);

        shareOne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = ShareCompat.IntentBuilder.from(MainActivity.this)
                        .setType("audio/*")
                        .setStream(musicShareOne.mImageUri)
                        .setChooserTitle("Compartilhar Áudio com")
                        .createChooserIntent();
                startActivity(shareIntent);
            }
        });

        ImageView shareTwo = (ImageView)this.findViewById(R.id.buttonShareTwo);

        shareTwo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = ShareCompat.IntentBuilder.from(MainActivity.this)
                        .setType("audio/*")
                        .setStream(musicShareTwo.mImageUri)
                        .setChooserTitle("Compartilhar Áudio com")
                        .createChooserIntent();
                startActivity(shareIntent);
            }
        });

        ImageView shareThree = (ImageView)this.findViewById(R.id.buttonShareThree);

        shareThree.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = ShareCompat.IntentBuilder.from(MainActivity.this)
                        .setType("audio/*")
                        .setStream(musicShareThree.mImageUri)
                        .setChooserTitle("Compartilhar Áudio com")
                        .createChooserIntent();
                startActivity(shareIntent);
            }
        });


        ImageView shareFour = (ImageView)this.findViewById(R.id.buttonShareFour);

        shareFour.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = ShareCompat.IntentBuilder.from(MainActivity.this)
                        .setType("audio/*")
                        .setStream(musicShareFour.mImageUri)
                        .setChooserTitle("Compartilhar Áudio com")
                        .createChooserIntent();
                startActivity(shareIntent);
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private static class MusicShare{
        private final Uri mImageUri;

        private MusicShare(String shareImg){
            mImageUri = Uri.parse("content://"+AssetProvider.CONTENT_URI +"/"+ shareImg);
        }
    }
}
