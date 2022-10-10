package com.ujjwalkumar.apicalldemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Product> al;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        al = new ArrayList<>();
        loadContent();
    }

    private void loadContent() {
        String url = "https://fakestoreapi.com/products";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        for(int i=0; i<response.length(); i++) {
                            JSONObject obj = response.getJSONObject(i);
                            Product product = new Product(obj.getInt("id"), obj.getString("title"), obj.getString("image"), response.getJSONObject(i).getDouble("price"));
                            al.add(product);
                        }
                        ProductAdapter adapter = new ProductAdapter(MainActivity.this, al);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recyclerView.setAdapter(adapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                },
                error -> Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show()){
            @Override
            public Map<String, String> getHeaders() {
                return new HashMap<>();
            }
        };

        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }
}