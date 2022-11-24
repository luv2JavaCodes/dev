package com.DAO;

import com.entity.Student;

public interface StudentDAO {

	public boolean studentRegister(Student st);
	
	public boolean checkUser(String em);
	
	public Student login(String email, String password);
	
	public Student getStudentById(int id);
}
