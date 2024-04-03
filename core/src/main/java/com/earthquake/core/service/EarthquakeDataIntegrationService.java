package com.earthquake.core.service;

import com.earthquake.core.model.EarthquakeLocationDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
public class EarthquakeDataIntegrationService {
//    private final EarthquakeLocationDataModel dataModel;
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public static final String QUERY = "SELECT * FROM table";

//    @Autowired
//    public EarthquakeDataIntegrationService(EarthquakeLocationDataModel dataModel) {
//        this.dataModel = dataModel;
//    }

    public boolean isEmpty(EarthquakeLocationDataModel dataModel) {
        if (dataModel.getLat() == 0 || dataModel.getLon() == 0 || dataModel.getIntensity() == 0) {
            return true;
        }
        return false;
    }

//    public boolean isValid() {
//        try {
//            connection = DatabaseConnector.connectDb();
//            statement = connection.createStatement();
////            preparedStatement = connection.prepareStatement(QUERY);
////            preparedStatement.setString(1, models.getX());
////            preparedStatement.setString(2, models.getPassword());
//            resultSet = statement.executeQuery(QUERY);
//
//            if(resultSet.next()) {
//                return true;
//            }
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        return false;
//    }
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

