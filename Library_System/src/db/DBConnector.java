package db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnector {
	private static HikariConfig config;
	private static HikariDataSource datasource;
	private static Properties prop;

	static {
		Properties prop = new Properties();
		try {
			Reader rd = new FileReader("./src/db/db.properties");
			prop.load(rd);
		} catch (FileNotFoundException e) {
			System.out.println("파일 위치 오류");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		config = new HikariConfig();
		
		config.setJdbcUrl(prop.getProperty("url"));
		config.setUsername(prop.getProperty("user"));
		config.setPassword(prop.getProperty("password"));
		config.addDataSourceProperty("maximumPoolSize", 2);
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		config.addDataSourceProperty("maxLifetime", "180000");
		
		datasource = new HikariDataSource(config);
	}
	
	 
	public static Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}

}