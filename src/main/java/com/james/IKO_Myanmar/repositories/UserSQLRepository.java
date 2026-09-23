package com.james.IKO_Myanmar.repositories;

import com.james.IKO_Myanmar.enums.Gender;
import com.james.IKO_Myanmar.enums.Status;
import com.james.IKO_Myanmar.enums.Type;
import org.springframework.stereotype.Component;
import com.james.IKO_Myanmar.models.User;
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

            // sql for awards

            boolean create_success = jdbcTemplate.execute(
                    sql,
                    (PreparedStatementCallback<Boolean>) (statement) -> {
                        statement.setString(1, userData.getUsername());
                        statement.setString(2, userData.getFullName());
                        statement.setString(3, userData.getEmail());
                        statement.setString(4, userData.getPassword());
                        statement.setString(5, userData.getPhone());
                        statement.setString(6, userData.getAddress());
                        statement.setString(7, userData.getGender().toString());
                        statement.setInt(7, userData.getRankId());
                        statement.setString(8, userData.getNrcNumber());
                        statement.setString(9, userData.getInternationalCard());
                        statement.setString(10, userData.getUserType().toString());
                        statement.setString(11, userData.getProfileType().toString());
                        statement.setString(12, userData.getStatus().toString());
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

                // sql for awards

                user = jdbcTemplate.execute(
                        sql,
                        (PreparedStatementCallback<User>) (statement) -> {
                            ResultSet resultSet = statement.executeQuery();
                            if (resultSet.next()) {
                                return new User(
                                        resultSet.getLong("id"),
                                        resultSet.getString("username"),
                                        resultSet.getString("full_name"),
                                        resultSet.getString("email"),
                                        resultSet.getString("password"),
                                        resultSet.getString("phone"),
                                        resultSet.getString("address"),
                                        Gender.valueOf(resultSet.getString("gender")),
                                        null,
                                        null,
                                        resultSet.getInt("rank_id"),
                                        resultSet.getString("nrc_number"),
                                        resultSet.getString("international_card"),
                                        Type.valueOf(resultSet.getString("user_type")),
                                        Type.valueOf(resultSet.getString("profile_type")),
                                        Status.valueOf(resultSet.getString("status")),
                                        new ArrayList<>(),
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

            // sql for awards

            users = jdbcTemplate.execute(
                    sql,
                    (PreparedStatementCallback<List<User>>) (statement) -> {
                        List<User> userList = new ArrayList<>();

                        ResultSet resultSet = statement.executeQuery();
                        while (resultSet.next()) {
                            userList.add(
                                    new User(
                                            resultSet.getLong("id"),
                                            resultSet.getString("username"),
                                            resultSet.getString("full_name"),
                                            resultSet.getString("email"),
                                            resultSet.getString("password"),
                                            resultSet.getString("phone"),
                                            resultSet.getString("address"),
                                            Gender.valueOf(resultSet.getString("gender")),
                                            null,
                                            null,
                                            resultSet.getInt("rank_id"),
                                            resultSet.getString("nrc_number"),
                                            resultSet.getString("international_card"),
                                            Type.valueOf(resultSet.getString("user_type")),
                                            Type.valueOf(resultSet.getString("profile_type")),
                                            Status.valueOf(resultSet.getString("status")),
                                            new ArrayList<>(),
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

            // sql for awards

            user = jdbcTemplate.execute(
                    sql,
                    (PreparedStatementCallback<User>) (statement) -> {
                        statement.setLong(1, id);

                        ResultSet resultSet = statement.executeQuery();
                        if (resultSet.next()) {
                            return new User(
                                    resultSet.getLong("id"),
                                    resultSet.getString("username"),
                                    resultSet.getString("full_name"),
                                    resultSet.getString("email"),
                                    resultSet.getString("password"),
                                    resultSet.getString("phone"),
                                    resultSet.getString("address"),
                                    Gender.valueOf(resultSet.getString("gender")),
                                    null,
                                    null,
                                    resultSet.getInt("rank_id"),
                                    resultSet.getString("nrc_number"),
                                    resultSet.getString("international_card"),
                                    Type.valueOf(resultSet.getString("user_type")),
                                    Type.valueOf(resultSet.getString("profile_type")),
                                    Status.valueOf(resultSet.getString("status")),
                                    new ArrayList<>(),
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

            // sql for awards

            boolean update_success = jdbcTemplate.execute(
                    sql,
                    (PreparedStatementCallback<Boolean>) (statement) -> {
                        statement.setString(1, userData.getUsername());
                        statement.setString(2, userData.getFullName());
                        statement.setString(3, userData.getEmail());
                        statement.setString(4, userData.getPassword());
                        statement.setString(5, userData.getPhone());
                        statement.setString(6, userData.getAddress());
                        statement.setString(7, userData.getGender().toString());
                        statement.setInt(8, userData.getRankId());
                        statement.setString(9, userData.getNrcNumber());
                        statement.setString(10, userData.getInternationalCard());
                        statement.setString(11, userData.getUserType().toString());
                        statement.setString(12, userData.getProfileType().toString());
                        statement.setString(13, userData.getStatus().toString());
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

                // sql for awards

                user = jdbcTemplate.execute(
                        sql,
                        (PreparedStatementCallback<User>) (statement) -> {
                            statement.setLong(1, id);

                            ResultSet resultSet = statement.executeQuery();
                            if (resultSet.next()) {
                                return new User(
                                        resultSet.getLong("id"),
                                        resultSet.getString("username"),
                                        resultSet.getString("full_name"),
                                        resultSet.getString("email"),
                                        resultSet.getString("password"),
                                        resultSet.getString("phone"),
                                        resultSet.getString("address"),
                                        Gender.valueOf(resultSet.getString("gender")),
                                        null,
                                        null,
                                        resultSet.getInt("rank_id"),
                                        resultSet.getString("nrc_number"),
                                        resultSet.getString("international_card"),
                                        Type.valueOf(resultSet.getString("user_type")),
                                        Type.valueOf(resultSet.getString("profile_type")),
                                        Status.valueOf(resultSet.getString("status")),
                                        new ArrayList<>(),
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