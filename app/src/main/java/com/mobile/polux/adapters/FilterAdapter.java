package com.mobile.polux.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mobile.polux.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laptoplenovo on 6/6/2018.
 */

public class FilterAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> filters;

    public FilterAdapter( Context context, int layout, List<String> filters) {
        this.context = context;
        this.layout = layout;
        this.filters = filters;
    }

    @Override
    public int getCount() {
        return this.filters.size();
    }

    @Override
    public Object getItem(int position) { return this.filters.get(position);
    }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.item_filter, null);

            holder = new ViewHolder();

            holder.tvText = (TextView) convertView.findViewById(R.id.tv_text);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String filter = filters.get(position);

        holder.tvText.setText(filter);

        return convertView;
    }

    public void clear(){
        filters = null;
        filters = new ArrayList<>();
        //filters.clear();
    }

    public void addAll(List<String> filters){
        this.filters.addAll(filters);
    }


    static class ViewHolder {
        private TextView tvText;
    }
}