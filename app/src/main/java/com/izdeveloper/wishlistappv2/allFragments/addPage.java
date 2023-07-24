package com.izdeveloper.wishlistappv2.allFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.izdeveloper.wishlistappv2.Article;
import com.izdeveloper.wishlistappv2.MainActivity;
import com.izdeveloper.wishlistappv2.R;
import com.izdeveloper.wishlistappv2.Storage;


public class addPage extends Fragment {

    private EditText AN, Descr;
    private CheckBox imp;

    public addPage() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_page, container, false);

        AN = view.findViewById(R.id.txtAN);
        Descr = view.findViewById(R.id.txtDescr);
        imp = view.findViewById(R.id.imp);

        Button include = view.findViewById(R.id.btnAddFin);

        include.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addArticle(v);
            }
        });

        return view;
    }

    public void addArticle(View view) {
        String N, D;
        boolean tempImp;

        N = AN.getText().toString();
        D = Descr.getText().toString();
        tempImp = imp.isChecked();

        Storage storage = Storage.getSingle();
        storage.addArticle(new Article(N, D, tempImp));

        MainActivity mainActivity = (MainActivity) getActivity();
        if (mainActivity != null) {
            mainActivity.dispthruFragment();
        }
    }

}
