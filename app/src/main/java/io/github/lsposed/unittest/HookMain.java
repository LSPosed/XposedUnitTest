package io.github.lsposed.unittest;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.util.TreeMap;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class HookMain implements IXposedHookLoadPackage {
    static {
        System.loadLibrary("lsposed_module");
    }

    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals("io.github.lsposed.unittest")) {
            XposedBridge.log("Injecting into self...");

            Class clazz = Class.forName("io.github.lsposed.unittest.Methods", false, lpparam.classLoader);
            XposedBridge.hookAllMethods(clazz,"staticTest", new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    int param1 = (int)param.args[0];
                    param.setResult(param1 + 2);
                }
            });

            XposedBridge.log("done");
        }
    }
}
