package com.mobile.polux.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.models.Payment;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by laptoplenovo on 22/10/2018.
 */

public class PaymentAdapter extends BaseAdapter {

    private List<Payment> payments;
    private int layout;
    private Context context;

    private final DecimalFormat df = new DecimalFormat("####,###,##0.00");

    public PaymentAdapter(Context context, int layout, List<Payment> payments) {
        this.context = context;
        this.layout = layout;
        this.payments = payments;
    }

    @Override
    public int getCount() {
        return this.payments.size();
    }

    @Override
    public Object getItem(int position) {
        return this.payments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(layout, null);

            holder = new ViewHolder();

            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvValue = (TextView) convertView.findViewById(R.id.tv_value);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Payment payment = payments.get(position);

        switch (payment.getTipo()) {
            case "E":
                holder.tvName.setText("Efectivo");
                break;
            default:
                holder.tvName.setText("Cheque");
                break;
        }

        holder.tvValue.setText("$ " + df.format(payment.getValor()));

        return convertView;
    }


    static class ViewHolder {
        private TextView tvName;
        private TextView tvValue;
    }
}