package com.mobile.polux.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.models.Delivery;
import com.mobile.polux.models.Order;

import java.util.List;

/**
 * Created by laptoplenovo on 11/10/2018.
 */

public class DeliveryAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Delivery> deliveryList;

    public DeliveryAdapter(Context context, int layout, List<Delivery> deliveryList) {
        this.context = context;
        this.layout = layout;
        this.deliveryList = deliveryList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        Delivery delivery = deliveryList.get(position);
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(layout, null);

            holder = new ViewHolder();

            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvAddress = (TextView) convertView.findViewById(R.id.tv_address);
            holder.tvObservation = (TextView) convertView.findViewById(R.id.tv_observations);
            holder.tvState = (TextView) convertView.findViewById(R.id.tv_state);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText("" + delivery.getName());
        holder.tvAddress.setText("" + delivery.getAddress());
        if (delivery.getObservation() == null || delivery.getObservation().isEmpty()) {
            holder.tvObservation.setText("Sin observaciones");
        } else {
            holder.tvObservation.setText("1 Observación");
        }

        if (delivery.getState() == null) {
            delivery.setState("PEN");
        }

        switch (delivery.getState()) {
            case "PEN":
                holder.tvState.setText("PENDIENTE");
                holder.tvState.setBackgroundResource(R.color.statePending);
                break;
            case "ENT":
                holder.tvState.setText("DESPACHADO");
                holder.tvState.setBackgroundResource(R.color.stateDelivery);
                break;
            default:
                holder.tvState.setText("NO SE ENCUENTRA");
                holder.tvState.setBackgroundResource(R.color.stateNotDelivery);
                break;
        }

        return convertView;
    }

    static class ViewHolder {
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvObservation;
        private TextView tvState;
    }
}
