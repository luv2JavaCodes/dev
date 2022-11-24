<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.StudentDAOImpl"%>
<%@page import="com.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Documents</title>
<%@include file="all_component/allCss.jsp"%>
</head>
<body>
	<c:if test="${empty userobj}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div class="container p-3">
		<div class="row">

			<div class="card">
				<div class="card-body">
					<div class="col-md-6 ">
						<h3 class="text-center text-success">Your Details</h3>
						
						<%
						Student s = (Student)session.getAttribute("userobj");
								StudentDAOImpl dao = new StudentDAOImpl(DBConnect.getConnection());
						%>

						<form action="order" method="post">
							<input type="hidden" value="${userobj.id }" name="id">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Name</label> <input type="text"
										name="username" class="form-control" id="inputEmail4"
										value="${userobj.name }" required="required">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Email</label> <input type="email"
										name="email" class="form-control" id="inputPassword4"
										value="${userobj.email }" required="required">
								</div>
							</div>

						</form>
						</div>
						
					</div>
				</div>
			</div>
		</div>
		<h2>Upload your Important Files</h2>
		<form method="post" action="fileuploadservlet"
			enctype="multipart/form-data" >
			<div class="input-group ">
				<div class="input-group-prepend">
					<span class="input-group-text">Upload</span>
				</div>
				<div class="custom-file">
					<input type="file" class="custom-file-input" id="inputGroupFile01">
					<label class="custom-file-label">Choose
						files</label>
				</div>
			</div>
		</form>
</body>
</html>