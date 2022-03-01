package net.lvs.connect.manager.base;

import system.mongo.core.connector.MongoGatewayConnector;
import system.mongo.core.connector.MongoObjectConnector;

import java.util.HashMap;

/**
 * Created by PhungHop on 12:26 PM - 3/23/2021.
 */
public class BaseConnector {
    private final static String DATABASE_NAME = "ManageDB";
    private static HashMap<String, MongoObjectConnector> mapConnector = new HashMap<>();

    public MongoObjectConnector getMongoObjectConnector(String connectionName) {
        System.setProperty("mongo.config.path", "C:\\Work\\DemoPrimeface\\mongo.conf");
        MongoObjectConnector mongoObjectConnector = mapConnector.get(connectionName);
        if (null == mongoObjectConnector) {
            mongoObjectConnector = MongoGatewayConnector.getMongoObjectConnector(DATABASE_NAME, connectionName);
            System.out.println("Connect " + connectionName + " success");
            mapConnector.put(connectionName, mongoObjectConnector);
        }
        return mongoObjectConnector;
    }
}

