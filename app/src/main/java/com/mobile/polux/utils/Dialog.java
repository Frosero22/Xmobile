package com.mobile.polux.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.mobile.polux.R;

/**
 * Created by laptoplenovo on 2/9/2018.
 */

public class Dialog {

    public void showDialog(String title, String message, Context context){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("ACEPTAR",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }


    public static void dialogo(String title, String message, Context context){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setIcon(R.drawable.error);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("ACEPTAR",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        alertDialog.setCancelable(false);

    }

    public static void recordatorio(String title, String message, Context context){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setIcon(R.drawable.campana);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("ACEPTAR",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        alertDialog.setCancelable(false);

    }

    public static void confirmacion(String title,String message,Context context){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(title);
        alertDialogBuilder.setIcon(R.drawable.correcto);
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("ACEPTAR",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        alertDialog.setCancelable(false);
    }



}
