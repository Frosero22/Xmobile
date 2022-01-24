package com.mobile.polux.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.models.Client;

import java.util.List;

/**
 * Created by laptoplenovo on 22/5/2018.
 */

public class ClientAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Client> clients;

    public ClientAdapter(Context context, int layout, List<Client> clients) {
        this.context = context;
        this.layout = layout;
        this.clients = clients;
    }

    @Override
    public int getCount() {
        return this.clients.size();
    }

    @Override
    public Object getItem(int position) {
        return this.clients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.clients.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.item_client, null);

            holder = new ViewHolder();

            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvBusiness = (TextView) convertView.findViewById(R.id.tv_business);
            holder.tvCode = (TextView) convertView.findViewById(R.id.tv_identification);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Client client = clients.get(position);

        holder.tvName.setText(client.getName());
        holder.tvBusiness.setText(client.getBusinessName());
        holder.tvCode.setText(client.getIdentification());

        return convertView;
    }

    public Client getClient(int position) {
        return clients.get(position);
    }

    public void clear() {
        clients.clear();
    }

    public void addAll(List<Client> clients) {
        this.clients.addAll(clients);
    }


    static class ViewHolder {
        private TextView tvName;
        private TextView tvBusiness;
        private TextView tvCode;
    }
}
