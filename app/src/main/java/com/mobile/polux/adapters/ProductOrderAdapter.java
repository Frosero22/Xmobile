package com.mobile.polux.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.models.Product;
import com.mobile.polux.models.ProductOrder;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by laptoplenovo on 28/5/2018.
 */

public class ProductOrderAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<ProductOrder> productsOrder;
    private Realm realm;

    DecimalFormat df = new DecimalFormat("####,###,##0.00");



    public ProductOrderAdapter(Context context, int layout, List<ProductOrder> productsOrder) {
        this.context = context;
        this.layout = layout;
        this.productsOrder = productsOrder;
    }

    @Override
    public int getCount() {
        return this.productsOrder.size();
    }

    @Override
    public Object getItem(int position) {
        return this.productsOrder.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.productsOrder.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.item_product_order, null);

            holder = new ViewHolder();

            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            holder.tvBoxes = (TextView) convertView.findViewById(R.id.tv_boxes);
            holder.tvUnits = (TextView) convertView.findViewById(R.id.tv_units);
            holder.tvPrice = (TextView) convertView.findViewById(R.id.tv_price);
            holder.tvTotal = (TextView) convertView.findViewById(R.id.tv_total);
            holder.llPromotion = (LinearLayout)convertView.findViewById(R.id.ll_promotion);
            holder.tvDiscount = (TextView)convertView.findViewById(R.id.tv_discount);
            holder.tvValueDiscount = (TextView)convertView.findViewById(R.id.tv_value_discount);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ProductOrder product = productsOrder.get(position);

        if (("S".equals(product.getEsPromocionAutomatica()) || "S".equals(product.getEsPromocion())) && product.getProductRelation() != null && product.getCodigoReglaNegocio() != null) {
            holder.tvName.setText("GRATIS - "+product.getCodigoPrestacion() +" - "+ product.getName());
            holder.tvName.setTextColor(context.getResources().getColor(R.color.colorAccent));
            holder.tvTotal.setText("" + df.format(0));
        } else {
            holder.tvName.setText(product.getCodigoPrestacion() +" - "+ product.getName());
            holder.tvName.setTextColor(context.getResources().getColor(R.color.itemProduct));
            holder.tvTotal.setText("" + df.format(product.getValorTotal()));
        }
        if (product.getBoxes() == 0) {
            holder.tvBoxes.setVisibility(View.INVISIBLE);
        } else {
            holder.tvBoxes.setText(product.getBoxes() +" cj");
        }

        holder.tvUnits.setText(product.getUnits() +" ud");
        holder.tvPrice.setText("" + df.format(product.getPrecioUnitarioVenta()));

        if (product.getProductRelation() == null && product.getPorcentajeDescuento() != null && product.getPorcentajeDescuento()>0) {
            holder.llPromotion.setVisibility(View.VISIBLE);
            holder.tvDiscount.setText("" + df.format(product.getPorcentajeDescuento()));
            holder.tvValueDiscount.setText(" - $ " + df.format(product.getValorDescuento()));
        } else {
            holder.llPromotion.setVisibility(View.GONE);
        }

        return convertView;
    }

    public void updateProduct(ProductOrder product){


    }

    public void clear() {
        productsOrder.clear();
    }

    public void addAll(List<ProductOrder> products) {
        this.productsOrder.addAll(products);
    }

    public void add(ProductOrder product) {
        this.productsOrder.add(product);
    }


    public String getProductName(int id) {
        try {
            return realm.where(Product.class).equalTo("id", id)
                    .findFirst().getName();
        } catch (Exception e) {
            return "";
        }
    }

    static class ViewHolder {
        private TextView tvName;
        private TextView tvBoxes;
        private TextView tvUnits;
        private TextView tvPrice;
        private TextView tvTotal;
        private LinearLayout llPromotion;
        private TextView tvDiscount;
        private TextView tvValueDiscount;
    }
}