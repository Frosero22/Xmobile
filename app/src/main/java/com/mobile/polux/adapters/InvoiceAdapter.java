package com.mobile.polux.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.app.App;
import com.mobile.polux.models.Invoice;

import java.util.List;

import io.realm.Realm;

/**
 * Created by laptoplenovo on 22/10/2018.
 */

public class InvoiceAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Invoice> invoices;

    public InvoiceAdapter(Context context, int layout, List<Invoice> invoices) {
        this.context = context;
        this.layout = layout;
        this.invoices = invoices;
    }

    @Override
    public int getCount() {
        return invoices.size();
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
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        Invoice invoice = invoices.get(position);
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(layout, null);

            holder = new ViewHolder();

            holder.tvInvoice = (TextView) convertView.findViewById(R.id.tv_invoice);
            holder.tvValue = (TextView) convertView.findViewById(R.id.tv_value);
            holder.tvDue = (TextView) convertView.findViewById(R.id.tv_due);
            holder.tvPendiente = (TextView) convertView.findViewById(R.id.tv_pending);
            holder.tvState = (TextView) convertView.findViewById(R.id.tv_state);
            holder.tvDate = (TextView) convertView.findViewById(R.id.tv_date);
            holder.tvDateVencimiento = (TextView) convertView.findViewById(R.id.tv_date_v);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvInvoice.setText("" + invoice.getCodigoComprobante());
        holder.tvValue.setText("$ " + App.DECIMAL_FORMAT.format(invoice.getTotal()));
        holder.tvDue.setText("$ " + App.DECIMAL_FORMAT.format(invoice.getDue()));
        holder.tvDate.setText("" + invoice.getFecha());
        holder.tvDateVencimiento.setText("" + invoice.getFechaVencimiento());
        holder.tvPendiente.setText("$ " + App.DECIMAL_FORMAT.format((invoice.getDue() - invoice.getPay())));


        if (invoice.getTotal() == invoice.getDue()) {
            invoice.setState("PEN");
        }

        if (invoice.getPay() == invoice.getDue()) {
            invoice.setState("CAN");
            holder.tvPendiente.setVisibility(View.GONE);
        }

        if (invoice.getPay() > 0 && invoice.getPay() < invoice.getDue()) {
            invoice.setState("PAR");
        }

        if (invoice.getState() == null) {
            invoice.setState("PEN");
        }

        switch (invoice.getState()) {
            case "PEN":
                holder.tvState.setText("PENDIENTE");
                //holder.tvState.setBackgroundResource(R.color.statePending);
                holder.tvState.setTextColor(ContextCompat.getColor(context, R.color.statePending));
                break;
            case "CAN":
                holder.tvState.setText("RECAUDADO");
                //holder.tvState.setBackgroundResource(R.color.stateDelivery);
                holder.tvState.setTextColor(ContextCompat.getColor(context, R.color.stateDelivery));
                break;
            default:
                holder.tvState.setText("PARCIAL");
                //holder.tvState.setBackgroundResource(R.color.stateNotDelivery);
                holder.tvState.setTextColor(ContextCompat.getColor(context, R.color.stateNotDelivery));
                break;
        }

        return convertView;
    }

    static class ViewHolder {
        private TextView tvInvoice;
        private TextView tvValue;
        private TextView tvDue;
        private TextView tvPendiente;
        private TextView tvState;
        private TextView tvDate;
        private TextView tvDateVencimiento;
    }
}
