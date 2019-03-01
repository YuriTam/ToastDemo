package com.sdsmdg.tastytoast;

import android.content.Context;
import android.widget.Toast;

/**
 * 提示工具类
 *
 * @author 谭忠扬-YuriTam
 * @Time 2017年8月3日
 */
public class ToastUtils {

    private static String oldMsg;
    private static Toast toast = null;
    private static Toast tasty = null;
    private static ToastType oldType = ToastType.INFO;
    private static long oneTime = 0;
    private static long twoTime = 0;
    private static Context mContext;

    public static void init(Context context) {
        mContext = context.getApplicationContext();
    }

    /************************** 原生的提示 *****************************/

    public static void showToast(int resId) {
        showToast(mContext.getString(resId));
    }

    public static void showToast(int resId, int gravity) {
        showToast(mContext.getString(resId), gravity, 0, 0);
    }

    public static void showToast(String msg, int gravity) {
        showToast(msg, gravity, 0, 0);
    }

    public static void showToast(int resId, int gravity, int offX, int offY) {
        showToast(mContext.getString(resId), gravity, offX, offY);
    }

    public static void showToast(String msg) {
        if (toast == null) {
            toast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
            toast.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (msg.equals(oldMsg)) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    toast.show();
                }
            } else {
                oldMsg = msg;
                toast.setText(msg);
                toast.show();
            }
        }
        oneTime = twoTime;
    }

    public static void showToast(String msg, int gravity, int offX, int offY) {
        if (toast == null) {
            toast = Toast.makeText(mContext, msg, Toast.LENGTH_SHORT);
            toast.setGravity(gravity, offX, offY);
            toast.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (msg.equals(oldMsg)) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    toast.show();
                }
            } else {
                oldMsg = msg;
                toast.setText(msg);
                toast.show();
            }
        }
        oneTime = twoTime;
    }

    /************************** 自定义的提示 *****************************/

    public static void showTasty(int resId, ToastType type) {
        showTasty(mContext.getString(resId), type);
    }

    public static void showTasty(int resId, int gravity, ToastType type) {
        showTasty(mContext.getString(resId), gravity, type, 0, 0);
    }

    public static void showTasty(String msg, int gravity, ToastType type) {
        showTasty(msg, gravity, type, 0, 0);
    }

    public static void showTasty(int resId, int gravity, ToastType type, int offX, int offY) {
        showTasty(mContext.getString(resId), gravity, type, offX, offY);
    }

    public static void showTasty(String msg, ToastType type) {
        if (tasty == null) {
            tasty = TastyToast.makeText(mContext, msg, Toast.LENGTH_SHORT, type);
            tasty.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (msg.equals(oldMsg) && type == oldType) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    tasty.show();
                }
            } else {
                oldMsg = msg;
                oldType = type;
                if (tasty != null) tasty.cancel();
                tasty = TastyToast.makeText(mContext, msg, Toast.LENGTH_SHORT, type);
                tasty.show();
            }
        }
        oneTime = twoTime;
    }

    public static void showTasty(String msg, int gravity, ToastType type, int offX, int offY) {
        if (tasty == null) {
            tasty = TastyToast.makeText(mContext, msg, Toast.LENGTH_SHORT, type);
            tasty.setGravity(gravity, offX, offY);
            tasty.show();
            oneTime = System.currentTimeMillis();
        } else {
            twoTime = System.currentTimeMillis();
            if (msg.equals(oldMsg) && type == oldType) {
                if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                    tasty.show();
                }
            } else {
                oldMsg = msg;
                oldType = type;
                if (tasty != null) tasty.cancel();
                tasty = TastyToast.makeText(mContext, msg, Toast.LENGTH_SHORT, type);
                tasty.show();
            }
        }
        oneTime = twoTime;
    }

}
