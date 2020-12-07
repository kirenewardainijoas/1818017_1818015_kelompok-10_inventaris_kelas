package com.example.Inventaris_kelas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.Inventaris_kelas.R;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Barang> movieItems;

    public CustomListAdapter(Activity activity, List<Barang> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView jenis = (TextView) convertView.findViewById(R.id.text_jenis);
        TextView jml = (TextView) convertView.findViewById(R.id.text_jml);
        TextView nomor = (TextView) convertView.findViewById(R.id.text_nmr);
        Barang m = movieItems.get(position);
        jenis.setText("Jenis Barang : "+ m.getJenis());
        jml.setText("Jumlah Barang : "+ m.getJml());
        nomor.setText("Nomor Inventaris : "+ m.getNmr());
        return convertView;
    }
}

