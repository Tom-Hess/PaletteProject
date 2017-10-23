package edu.temple.PaletteProject;


import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaletteFragment extends Fragment {
    GridView gvColors;
    Resources res;
    List<String> colorsArrayList;
    List<String> englishColors;


    public interface onGridViewClickListener {
        void displayColor(String color);
    }

    public onGridViewClickListener myListener;

    public PaletteFragment() {
        // Required empty public constructor
    }

    public static PaletteFragment getInstance() {
        PaletteFragment fragment = new PaletteFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.palette_fragment, container, false);
        res = getResources();
        colorsArrayList = new ArrayList<>(Arrays.asList(res.getStringArray(R.array.colorsArray)));

        gvColors = (GridView) v.findViewById(R.id.paletteGVColors);
        res = this.getResources();
        englishColors = new ArrayList<>(Arrays.asList(res.getStringArray(R.array.englishColorsArray)));

        CustomAdapter adapter = new CustomAdapter(getActivity(), R.layout.activity_background,
                R.id.textView, colorsArrayList, englishColors);
        gvColors.setAdapter(adapter);
        gvColors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String pickedColor = englishColors.get(position);
                myListener.displayColor(pickedColor);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            myListener = (onGridViewClickListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myListener = null;
    }

}
