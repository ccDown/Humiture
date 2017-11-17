package soul.listener.com.humiture.activity;

import com.orhanobut.logger.Logger;

import java.sql.SQLException;
import java.util.ArrayList;

import soul.listener.com.humiture.db.SQLCursor;
import soul.listener.com.humiture.model.BlocksModel;
import soul.listener.com.humiture.model.PartDataSelectionModel;
import soul.listener.com.humiture.model.SqlFactory;
import soul.listener.com.humiture.model.SqlInfoCallBack;
import soul.listener.com.humiture.model.SystemUserModel;
import soul.listener.com.humiture.mvp.BasePresenter;
import soul.listener.com.humiture.util.Constants;
import soul.listener.com.humiture.util.SqlStateCode;


/**
 * @description
 * Created by kuan on .
 */
class HomePresenter extends BasePresenter<HomeActivity> {
    HomePresenter(HomeActivity activity) {
        super(activity);
    }

    public void toLogV() {
        try {
            SQLCursor.getData(Constants.SYSUSER_TABLE_NO, new SqlInfoCallBack() {
                @Override
                public void Success(ArrayList<SqlFactory> sqlFactories) {
                    for (SqlFactory s : sqlFactories) {
                        Logger.e(((SystemUserModel) s).toString());
                    }
                }

                @Override
                public void Faild(int num) {
                    Logger.e("错误编码为=====" + num);
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void toLogD() {
        try {
            //设置查询条件
            PartDataSelectionModel model = new PartDataSelectionModel();
            model.setTableNameNo(Constants.BLOCKS_TABLE_NO);
            model.setParts(new String[]{"*"});
            model.setSelections(new String[]{Constants.BLOCK_ID});
            model.setHazyOrExact(new String[]{Constants.IS});
            model.setConditions(new String[]{"1"});
            model.setStartLimit(0);
            model.setEndLimit(10);

            SQLCursor.getPartDataBySelection(model, new SqlInfoCallBack() {
                        @Override
                        public void Success(ArrayList<SqlFactory> sqlFactories) {
                            for (SqlFactory s : sqlFactories) {
                                Logger.e(((BlocksModel) s).toString());
                            }
                        }

                        @Override
                        public void Faild(int num) {
                            Logger.e("错误编码为=====" + SqlStateCode.getSqlFaildInfo(num));
                        }
                    });
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
