package com.izdeveloper.wishlistappv2.allFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.izdeveloper.wishlistappv2.Adapter;
import com.izdeveloper.wishlistappv2.Article;
import com.izdeveloper.wishlistappv2.MainActivity;
import com.izdeveloper.wishlistappv2.R;
import com.izdeveloper.wishlistappv2.Storage;

import java.util.ArrayList;
import java.util.Collections;

public class listPage extends Fragment {

    private RecyclerView recyclerView;
    private Adapter adapterList;
    private Storage list;

    public listPage() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = Storage.getSingle();
        adapterList = new Adapter(getContext(), list.getItems(), (MainActivity) requireActivity());

    }

    @Override
    public void onResume() {
        super.onResume();
        adapterList.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_page, container, false);


        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapterList);

        ImageView btnSortByAlph = view.findViewById(R.id.btnSortByAlph);
        btnSortByAlph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortWithAlph();
            }
        });

        ImageView btnSortByTime = view.findViewById(R.id.btnSortByTime);
        btnSortByTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortWithTime();
            }
        });

        return view;
    }

    private void sortWithTime() {
        ArrayList<Article> allItems, sortedItems;

        allItems = Storage.getSingle().getItems();
        sortedItems = new ArrayList<>(allItems.size());

        for (Article c : allItems) {
            boolean yesorno = false;

            for (int i = 0; i < sortedItems.size(); i++) {

                if (c.getTimeOfAddition() < sortedItems.get(i).getTimeOfAddition()) {
                    sortedItems.add(i, c);

                    yesorno = true;

                    break;
                }
            }
            if (!yesorno) {
                sortedItems.add(c);

            }
        }

        allItems.clear();
        allItems.addAll(sortedItems);
        adapterList.notifyDataSetChanged();
    }

    private void sortWithAlph() {
        ArrayList<String> itemNames = new ArrayList<>();

        Storage storage = Storage.getSingle();
        ArrayList<Article> list = storage.getItems();

        for (Article item : list) {
            itemNames.add(item.getItemName());
        }
        Collections.sort(itemNames);

        ArrayList<Article> sortedItems = new ArrayList<>();
        for (String itemName : itemNames) {
            boolean yesorno = false;

            for (int i = 0; i < sortedItems.size(); i++) {

                Article c = sortedItems.get(i);

                if (c.getItemName().equals(itemName)) {
                    sortedItems.add(i, c);
                    yesorno = true;

                    break;
                }
            }

            if (!yesorno) {
                for (Article item : list) {
                    if (item.getItemName().equals(itemName)) {
                        sortedItems.add(item);

                        break;
                    }
                }
            }
        }

        list.clear();
        list.addAll(sortedItems);
        adapterList.notifyDataSetChanged();
    }
}
