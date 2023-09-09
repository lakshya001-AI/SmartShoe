package com.example.ultrasonic_sensorproject;

import static android.view.View.INVISIBLE;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;

public class Mainpage2 extends AppCompatActivity {

    private BluetoothAdapter bluetoothAdapter;
    private BluetoothDevice hc05;
    private BluetoothSocket socket;
    private InputStream inputStream;
    private TextView textView;
    private TextToSpeech textToSpeech;
    private ImageView buttonSpeak;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage2);

        textView = findViewById(R.id.distancetextview);
        buttonSpeak = findViewById(R.id.voicecommandimage);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        hc05 = bluetoothAdapter.getRemoteDevice("00:22:12:00:73:FC"); // Replace with your HC-05 address

        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");//uuid for the hc04 bluetooth module//

        //Socket Code Goes Here
        try {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivity(enableBtIntent);
            }

            socket = hc05.createRfcommSocketToServiceRecord(uuid);
            socket.connect();
            inputStream = socket.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a thread to read data from the HC-05 module
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] buffer = new byte[1024];
                int bytes;

                while (true) {
                    try {
                        bytes = inputStream.read(buffer);
                        String receivedData = new String(buffer, 0, bytes);
                        // Update the UI thread with the received data
                        handler.obtainMessage(0, receivedData).sendToTarget();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        // voice command code goes here
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = textToSpeech.setLanguage(Locale.US);

                    if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Toast.makeText(getApplicationContext(), "Language is not supported", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Voice Command in Progress", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // voice command code goes here
        buttonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakText();
            }
        });

    }
    // voice command code goes here
    private void speakText() {
        String text = textView.getText().toString();
        String text1 = "The object detected at " + text + "CentiMeter";
        textToSpeech.speak(text1, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    // voice command code goes here
    @Override
    protected void onDestroy() {
        if(textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    private final Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            String data = (String) msg.obj;
            // Update your TextView with the received data
            textView.setText(data);
            return true;
        }
    });




}