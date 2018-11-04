package com.manager.direct.jacobshack2018.navi;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AsyncPost extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... voids){  BufferedReader inputStream = null;

        return postData(voids[0]);
    }

    public String postData(String s) {
        // Create a new HttpClient and Post Header
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = new FormBody.Builder()
                .add("email", Data.email)
                .add("password", Data.password)
                .build();
        final Request request = new Request.Builder()
                .url(s)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Call request, final IOException e) {

            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    final String message = jsonObject.toString(5);
                    Looper looper = Looper.getMainLooper();
                    Handler handler = new Handler(looper);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        return null;
    }
}
