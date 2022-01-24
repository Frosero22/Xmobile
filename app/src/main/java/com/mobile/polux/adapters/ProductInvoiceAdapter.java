package com.mobile.polux.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mobile.polux.R;

import com.mobile.polux.models.ProductInvoice;

import java.text.DecimalFormat;
import java.util.List;

public class ProductInvoiceAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<ProductInvoice> products;

    DecimalFormat df = new DecimalFormat("####,###,##0.00");

    public ProductInvoiceAdapter(Context context, int layout, List<ProductInvoice> products) {
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
            holder.tvLbCode = (TextView) convertView.findViewById(R.id.tv_lv_code);
            holder.tvCode = (TextView) convertView.findViewById(R.id.tv_code);
            holder.tvLbStock = (TextView) convertView.findViewById(R.id.tv_lb_stock);
            holder.tvStock = (TextView) convertView.findViewById(R.id.tv_stock);
            holder.tvLbPrice = (TextView) convertView.findViewById(R.id.tv_lb_price);
            holder.tvPrice = (TextView) convertView.findViewById(R.id.tv_price);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ProductInvoice product = products.get(position);

        holder.tvName.setText(product.getId()+" - "+product.getName());
        holder.tvLbCode.setText("Cant.");
        holder.tvCode.setText("" + product.getCant());
        holder.tvLbStock.setText("Precio $");
        holder.tvLbPrice.setText("Total $");
        holder.tvStock.setText("" + df.format(product.getPrice()));
        holder.tvPrice.setText("" + df.format(product.getTotal()));
        return convertView;
    }

    public ProductInvoice getProduct(int position) {
        return products.get(position);
    }

    public void clear() {
        products.clear();
    }

    public void addAll(List<ProductInvoice> products) {
        this.products.addAll(products);
    }


    static class ViewHolder {
        private TextView tvName;
        private TextView tvLbCode;
        private TextView tvCode;
        private TextView tvLbStock;
        private TextView tvStock;
        private TextView tvLbPrice;
        private TextView tvPrice;
    }
}
