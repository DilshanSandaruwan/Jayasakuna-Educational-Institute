package lk.ijse.Jayasakuna.dao.custom.impl.util;

import lk.ijse.Jayasakuna.db.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUtil {
    public static <T>T execute(String sql,Object... args) throws SQLException, ClassNotFoundException {
        Connection connection = DBconnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pstm.setObject((i+1),args[i]);
        }
        if (sql.startsWith("SELECT") || sql.startsWith("select")){
            return (T) pstm.executeQuery();
        }else{
            return (T)  new Boolean(pstm.executeUpdate()>0);
        }
    }
}
