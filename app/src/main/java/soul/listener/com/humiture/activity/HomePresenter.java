package soul.listener.com.humiture.activity;

import com.orhanobut.logger.Logger;

import soul.listener.com.humiture.mvp.BasePresenter;


/**
 * @description Created by kuan on .
 */
class HomePresenter extends BasePresenter<HomeActivity> {
    HomePresenter(HomeActivity activity) {
        super(activity);
    }

    public void toLogV() {
        Logger.v("VVVV","asdasd","asdasd");
    }

    public void toLogD() {
        Logger.d("DDDD");
    }

    public void toLogI() {
        Logger.i("IIII");
    }

    public void toLogW() {
        Logger.w("WWWW");
    }

    public void toLogE() {
        Logger.e("EEEE");
    }
}
