package com.mobile.polux.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by laptoplenovo on 26/1/2019.
 */

public class MoneyTextWatcher implements TextWatcher {

    private final WeakReference<EditText> editTextWeakReference;

    public MoneyTextWatcher(EditText editText) {
        editTextWeakReference = new WeakReference<EditText>(editText);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if(editTextWeakReference.get() == null){
            return;
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {
        try{

            if(editTextWeakReference.get() != null){
                EditText editText = editTextWeakReference.get();
                if (editText == null) return;
                String s = editable.toString();
                if (s.isEmpty()) return;
                editText.removeTextChangedListener(this);
                String cleanString = s.replaceAll("[$,.]", "");
                BigDecimal parsed = new BigDecimal(cleanString).setScale(2, BigDecimal.ROUND_FLOOR).divide(new BigDecimal(100), BigDecimal.ROUND_FLOOR);
                String formatted = NumberFormat.getCurrencyInstance(Locale.US).format(parsed);
                editText.setText(formatted);
                editText.setSelection(formatted.length());
                editText.addTextChangedListener(this);
            }

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}