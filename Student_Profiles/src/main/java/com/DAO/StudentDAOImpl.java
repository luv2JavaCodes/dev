package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.Student;

public class StudentDAOImpl implements StudentDAO {
	private Connection conn;

	public StudentDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean studentRegister(Student st) {
		boolean f = false;

		try {
			String sql = "insert into student(name,email,dob,address,phone,gender,password) values (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, st.getName());
			ps.setString(2, st.getEmail());
			ps.setString(3, st.getDob());
			ps.setString(4, st.getAddress());
			ps.setString(5, st.getPhone());
			ps.setString(6, st.getGender());
			ps.setString(7, st.getPassword());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public boolean checkUser(String em) {

		boolean f = true;
		try {
			String sql = "select * from student where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, em);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public Student login(String email, String password) {
		Student st = null;
		try {
			String sql = "select * from student where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				st = new Student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setDob(rs.getString(4));
				st.setAddress(rs.getString(5));
				st.setPhone(rs.getString(6));
				st.setGender(rs.getString(7));
				st.setPassword(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}

	public Student getStudentById(int id) {
		Student st = null;

		try {
			String sql = "select * from student where d = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				st = new Student();
				st.setId(rs.getInt(1));
				st.setName(rs.getString(2));
				st.setEmail(rs.getString(3));
				st.setDob(rs.getString(4));
				st.setAddress(rs.getString(5));
				st.setPhone(rs.getString(6));
				st.setGender(rs.getString(7));
							}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}

}
