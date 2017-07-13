package com.cyanogenlabs.laomaal;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

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
                        tv1.setText(token);
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
                String cartadd = "https://www.laomaal.com/index.php?route=api/cart/add" + "&token=" + token;

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
                        return params;
                    }
                };

                queue.add(addtocart);

                /*Uri uri = Uri.parse("https://laomaal.com/");

                CookieStore cookieStore = cookieManager.getCookieStore();

                List cookieList = cookieStore.getCookies();

                String json = new Gson().toJson(cookieList);

                tv1.setText(json);*/

                //Toast.makeText(getApplicationContext(),token,Toast.LENGTH_LONG).show();

            }
        });

        Button shipAdd = (Button) findViewById(R.id.shipadd);

        shipAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shipAddrs = "https://www.laomaal.com/index.php?route=api/shipping/address" + "&token=" + token;

                StringRequest shippingAddress = new StringRequest(Request.Method.POST,shipAddrs,new Response.Listener<String>()
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
                        params.put("firstname", "Ammar");
                        params.put("lastname", "Zubair");
                        params.put("address_1", "mygerrys");
                        params.put("city", "KARACHI");
                        params.put("country_id", "1");
                        params.put("zone_id", "4473");
                        return params;
                    }
                };

                queue.add(shippingAddress);

                String payAddrs = "https://www.laomaal.com/index.php?route=api/payment/address" + "&token=" + token;

                StringRequest payAddress = new StringRequest(Request.Method.POST,payAddrs,new Response.Listener<String>()
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
                        params.put("firstname", "Ammar");
                        params.put("lastname", "Zubair");
                        params.put("address_1", "mygerrys");
                        params.put("city", "KARACHI");
                        params.put("country_id", "1");
                        params.put("zone_id", "4473");
                        return params;
                    }
                };

                queue.add(payAddress);
            }
        });

        Button shipMtd = (Button) findViewById(R.id.shipmtd);

        shipMtd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String shipMethods = "https://www.laomaal.com/index.php?route=api/shipping/methods" + "&token=" + token;

                StringRequest shippingMethods = new StringRequest(Request.Method.POST,shipMethods,new Response.Listener<String>()
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
                        params.put("shipping_method", "free.free");
                        return params;
                    }
                };

                queue.add(shippingMethods);

                String shipMethod = "https://www.laomaal.com/index.php?route=api/shipping/method" + "&token=" + token;

                StringRequest shippingMethod = new StringRequest(Request.Method.POST,shipMethod,new Response.Listener<String>()
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
                        params.put("shipping_method", "free.free");
                        return params;
                    }
                };

                queue.add(shippingMethod);

                String paymMethods = "https://www.laomaal.com/index.php?route=api/payment/methods" + "&token=" + token;

                StringRequest payMethods = new StringRequest(Request.Method.POST,paymMethods,new Response.Listener<String>()
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
                        params.put("shipping_method", "cod");
                        return params;
                    }
                };

                queue.add(payMethods);

                String paymMethod = "https://www.laomaal.com/index.php?route=api/payment/method" + "&token=" + token;

                StringRequest payMethod = new StringRequest(Request.Method.POST,paymMethod,new Response.Listener<String>()
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
                        params.put("payment_method", "cod");
                        return params;
                    }
                };

                queue.add(payMethod);

            }
        });

        Button cstInfo = (Button) findViewById(R.id.cstmInfo);

        cstInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cstmrInfo = "https://www.laomaal.com/index.php?route=api/customer" + "&token=" + token;

                StringRequest cstmInfo = new StringRequest(Request.Method.POST,cstmrInfo,new Response.Listener<String>()
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
                        params.put("firstname", "Ammar");
                        params.put("lastname", "Zubair");
                        params.put("email", "ammarzubair@gmail.com");
                        params.put("telephone", "03472548185");
                        return params;
                    }
                };

                queue.add(cstmInfo);

            }
        });

        Button crtOrder = (Button) findViewById(R.id.crtOrder);

        crtOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String crtOrder = "https://www.laomaal.com/index.php?route=api/order/add" + "&token=" + token;

                StringRequest createOrder = new StringRequest(Request.Method.POST,crtOrder,new Response.Listener<String>()
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
                        params.put("shipping_method", "free.free");
                        return params;
                    }
                };

                queue.add(createOrder);

            }
        });

    }
}
