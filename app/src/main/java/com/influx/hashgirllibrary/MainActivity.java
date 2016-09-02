package com.influx.hashgirllibrary;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import kr.pe.burt.android.lib.hashgirl.HashGirl;
import kr.pe.burt.android.lib.hashgirl.OnClickHashListener;

public class MainActivity extends AppCompatActivity {

    TextView afterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String text = "Hello, I'm #Super Hash Girl^ in the World. You can hash #every^thing what you want. #I will hash you^ powered by #SelvaSanthosh^";

        afterTextView = (TextView) findViewById(R.id.textview);
        HashGirl
                .with(text)
                .grab("(#((\\w+ *)*)\\^)", "^", "#")
                .underline()
                .color(Color.BLUE)
                .bgcolor(Color.WHITE)
                .click(new OnClickHashListener() {
                    @Override
                    public void onClickHash(String hash) {
                        if (hash.equalsIgnoreCase("SelvaSanthosh")) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.selvasanthosh.com")));
                        } else {
                            Toast.makeText(MainActivity.this, hash, Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .into(afterTextView);

    }
}
