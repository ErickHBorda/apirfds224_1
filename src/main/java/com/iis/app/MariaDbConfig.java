package com.iis.app;

//import java.sql.SQLException;

import javax.sql.DataSource;

//import org.postgresql.ds.PGSimpleDataSource;
//import org.mariadb.jdbc.MariaDbPoolDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class MariaDbConfig {
    @Bean
    DataSource dataSource(){
        //MARIA DB
        /*MariaDbPoolDataSource dataSource = new MariaDbPoolDataSource();

        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/dbgeneral");
            dataSource.setUser("root");
            dataSource.setPassword("2121");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataSource;*/

        //SQL SERVER
        SQLServerDataSource dataSource = new SQLServerDataSource();
        dataSource.setURL("jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=dbgeneral");
        dataSource.setUser("sa");
        dataSource.setPassword("111");
        return dataSource;

        //POSTGRESQL
        /*HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:postgresql://localhost:5432/dbgeneral");
        config.setUsername("postgres");
        config.setPassword("111");
        config.setDriverClassName("org.postgresql.Driver");

        return new HikariDataSource(config);
        

        //ORACLE
        /*HikariConfig config = new HikariConfig();

        config.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE"); // Cambia según tu configuración de Oracle
        config.setUsername("system");
        config.setPassword("111");
        config.setDriverClassName("oracle.jdbc.OracleDriver");

        return new HikariDataSource(config); */
    } 
    
}
