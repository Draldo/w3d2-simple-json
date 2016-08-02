package com.example.admin.simplejson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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

    public void doGson(View view) {
        Gson gson = new GsonBuilder().create();
        //Let know the gson helper
        Type listType = new TypeToken<List<student>>() {}.getType();

        ArrayList<student> students = gson.fromJson(jsonString, listType);

        for(student std : students){
            Log.d(TAG, "doGson: "
                    + std.name + " "
                    + std.grade + " "
                    + std.age + " "
            );
        }
    }
}
