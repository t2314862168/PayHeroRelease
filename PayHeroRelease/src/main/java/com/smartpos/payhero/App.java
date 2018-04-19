package com.smartpos.payhero;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.bill99.smartpos.sdk.api.BillPayment;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.tencent.bugly.crashreport.CrashReport;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by xudong.zhang on 2017/6/5.
 * Email: xudong.zhang@99bill.com
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //start up sdk
        BillPayment.startUp(this);
        //设置支付SDK调试模式，建议开发版本设为true, 发布版本设为false。默认为false
        BillPayment.setDebugMode(true);


        initBugly();
        Logger.addLogAdapter(new AndroidLogAdapter());

//        //Bugly crash report
//        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(this);
//        strategy.setCrashHandleCallback(new CrashReport.CrashHandleCallback() {
//            @Override
//            public synchronized Map<String, String> onCrashHandleStart(int i, String s, String s1, String s2) {
//                // 退出程序
//                android.os.Process.killProcess(android.os.Process.myPid());
//                System.exit(0);
//
//                return super.onCrashHandleStart(i, s, s1, s2);
//            }
//
//        });
//        CrashReport.initCrashReport(getApplicationContext(), "d8e8b5fef7", true, strategy);
    }

    /**
     * 初始化Bugly
     */
    private void initBugly() {
        Context context = getApplicationContext();
        // 获取当前包名
        String packageName = context.getPackageName();
        // 获取当前进程名
        String processName = getProcessName(android.os.Process.myPid());
        // 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        // 初始化Bugly
        CrashReport.initCrashReport(context, "1a522f83c6", BuildConfig.DEBUG, strategy);
    }

    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    private String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}
