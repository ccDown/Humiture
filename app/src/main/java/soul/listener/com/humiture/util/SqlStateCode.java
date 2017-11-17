package soul.listener.com.humiture.util;

/**
 * @author kuan
 *         Created on 2017/11/17.
 * @description
 */

public class SqlStateCode {
    public static final int STSTE_NODATA = 0;

    public static String getSqlFaildInfo(int num) {
        String sqlFaildInfo = null;
        switch (num) {
            case STSTE_NODATA:
                sqlFaildInfo = "没有该数据";
                break;
            default:
                break;
        }
        return sqlFaildInfo;
    }
}
