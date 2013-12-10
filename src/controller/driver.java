package controller;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Album;
import view.View;

/**
 * the actuall controller, handels all comunication between the view and the
 * modell
 * 
 * @author luben and steffe
 * 
 */
public class driver {
	// private ArrayList<String> test;
	private View frame;
	private ArrayList<Album> results;
	//private ArrayList<String> colname;
	private String ip = "83.250.249.187", user = "clientuser", pwd = "12345";

	/**
	 * start is the equivalent of the constructor
	 */
	public void start() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new View(driver.this);
					frame.setVisible(true);
				} catch (Exception e) {
					javax.swing.JOptionPane.showMessageDialog(null,
							"Could not start program, " + e.toString());
					// e.printStackTrace();// test only
				}
			}
		});
		//*
		String server = "jdbc:mysql://" + ip + ":3306/" + "labb1"
				+ "?UseClientEnc=UTF8";

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(server, user, pwd);
			// System.out.println("Connected!");
			
			
			// usally do shit
			
			
		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Database error, "
					+ e.toString());
			// e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					// System.out.println("Connection closed.");
				}
			} catch (SQLException e) {
				javax.swing.JOptionPane.showMessageDialog(null,
						"Database error, " + e.toString());
			}
		}
		//*/
	}

	/**
	 * update contains a insert SQL statment
	 * 
	 * @param artist
	 * @param album
	 * @param genre
	 * @throws NullValueExecption
	 *             if artist or album is NULL
	 */
	public void update(String artist, String album, String genre)
			throws NullValueExecption {
		if (!artist.equals("") && !album.equals("")) {
			connect("insert into music (artist,album,genre) values ('"
					+ artist + "', '" + album + "', '" + genre + "')", "update");

		} else {
			//System.out.println("hej");
			throw new NullValueExecption("Null is not an acceteble value here");
		}
	}

	/**
	 * query contains a select SQL statment
	 * 
	 * @param value1
	 *            is the name of the column
	 * @param value2
	 *            is the search query
	 */
	public void query(String value1, String value2) {
		connect("Select * FROM music where " + value1 + " like '" + value2
				+ "%'", "query");

	}

	/**
	 * selects all
	 */
	public void selectAll() {
		connect("Select * FROM music ", "query");

	}

	/**
	 * updates rating
	 * 
	 * @param rating
	 * @param album
	 */
	public void updateRating(String rating, String album) {
		connect("update music set rating = '" + rating + "' where artist ='"
				+ album + "'", "update");

	}

	//@SuppressWarnings("unchecked")
	public ArrayList<Album> getLatestQueryResults() {
		return (ArrayList<Album>) results.clone();
	}


	/**
	 * connect, connects to a database
	 * 
	 * @param sql
	 * @param type
	 *            is either update or query depending on the nature of the
	 *            SQLstament
	 */
	public void connect(String sql, String type) {
		String server = "jdbc:mysql://" + ip + ":3306/" + "labb1"
				+ "?UseClientEnc=UTF8";

		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(server, user, pwd);
			// System.out.println("Connected!");

			switch (type) {
			case "update":
				SQLupdate update = new SQLupdate(con);
				update.execute(sql);
				break;
			case "query":
				SQLquery query = new SQLquery(con);
				query.execute(sql);
				results = query.getResults();
				break;
			}

		} catch (Exception e) {
			javax.swing.JOptionPane.showMessageDialog(null, "Database error, "
					+ e.toString());
			// e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
					// System.out.println("Connection closed.");
				}
			} catch (SQLException e) {
				javax.swing.JOptionPane.showMessageDialog(null,
						"Database error, " + e.toString());
			}
		}

	}

}
