package com.mobile.polux.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.models.GeoLocation;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by laptoplenovo on 21/7/2018.
 */

public class VisitAdapter extends BaseAdapter {

    public static final int TYPE_ITEM = 0;
    private static final int TYPE_HEADER = 1;

    private ArrayList<GeoLocation> mData = new ArrayList<>();
    private TreeSet<Integer> sectionHeader = new TreeSet<>();

    private LayoutInflater mInflater;

    public VisitAdapter(Context context) {
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addItem(final GeoLocation item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    public void addSectionHeaderItem(final GeoLocation item) {
        mData.add(item);
        sectionHeader.add(mData.size() - 1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return sectionHeader.contains(position) ? TYPE_HEADER : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return this.mData.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        int rowType = getItemViewType(position);

        if (convertView == null) {
            holder = new ViewHolder();
            switch (rowType) {
                case TYPE_ITEM:
                    convertView = mInflater.inflate(R.layout.item_visit, null);
                    holder.tvClient = (TextView) convertView.findViewById(R.id.tv_name);
                    holder.tvAddress = (TextView) convertView.findViewById(R.id.tv_address);
                    holder.tvZone = (TextView) convertView.findViewById(R.id.tv_zone);
                    holder.llClient = (LinearLayout) convertView.findViewById(R.id.ll_client);
                    //holder.tvClientType = (TextView) convertView.findViewById(R.id.tv_client_type);
                    //holder.llDay = (LinearLayout) convertView.findViewById(R.id.ll_day);
                    break;
                case TYPE_HEADER:
                    convertView = mInflater.inflate(R.layout.header_item, null);

                    holder.tvDay = (TextView) convertView.findViewById(R.id.tv_day);
                    holder.tvCant = (TextView) convertView.findViewById(R.id.tv_cant);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (rowType == TYPE_ITEM) {
            holder.tvClient.setText("" + mData.get(position).getClientName());
            holder.tvAddress.setText("" + mData.get(position).getAddress());
            //holder.tvZone.setText("" + mData.get(position).getZone());
            String value = ""+mData.get(position).getClientId();
            if (mData.get(position).getReference() != null ){
                value += " - "+mData.get(position).getReference();
            }
            if (mData.get(position).getClientType() != null ){
                value += " - "+mData.get(position).getClientType();
            }
            if (mData.get(position).getBusinessType() != null ){
                value += " - "+mData.get(position).getBusinessType();
            }
            value += " - "+mData.get(position).getZone();
            holder.tvZone.setText("" + value);

            if (mData.get(position).getNumOrders() > 0){
                holder.llClient.setBackgroundColor(Color.parseColor("#FFC6DEF1"));
            } else if (mData.get(position).getNumVisits() > 0){
                holder.llClient.setBackgroundColor(Color.parseColor("#F3F1F1"));
            } else {
                holder.llClient.setBackgroundColor(Color.parseColor("#8EFFE3E3"));
            }//pedido FFC6DEF1
        } else if (rowType == TYPE_HEADER) {
            holder.tvDay.setText(mData.get(position).getDay());
            holder.tvCant.setText(""+mData.get(position).getCant());
        }

        return convertView;
    }

    static class ViewHolder {
        private TextView tvClient;
        private TextView tvAddress;
        private TextView tvZone;
        //private TextView tvClientType;

        private LinearLayout llClient;

        private TextView tvDay;
        private TextView tvCant;
    }
}
