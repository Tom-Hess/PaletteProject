package edu.temple.PaletteProject;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity implements PaletteFragment.onGridViewClickListener {

    boolean twoPane;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        twoPane = (findViewById(R.id.fragment2) != null);
        FragmentManager fm = getFragmentManager();
        fm.popBackStack();

        Fragment palette = new PaletteFragment();
        loadFragment(R.id.fragment1, palette, false);

        if(twoPane)
            loadFragment(R.id.fragment2, new CanvasFragment(), false);
    }

    public void displayColor(String color) {
        CanvasFragment canvas = new CanvasFragment();
        Bundle args = new Bundle();
        args.putString("color", color);
        canvas.setArguments(args);

        loadFragment(twoPane ? R.id.fragment2 : R.id.fragment1, canvas, !twoPane);

    }

    private void loadFragment(int id, Fragment fragment, boolean addToBackStack){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft;
        ft = fm.beginTransaction().replace(id, fragment);
        if(addToBackStack) {
            ft.addToBackStack(null);
        }
        ft.commit();

        fm.executePendingTransactions();
    }

}
