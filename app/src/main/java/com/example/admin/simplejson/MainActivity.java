package com.example.admin.simplejson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String jsonString = "[{\"name\":\"Juan\",\"age\":20,\"grade\":8.1},{\"name\":\"Miguel\",\"age\":23,\"grade\":8.3},{\"name\":\"Roberto\",\"age\":39,\"grade\":9.3},{\"name\":\"Luis\",\"age\":19,\"grade\":6.9},{\"name\":\"Gaudencio\",\"age\":25,\"grade\":4.3}]";
    private String jsonComplex = "{\"students\":[{\"name\":\"Juan\",\"age\":20,\"grade\":8.1},{\"name\":\"Miguel\",\"age\":23,\"grade\":8.3},{\"name\":\"Roberto\",\"age\":39,\"grade\":9.3},{\"name\":\"Luis\",\"age\":19,\"grade\":6.9},{\"name\":\"Gaudencio\",\"age\":25,\"grade\":4.3}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doMagic(View view) {
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject;
            for (int i = 0; i < jsonArray.length(); i++) {
//                Log.d(TAG, "doMagic: " + i + " " + jsonArray.get(i));
                jsonObject = new JSONObject(jsonArray.get(i).toString());
                String name = jsonObject.getString("name");
                String grade = jsonObject.getString("grade");
                String age = jsonObject.getString("age");
                Log.d(TAG, "doMagic: " + i + " " + name + " " + grade + " " + age);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void doComplex(View view) {
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            JSONObject jsonObject, jsonObject2;
            for (int i = 0; i < jsonArray.length(); i++) {
//                Log.d(TAG, "doMagic: " + i + " " + jsonArray.get(i));
                jsonObject2 = new JSONObject(jsonComplex);
                String arr = jsonObject2.getString("students");
                jsonObject = new JSONObject(jsonArray.get(i).toString());
                String name = jsonObject.getString("name");
                String grade = jsonObject.getString("grade");
                String age = jsonObject.getString("age");
                Log.d(TAG, "doComplex: " + i + " " + name + " " + grade + " " + age);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
