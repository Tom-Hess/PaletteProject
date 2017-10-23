package edu.temple.PaletteProject;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 9/28/2017.
 */

public class CustomAdapter extends ArrayAdapter{
    LayoutInflater inflater;
    List<String> colors = new ArrayList<>();
    List<String> englishColors = new ArrayList<>();


    public CustomAdapter(Activity context, int resource, int textViewId, List<String> colors, List<String> englishColors) {
        super(context, resource, textViewId, colors);
        inflater = context.getLayoutInflater();
        this.colors = colors;
        this.englishColors = englishColors;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View items = inflater.inflate(R.layout.activity_background, null, true);

        TextView txtColor = (TextView) items.findViewById(R.id.textView);
        txtColor.setText(colors.get(position).toString());
        txtColor.setBackgroundColor(Color.parseColor(englishColors.get(position)));
        //txtColor.getLayoutParams().width = LinearLayout.LayoutParams.MATCH_PARENT;
        txtColor.getLayoutParams().width = 2000;
        txtColor.getLayoutParams().height= 200;
        txtColor.setTextSize(30);

        return items;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        View v = null;
        v = super.getDropDownView(position, null, parent);
        v.setBackgroundColor(Color.parseColor(englishColors.get(position)));
        return v;
    }
}
