package soul.listener.com.humiture.base;

/**
 * @description IBasePresenter
 * Created by kuan on 2017/7/31.
 */

public interface IBasePresenter<V extends Object> {
    void attachView(V view);
    void detachView();
}
