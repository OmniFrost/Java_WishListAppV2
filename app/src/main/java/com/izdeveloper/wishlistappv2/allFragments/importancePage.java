package com.izdeveloper.wishlistappv2.allFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.izdeveloper.wishlistappv2.R;

import java.util.ArrayList;

public class importancePage extends Fragment {
    private TextView textView2;
    public importancePage() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View nakyma = inflater.inflate(R.layout.fragment_importance_page, container, false);
        textView2 = nakyma.findViewById(R.id.textView2);

        return nakyma;
    }

    public void printImpArt(ArrayList<String> nStarred) {
        StringBuilder combiner = new StringBuilder();

        for (int k = 0; k < nStarred.size(); k++) {

            String i = nStarred.get(k);
            combiner.append(k+1).append(") ").append(i).append("\n");
        }

        textView2.setText(combiner.toString());
    }
}