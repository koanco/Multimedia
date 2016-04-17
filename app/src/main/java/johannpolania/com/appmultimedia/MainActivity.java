package johannpolania.com.appmultimedia;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoView =(VideoView)findViewById(R.id.surface_view);

        //establece la ruta del video
        mVideoView.setVideoPath("http://www.ebookfrenzy.com/android_book/movie.mp4");
        //Mostrar los botones de reproducción, pausa y stop.
        mVideoView.setMediaController(new MediaController(this));
        //inicia la reproducción del video
        mVideoView.start();
        mVideoView.requestFocus();

    }
}
