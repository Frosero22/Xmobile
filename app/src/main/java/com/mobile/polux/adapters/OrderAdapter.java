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
import com.mobile.polux.app.App;
import com.mobile.polux.models.Order;

import java.util.List;

import io.realm.Realm;

/**
 * Created by laptoplenovo on 23/5/2018.
 */

public class OrderAdapter extends BaseAdapter  implements
        View.OnClickListener{

    private Context context;
    private int layout;
    private List<Order> orders;
    private boolean showNumber;
    private boolean multiSelect;


    public OrderAdapter(Context context, int layout, List<Order> orders, boolean showNumber, boolean multiSelect) {
        this.context = context;
        this.layout = layout;
        this.orders = orders;
        this.showNumber = showNumber;
        this.multiSelect = multiSelect;
    }

    @Override
    public int getCount() {
        return this.orders.size();
    }

    @Override
    public Order getItem(int position) {
        return this.orders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.orders.get(position).getId();
    }

    @Override
    public int getViewTypeCount() {
        if(getCount() > 0){
            return getCount();
        }else{
            return super.getViewTypeCount();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        Order order = orders.get(position);
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(layout, null);


            holder = new ViewHolder();

            holder.llContent = convertView.findViewById(R.id.ll_content);
            holder.tvClient = (TextView) convertView.findViewById(R.id.tv_client);
            holder.tvSubTotal = (TextView) convertView.findViewById(R.id.tv_subtotal);
            holder.tvTotal = (TextView) convertView.findViewById(R.id.tv_total);
            holder.llNumber = (LinearLayout) convertView.findViewById(R.id.ll_num);
            holder.cbSelect = (CheckBox) convertView.findViewById(R.id.cb_selected);
            holder.tvOrder = (TextView) convertView.findViewById(R.id.tv_num_order);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if ("ON".equals(order.getState())){
            if (order.isApproved()) {
                holder.llContent.setBackgroundResource(R.color.approved);
            } else {
                holder.llContent.setBackgroundResource(R.color.noApproved);
            }
        }

        holder.tvClient.setText("" + order.getName());
        holder.tvSubTotal.setText("" + App.DECIMAL_FORMAT.format(order.getSubtotal()));
        holder.tvTotal.setText("" + App.DECIMAL_FORMAT.format(order.getTotal()));

        if (showNumber) {
            //holder.llNumber.setVisibility(View.VISIBLE);
            holder.tvOrder.setText("" + order.getNumeroOrden());
        } else {
            holder.tvOrder.setText("OFF-" + order.getId());
        }

        if (multiSelect) {
            holder.cbSelect.setVisibility(View.VISIBLE);
            holder.cbSelect.setTag(position);
            holder.cbSelect.setChecked(order.isChecked());
            holder.cbSelect.setOnClickListener(this);
        }

        return convertView;
    }

    @Override
    public void onClick(View v) {
        CheckBox checkBox = (CheckBox) v;
        int position = (Integer) v.getTag();

        getItem(position).setChecked(checkBox.isChecked());

        //se notifica el cambio en el objeto para que en la vista se sincronice
        notifyDataSetChanged();
    }

    static class ViewHolder {
        private LinearLayout llContent;
        private TextView tvClient;
        private TextView tvSubTotal;
        private TextView tvTotal;
        private LinearLayout llNumber;
        private CheckBox cbSelect;
        private TextView tvOrder;
    }
}