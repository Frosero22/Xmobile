package com.mobile.polux.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.models.Client;
import com.mobile.polux.models.Location;

import java.util.List;

/**
 * Created by laptoplenovo on 9/6/2018.
 */

public class LocationAdapter extends BaseAdapter {

    private Context context;
    private List<Location> locations;

    public LocationAdapter( Context context, List<Location> locations) {
        this.context = context;
        this.locations = locations;
    }

    @Override
    public int getCount() {
        return this.locations.size();
    }

    @Override
    public Object getItem(int position) { return this.locations.get(position);
    }

    @Override
    public long getItemId(int position) { return this.locations.get(position).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.item_location, null);

            holder = new ViewHolder();

            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvAddress = (TextView) convertView.findViewById(R.id.tv_address);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Location location = locations.get(position);

        holder.tvName.setText(location.getName());
        holder.tvAddress.setText(location.getAddress());

        return convertView;
    }

    public Location getLocation(int position){
        return locations.get(position);
    }

    static class ViewHolder {
        private TextView tvName;
        private TextView tvAddress;
    }
}
