package com.mobile.polux.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.adapters.ProductInvoiceAdapter;
import com.mobile.polux.adapters.ProductOrderAdapter;
import com.mobile.polux.models.Order;
import com.mobile.polux.models.Product;
import com.mobile.polux.models.ProductInvoice;
import com.mobile.polux.models.ProductOrder;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

public class FullScreenDialog extends DialogFragment {

    public static final String TAG = "FullScreenDialog";
    private final DecimalFormat df = new DecimalFormat("####,###,##0.00");

    public static Order ORDER = null;
    public static List<ProductInvoice> products = null;
    public static String numOrder = null;
    private Realm realm;
    public static double iva;
    public static double discount;
    public static double subTotal;
    public static double total;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle);

        if (realm == null || realm.isClosed()) {
            realm = Realm.getDefaultInstance();
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle state) {
        super.onCreateView(inflater, parent, state);

        View view = getActivity().getLayoutInflater().inflate(R.layout.view_order, parent, false);

        TextView tvSubtotal = (TextView) view.findViewById(R.id.tv_subtotal);
        TextView tvIva = (TextView) view.findViewById(R.id.tv_iva);
        TextView tvDiscount = (TextView) view.findViewById(R.id.tv_discount);
        TextView tvTotal = (TextView) view.findViewById(R.id.tv_total);
        TextView tvOrder = (TextView) view.findViewById(R.id.tv_order);
        TextView tvTotalItems = (TextView) view.findViewById(R.id.tv_total_items);

        Button btnFinalize = (Button) view.findViewById(R.id.btn_finalize);
        btnFinalize.setVisibility(View.GONE);

        ListView lvProductsOrder = (ListView) view.findViewById(R.id.lv_products);

        if (ORDER != null){
            tvOrder.setText("Orden " + ORDER.getNumeroOrden());

            tvTotal.setText("" + df.format(ORDER.getTotal()));
            tvIva.setText("" + df.format(ORDER.getIva()));
            tvSubtotal.setText("" + df.format(ORDER.getSubtotal()));
            tvDiscount.setText("" + df.format(ORDER.getDiscount()));
            tvTotalItems.setText("" +ORDER.getLsDafDetallesOrdens().size());

            prepareOrder(ORDER.getLsDafDetallesOrdens());
            ProductOrderAdapter adapter = new ProductOrderAdapter(getActivity(), R.layout.item_product_order, productsOrder);
            lvProductsOrder.setAdapter(adapter);
        } else {
            tvOrder.setText("Orden " + numOrder);
            tvTotal.setText("" + df.format(total));
            tvIva.setText("" + df.format(iva));
            tvSubtotal.setText("" + df.format(subTotal));
            tvDiscount.setText("" + df.format(discount));
            ProductInvoiceAdapter productAdapter = new ProductInvoiceAdapter(getActivity(), R.layout.item_product, products);
            lvProductsOrder.setAdapter(productAdapter);
        }

        Button btnClose = (Button) view.findViewById(R.id.btn_close);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FullScreenDialog.this.dismiss();
            }
        });

        return view;
    }

    RealmList<ProductOrder> productsOrder;
    public void prepareOrder(List<ProductOrder> list) {
        productsOrder = new RealmList<>();
        for (ProductOrder p : list) {
            productsOrder.add(p);
            if (p.getLstDafDetallesOrden() != null) {
                for (ProductOrder promo : p.getLstDafDetallesOrden()) {
                    promo.setProductRelation(p.getCodigoPrestacion());
                    promo.setName(getProductName(promo.getCodigoPrestacion()));
                    productsOrder.add(promo);
                }
            }
        }
    }

    public String getProductName(int id) {
        try {
            return realm.where(Product.class).equalTo("id", id)
                    .findFirst().getName();
        } catch (Exception e) {
            return "";
        }
    }
}