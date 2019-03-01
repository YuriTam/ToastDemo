package com.tasty.toast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.sdsmdg.tastytoast.ToastType;
import com.sdsmdg.tastytoast.ToastUtils;

/**
 * TOAST示例
 *
 * 其中，TASTY-TOAST部分来源于：https://github.com/yadav-rahul/TastyToast
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void showSuccessToast(View view) {
        ToastUtils.showTasty("Download Successful !", ToastType.SUCCESS);
    }

    public void showWarningToast(View view) {
        ToastUtils.showTasty("Are you sure ?", ToastType.WARNING);
    }

    public void showErrorToast(View view) {
        ToastUtils.showTasty("Downloading failed ! Try again later !", ToastType.ERROR);
    }

    public void showInfoToast(View view) {
        ToastUtils.showTasty("This is Info Toast !", ToastType.INFO);
    }

    public void showDefaultToast(View view) {
        ToastUtils.showTasty("This is Default Toast !", ToastType.DEFAULT);
    }

    public void showConfusingToast(View view) {
        ToastUtils.showTasty("I don't Know !", ToastType.CONFUSING);
    }

}
