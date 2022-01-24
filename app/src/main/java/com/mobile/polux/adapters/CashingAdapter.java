package com.mobile.polux.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.app.App;
import com.mobile.polux.models.CashingGuideDetail;

import java.util.List;

/**
 * Created by laptoplenovo on 16/10/2018.
 */

public class CashingAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<CashingGuideDetail> cashingList;

    public CashingAdapter(Context context, int layout, List<CashingGuideDetail> cashingList) {
        this.context = context;
        this.layout = layout;
        this.cashingList = cashingList;
    }

    @Override
    public int getCount() {
        return cashingList.size();
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

        CashingGuideDetail cashing = cashingList.get(position);
        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(layout, null);

            holder = new ViewHolder();

            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvAddress = (TextView) convertView.findViewById(R.id.tv_address);
            holder.tvCollected = (TextView) convertView.findViewById(R.id.tv_collected);
            holder.tvPending = (TextView) convertView.findViewById(R.id.tv_pending);
            holder.tvState = (TextView) convertView.findViewById(R.id.tv_state);
            holder.llBalance = (LinearLayout) convertView.findViewById(R.id.ll_balance);
            holder.tvBalance = (TextView) convertView.findViewById(R.id.tv_balance);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvName.setText("" + cashing.getName());
        holder.tvAddress.setText("" + cashing.getAddress());

        holder.tvCollected.setText("$ " + App.DECIMAL_FORMAT.format(cashing.getCollected()));
        holder.tvPending.setText("$ " + App.DECIMAL_FORMAT.format(cashing.getTotalDue()));

        double pendiente = cashing.getTotalDue()-cashing.getCollected();
        if (pendiente>0) {
            holder.llBalance.setVisibility(View.VISIBLE);
            holder.tvBalance.setText("$ "+App.DECIMAL_FORMAT.format(pendiente));
        }

        String state = cashing.getState();
        if (state == null) {
            state = "PEN";
        }
        if (pendiente<=0){
            state = "REC";
        }

        switch (state) {
            case "PEN":
                holder.tvState.setText("PENDIENTE");
                //holder.tvState.setBackgroundResource(R.color.statePending);
                holder.tvState.setTextColor(ContextCompat.getColor(context, R.color.statePending));
                break;
            case "REC":
                holder.tvState.setText("RECAUDADO");
                //holder.tvState.setBackgroundResource(R.color.stateDelivery);
                holder.tvState.setTextColor(ContextCompat.getColor(context, R.color.stateDelivery));
                break;
            default:
                holder.tvState.setText("NO SE ENCUENTRA");
                //holder.tvState.setBackgroundResource(R.color.stateNotDelivery);
                holder.tvState.setTextColor(ContextCompat.getColor(context, R.color.stateNotDelivery));
                break;
        }

        return convertView;
    }

    static class ViewHolder {
        private TextView tvName;
        private TextView tvAddress;
        private TextView tvCollected;
        private TextView tvPending;
        private TextView tvState;
        private LinearLayout llBalance;
        private TextView tvBalance;
    }
}