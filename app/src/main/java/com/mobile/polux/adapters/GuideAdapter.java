package com.mobile.polux.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.mobile.polux.R;
import com.mobile.polux.models.InfoGuia;

import java.util.List;

public class GuideAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<InfoGuia> guides;

    public GuideAdapter(Context context, int layout, List<InfoGuia> guides) {
        this.context = context;
        this.layout = layout;
        this.guides = guides;
    }

    @Override
    public int getCount() {
        return this.guides.size();
    }

    @Override
    public Object getItem(int position) {
        return this.guides.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.guides.get(position).getCodigoGuiasCobro();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        InfoGuia guide = guides.get(position);
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(layout, null);


            holder = new ViewHolder();

            holder.tvGuide = convertView.findViewById(R.id.tv_guide);
            holder.tvName = convertView.findViewById(R.id.tv_name);
            holder.tvDate = convertView.findViewById(R.id.tv_date);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvGuide.setText("" + guide.getCodigoGuiasCobro());
        holder.tvName.setText("" + guide.getNombreCompletoVendedor());
        holder.tvDate.setText("" + guide.getFechaIngreso());

        return convertView;
    }

    static class ViewHolder {
        private TextView tvGuide;
        private TextView tvName;
        private TextView tvDate;
    }
}
