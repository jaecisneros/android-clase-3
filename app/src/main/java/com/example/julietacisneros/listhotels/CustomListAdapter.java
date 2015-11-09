package com.example.julietacisneros.listhotels;

/**
 * Created by julietacisneros on 06/11/15.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

public abstract class CustomListAdapter extends BaseAdapter {

    private ArrayList<?> entries;
    private int layoutIdView;
    private Context context;

    public CustomListAdapter(Context context, int layoutIdView, ArrayList<?> entries) {
        super();
        this.context = context;
        this.entries = entries;
        this.layoutIdView = layoutIdView;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(layoutIdView, null);
        }
        onEntry(entries.get(position), view);
        return view;
    }

    @Override
    public int getCount() {
        return entries.size();
    }

    @Override
    public Object getItem(int position) {
        return entries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public abstract void onEntry(Object entry, View view);
}
