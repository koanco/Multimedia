package johannpolania.com.recorderaudio;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener
{
    private MediaRecorder recorder;
    private MediaPlayer player;
    File archivo;
    Button reproducir, detener, grabar;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reproducir=(Button)(findViewById(R.id.Reroducir));
        detener=(Button)findViewById(R.id.Detener);
        grabar=(Button)findViewById(R.id.Grabar);
        ;
    }


    public void grabar(View view)
    {
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        File path = new File(Environment.getExternalStorageDirectory()
                .getPath());
        try {
            archivo = File.createTempFile("temporal", ".3gp", path);
        } catch (IOException e) {
        }
        recorder.setOutputFile(archivo.getAbsolutePath());
        try {
            recorder.prepare();
        } catch (IOException e) {
        }
        recorder.start();
        grabar.setEnabled(false);
        reproducir.setEnabled(true);


    }

    public void detener(View view)
    {
        recorder.stop();
        recorder.release();
        player = new MediaPlayer();
        player.setOnCompletionListener(this);
        try {
            player.setDataSource(archivo.getAbsolutePath());
        } catch (IOException e) {
        }
        try {
            player.prepare();
        } catch (IOException e) {
        }
        reproducir.setEnabled(true);
        detener.setEnabled(false);
        grabar.setEnabled(true);




    }

    public void reproducir(View view)
    {
        player.start();
        reproducir.setEnabled(false);
        detener.setEnabled(false);
        grabar.setEnabled(false);



    }

    public void onCompletion(MediaPlayer mp) {
        reproducir.setEnabled(true);
        detener.setEnabled(true);
        grabar.setEnabled(true);



    }


}
