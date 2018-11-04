package com.manager.direct.jacobshack2018;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RentList extends AppCompatActivity {
    private static final String TAG = "RecyclerViewExample";

    private List<FeedItem> feedsList;
    private RecyclerView mRecyclerView;
    private MyRecyclerViewAdapter adapter;
    private ProgressBar progressBar;
    private Intent dateIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        dateIntent =getIntent();

        String url = "http://stacktips.com/?json=get_category_posts&slug=news&count=30";
        new DownloadTask().execute(url);
    }

    public class DownloadTask extends AsyncTask<String, Void, Integer> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Integer doInBackground(String... params) {
            Integer result = 1;
            parseResult();


//            Integer result = 0;
//            HttpURLConnection urlConnection;
//            try {
//                URL url = new URL(params[0]);
//                urlConnection = (HttpURLConnection) url.openConnection();
//                int statusCode = urlConnection.getResponseCode();
//
//                // 200 represents HTTP OK
//                if (statusCode == 200) {
//                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//                    StringBuilder response = new StringBuilder();
//                    String line;
//                    while ((line = r.readLine()) != null) {
//                        response.append(line);
//                    }
//                    parseResult(response.toString());
//                    result = 1; // Successful
//                } else {
//                    result = 0; //"Failed to fetch data!";
//                }
//            } catch (Exception e) {
//                Log.d(TAG, e.getLocalizedMessage());
//            }
            return result; //"Failed to fetch data!";
        }

        @Override
        protected void onPostExecute(Integer result) {
            progressBar.setVisibility(View.GONE);

            if (result == 1) {
                adapter = new MyRecyclerViewAdapter(RentList.this, feedsList);
                mRecyclerView.setAdapter(adapter);
                adapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(FeedItem item) {
                        Toast.makeText(RentList.this, item.getTitle(), Toast.LENGTH_LONG).show();
                        if(item.getBool()) {
                        CustomDialogClass cdd = new CustomDialogClass(RentList.this, dateIntent);
                        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        cdd.show();}
                        else {
                            Intent intent1 = new Intent(getApplicationContext(), WebViewActivity.class);
                            startActivity(intent1);
                            finish();
                        }

                    }
                });

            } else {
                Toast.makeText(RentList.this, "Failed to fetch data!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void parseResult() {


        feedsList = new ArrayList<>();
        FeedItem item = new FeedItem();
        item.setTitle("Oberklasse\nPrice " + Math.round(132+dateIntent.getDoubleExtra("description",0)) + " €");
        item.setThumbnail(R.drawable.car1);
        item.setBool(false);
        feedsList.add(item);

        item = new FeedItem();
        item.setTitle("Oberklasse\nPrice " + Math.round(162+dateIntent.getDoubleExtra("description",0)) + " €");
        item.setThumbnail(R.drawable.car2);
        item.setBool(false);
        feedsList.add(item);

        item = new FeedItem();
        item.setTitle("Mittelklasse\nPrice " + 12 + " €");
        item.setThumbnail(R.drawable.carmain);
        item.setBool(true);
        feedsList.add(item);

        item = new FeedItem();
        item.setTitle("Untere Mittelklasse\nPrice " + Math.round(150+dateIntent.getDoubleExtra("description",0)) + " €");
        item.setThumbnail(R.drawable.car4);
        item.setBool(false);
        feedsList.add(item);

        item = new FeedItem();
        item.setTitle("Kleinwagenklasse\nPrice " + Math.round(200+dateIntent.getDoubleExtra("description",0)) + " €");
        item.setThumbnail(R.drawable.car5);
        item.setBool(false);
        feedsList.add(item);

    }
}