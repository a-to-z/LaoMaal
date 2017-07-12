package com.cyanogenlabs.laomaal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://www.laomaal.com/index.php?route=api/login";

        final TextView tv1 = (TextView) findViewById(R.id.tv1);

        StringRequest strRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        try {
                            JSONObject jObject = new JSONObject(response);
                            token = jObject.getString("token");
                        }catch (Exception exception){

                        }
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                        tv1.setText(response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                        tv1.setText(error.toString());
                    }
                })
        {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", "androidapp");
                params.put("key", "K2d75pYgA6UYKOhRVmpAeVb3AwUWkGsjam2i8jRtF51YF0pTwilS7dpvAVTOj2lmBX31ekCyeTgaroyuOl2x41wjd6y6JbdicNTl5SBbIrKnxY0FVA8VvKUZ54gY7B0cNm8RJ2JsCdXA8fDT3euzNxnFh4tQeE631fHW1Bm6LvjJgneR6TWu8vcoUWprcPpeXw6wjwxJlxnAcaYAjBZCU7LF7wEe1Ksc6YnkRWQXDsaML68PzLw2NTxycVXtiuJu");
                return params;
            }
        };

        queue.add(strRequest);

        Button buy = (Button) findViewById(R.id.buy);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cartadd = "https://www.laomaal.com/index.php?route=api/cart/add";

                StringRequest addtocart = new StringRequest(Request.Method.POST,cartadd,new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();

                    }
                },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error)
                            {
                                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        })
                {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("product_id", "28");
                        params.put("quantity", "1");
                        params.put("token",token);
                        return params;
                    }
                };

                queue.add(addtocart);
            }
        });

    }
}
