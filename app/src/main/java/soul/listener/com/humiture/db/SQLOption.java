package soul.listener.com.humiture.db;

import soul.listener.com.humiture.manager.DBManager;

/**
 * @description 数据库操作类
 * @author kuan
 * Created 2017/10/24.
 */

public class SQLOption {
    private static SQLOption sqlOption;
    private SQLOption(){}

    public static SQLOption getSQLInstance(){
        if (sqlOption == null){
            synchronized(DBManager.class) {
                if (sqlOption == null) {
                    sqlOption = new SQLOption();
                }
            }
        }
        return sqlOption;
    }
}
