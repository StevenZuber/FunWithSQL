package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InputDbDAO implements InputDAO {
	private static final String url = "jdbc:mysql://localhost:3306/sdvid";
	private static final String user = "student";
	private static final String pword = "student";

	@Override
	public List<List<String>> queryByInput(String input) {
		List<List<String>> items = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pword);
			Statement stmt = conn.createStatement();
			if (input.trim().toUpperCase().startsWith("SELECT")) {
				ResultSet rs = stmt.executeQuery(input);
				ResultSetMetaData rsmd = rs.getMetaData();
				int cols = rsmd.getColumnCount();
				while (rs.next()) {
					List<String> item = new ArrayList<>();
					for (int c = 0; c < cols; c++) {
						item.add(rs.getString(c + 1));
					}
					items.add(item);
				}
				rs.close();
			}
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			System.err.println(sqle);
		}
		catch (ClassNotFoundException cnfe) {
			System.err.println(cnfe);

		}
		return items;
	}
}