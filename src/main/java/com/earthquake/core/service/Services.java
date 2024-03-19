package com.earthquake.core.service;

import com.earthquake.core.model.Models;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
public class Services {
    private final Models models;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public static final String QUERY = "SELECT * FROM table";


    @Autowired
    public Services(Models models) {
        this.models = models;
    }

    public void setModels(int x, String y, String z) {
        models.setX(x);
        models.setY(y);
        models.setZ(z);
    }

    public boolean isValid() {
        try {
            connection = DatabaseConnector.connectDb();
            statement = connection.createStatement();
//            preparedStatement = connection.prepareStatement(QUERY);
//            preparedStatement.setString(1, models.getX());
//            preparedStatement.setString(2, models.getPassword());
            resultSet = statement.executeQuery(QUERY);

            if(resultSet.next()) {
                return true;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}


//    public Optional<User> getUser(Integer id) {
//        Optional<User> optional = Optional.empty();
//        for (User user: userList) {
//            if(id == user.getId()){
//                optional = Optional.of(user);
//                return optional;
//            }
//        }
//        return optional;
//    }
//}

