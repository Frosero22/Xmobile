package com.mobile.polux.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.polux.R;
import com.mobile.polux.app.App;
import com.mobile.polux.models.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laptoplenovo on 28/6/2018.
 */

public class AccountClientAdapter extends BaseAdapter {

    private List<Account> accounts;
    private int layout;

    private Context context;

    public AccountClientAdapter(Context context, List<Account> accounts, int layout) {
        this.accounts = new ArrayList<>();
        for (Account acc : accounts) {
            this.accounts.add(new Account(acc.getId(),
                    acc.getQuota(),
                    acc.getNameSale(),
                    acc.getSaleTypeCode(),
                    acc.getDivisionCode(),
                    acc.getnDivision(),
                    acc.getXDZVCode(),
                    acc.getDivision(),
                    acc.getPermiteModificarDiasPedido(),
                    acc.getDiasPlazo()));
        }
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.accounts.size();
    }

    @Override
    public Object getItem(int position) {
        return this.accounts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.accounts.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(layout, null);

            holder = new ViewHolder();

            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvDivision = (TextView) convertView.findViewById(R.id.tv_division);
            holder.tvQuota = (TextView) convertView.findViewById(R.id.tv_quota);
            holder.llAccount = (LinearLayout) convertView.findViewById(R.id.ll_account);
            holder.tvQuotaLabel = (TextView) convertView.findViewById(R.id.tv_quota_lb);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Account account = accounts.get(position);

        if(account.getQuota() == null){
            Toast.makeText(context, "El Cliente Seleccionado No Tiene un Cupo Asignado, por favor contacte al Administrador ", Toast.LENGTH_SHORT).show();

        }else{
            holder.tvQuota.setText("" + App.DECIMAL_FORMAT.format(account.getQuota()));

        }

        if(account.getDivision() == null){
            Toast.makeText(context, "El Cliente Seleccionado No Tiene Divisiones Asignadas, por favor contacte al Administrador ", Toast.LENGTH_SHORT).show();
        }else{
            holder.tvDivision.setText(account.getDivision());
        }

        if(account.getNameSale() == null){
            Toast.makeText(context, "El Cliente Seleccionado No Tiene un Nombre Ingresado, por favor contacte al Administrador ", Toast.LENGTH_SHORT).show();

        }else{
            holder.tvName.setText(account.getNameSale());

        }




        if (account.isSelect()) {
            holder.llAccount.setBackgroundColor(Color.parseColor("#2196F3"));
            holder.tvName.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvDivision.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvQuota.setTextColor(Color.parseColor("#FFFFFF"));
            holder.tvQuotaLabel.setTextColor(Color.parseColor("#FFFFFF"));


        } else {
            holder.llAccount.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.tvName.setTextColor(Color.parseColor("#5e5e5e"));
            holder.tvDivision.setTextColor(Color.parseColor("#5e5e5e"));
            holder.tvQuota.setTextColor(Color.parseColor("#3b3b3b"));
            holder.tvQuotaLabel.setTextColor(Color.parseColor("#3b3b3b"));
        }

        return convertView;
    }

    public void allDisable() {
        for (int i = 0; i < accounts.size(); i++) {
            accounts.get(i).setSelect(false);
        }
    }

    public void enableAccount(int position) {
        accounts.get(position).setSelect(true);
    }

    public Account getAccount(int position) {
        return accounts.get(position);
    }

    public int getPositionId(int id) {
        if (accounts == null) {
            return -1;
        }
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }


    static class ViewHolder {
        private TextView tvName;
        private TextView tvDivision;
        private TextView tvQuota;
        private TextView tvQuotaLabel;
        private LinearLayout llAccount;
    }
}