package com.dhxz.prospring5.ch6.dao;

import com.dhxz.prospring5.ch6.entities.Singer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlainSingerDao implements SingerDao {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://118.25.50.86:3306/pro_spring_5?useSSL=true","donghan","123456");
    }
    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Singer> findAll() {
        List<Singer> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("SELECT * FROM SINGER");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.add(Singer.builder()
                        .id(resultSet.getLong("id"))
                        .firstName(resultSet.getString("first_name"))
                        .lastName(resultSet.getString("last_name"))
                        .birthDate(resultSet.getDate("birth_date"))
                        .build());
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Singer singer) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO SINGER(first_name, last_name, birth_date) VALUES " +
                            "(?, ?, ?)",Statement.RETURN_GENERATED_KEYS
            );
            statement.setString(1,singer.firstName());
            statement.setString(2,singer.lastName());
            statement.setDate(3,singer.birthDate());
            statement.execute();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                singer.id(generatedKeys.getLong(1));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(Long singerId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM SINGER WHEN id = ?"
            );
            statement.setLong(1,singerId);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Singer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Singer singer) {

    }
}
