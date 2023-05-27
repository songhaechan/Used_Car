package dao;

import entity.User;

import java.sql.*;

public class UserDao {
    private UserDao(){}

    //TODO #9 05.26 static inner class JVM 로드시점 정리
    //DB Connection 은 리소스가 크기때문에 Singleton 으로 구현
    private static class UserDaoCreation{
        private static final UserDao INSTANCE = new UserDao();
    }
    public static UserDao userDaoGetInstance(){
        return UserDaoCreation.INSTANCE;
    }

    public Long addUser(User user) {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DbConfig.dbUrl,DbConfig.dbName
                    ,DbConfig.dbPassword);
        }catch(SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        PreparedStatement ps = null;
        ResultSet rs = null;
        Long resultId = null;
        String sql = " INSERT INTO user(login_id, login_pw, address,name, balance, registration_date, birth)VALUES (?, ?, ?, ?, ?, ?, ?);";
        try{
            ps = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUserId());
            ps.setString(2, user.getUserPassword());
            ps.setString(3,user.getUserAddress());
            ps.setString(4, user.getUserName());
            ps.setInt(5,user.getUserBalance());
            ps.setTimestamp(6, Timestamp.valueOf(user.getUserRegistration()));
            ps.setString(7,user.getUserBirth());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            resultId = rs.getLong(1);
        }catch(SQLException e){
            System.out.println("PreparedStatement Failed");
            e.printStackTrace();
        }
        try{
            rs.close();
            ps.close();
            conn.close();
        }catch(SQLException e){
            System.out.println("Connection close Failed");
            e.printStackTrace();
        }
        return resultId;
    }
}
