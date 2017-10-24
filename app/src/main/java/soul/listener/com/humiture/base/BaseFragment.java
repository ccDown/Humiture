package soul.listener.com.humiture.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @description BaseFragment
 * Created by kuan on 2017/7/31.
 */

public abstract class BaseFragment extends Fragment {
    protected View mView;
    public abstract void initView();
    public abstract void initData();
    public abstract void initAction();
    public abstract int setLayout();
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            mView = inflater.inflate(setLayout(),null);
            initView();
            initData();
            initAction();
            return mView;
        }

}
