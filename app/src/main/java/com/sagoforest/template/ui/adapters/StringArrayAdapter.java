package com.sagoforest.template.ui.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.sagoforest.template.R;

/**
 * Created by andy on 3/8/18.
 */



public class StringArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> values;

    public StringArrayAdapter(Context context, ArrayList<String> values) {
        super(context, R.layout.rowlayout, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public void notifyDataSetChanged() {
        // TODO Auto-generated method stub
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = null;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rowView = inflater.inflate(R.layout.rowlayout, parent, false);

        // Displaying a textview
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        textView.setText(values.get(position));


        return rowView;
    }