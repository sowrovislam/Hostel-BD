package com.example.hostelbd1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ImageSlider imageSlider;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); imageSlider =findViewById(R.id.image_slider);
        recyclerView=findViewById(R.id.recyclerView);

        imageslide();




        Myadapter myadapter=new Myadapter();
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity2.this,RecyclerView.VERTICAL,false));










    }





    private class Myadapter extends RecyclerView.Adapter<Myadapter.MyVideHolder>{


        private class MyVideHolder extends RecyclerView.ViewHolder{


            public MyVideHolder(@NonNull View itemView) {
                super(itemView);
            }
        }




        @NonNull
        @Override
        public MyVideHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


            LayoutInflater layoutInflater=getLayoutInflater();

            View myView=   layoutInflater.inflate(R.layout.layout,parent,false);

            return new MyVideHolder(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyVideHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 10;
        }









    }
































    private void imageslide (){
        ArrayList<SlideModel> imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.img, ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.img_1,ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.img_2,ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.sss,ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.img_4,ScaleTypes.CENTER_CROP));
        imageSlider.setImageList(imageList);





    }







}