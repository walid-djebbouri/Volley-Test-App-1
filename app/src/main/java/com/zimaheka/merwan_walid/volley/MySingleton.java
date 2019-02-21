package com.zimaheka.merwan_walid.volley;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Walid Djebbouri on 07/07/2018.
 */

public class MySingleton {
    private static MySingleton mInstance;
    private RequestQueue mRequestQueue;

    private static Context mCtx;

    private MySingleton(Context context) {

        mCtx = context;
        Toast.makeText(mCtx.getApplicationContext(),"constrecteur1" , Toast.LENGTH_LONG ).show();
       // mRequestQueue = getRequestQueue();
        Toast.makeText(mCtx.getApplicationContext(),"constrecteur2" , Toast.LENGTH_LONG ).show();

    }

    public static synchronized MySingleton getInstance(Context context) {
        if (mInstance == null) {

            mInstance = new MySingleton(context);
            Toast.makeText(mCtx.getApplicationContext(),"instance" , Toast.LENGTH_LONG ).show();



        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            Toast.makeText(mCtx.getApplicationContext(),"qeueu=null" , Toast.LENGTH_LONG ).show();

            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());


        }

        return mRequestQueue;
    }

    public <String> void addToRequestQueue(Request<String> req) {

        getRequestQueue().add(req);
    }


}