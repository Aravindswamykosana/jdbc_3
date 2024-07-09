package jdbc_3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import jdbc_3.dto.Student;

public class StudentCrud {
	public void batchSave(List<Student> s) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase", "root", "root");
		PreparedStatement ps = con.prepareStatement("insert into student1 values(?,?,?,?,?,?) ");
		for(Student stud:s) {
			ps.setInt(1, stud.getId());
			ps.setString(2,stud.getName());
			ps.setString(3,stud.getEmail());
			ps.setLong(4, stud.getPhone());
			ps.setString(5,stud.getPwd());
			ps.setDouble(6, stud.getMarks());
			ps.addBatch();
		}
		ps.executeBatch();
		ps.close();
		con.close();
	}
}
