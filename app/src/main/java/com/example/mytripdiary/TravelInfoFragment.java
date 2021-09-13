package com.example.mytripdiary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;

public class TravelInfoFragment extends Fragment {
    SearchView mySearchView;
    protected ListView lv;
    protected ListAdapter adapter;
    SimpleAdapter mList;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] Pil;
    String[] Gbr;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.travelinfo_fragment,container, false);
        ListView btnFragment = (ListView) fragmentView.findViewById(R.id.lv);
        mySearchView = (SearchView) fragmentView.findViewById(R.id.searchView);
        lv = (ListView) fragmentView.findViewById(R.id.lv);

        Pil = new String[] {"Jakarta", "Bogor", "Surabaya", "Palembang", "Puncak", "Bali"};
        Gbr = new String[]{Integer.toString(R.drawable.jakarta),
                Integer.toString(R.drawable.bogor),
                Integer.toString(R.drawable.surabaya),
                Integer.toString(R.drawable.palembang),
                Integer.toString(R.drawable.puncak),
                Integer.toString(R.drawable.bali)
                            };
        mylist = new ArrayList<HashMap<String,String>>();
        for (int i = 0; i < Pil.length; i++){
            map = new HashMap<String, String>();
            map.put("list", Pil[i]);
            map.put("gbr", Gbr[i]);
            mylist.add(map);
        }

        final SimpleAdapter mList = new SimpleAdapter(getActivity(), mylist, R.layout.travel_info_list,
                                new String[]{"list", "gbr"}, new int[] {R.id.tv_nama, R.id.imV});
        lv.setAdapter(mList);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                mList.getFilter().filter(s);

                return false;
            }
        });

        return fragmentView;
        }
}
