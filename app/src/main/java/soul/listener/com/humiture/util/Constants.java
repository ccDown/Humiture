package soul.listener.com.humiture.util;

/**
 * @description 常量类
 */
public class Constants {

    private Constants() {}
    // 打印日志开关
    public static final boolean DEBUG = true;

    //远程数据库账号
    public static final String SQLITEURL = "jdbc:mysql://120.24.52.34:3306/housetem";
    //远程数据库账号
    public static final String SQLITEUSER = "user";
    //远程数据库密码
    public static final String SQLITEPW = "";

    //默认 SharePreferences文件名
    public static final String SHARED_PATH = "soul.listener.com.humiture";

    public static final String LIKE = " like ";
    public static final String IS = " = ";

    //数据库列表序号
    public static final int SYSUSER_TABLE_NO = 1;
    public static final int BLOCKS_TABLE_NO = 2;
    public static final int RESIDENT_TABLE_NO = 3;
    public static final int LOG_TABLE_NO = 4;
    public static final int TEMPERATURE_TABLE_NO = 5;
    //数据库表名
    public static final String SYSUSER_TABLE = "sysuser_table";
    public static final String BLOCKS_TABLE = "blocks_table";
    public static final String RESIDENT_TABLE = "resident_table";
    public static final String LOG_TABLE = "log_table";
    public static final String TEMPERATURE_TABLE = "temperature_table";
    //sysuser_table列名
    public static final String SYSUSER_ID = "id";
    public static final String SYSUSER_USERID = "userid";
    public static final String SYSUSER_USERNAME = "username";
    public static final String SYSUSER_PASSWORD = "userpassword";
    public static final String SYSUSER_USERPRIVILEGES = "userpPrivileges";
    public static final String SYSUSER_USERTYPE = "userType";
    public static final String SYSUSER_USERMAIL = "userMail";
    public static final String SYSUSER_USERTEL = "userTel";
    //block 列名
    public static final String BLOCK_ID = "blocksID";
    public static final String BLOCK_NAME = "blocksName";
    public static final String BLOCK_LOACTION = "blocksLocation";
    public static final String BLOCK_CONTACT = "blocksContact";
    public static final String BLOCK_CONTACETEL = "blocksContaceTel";



}
