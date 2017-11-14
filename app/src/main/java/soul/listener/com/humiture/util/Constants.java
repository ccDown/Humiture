package soul.listener.com.humiture.util;

/**
 * @description 常量类
 */
public class Constants {

    private Constants() {}
    // 打印日志开关
    public static final boolean DEBUG = true;

    //远程数据库账号
    public static final String SQLITEURL = "jdbc:mysql://120.24.52.34:3306/chicken_info";
    //远程数据库账号
    public static final String SQLITEUSER = "user";
    //远程数据库密码
    public static final String SQLITEPW = "";

    //默认 SharePreferences文件名.
    public static final String SHARED_PATH = "soul.listener.com.humiture";

    //数据库表名
    public static final String SYSUSER_TABLE = "sysuser_table";
    public static final String BLOCKS_TABLE = "blocks_table";
    public static final String RESIDENT_TABLE = "resident_table";
    public static final String LOG_TABLE = "log_table";
    public static final String TEMPERATURE_TABLE = "temperature_table";
}
