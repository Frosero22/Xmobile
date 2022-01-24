package com.mobile.polux.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.models.Product;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by laptoplenovo on 22/5/2018.
 */

public class ProductAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Product> products;

    DecimalFormat df = new DecimalFormat("####,###,##0.00");

    public ProductAdapter(Context context, int layout, List<Product> products) {
        this.context = context;
        this.layout = layout;
        this.products = products;
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public Object getItem(int position) {
        return this.products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.products.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.item_product, null);

            holder = new ViewHolder();

            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvCode = (TextView) convertView.findViewById(R.id.tv_code);
            holder.tvLbStock = (TextView) convertView.findViewById(R.id.tv_lb_stock);
            holder.tvStock = (TextView) convertView.findViewById(R.id.tv_stock);
            holder.tvPrice = (TextView) convertView.findViewById(R.id.tv_price);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Product product = products.get(position);

        holder.tvName.setText(product.getName());
        holder.tvCode.setText("" + product.getId());
        holder.tvStock.setText("" + product.getStock());
        holder.tvPrice.setText("" + df.format(product.getPrice()));
        if (product.getCodigoExistencia() == null){
            holder.tvLbStock.setVisibility(View.INVISIBLE);
            holder.tvStock.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

    public Product getProduct(int position) {
        return products.get(position);
    }

    public void clear() {
        products.clear();
    }

    public void addAll(List<Product> products) {
        this.products.addAll(products);
    }


    static class ViewHolder {
        private TextView tvName;
        private TextView tvCode;
        private TextView tvLbStock;
        private TextView tvStock;
        private TextView tvPrice;
    }
}
