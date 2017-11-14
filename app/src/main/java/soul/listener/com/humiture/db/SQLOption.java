package soul.listener.com.humiture.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import soul.listener.com.humiture.manager.DBManager;
import soul.listener.com.humiture.util.Constants;

/**
 * @description 数据库操作类
 * @author kuan
 * Created 2017/10/24.
 */

public class SQLOption {

    private static SQLOption sqlOption;
    private static Connection connection ;
    private SQLOption(){}

    /**
     *
     * 单例
     * 获取实例
     * @return
     */
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

    /**
     *
     * 开始连接
     * @return
     * @throws SQLException
     */
    public static SQLCursor getConnection() throws SQLException {
        if (connection == null){
            synchronized (DBManager.class){
                if (connection == null){
                    connection = DriverManager.getConnection(Constants.SQLITEURL,Constants.SQLITEUSER,Constants.SQLITEPW);
                }
            }
        }
        return new SQLCursor(connection);
    }

}
