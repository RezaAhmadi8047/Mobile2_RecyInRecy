package com.example.recyinrecy;

import android.app.AlertDialog;
import android.content.Context;

public class ListDialog {

    private final Context context;
    private final InterfaceNumber listener;

    public ListDialog(Context context, InterfaceNumber listener) {
        this.context = context;
        this.listener = listener;
    }

    public void showDialog() {
        // نمایش اعداد 1 تا 10
        String[] items = {"1","2","3","4","5","6","7","8","9","10"};

        new AlertDialog.Builder(context)
                .setTitle("یک عدد انتخاب کن")
                .setItems(items, (dialog, which) -> {
                    String selected = items[which];
                    listener.onItemClicked(selected); // ارسال عدد انتخاب شده به Activity
                })
                .show();
    }
}