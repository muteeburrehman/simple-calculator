package com.example.requestj;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import pk.codebase.requests.HttpRequest;
import pk.codebase.requests.HttpResponse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpRequest request = new HttpRequest();
        request.setOnResponseListener(response -> {
            if (response.code == HttpResponse.HTTP_OK){
                System.out.println(response.toJSONObject());
            }
        });
        request.setOnErrorListener(error -> {
            //There was an error, deal with it
        });

        request.get("http://localhost:8000/api/products");
    }
}