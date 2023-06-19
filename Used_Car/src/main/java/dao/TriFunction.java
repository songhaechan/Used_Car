package dao;

import java.sql.SQLException;

/**
 * @param <C> Connection
 * @param <P> PreparedStatement
 * @param <R> ResultSet
 * @param <T> Optional<String>
 */
@FunctionalInterface
public interface TriFunction<C, P, R, T> {
    T prepare(C c, P p, R r) throws SQLException;
}
