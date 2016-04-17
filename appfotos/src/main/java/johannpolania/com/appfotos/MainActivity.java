package johannpolania.com.appfotos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.Matrix;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private String name = "";
    private Button captura;
    private ImageView imagen;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        captura = (Button) (findViewById(R.id.bCapturar));
        imagen = (ImageView) (findViewById(R.id.foto));
        name = Environment.getExternalStorageDirectory() + "foto.jpg";
        captura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent cameraIntent = new Intent(Intent.ACTION_PICK);
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                Uri salida = Uri.fromFile(new File(name));
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, salida);
                //cameraIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(cameraIntent, 1234);


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
/*
        if (requestCode == 1234 && resultCode == RESULT_OK) {

            Uri selectedImage = data.getData();
            InputStream is;
            try {
                is = getContentResolver().openInputStream(selectedImage);
                BufferedInputStream bis = new BufferedInputStream(is);
                Bitmap bitmap = BitmapFactory.decodeStream(bis);
                ImageView iv = (ImageView)findViewById(R.id.foto);
                imagen.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {}


        }

*/


        if (requestCode == 1234 && resultCode == RESULT_OK) {
            //Creamos un bitmap con la imagen recientemente
            //almacenad
            Bitmap bMap = BitmapFactory.decodeFile(
                    Environment.getExternalStorageDirectory() +
                            "foto.jpg");
            //Añadimos el bitmap al imageView para
            //mostrarlo por pantalla
            Matrix mat = new Matrix();
            mat.postRotate(90);
            Bitmap bMapRotate = Bitmap.createBitmap(bMap, 0, 0,bMap.getWidth(),bMap.getHeight(), mat, true);
            imagen.setImageBitmap(bMapRotate);


    }





    }
}
