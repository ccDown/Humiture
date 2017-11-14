package soul.listener.com.humiture.db;

import com.mysql.jdbc.Statement;
import com.orhanobut.logger.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author kuan
 *         Created on 2017/11/14.
 * @description
 */

public class SQLCursor {
    private  Connection connection;
    public SQLCursor(Connection connection) {
        this.connection = connection;
    }
    /**
     *
     * 返回全部数据
     * @param tableName
     * @param serchContent
     * @param startlimit
     * @param endlimit
     * @return resultSet
     * @throws SQLException
     */
    public  ResultSet getData(String tableName, String serchContent, int startlimit, int endlimit) throws SQLException {
        Statement statement = (Statement) connection.createStatement();
        String sqlMessage = "Select * From " + tableName + " Where title like '%" + serchContent + "%' limit " + startlimit + " ," + endlimit;
        Logger.e("getData========"+sqlMessage);
        ResultSet resultSet = statement.executeQuery(sqlMessage);
        return resultSet;
    }

    /**
     *
     * 返回部分数据
     * @param tableName
     * @param parts
     * @param startlimit
     * @param endlimit
     * @return resultSet
     * @throws SQLException
     */

    public  ResultSet getPartData(String tableName,String[] parts,int startlimit,int endlimit ) throws SQLException {
        Statement statement = (Statement) connection.createStatement();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < parts.length ; i++){
            if (i != parts.length) {
                stringBuilder.append(parts + ",");
            }else{
                stringBuilder.append(parts);
            }
        }
        String sqlMessage = "Select "+stringBuilder.toString()+" From " + tableName + " limit " + startlimit + " ," + endlimit;
        Logger.e("getPartData========"+sqlMessage);
        ResultSet resultSet = statement.executeQuery(sqlMessage);
        return resultSet;
    }

    /**
     * 根据条件查询部分数据
     * @param tableName
     * @param parts
     * @param selections
     * @param conditions
     * @param startlimit
     * @param endlimit
     * @return resultSet
     * @throws SQLException
     */
    public  ResultSet getPartDataBySelection(String tableName,String[] parts,String[] selections,String[] conditions,int startlimit,int endlimit) throws SQLException {
        Statement statement = (Statement) connection.createStatement();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < parts.length ; i++){
            if (i == 0) {
                stringBuilder.append(parts[i]);
            }else{
                stringBuilder.append(","+parts[i]);
            }
        }
        String part = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("Select "+part+" From " + tableName +"Where ");
        for (int i = 0 ;i < selections.length;i++){
            if (i == 0) {
                stringBuilder.append(selections[i] + " = '" + conditions[i] + "'");
            }else{
                stringBuilder.append("and "+selections[i] + " = '" + conditions[i] + "'");
            }
        }
        stringBuilder.append(" limit " + startlimit + " ," + endlimit);
        String sqlMessage = stringBuilder.toString();
        Logger.e("getPartDataBySelection========"+sqlMessage);
        ResultSet resultSet = statement.executeQuery(sqlMessage);
        return resultSet;
    }
}
