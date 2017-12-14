package com.example.java8stream.toast;

import android.content.Context;
import android.widget.Toast;

import com.example.java8stream.MyApplication;

/**
 * Created by admin on 2017/12/13.
 */

public class ToastUtils {

    private static Toast toast;

    public static void showToast(Object msg){
        if(toast==null){
            toast=Toast.makeText(MyApplication.getContext() ,msg.toString(),Toast.LENGTH_SHORT);
        }else {
            toast.setText(msg.toString());
        }
        toast.show();
    }


}
