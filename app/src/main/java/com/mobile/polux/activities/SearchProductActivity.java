package com.mobile.polux.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.polux.R;
import com.mobile.polux.adapters.FilterAdapter;
import com.mobile.polux.adapters.ProductAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.models.Filter;
import com.mobile.polux.models.Product;
import com.mobile.polux.models.ProductOrder;
import com.mobile.polux.utils.Dialog;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.Sort;

public class SearchProductActivity extends AbstractActivity implements SearchView.OnQueryTextListener {

    private List<Product> products;

    private ListView lvProducts;
    private ListView lvFilters;

    private ProductAdapter adapter;
    private FilterAdapter filterAdapter;

    private Product productSelect;
    private AlertDialog dialog;
    private Realm realm;
    private List<String> filters;

    private SearchView searchView;
    private TextView tvMessage;

    DecimalFormat df = new DecimalFormat("####,###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);

        getSupportActionBar().setTitle("Productos");

        if (realm == null || realm.isClosed()) {
            realm = Realm.getDefaultInstance();
        }

        tvMessage = (TextView) findViewById(R.id.message);

        bindUI();

        if (filters == null) {
            allFilters();
        }
    }

    private void bindUI() {
        lvProducts = (ListView) findViewById(R.id.lv_products);
        lvFilters = (ListView) findViewById(R.id.lv_filters);
        visibleFilters();

        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                productSelect = adapter.getProduct(position);
                // saveProduct(productSelect);

                if (existProduct(productSelect.getId())) {
                    showToastL("El producto selecionado ya se encuentra agregado en el pedido");
                } else {
                    try {
                        showDialogProduct();
                    } catch (Exception e) {
                    }
                }

            }
        });

        lvFilters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String f = (String) filterAdapter.getItem(position);

                MenuItemCompat.expandActionView(item);
                // searchView.setQuery(search, true);
                searchView.setQuery(f, false);
                // searchView.requestFocus();
                resultSearch(f);

            }
        });
    }

    private void allFilters() {
        filters = new ArrayList<>();
        List<Filter> filtersDb = realm.where(Filter.class).equalTo("type", "PR").findAllSorted("date", Sort.DESCENDING);
        for (Filter f : filtersDb) {
            filters.add(f.getText());
        }
        filterAdapter = new FilterAdapter(this, R.layout.item_filter, filters);
        lvFilters.setAdapter(filterAdapter);
    }

    private void setFilter(String text) {
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(new Filter(text, "PR"));
            realm.commitTransaction();
        } catch (Exception e) {
        }
    }


    private boolean existProduct(int code) {

        for (ProductOrder p : OrderProductsActivity.productsOrder) {
            if (p.getProductRelation() == null && p.getCodigoPrestacion() == code) {
                return true;
            }
        }
        return false;
    }

    private int boxes;
    private int units;


    private void showDialogProduct() {

        final View view = getLayoutInflater().inflate(R.layout.product_select, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(SearchProductActivity.this).create();
        alertDialog.setTitle(productSelect.getName());
        alertDialog.setCancelable(false);

        LinearLayout llBoxes = (LinearLayout) view.findViewById(R.id.ll_boxes);
        final EditText etUnits = (EditText) view.findViewById(R.id.et_units);
        final EditText etBoxes = (EditText) view.findViewById(R.id.et_boxes);

        final TextView tvStock = (TextView) view.findViewById(R.id.tv_stock);
        final TextView tvPrice = (TextView) view.findViewById(R.id.tv_price);
        final Button btnLessC = (Button) view.findViewById(R.id.btn_less_c);
        final Button btnMoreC = (Button) view.findViewById(R.id.btn_more_c);
        final Button btnLessU = (Button) view.findViewById(R.id.btn_less_u);
        final Button btnMoreU = (Button) view.findViewById(R.id.btn_more_u);
        LinearLayout llStock = (LinearLayout) view.findViewById(R.id.ll_stock);

        App.getValueOfPreferencesUser(App.KEY_DISCOUNT, "N");
        if ("S".equals(App.getValueOfPreferencesUser(App.KEY_DISCOUNT, "N"))) {

            boolean value = false;
            boolean percent = false;
            if ("S".equals(App.getValueOfPreferencesUser(App.KEY_DISCOUNT_VALUE, "N"))) {
                RadioButton rb = view.findViewById(R.id.dollar);
                rb.setVisibility(View.VISIBLE);
                value = true;
            }
            if ("S".equals(App.getValueOfPreferencesUser(App.KEY_DISCOUNT_PERCENT, "N"))) {
                RadioButton rb = view.findViewById(R.id.percent);
                rb.setVisibility(View.VISIBLE);
                percent = true;
            }

            if (value || percent) {
                LinearLayout llDiscount = (LinearLayout) view.findViewById(R.id.ll_discounts);
                llDiscount.setVisibility(View.VISIBLE);
                RadioGroup rg = view.findViewById(R.id.rg_discount);
                if (value) {
                    rg.check(R.id.dollar);
                } else if (percent) {
                    rg.check(R.id.percent);
                }
            }
        }

        final EditText etValueDiscount = (EditText) view.findViewById(R.id.et_value);
        final RadioGroup groupDiscount = view.findViewById(R.id.rg_discount);

        //final int unitsMin = productSelect.getUnidadesXCajas();
        boolean isBoxes = productSelect.getUnidadesXCajas() != null && productSelect.getUnidadesXCajas() > 0;
        if (productSelect.getCodigoExistencia() == null){
            llStock.setVisibility(View.GONE);
        }
        if (productSelect.getCodigoExistencia() == null || App.getValueOfPreferencesUser(App.KEY_USE_EQUIV, "").equals("N")){
            isBoxes = false;
        }

        boxes = 0;
        units = 0;
        if (isBoxes) {
            llBoxes.setVisibility(View.VISIBLE);
           // boxes = 0;
            //units = 0;
        }

        etUnits.setText("" + units);
        etBoxes.setText("" + boxes);
        double iva = 0;
        final double price;
        if ("S".equals(productSelect.getAplicaIva())) {
            iva = productSelect.getPrice() * productSelect.getPorcentajeIva();
        }
        price = productSelect.getPrice() + iva;

        tvStock.setText("" + productSelect.getStock());
        tvPrice.setText("" + df.format(price));
        final boolean isBoxesF = isBoxes;
        btnLessU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (units > 0) {
                    units--;
                    etUnits.setText("" + units);
                }
            }
        });
        btnMoreU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                units++;

                etUnits.setText("" + units);
            }
        });

        btnLessC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (boxes > 0) {
                    boxes--;
                    etBoxes.setText("" + boxes);
                }
            }
        });
        btnMoreC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boxes++;
                etBoxes.setText("" + boxes);
            }
        });

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                int units = getIntString(etUnits.getText().toString());
                int cant = 0;


                    if (isBoxesF) {
                        boxes = getIntString(etBoxes.getText().toString());
                        cant = boxes * productSelect.getUnidadesXCajas();
                    }

                    cant = cant + units;

               /* if (cant > productSelect.getStock()) {
                    showToastL(" Stock insuficiente ");
                } else */
            if(App.getValueOfPreferencesUser(App.KEY_USE_EQUIV).equalsIgnoreCase("S")) {
                if (units >= productSelect.getUnidadesXCajas()) {
                    if (productSelect.getUnidadesXCajas() != 1) {
                        Dialog.dialogo("ATENCION", "La Cantidad de Unidades Digitadas, Sobrepasan a la Cantidad de Unidades por Caja, TOTAL DE UNIDADES ESCOGIDAS = " + units + " ,TOTAL DE UNIDADES POR CAJA = " + productSelect.getUnidadesXCajas(), SearchProductActivity.this);
                        return;
                    }
                }
            }
                    if (cant < 1) {
                        showToastL(" Ingresa la cantidad de productos que quieres agregar ");

                    }else{

                        double percent = 0;
                        double value = getDoubleString(etValueDiscount.getText().toString());
                        if (value != 0) {
                            if (groupDiscount.getCheckedRadioButtonId() == R.id.dollar) {
                                percent = (100 * value) / (cant * productSelect.getPrice());
                            } else if (groupDiscount.getCheckedRadioButtonId() == R.id.percent) {
                                percent = value;
                            }
                        }

                        Intent intent = new Intent(getApplicationContext(), OrderProductsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        intent.putExtra("productId", productSelect.getId());
                        intent.putExtra("codigoExistencia",productSelect.getCodigoExistencia());

                        Log.e(""," " +productSelect.getCodigoExistencia());
                        intent.putExtra("boxes", boxes);
                        intent.putExtra("units", units);
                        intent.putExtra("cant", cant);
                        intent.putExtra("price", productSelect.getPrice());
                        intent.putExtra("discountP", percent);

                        startActivity(intent);
                    }

                }

        });


        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });


        alertDialog.setView(view);
        alertDialog.setCancelable(false);
        alertDialog.show();


    }

    private void visibleResults() {
        lvProducts.setVisibility(View.VISIBLE);
        lvFilters.setVisibility(View.GONE);
        tvMessage.setVisibility(View.GONE);
    }

    private void visibleFilters() {
        lvProducts.setVisibility(View.GONE);
        lvFilters.setVisibility(View.VISIBLE);
        tvMessage.setVisibility(View.GONE);
    }

    private void visibleMessage() {
        lvProducts.setVisibility(View.GONE);
        lvFilters.setVisibility(View.GONE);
        tvMessage.setVisibility(View.VISIBLE);
    }

    private void resultSearch(String text) {
        callProductsDB(text);
    }

    private void callProductsDB(String text) {

        boolean isNumber;
        int number = 0;
        try {
            number = new Integer(text);
            isNumber = true;
        } catch (Exception e) {
            isNumber = false;
        }
            /*System.out.println("DIVISION --> " +OrderClientActivity.account.getnDivision());
            System.out.println("VERSION --> " +OrderClientActivity.client.getVersion());
            System.out.println("GRUPO --> " + App.getValueOfPreferencesUser(App.KEY_PROMOTION_GROUP, 0));
            System.out.println("SUBGRUPO --> " +App.getValueOfPreferencesUser(App.KEY_PROMOTION_SUBGROUP, 0));
            System.out.println("ARTICULO --> " +App.getValueOfPreferencesUser(App.KEY_PROMOTION_ARTICLE, 0));*/


        if (isNumber) {
            products = realm.where(Product.class)
                    .equalTo("nDivision", OrderClientActivity.account.getnDivision())
                    .equalTo("version", OrderClientActivity.client.getVersion())
                    .notEqualTo("group", App.getValueOfPreferencesUser(App.KEY_PROMOTION_GROUP, 0))
                    .notEqualTo("subGroup", App.getValueOfPreferencesUser(App.KEY_PROMOTION_SUBGROUP, 0))
                    .notEqualTo("article", App.getValueOfPreferencesUser(App.KEY_PROMOTION_ARTICLE, 0))
                    .beginGroup()
                    .contains("name", text.toUpperCase(), Case.INSENSITIVE)
                    .or()
                    .equalTo("id", number)
                    .endGroup()
                    .findAll();
        } else {
            products = realm.where(Product.class)
                    .equalTo("nDivision", OrderClientActivity.account.getnDivision())
                    .equalTo("version", OrderClientActivity.client.getVersion())
                    .notEqualTo("group", App.getValueOfPreferencesUser(App.KEY_PROMOTION_GROUP, 0))
                    .notEqualTo("subGroup", App.getValueOfPreferencesUser(App.KEY_PROMOTION_SUBGROUP, 0))
                    .notEqualTo("article", App.getValueOfPreferencesUser(App.KEY_PROMOTION_ARTICLE, 0))
                    .contains("name", text.toUpperCase(), Case.INSENSITIVE)
                    .findAll();
        }

        if (products == null || products.isEmpty()) {
            visibleMessage();
        } else {
            adapter = null;
            adapter = new ProductAdapter(this, R.layout.item_product, products);
            lvProducts.setAdapter(adapter);
            visibleResults();
        }
    }

    private List<String> filter(String newText) {
        List<String> filtered = new ArrayList<>();
        for (String filter : filters) {
            if (filter.contains(newText.toLowerCase())) {
                filtered.add(filter);
            }
        }
        return filtered;
    }

    private void showToastL(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    private SupportMenuItem item;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        item = (SupportMenuItem) menu.findItem(R.id.search);
        searchView = (SearchView) item.getActionView();
        //SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

        /*MenuItemCompat.setOnActionExpandListener(item, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                return true;
            }
        });*/

        item.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        try {
            searchView.setQuery(query, false);
            setFilter(query.trim());

            resultSearch(query.trim());

        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        try {
            visibleFilters();
            filterAdapter.clear();
            filterAdapter.addAll(filter(newText));
            filterAdapter.notifyDataSetChanged();

        } catch (Exception e) {
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (realm != null) {
            realm.close();
        }
    }

}
