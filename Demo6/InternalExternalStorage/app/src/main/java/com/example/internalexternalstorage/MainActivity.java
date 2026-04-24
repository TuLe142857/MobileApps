package com.example.internalexternalstorage;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void writeIS(String file, String content) {
        try (FileOutputStream fos = openFileOutput(file, MODE_PRIVATE)){
            fos.write(content.getBytes(StandardCharsets.UTF_8));
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private String readIS(String file){
        try(FileInputStream fin = openFileInput(file)){
            byte[] buffer = new byte[1024];
            int length = fin.read(buffer);
            return new String(buffer, 0, length);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    private void writeFC(String file, String content){
        File cacheDir = getCacheDir();
        try(FileOutputStream fos = new FileOutputStream(new File(cacheDir, file)))
        {
            fos.write(content.getBytes(StandardCharsets.UTF_8));
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private String readFC(String file){
        File cacheDir = getCacheDir();
        try(FileInputStream fin = new FileInputStream(new File(cacheDir, file)))
        {
            byte[] buffer = new byte[1024];
            int length = fin.read(buffer);
            return new String(buffer, 0, length);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    private void writeES(String file, String content){
        String sdCard = getExternalFilesDir("") + "/" + file;
        try(OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(sdCard))){
            writer.write(content);
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private String readES(String file){
        String sdCard = getExternalFilesDir("") + "/" + file;
        try(Scanner scanner = new Scanner(new File(sdCard)))
        {
            String res = "";
            while (scanner.hasNext()){
                res = res + scanner.nextLine() + "\n";
            }
            return res;
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return "";
    }

    @Override
    public void onClick(View v) {
        int btn_id = v.getId();
        if (btn_id == R.id.button){
            writeIS("file.txt", "internal storage file content ");
            Toast.makeText(this, "Write Internal Storage OK!", Toast.LENGTH_SHORT).show();
        }
        else if (btn_id == R.id.button2){
            Toast.makeText(this, "Read Internal Storage: " + readIS("file.txt"), Toast.LENGTH_SHORT).show();
        }
        else if (btn_id == R.id.button3){
            writeFC("file.txt", "file cache content");
            Toast.makeText(this, "Write Cache File OK!", Toast.LENGTH_SHORT).show();
        }
        else if (btn_id == R.id.button4){
            Toast.makeText(this, "Read Cache File: " + readFC("file.txt"), Toast.LENGTH_SHORT).show();
        }
        else if (btn_id == R.id.button5){
            writeES("file.txt", "external storage file content");
            Toast.makeText(this, "Write External Storage OK!", Toast.LENGTH_SHORT).show();
        }
        else if (btn_id == R.id.button6){
            Toast.makeText(this, "Read External Storage: " + readES("file.txt"), Toast.LENGTH_SHORT).show();
        }
    }
}