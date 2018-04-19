package com.smartpos.payhero.txb.tools;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by tangxuebing on 2018/4/19.
 */

public class ToastTools {
    public static void showStrByShort(Context context, String str) {
        Toast.makeText(context.getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }
}
