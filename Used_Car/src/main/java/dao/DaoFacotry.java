package dao;

import java.sql.*;
import java.util.Optional;

public class DaoFacotry {
    //MySQL URL
    private final String dbUrl = "jdbc:mysql://localhost:3306/used_car?useSSL=false";
    // Id
    private final String dbName = "root";
    // Pw
    private final String dbPassword = "At7x23112560!";

    //Select query template
    public Optional<String> DaoTemplate(TriFunction<Connection, PreparedStatement, ResultSet, Optional<String>> select) {
        Connection con = loadConnection();
        Optional<String> result = Optional.empty();
        try {
            result = select.prepare(con, null, null);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("파라미터 세팅 오류");
        }
        return result;
    }

    //DB Connection load
    public Connection loadConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(dbUrl, dbName
                    , dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DB Connection loading 오류");
        }
        return con;
    }

    // DB관련 리소스 닫기
    public void closeResources(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("리소스 닫기 오류");
        }
    }
}
