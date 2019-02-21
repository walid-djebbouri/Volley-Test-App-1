package com.zimaheka.merwan_walid.volley;

import android.app.VoiceInteractor;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import org.json.JSONObject;

import static android.content.ContentValues.TAG;

/**
 * Created by Walid Djebbouri on 04/07/2018.
 */

public class Requete extends JsonObjectRequest{


    public  Requete (String url , Response.Listener<JSONObject> listenner   ){


        super( Method.GET , url, null  , listenner , null ) ;


    }




}
