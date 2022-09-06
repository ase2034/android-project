//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ss.rtc.demo.quickstart;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;

public class Utilities {
    private static Context mAppCxt;

    private Utilities() {
    }

    public static void initApp(Context context) {
        mAppCxt = context.getApplicationContext();
    }

    public static Context getApplicationContext() {
        if (mAppCxt == null) {
            throw new IllegalStateException("Please init app at first!");
        } else {
            return mAppCxt;
        }
    }

    public static void silentClose(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException var2) {
            }
        }

    }
}
