package com.iis.app;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbPoolDataSource;
//import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
//import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//ORACLE
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class MariaDbConfig {
    @Bean
    DataSource dataSource(){
        //MARIA DB
        MariaDbPoolDataSource dataSource = new MariaDbPoolDataSource();

        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/dbgeneral");
            dataSource.setUser("root");
            dataSource.setPassword("2121");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataSource;

        //SQL SERVER
        /*SQLServerDataSource dataSource = new SQLServerDataSource();
        try {
            dataSource.setURL("jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=dbgeneral");
            dataSource.setUser("sa");
            dataSource.setPassword("111");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;*/

        //POSTGRESQL
        /*PGSimpleDataSource dataSource = new PGSimpleDataSource();
        try {
            dataSource.setUrl("jdbc:postgresql://localhost:5432/dbgeneral");
            dataSource.setUser("postgres");
            dataSource.setPassword("111");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;*/

        //ORACLE
        /*HikariConfig config = new HikariConfig();
        try {
            config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
            config.setUsername("system");
            config.setPassword("111");
            config.setDriverClassName("oracle.jdbc.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new HikariDataSource(config); */
        
    } 
    
}
