package com.example.eunoia;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class recommendation extends Fragment{

    Button BtnMusic,BtnBreathing,BtnYoga;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public recommendation() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment music.
     */
    // TODO: Rename and change types and number of parameters
    public static music newInstance(String param1, String param2) {
        music fragment = new music();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recommendation, container, false);
    }

    @Override
    public void onViewCreated( View view, @Nullable Bundle savedInstanceState) {
        //Calling Music Fragment from Recommendation Fragment
        BtnMusic = view.findViewById(R.id.BtnMusic);
        View.OnClickListener OCLmusic =new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(view).navigate(R.id.DesMusic);
                }
            };
        BtnMusic.setOnClickListener(OCLmusic);

        //Calling Yoga Fragment from Recommendation Fragment
        BtnYoga = view.findViewById(R.id.BtnYoga);
        View.OnClickListener OCLYoga =new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.Desyoga);
            }
        };
        BtnYoga.setOnClickListener(OCLYoga);

        //Calling Breathing Fragment from Recommendation Fragment
        BtnBreathing = view.findViewById(R.id.BtnBreathing);
        View.OnClickListener OCLBreathing =new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.DesBreathing_exercise);
            }
        };
        BtnBreathing.setOnClickListener(OCLBreathing);
    }
}


