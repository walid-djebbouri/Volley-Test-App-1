package com.zimaheka.merwan_walid.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import static com.zimaheka.merwan_walid.volley.Singleton.getSingleton;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }




    public void recherche (View view){

        final TextView textView = (TextView)findViewById(R.id.textView) ;
        EditText editText = (EditText)findViewById(R.id.editText);
        String id = editText.getText().toString().trim() ;
        String url = "http://zemahek.000webhostapp.com/recherche_mobile.php?id="+id ;

        Response.Listener<JSONObject> listener = new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {



                try{

                    Boolean success = response.getBoolean("success") ;
                    if(success){

                        Toast.makeText(getApplicationContext() , response.getString("nom") +" "+response.getString("prenom") , Toast.LENGTH_LONG ).show();
                        textView.setText( response.toString() );

                    }else{

                        Toast.makeText(getApplicationContext() , "false" , Toast.LENGTH_LONG).show();

                    }

                }catch (JSONException e){

                    Toast.makeText(getApplicationContext() , "exception" , Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }


        } ;
        Requete requete = new Requete( url , listener) ;


      //  RequestQueue requestQueue = Volley.newRequestQueue(this);
       // requestQueue.add(requete);



        //RequestQueue requestQueue = getSingleton(this.getApplicationContext()).getRequestQueue() ;


    //   RequestQueue queue = MySingleton.getInstance(this.getApplicationContext()).getRequestQueue();
     //   queue.add(requete);

       MySingleton.getInstance(this.getApplicationContext()).addToRequestQueue(requete);








    }



}
