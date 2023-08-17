<jsp:include page="/layout/header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<main class="container">
<div class="d-flex justify-content-center mt-3">
<form class="Form row gy-2" action="add?token=<%=session.getAttribute("token")%>" method="POST">
			<h1 class="text-center">Add Contact</h1>

			<h4 class="col-md-6">First Name</h4>
			<input type="text" class="col-md-6" name="first_name" required
			/>
			<h4 class="col-md-6">Last Name</h4>
			<input class="col-md-6" type="text" name="last_name" required/>
			
			<h4 class="col-md-6">Street</h4>
			<input class="col-md-6" type="text" name="street"/>
			
			<h4 class="col-md-6">Address</h4>
			<input class="col-md-6" type="text" name="address"/>
			
			<h4 class="col-md-6">City</h4>
			<input class="col-md-6" type="text" name="city"/>
			
			<h4 class="col-md-6">State</h4>
			<input class="col-md-6" type="text" name="state"/>
			
			<h4 class="col-md-6">Email</h4>
			<input class="col-md-6" type="text" name="email"/>
			
			<h4 class="col-md-6">Phone</h4>
			<input class="col-md-6" type="text" name="phone"/>
			
			 <div id="cont">
			<div class="d-flex justify-content-center">
				<input class="btn btn-secondary" id="btn1" type="submit" value="Add" />
			</div>
			<div class="d-flex justify-content-center">
				<a href="welcome"><input class="btn btn-secondary" id="btn1" onclick="location.href='welcome';" type="button" value="Back" /></a>
			</div>
			</div>
		</form>
		</div>
</main>
<jsp:include page="/layout/footer.jsp" />