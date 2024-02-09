package com.example.hostelbd1;


import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.jsibbold.zoomage.ZoomageView;

public class BlankFragment3 extends Fragment {


    public static Bitmap MY_BITMAP=null;

    ViewFlipper viewFlipper;
    ImageButton next,previous;

    ZoomageView image1,image2,image3,image4,image5;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myy3=inflater.inflate(R.layout.fragment_blank3, container, false);





        viewFlipper=myy3.findViewById(R.id.viewFlipper);
        next=myy3.findViewById(R.id.next);

        previous=myy3.findViewById(R.id.previous);

        image1=myy3.findViewById(R.id.image1);
        image2=myy3.findViewById(R.id.image2);
        image3=myy3.findViewById(R.id.image3);
        image4=myy3.findViewById(R.id.image4);
        image5=myy3.findViewById(R.id.image5);




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewFlipper.showNext();

            }
        });



        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewFlipper.showPrevious();




            }
        });


        if (MY_BITMAP!=null){

            image1.setImageBitmap(MY_BITMAP);

        }else {


        }












        return myy3;
    }
}