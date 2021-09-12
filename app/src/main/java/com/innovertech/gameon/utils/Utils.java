package com.innovertech.gameon.utils;

import android.graphics.Color;
import android.view.View;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class Utils {

    public static void showSnackBar(View view, String msg) {
        Snackbar.make(view, msg, BaseTransientBottomBar.LENGTH_LONG).setActionTextColor(Color.RED).show();
    }
}
