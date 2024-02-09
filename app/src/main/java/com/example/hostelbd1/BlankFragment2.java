package com.example.hostelbd1;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.jsibbold.zoomage.ZoomageView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class BlankFragment2 extends Fragment {



    ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();

    HashMap<String,String>hashMap;

    RecyclerView recyclerView;















    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myview2=inflater.inflate(R.layout.fragment_blank2, container, false);

        recyclerView=myview2.findViewById(R.id.recycilerview);





        String url = "https://sowrovnil5bd.000webhostapp.com/apps/hostel.json";

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int x=0;x<response.length();x++){


                    try {
                        JSONObject jsonObject=response.getJSONObject(x);

                        String image_url=jsonObject.getString("image_url");


                        hashMap=new HashMap<>();

                        hashMap.put("image_url",image_url);

                        arrayList.add(hashMap);











                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    Myadapter1 myadapter1=new Myadapter1();
                    recyclerView.setAdapter(myadapter1);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));


                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue=Volley.newRequestQueue(getContext());

        queue.add(jsonArrayRequest);













            return myview2;



    }


    private class Myadapter1 extends RecyclerView.Adapter<Myadapter1.MyViewHolder1>{


        private class MyViewHolder1 extends RecyclerView.ViewHolder{

            ViewFlipper viewFlipper;

            ZoomageView image1,image2,imae3,image4;

            ImageView next,previuse;



            public MyViewHolder1(@NonNull View itemView) {
                super(itemView);

                viewFlipper=itemView.findViewById(R.id.viewFlipper);

                next=itemView.findViewById(R.id.nextpage);

                previuse=itemView.findViewById(R.id.previous);

                image1=itemView.findViewById(R.id.image1);


            }
        }



        @NonNull
        @Override
        public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater=getLayoutInflater();

            View myView=layoutInflater.inflate(R.layout.layout2,parent,false);


            return new MyViewHolder1(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder1 holder, int position) {


           hashMap=arrayList.get(position);


         String image_url=  hashMap.get("image_url");



            Picasso.get()
                    .load(image_url)

                    .into(holder.image1);





            holder.next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    holder.viewFlipper.showPrevious();


                }
            });

            holder.previuse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    holder.viewFlipper.showNext();


                }
            });




        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }






    }
















    }