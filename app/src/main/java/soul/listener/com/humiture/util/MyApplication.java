package soul.listener.com.humiture.util;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.zhy.autolayout.config.AutoLayoutConifg;


/**
 * @author haidragon create at 2017-7-17
 * @description 获取整个应用的上下文
 */
public class MyApplication extends Application /*implements UncaughtExceptionHandler*/ {

    private static final String TAG = "MyApplication";
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        LOG.logI("--------------onCreate()");
        /**检测内存溢出*/
        initLeakCanary();
        /**初始化日志管理*/
        initLogger();
        AutoLayoutConifg.getInstance().useDeviceSize();
        initData();//初始化流水号
    }

    //初始化数据
    private void initData() {

    }

    /**检测内存溢出*/
    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    /**初始化日志管理*/
    private void initLogger() {
        if (Constants.DEBUG) {
            Logger.init().methodCount(0).hideThreadInfo().logLevel(LogLevel.FULL);
        } else {
            Logger.init().methodCount(0).hideThreadInfo().logLevel(LogLevel.NONE);
        }
    }

    public static Context getContext() {
        return mContext;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        //解决安卓5.0以下手机不能编译运行
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP
//                && BuildConfig.DEBUG) {
//            MultiDex.install(this);
//        }
    }

}
