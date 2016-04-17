package johannpolania.com.reproduciraudio;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private Button playMp;
    private Button stopMp;
    private  Button bsoundpool;
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playMp=(Button) findViewById(R.id.playMp);
        stopMp=(Button) findViewById(R.id.stopMp);
        bsoundpool=(Button) findViewById(R.id.playSp);

        playMp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(MainActivity.this, R.raw.rx);
                mp.start();
            }
        });
        stopMp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                try {
                    mp.prepare();
                }
                catch (IOException exc)
                {
                }
            }
        });
        bsoundpool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying()){
                    mp.pause();
                } else {
                    mp.start();
                }
            }
        });
    }
}