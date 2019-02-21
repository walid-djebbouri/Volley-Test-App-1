package com.zimaheka.merwan_walid.volley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Walid Djebbouri on 07/07/2018.
 */

public class Singleton {

    private static Singleton singleton ;
    private Context context ;
    private RequestQueue requestQueue ;

    public Singleton(Context context){

        this.context = context.getApplicationContext() ;
        this.requestQueue = getRequestQueue();

    }

    public static synchronized Singleton  getSingleton(Context context){

        if (singleton == null){

            singleton = new Singleton(context) ;

        }

        return singleton ;

    }

    public  RequestQueue getRequestQueue(){

        if(this.requestQueue == null){

            this.requestQueue = Volley.newRequestQueue(this.context.getApplicationContext()) ;
        }

        return this.requestQueue ;
    }
}
