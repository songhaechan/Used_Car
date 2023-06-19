package dao.user;

import dao.DaoFacotry;
import entity.User;

import java.sql.*;
import java.util.Optional;

/**
 * SELECT Query 는 Optional 을 이용
 * UPDATE, DELETE, INSERT 는 기본타입 사용
 */
public class UserDaoImpl {
    private UserDaoImpl() {
    }

    //TODO #9 05.26 static inner class JVM 로드시점 정리
    private static class UserDaoCreation {
        private static final UserDaoImpl INSTANCE = new UserDaoImpl();
    }

    public static UserDaoImpl getInstance() {
        return UserDaoCreation.INSTANCE;
    }

    private final DaoFacotry daoFactory = new DaoFacotry();

    /**
     * INSERT Query
     * SELECT Query
     * 회원가입
     */
    public Optional<String> addUser(User user) {
        return daoFactory.DaoTemplate(
                (con, ps, rs) -> {
                    // 회원정보 INSERT
                    String InsertQuery = " INSERT INTO users(login_id, login_pw, address,name, balance, registration_date, birth)VALUES (?, ?, ?, ?, ?, ?, ?);";
                    ps = con.prepareStatement(InsertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
                    ps.setString(1, user.getUserId());
                    ps.setString(2, user.getUserPassword());
                    ps.setString(3, user.getUserAddress());
                    ps.setString(4, user.getUserName());
                    ps.setInt(5, user.getUserBalance());
                    ps.setTimestamp(6, Timestamp.valueOf(user.getUserRegistration()));
                    ps.setString(7, user.getUserBirth());
                    ps.executeUpdate();
                    rs = ps.getGeneratedKeys();
                    rs.next();
                    int id = rs.getInt(1);
                    // 가입된 회원이름 반환
                    String SelectQuery = "SELECT NAME FROM users WHERE USER_ID = ?;";
                    ps = con.prepareStatement(SelectQuery);
                    ps.setString(1, String.valueOf(id));
                    ps.execute();
                    rs = ps.getResultSet();
                    rs.next();
                    Optional<String> result = Optional.ofNullable(rs.getString("NAME"));
                    daoFactory.closeResources(con, ps, rs);
                    return result;
                }
        );
    }

    /**
     * SELECT Query
     * 중복 ID 검증
     */
    public Optional<String> findByUserId(String userId) {
        return daoFactory.DaoTemplate(
                (con, ps, rs) -> {
                    String sql = "SELECT LOGIN_ID FROM users WHERE LOGIN_ID = ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, userId);
                    ps.execute();
                    rs = ps.getResultSet();
                    String result = null;
                    if(rs.next()){
                        result = rs.getString("LOGIN_ID");
                    }
                    daoFactory.closeResources(con, ps, rs);
                    if(result == null)
                        return Optional.of("success");
                    else
                        return Optional.empty();
                }
        );
    }

    /**
     * SELECT Query
     * 회원 로그인
     */
    public Optional<String> findByUserIdAndPassword(String loginId, String loginPassWord) {
        return daoFactory.DaoTemplate(
                (con, ps, rs) -> {
                    String sql = "SELECT NAME FROM users WHERE LOGIN_ID = ? AND LOGIN_PW = ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, loginId);
                    ps.setString(2, loginPassWord);
                    ps.execute();
                    rs = ps.getResultSet();
                    Optional<String> result = Optional.empty();
                    if(rs.next()){
                        result = Optional.ofNullable(rs.getString("NAME"));
                    }
                    daoFactory.closeResources(con, ps, rs);
                    return result;
                }
        );
    }

    /**
     * DELETE Query
     * 회원 탈퇴
     */
    public Optional<String> deleteUser(String loginId, String loginPassword){
        return daoFactory.DaoTemplate(
                (con,ps,rs)->{
                    String sql = "DELETE FROM users WHERE LOGIN_ID = ? AND LOGIN_PW = ?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, loginId);
                    ps.setString(2, loginPassword);
                    int result = ps.executeUpdate();
                    daoFactory.closeResources(con, ps, rs);
                    // 결과가 1이면 삭제 성공, ID 반환
                    if(result != 0){
                        return Optional.of(loginId);
                    }else {
                        return Optional.empty();
                    }
                }
        );
    }
}
