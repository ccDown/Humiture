package soul.listener.com.humiture.activity;

import soul.listener.com.humiture.R;
import soul.listener.com.humiture.mvp.BaseMvpActivity;


/**
 * @description Created by kuan on .
 */
public class HomeActivity extends BaseMvpActivity<HomePresenter> implements HomeView {

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected void setView() {
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void initEvent() {

    }
}