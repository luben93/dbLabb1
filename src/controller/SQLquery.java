package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Album;

/**
 * SQLquery exectues a query and recives the result and puts it in an array as
 * objects
 * 
 * @author luben and steffe
 * 
 */
public class SQLquery {
	private Connection con;
	private ArrayList<Album> result;

	public SQLquery(Connection con) {//constructs every query 
		this.con = con;
		result = new ArrayList<Album>();//new objects per query 
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Album> execute(String query) throws SQLException {

		Statement stmt = null;
		try {
			// Execute the SQL statement
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// Get the attribute names
			ResultSetMetaData metaData = rs.getMetaData();
			int ccount = metaData.getColumnCount();
			for (int i = 0; i < ccount; i++) {
				//colname.add(metaData.getColumnName(i));
			}
			// Get the attribute values
			while (rs.next()) {
				//for (int c = 1; c <= ccount; c++) {
				//}
				//need to read artist result
				String[] temp=new String[5];
				temp[0]=rs.getString(1);//bad wrong, such no!!!
				result.add(new Album(temp, rs.getString(2), rs
						.getString(3), rs.getString(4), rs.getString(5)));
			}

		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		 return result;
	}

	/**
	 * @return result, the result of the SQL query
	 */
	public ArrayList<Album> getResults() {
		return (ArrayList<Album>) result.clone();
	}

}
