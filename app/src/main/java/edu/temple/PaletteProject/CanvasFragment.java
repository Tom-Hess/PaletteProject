package edu.temple.PaletteProject;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    LinearLayout layout;

    public CanvasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.canvas_fragment, container, false);
        Bundle args = getArguments();
        if (args != null) {
            String color = args.getString("color");
            layout = (LinearLayout) v.findViewById(R.id.colorLayout);
            layout.setBackgroundColor(Color.parseColor(color));
        }
        return v;
    }

}
