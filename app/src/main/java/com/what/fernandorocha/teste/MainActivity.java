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

import java.util.ArrayList;
import java.util.List;

import static android.view.View.*;
/*
Button one = (Button)this.findViewById(R.id.buttonChega);
        final MediaPlayer mp2 = MediaPlayer.create(this, R.raw.salgadin);
        one.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                // If the music is playing

                    mp2.start();
            }
        });



        Button two = (Button)this.findViewById(R.id.buttonTwo);
        final MediaPlayer musictwo = MediaPlayer.create(this, R.raw.salgadin_dois);
        two.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                // If the music is playing

                musictwo.start();
            }
        });

        Button three = (Button)this.findViewById(R.id.buttonThree);
        final MediaPlayer musicthree = MediaPlayer.create(this, R.raw.salgadin_tres);
        three.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                // If the music is playing

                musicthree.start();
            }
        });

        Button four = (Button)this.findViewById(R.id.buttonFour);
        final MediaPlayer musicfour = MediaPlayer.create(this, R.raw.salgadin_hogod);
        four.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {

                // If the music is playing

                musicfour.start();
            }
        });
*/


public class MainActivity extends Activity implements OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    @Override
    public void onClick(View v) {


        Intent shareIntent = ShareCompat.IntentBuilder.from(MainActivity.this)
                .setText("Beatifull")
                .setType("audio/*")
                .setStream(MusicShare.)
                .setChooserTitle("Imagem")
                .createChooserIntent();
        startActivity(shareIntent);
    }

    private static class MusicShare{
        private final Uri mImageUri;

        private MusicShare(String shareImg){
            mImageUri = Uri.parse("content://"+AssetProvider.CONTENT_URI +"/"+ shareImg);
        }
    }
}
