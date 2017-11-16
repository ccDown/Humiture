package soul.listener.com.humiture.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import soul.listener.com.humiture.R;
import soul.listener.com.humiture.mvp.BaseMvpActivity;


/**
 * @description Created by kuan on .
 */
public class HomeActivity extends BaseMvpActivity<HomePresenter> implements HomeView {

    @BindView(R.id.log_v)
    Button logV;
    @BindView(R.id.log_d)
    Button logD;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

    }

    @OnClick({R.id.log_v, R.id.log_d})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.log_v:
                mPresenter.toLogV();
                break;
            case R.id.log_d:
                mPresenter.toLogD();

                break;
            default:
                break;
        }
    }
}