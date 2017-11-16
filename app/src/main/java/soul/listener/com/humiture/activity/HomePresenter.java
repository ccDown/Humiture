package soul.listener.com.humiture.activity;

import com.orhanobut.logger.Logger;

import java.sql.SQLException;
import java.util.ArrayList;

import soul.listener.com.humiture.db.SQLCursor;
import soul.listener.com.humiture.model.BlocksModel;
import soul.listener.com.humiture.model.SqlFactory;
import soul.listener.com.humiture.model.SystemUserModel;
import soul.listener.com.humiture.mvp.BasePresenter;
import soul.listener.com.humiture.util.Constants;


/**
 * @description Created by kuan on .
 */
class HomePresenter extends BasePresenter<HomeActivity> {
    HomePresenter(HomeActivity activity) {
        super(activity);
    }

    public void toLogV() {
        try {
            ArrayList<SqlFactory> sqlFactory = SQLCursor.getData(Constants.SYSUSER_TABLE_NO);
            for (SqlFactory s:sqlFactory) {
                Logger.e(((SystemUserModel)s).toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void toLogD()  {
        ArrayList<SqlFactory> sqlFactory = null;
        try {
            sqlFactory = SQLCursor.getPartDataBySelection(Constants.BLOCKS_TABLE_NO
                    ,new String[]{"*"}
                    ,new String[]{Constants.BLOCK_ID}
                    ,new String[]{Constants.IS}
                    ,new String[]{"1"}
                    ,0,10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (SqlFactory s:sqlFactory) {
            Logger.e(((BlocksModel)s).toString());
        }
    }

}
