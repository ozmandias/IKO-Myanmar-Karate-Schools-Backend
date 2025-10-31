package com.james.IKO_Myanmar.repository;

import com.james.IKO_Myanmar.type.UserGender;
import org.springframework.stereotype.Component;
import com.james.IKO_Myanmar.model.User;
import com.james.IKO_Myanmar.type.ProfileType;
import com.james.IKO_Myanmar.type.UserStatus;
import com.james.IKO_Myanmar.type.UserType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserSQLRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserSQLRepository(JdbcTemplate jdbcTemplateDependency) {
        this.jdbcTemplate = jdbcTemplateDependency;
    }

    public User create(User userData) {
        String sql = "";

        User user = null;
        try {
            sql =
                    "INSERT INTO " +
                            "users(username, full_name, email, password, phone, " +
                            "address, gender, rank_id, nrc_number, international_card, user_type, " +
                            "profile_type, status, create_date) " +
                            "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            boolean create_success = jdbcTemplate.execute(
                    sql,
                    (PreparedStatementCallback<Boolean>) (statement) -> {
                        statement.setString(1, userData.username);
                        statement.setString(2, userData.full_name);
                        statement.setString(3, userData.email);
                        statement.setString(4, userData.password);
                        statement.setString(5, userData.phone);
                        statement.setString(6, userData.address);
                        statement.setString(7, userData.gender.toString());
                        statement.setInt(7, userData.rank_id);
                        statement.setString(8, userData.nrc_number);
                        statement.setString(9, userData.international_card);
                        statement.setString(10, userData.user_type.toString());
                        statement.setString(11, userData.profile_type.toString());
                        statement.setString(12, userData.status.toString());
                        statement.setTimestamp(13, java.sql.Timestamp.valueOf(LocalDateTime.now()));

                        int rowCount = statement.executeUpdate();
                        if (rowCount > 0) {
                            return true;
                        }
                        return false;
                    }
            );

            if (create_success) {
                sql =
                        "SELECT " +
                                "id, username, full_name, email, password, " +
                                "phone, address, gender, rank_id, nrc_number, international_card, " +
                                "user_type, profile_type, status, create_date, " +
                                "update_date " +
                                "FROM users " +
                                "ORDER BY id DESC " +
                                "LIMIT 1;";

                user = jdbcTemplate.execute(
                        sql,
                        (PreparedStatementCallback<User>) (statement) -> {
                            ResultSet resultSet = statement.executeQuery();
                            if (resultSet.next()) {
                                return new User(
                                        resultSet.getInt("id"),
                                        resultSet.getString("username"),
                                        resultSet.getString("full_name"),
                                        resultSet.getString("email"),
                                        resultSet.getString("password"),
                                        resultSet.getString("phone"),
                                        resultSet.getString("address"),
                                        UserGender.valueOf(resultSet.getString("gender")),
                                        resultSet.getInt("rank_id"),
                                        resultSet.getString("nrc_number"),
                                        resultSet.getString("international_card"),
                                        UserType.valueOf(resultSet.getString("user_type")),
                                        ProfileType.valueOf(resultSet.getString("profile_type")),
                                        UserStatus.valueOf(resultSet.getString("status")),
                                        resultSet.getTimestamp("create_date") != null ? resultSet.getTimestamp("create_date").toLocalDateTime() : null,
                                        resultSet.getTimestamp("update_date") != null ? resultSet.getTimestamp("update_date").toLocalDateTime() : null
                                );
                            }
                            return null;
                        }
                );
            }
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    public List<User> getAll() {
        String sql = "";

        List<User> users = null;
        try {
            sql =
                    "SELECT " +
                            "id, username, full_name, email, password, " +
                            "phone, address, gender, rank_id, nrc_number, international_card, " +
                            "user_type, profile_type, status, create_date, " +
                            "update_date " +
                            "FROM users " +
                            "ORDER BY id ASC " +
                            "LIMIT 100;";

            users = jdbcTemplate.execute(
                    sql,
                    (PreparedStatementCallback<List<User>>) (statement) -> {
                        List<User> userList = new ArrayList<>();

                        ResultSet resultSet = statement.executeQuery();
                        while (resultSet.next()) {
                            userList.add(
                                    new User(
                                            resultSet.getInt("id"),
                                            resultSet.getString("username"),
                                            resultSet.getString("full_name"),
                                            resultSet.getString("email"),
                                            resultSet.getString("password"),
                                            resultSet.getString("phone"),
                                            resultSet.getString("address"),
                                            UserGender.valueOf(resultSet.getString("gender")),
                                            resultSet.getInt("rank_id"),
                                            resultSet.getString("nrc_number"),
                                            resultSet.getString("international_card"),
                                            UserType.valueOf(resultSet.getString("user_type")),
                                            ProfileType.valueOf(resultSet.getString("profile_type")),
                                            UserStatus.valueOf(resultSet.getString("status")),
                                            resultSet.getTimestamp("create_date") != null ? resultSet.getTimestamp("create_date").toLocalDateTime() : null,
                                            resultSet.getTimestamp("update_date") != null ? resultSet.getTimestamp("update_date").toLocalDateTime() : null
                                    )
                            );
                        }
                        return userList;
                    }
            );
        } catch (Exception e) {
            users = null;
        }
        return users;
    }

    public User getById(Long id) {
        String sql = "";

        User user = null;
        try {
            sql =
                    "SELECT " +
                            "id, username, full_name, email, password, " +
                            "phone, address, gender, rank_id, nrc_number, international_card, " +
                            "user_type, profile_type, status, create_date, " +
                            "update_date " +
                            "FROM users " +
                            "WHERE id=?;";

            user = jdbcTemplate.execute(
                    sql,
                    (PreparedStatementCallback<User>) (statement) -> {
                        statement.setLong(1, id);

                        ResultSet resultSet = statement.executeQuery();
                        if (resultSet.next()) {
                            return new User(
                                    resultSet.getInt("id"),
                                    resultSet.getString("username"),
                                    resultSet.getString("full_name"),
                                    resultSet.getString("email"),
                                    resultSet.getString("password"),
                                    resultSet.getString("phone"),
                                    resultSet.getString("address"),
                                    UserGender.valueOf(resultSet.getString("gender")),
                                    resultSet.getInt("rank_id"),
                                    resultSet.getString("nrc_number"),
                                    resultSet.getString("international_card"),
                                    UserType.valueOf(resultSet.getString("user_type")),
                                    ProfileType.valueOf(resultSet.getString("profile_type")),
                                    UserStatus.valueOf(resultSet.getString("status")),
                                    resultSet.getTimestamp("create_date") != null ? resultSet.getTimestamp("create_date").toLocalDateTime() : null,
                                    resultSet.getTimestamp("update_date") != null ? resultSet.getTimestamp("update_date").toLocalDateTime() : null
                            );
                        }
                        return null;
                    }
            );
        } catch (Exception e) {
            user = null;
        }
        return user;
    }

    public User update(Long id, User userData) {
        String sql = "";

        User user = null;
        try {
            sql =
                    "UPDATE users SET " +
                            "username=?, full_name=?, email=?, password=?, phone=?, " +
                            "address=?, gender=?, rank_id=?, nrc_number=?, international_card=?, " +
                            "user_type=?, profile_type=?, status=?, update_date=? " +
                            "WHERE id=?;";

            boolean update_success = jdbcTemplate.execute(
                    sql,
                    (PreparedStatementCallback<Boolean>) (statement) -> {
                        statement.setString(1, userData.username);
                        statement.setString(2, userData.full_name);
                        statement.setString(3, userData.email);
                        statement.setString(4, userData.password);
                        statement.setString(5, userData.phone);
                        statement.setString(6, userData.address);
                        statement.setString(7, userData.gender.toString());
                        statement.setInt(8, userData.rank_id);
                        statement.setString(9, userData.nrc_number);
                        statement.setString(10, userData.international_card);
                        statement.setString(11, userData.user_type.toString());
                        statement.setString(12, userData.profile_type.toString());
                        statement.setString(13, userData.status.toString());
                        statement.setTimestamp(14, Timestamp.valueOf(LocalDateTime.now()));
                        statement.setLong(15, id);

                        int rowCount = statement.executeUpdate();
                        if (rowCount > 0) {
                            return true;
                        }
                        return false;
                    }
            );

            if (update_success) {
                sql =
                        "SELECT " +
                                "id, username, full_name, email, password, " +
                                "phone, address, gender, rank_id, nrc_number, international_card, " +
                                "user_type, profile_type, status, create_date, " +
                                "update_date " +
                                "FROM users " +
                                "WHERE id=?;";

                user = jdbcTemplate.execute(
                        sql,
                        (PreparedStatementCallback<User>) (statement) -> {
                            statement.setLong(1, id);

                            ResultSet resultSet = statement.executeQuery();
                            if (resultSet.next()) {
                                return new User(
                                        resultSet.getInt("id"),
                                        resultSet.getString("username"),
                                        resultSet.getString("full_name"),
                                        resultSet.getString("email"),
                                        resultSet.getString("password"),
                                        resultSet.getString("phone"),
                                        resultSet.getString("address"),
                                        UserGender.valueOf(resultSet.getString("gender")),
                                        resultSet.getInt("rank_id"),
                                        resultSet.getString("nrc_number"),
                                        resultSet.getString("international_card"),
                                        UserType.valueOf(resultSet.getString("user_type")),
                                        ProfileType.valueOf(resultSet.getString("profile_type")),
                                        UserStatus.valueOf(resultSet.getString("status")),
                                        resultSet.getTimestamp("create_date") != null ? resultSet.getTimestamp("create_date").toLocalDateTime() : null,
                                        resultSet.getTimestamp("update_date") != null ? resultSet.getTimestamp("update_date").toLocalDateTime() : null
                                );
                            }
                            return null;
                        }
                );
            }
        } catch (Exception e) {
            user = null;
        }


        return user;
    }

    public boolean delete(Long id) {
        String sql = "";

        boolean delete_success = false;
        try {
            sql =
                    "DELETE FROM users " +
                            "WHERE id=?";

            delete_success = jdbcTemplate.execute(
                    sql,
                    (PreparedStatementCallback<Boolean>) (statement) -> {
                        statement.setLong(1, id);

                        int rowCount = statement.executeUpdate();
                        if (rowCount > 0) {
                            return true;
                        }
                        return false;
                    }
            );
        } catch (Exception e) {
            delete_success = false;
        }
        return delete_success;
    }
}