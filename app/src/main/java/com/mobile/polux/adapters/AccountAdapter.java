package com.mobile.polux.adapters;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.models.Account;

import java.io.File;
import java.util.List;

/**
 * Created by laptoplenovo on 14/6/2018.
 */

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {

    private List<Account> accounts;
    private int layout;

    private Context context;

    public AccountAdapter(List<Account> accounts, int layout) {
        this.accounts = accounts;
        this.layout = layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context = parent.getContext();
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(accounts.get(position));
    }

    @Override
    public int getItemCount() {
        return accounts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvNameSale;
        public TextView tvQuota;
        public TextView tvDayP;
        public TextView tvDayG;
        public TextView tvComment;


        public ViewHolder(View itemView){
            super(itemView);
            tvNameSale = (TextView) itemView.findViewById(R.id.tv_name_sale);
            tvQuota = (TextView) itemView.findViewById(R.id.tv_quota);
            tvDayP = (TextView) itemView.findViewById(R.id.tv_day_p);
            tvDayG = (TextView) itemView.findViewById(R.id.tv_day_g);
            tvComment = (TextView) itemView.findViewById(R.id.tv_comment);
        }

        public void bind(Account account){
            //procesar datos a renderizar
            tvNameSale.setText(account.getNameSale());
            tvQuota.setText(""+account.getQuota());
            tvDayP.setText(""+account.getDiasPlazo());
            tvDayG.setText(""+account.getDaysGrace());
            tvComment.setText(account.getComments());
        }
    }

}