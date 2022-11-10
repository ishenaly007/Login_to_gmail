package com.abit.login_to_gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    Button send;
    EditText address, subject, emailtext;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Наши поля и кнопка
        send = (Button) findViewById(R.id.send);
        address = (EditText) findViewById(R.id.address2);
        subject = (EditText) findViewById(R.id.title2);
        emailtext = (EditText) findViewById(R.id.text2);

        send.setOnClickListener(v -> {

            final Intent emailIntent = new Intent(Intent.ACTION_SEND);

            emailIntent.setType("plain/text");
            // Кому
            emailIntent.putExtra(Intent.EXTRA_EMAIL,
                    new String[] { address.getText().toString() });
            // Зачем
            emailIntent.putExtra(Intent.EXTRA_SUBJECT,
                    subject.getText().toString());
            // О чём
            emailIntent.putExtra(Intent.EXTRA_TEXT,
                    emailtext.getText().toString());
            // С чем
            /*emailIntent.putExtra(
                    android.content.Intent.EXTRA_STREAM,
                    Uri.parse("file://"
                            + Environment.getExternalStorageDirectory()
                            + "/Клипы/SOTY_ATHD.mp4"));

            emailIntent.setType("text/video");*/

            MainActivity.this.startActivity(Intent.createChooser(emailIntent,
                    "Отправка письма..."));
        });
    }
}