package soul.listener.com.humiture.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import soul.listener.com.humiture.BuildConfig;
import soul.listener.com.humiture.R;
import soul.listener.com.humiture.manager.AppManager;
import soul.listener.com.humiture.mvp.IBaseView;
import soul.listener.com.humiture.view.CustomProgressDialog;


public class BaseActivity extends AppCompatActivity implements IBaseView {
    public Activity mActivity;
    private CustomProgressDialog mDialog;
    private Unbinder mUnbinder;
    public static final String EXTRA = "extra";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setView();

        //判断当前SDK版本号，如果是4.4以上，就是支持沉浸式状态栏的
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getApplicationContext().getResources().getColor(R.color.deepblue));
        }
        mActivity = this;
        mDialog = new CustomProgressDialog(this);
        mUnbinder = ButterKnife.bind(this);
        AppManager.getAppManager().addActivity(this);
        resetFragment(savedInstanceState);
        initView();
        initData();
        initEvent();
        // 设置状态栏字体的颜色
        //        setMiuiStatusBarDarkMode(this,true);
    }

    protected void setView() {
    }

    /**
     * 主界面异常重启时使用
     *
     * @param savedInstanceState
     */
    protected void resetFragment(Bundle savedInstanceState) {
    }

    protected void initView() {
    }

    protected void initEvent() {
    }

    protected void initData() {
    }

    public void startActivity(Class<?> cls) {
        Intent it = new Intent(this, cls);
        this.startActivity(it);
    }

    public void startActivityForResult(Class<?> cls, int reqCode) {
        Intent it = new Intent(this, cls);
        this.startActivityForResult(it, reqCode);
    }

    public void startActivityWithExtra(Class<?> cls, String data) {
        Intent it = new Intent(this, cls);
        it.putExtra(EXTRA, data);
        this.startActivity(it);
    }

    public void startActivityWithExtras(Class<?> cls, Bundle bundle) {
        Intent it = new Intent(this, cls);
        it.putExtras(bundle);
        this.startActivity(it);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!BuildConfig.DEBUG) {
//            MobclickAgent.onResume(this);//友盟
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (!BuildConfig.DEBUG) {
//            MobclickAgent.onPause(this);//友盟
        }
    }

    @Override
    protected void onDestroy() {
        mUnbinder.unbind();
        hideDialog();
        AppManager.getAppManager().finishActivity(this);
        super.onDestroy();
    }

    @Override
    public void showDialog() {
        if (mDialog != null && !mDialog.isShowing()) {
            mDialog.showDialog();
        }
    }

    @Override
    public void hideDialog() {
        mDialog.dismissDialog();
    }


    /**
     * 改变状态栏字体颜色 支持小米手机或者MIUI内核6.0+版本
     *
     * @param activity 本活动
     * @param darkmode true 改变字体为黑色
     */
    public static boolean setMiuiStatusBarDarkMode(Activity activity, boolean darkmode) {
        Class<? extends Window> clazz = activity.getWindow().getClass();
        try {
            int darkModeFlag = 0;
            Class<?> layoutParams = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            Field field = layoutParams.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
            darkModeFlag = field.getInt(layoutParams);
            Method extraFlagField = clazz.getMethod("setExtraFlags", int.class, int.class);
            extraFlagField.invoke(activity.getWindow(), darkmode ? darkModeFlag : 0, darkModeFlag);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}