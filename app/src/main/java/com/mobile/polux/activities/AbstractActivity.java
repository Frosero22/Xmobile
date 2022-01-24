package com.mobile.polux.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class AbstractActivity extends AppCompatActivity {

    private ProgressDialog progress;

    protected void showProgressDialog(String message) {
        progress = new ProgressDialog(this);
        progress.setMessage(message);
        progress.setCancelable(false);
        progress.show();
    }



    protected void closeProgressDialog() {
        progress.dismiss();
    }

    protected int getIntString(String text) {
        try {
            if (text.isEmpty()) {
                return 0;
            } else {
                return Integer.valueOf("" + text);
            }
        } catch (Exception e) {
            return 0;
        }
    }

    protected double getDoubleString(String text) {
        try {
            if (text.isEmpty()) {
                return 0;
            } else {
                return Double.valueOf("" + text);
            }
        } catch (Exception e) {
            return 0;
        }
    }

    protected void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }


}
