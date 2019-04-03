package testcases;

import java.sql.SQLException;

import utilities.DbManager;

public class TestDBConn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {


		/*
		 * ip:port URL: jdbc:mysql://localhost:3306/20thjan2019;
		 * username: root password:
		 * 
		 */

		DbManager.setMysqlDbConnection();
		System.out.println(DbManager.getMysqlQuery("select tutorial_author from selenium where tutorial_id = 2"));
		
	}

}
