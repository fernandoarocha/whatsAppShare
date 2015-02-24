package what.fernandorocha.br.com.what.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import what.fernandorocha.br.com.what.R;
import what.fernandorocha.br.com.what.provider.AssetProvider;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    private MediaPlayer mp;
    private MusicShare musicShare;
    private ActionBar actionBar;
    private Intent shareIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Listener de Música
         */
        ImageView one = (ImageView)this.findViewById(R.id.buttonChega);
        one.setOnClickListener(this);

        ImageView two = (ImageView)this.findViewById(R.id.buttonTwo);
        two.setOnClickListener(this);

        ImageView three = (ImageView)this.findViewById(R.id.buttonThree);
        three.setOnClickListener(this);

        ImageView four = (ImageView)this.findViewById(R.id.buttonFour);
        four.setOnClickListener(this);

        /**
         * Listener de Share
         */
        ImageView shareOne = (ImageView)this.findViewById(R.id.buttonShareOne);
        shareOne.setOnClickListener(this);

        ImageView shareTwo = (ImageView)this.findViewById(R.id.buttonShareTwo);
        shareTwo.setOnClickListener(this);

        ImageView shareThree = (ImageView)this.findViewById(R.id.buttonShareThree);
        shareThree.setOnClickListener(this);

        ImageView shareFour = (ImageView)this.findViewById(R.id.buttonShareFour);
        shareFour.setOnClickListener(this);

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setIcon(R.drawable.ic_launcher);



    }

    /**
     * Verificação e criação de Stop na música
     */
    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            Intent share = new Intent();
            share.setAction(Intent.ACTION_SEND);
            share.putExtra(Intent.EXTRA_TEXT, R.string.text_share+" \n"+R.string.link_share);
            share.setType("text/plain");
            startActivity(Intent.createChooser(share, getResources().getText(R.string.send_to)));
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonChega:
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.salgadin);
                mp.start();
                break;
            case R.id.buttonTwo:
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.salgadin_dois);
                mp.start();
                break;
            case R.id.buttonThree:
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.salgadin_tres);
                mp.start();
                break;
            case R.id.buttonFour:
                stopPlaying();
                mp = MediaPlayer.create(MainActivity.this, R.raw.salgadin_hogod);
                mp.start();
                break;
            case R.id.buttonShareOne:
                musicShare = new MusicShare("120429.mp3");
                shareIntent = ShareCompat.IntentBuilder.from(MainActivity.this)
                        .setType("audio/*")
                        .setStream(musicShare.mImageUri)
                        .setChooserTitle(R.string.send_to)
                        .createChooserIntent();
                startActivity(shareIntent);
                break;
            case R.id.buttonShareTwo:
                musicShare = new MusicShare("120430.mp3");
                shareIntent = ShareCompat.IntentBuilder.from(MainActivity.this)
                        .setType("audio/*")
                        .setStream(musicShare.mImageUri)
                        .setChooserTitle(R.string.send_to)
                        .createChooserIntent();
                startActivity(shareIntent);
                break;
            case R.id.buttonShareThree:
                musicShare = new MusicShare("120431.mp3");
                shareIntent = ShareCompat.IntentBuilder.from(MainActivity.this)
                        .setType("audio/*")
                        .setStream(musicShare.mImageUri)
                        .setChooserTitle(R.string.send_to)
                        .createChooserIntent();
                startActivity(shareIntent);
                break;
            case R.id.buttonShareFour:
                musicShare = new MusicShare("120432.mp3");
                shareIntent = ShareCompat.IntentBuilder.from(MainActivity.this)
                        .setType("audio/*")
                        .setStream(musicShare.mImageUri)
                        .setChooserTitle(R.string.send_to)
                        .createChooserIntent();
                startActivity(shareIntent);
                break;

        }
    }


    private static class MusicShare{
        private final Uri mImageUri;

        private MusicShare(String shareMusic){
            mImageUri = Uri.parse("content://"+ AssetProvider.CONTENT_URI +"/"+ shareMusic);
        }
    }
}
