package johannpolania.com.appvideo;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    VideoView video;
    Button capturar;
String name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    video=(VideoView)findViewById(R.id.videoPrueba);
    capturar=(Button)findViewById(R.id.capturar);
        video.setMediaController(new MediaController(this));
        capturar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                name = Environment.getExternalStorageDirectory() + "video.mp4";
                Intent cameraIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                Uri salida = Uri.fromFile(new File(name));

                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, salida);
                //cameraIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(cameraIntent, 1234);




            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Uri uri=data.getData();
        video.setVideoURI(uri);
        video.start();

    }
}
