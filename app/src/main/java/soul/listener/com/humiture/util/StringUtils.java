package soul.listener.com.humiture.util;

/**
 * @author kuan
 *         Created on 2017/11/16.
 * @description
 */

public class StringUtils {
    public static String dealTableName(int tableNo){
        String tableName = null;
        switch (tableNo){
            case Constants.SYSUSER_TABLE_NO:
                tableName = Constants.SYSUSER_TABLE;
                break;
            case Constants.BLOCKS_TABLE_NO:
                tableName = Constants.BLOCKS_TABLE;
                break;
            case Constants.RESIDENT_TABLE_NO:
                tableName = Constants.RESIDENT_TABLE;
                break;
            case Constants.LOG_TABLE_NO:
                tableName = Constants.LOG_TABLE;
                break;
            case Constants.TEMPERATURE_TABLE_NO:
                tableName = Constants.TEMPERATURE_TABLE;
                break;
            default:
                break;
        }
        return tableName;
    }
}
