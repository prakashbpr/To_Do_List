package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import com.mysql.cj.protocol.Resultset;

import dto.User;

public class Dao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root","root");
		return con;
	}
	public static int saveUser(User user) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("insert into user values (?,?,?,?,?,?)");
		pst.setInt(1, user.getUserid());
		pst.setString(2, user.getUsername());
		pst.setString(3, user.getUseremail());
		pst.setLong(4, user.getUsercontact());
		pst.setString(6, user.getUserpassword());
		
		Blob imageBlob = new SerialBlob(user.getUserimage()) ;
		pst.setBlob(5, imageBlob);
		int res = pst.executeUpdate();
		return res;
		
	}
	
	public User findByEmail(String email) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		PreparedStatement pst = con.prepareStatement("select * from user where useremail = ?");
		pst.setNString(1, email);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			
			//convert blob image to byte[]
			Blob imageBlob = rs.getBlob(5);
			byte[] image = imageBlob.getBytes(1, (int)imageBlob.length());
			
			User u = new User(rs.getInt(1),rs.getNString(2),rs.getNString(3),rs.getLong(4),rs.getNString(6), image);
			
			return u;
			
		}
		else {
			return null;
		}
	}
	
}
