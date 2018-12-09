package com.example.yousif.iot;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
/*import android.webkit.WebView;*/
import com.loopj.android.http.*;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    final String url = "https://io.adafruit.com/api/v2/elsekily/feeds/led/data?X-AIO-KEY=4109b6d2b091498bb87d98831f4441ba";
    StringEntity entity;
    String value;
    String feed_id;
    String feed_key;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void on(View view) {
        AsyncHttpClient client = new AsyncHttpClient();
        JSONObject data = new JSONObject();
        JSONObject val = new JSONObject();
        try {
            val.put("value", "1");
            data.put("datum", val);
            entity = new StringEntity(data.toString());
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "parameter off", Toast.LENGTH_SHORT).show();
        }

        client.post(context, url, entity, "application/json", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    feed_key=response.getString("feed_key");
                    Toast.makeText(MainActivity.this, feed_key, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "Request Success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject response) {
                Toast.makeText(MainActivity.this, "Request Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void off(View view) {
        AsyncHttpClient client = new AsyncHttpClient();
        JSONObject data = new JSONObject();
        JSONObject val = new JSONObject();
        try {
            val.put("value", "0");
            data.put("datum", val);
            entity = new StringEntity(data.toString());
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "parameter off", Toast.LENGTH_SHORT).show();
        }

        client.post(context, url, entity, "application/json", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    feed_key=response.getString("feed_key");
                    Toast.makeText(MainActivity.this, feed_key, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "Request Success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject response) {
                Toast.makeText(MainActivity.this, "Request Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }
}