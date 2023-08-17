<jsp:include page="/layout/header.jsp" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<main class="container">
<div class="d-flex justify-content-center mt-3">
<form class="Form row gy-2" action="update?token=${token}&uuid=${uuid}" method="POST">
		 	<h1 class="text-center">Edit Contact</h1>
			<c:if test="${success==true}">
				<p style="border: 2px solid black;"
					class="text-center bg-success text-white">${msg}</p>
			</c:if>
			<c:if test="${success==false}">
				<p style="border: 2px solid black;"
					class="text-center bg-danger text-white">${msg}</p>
			</c:if>
			
			<h4 class="col-md-6">First Name</h4>
			<input class="col-md-6" type="text" name="first_name" value="${contact.getFirst_name()}" required/>
			
			<h4 class="col-md-6">Last Name</h4>
			<input class="col-md-6" type="text" value="${contact.getLast_name()}" name="last_name" required/>
			
			<h4 class="col-md-6">Street</h4>
			<input class="col-md-6" type="text" value="${contact.getStreet()}" name="street"/>
			
			<h4 class="col-md-6">Address</h4>
			<input class="col-md-6" type="text" value="${contact.getAddress()}" name="address"/>
			
			<h4 class="col-md-6">City</h4>
			<input class="col-md-6" type="text" value="${contact.getCity()}" name="city"/>
			
			<h4 class="col-md-6">State</h4>
			<input class="col-md-6" type="text" value="${contact.getState()}" name="state"/>
			
			<h4 class="col-md-6">Email</h4>
			<input class="col-md-6" type="text" value="${contact.getEmail()}" name="email"/>
			
			<h4 class="col-md-6">Phone</h4>
			<input class="col-md-6" type="text" value="${contact.getPhone()}" name="phone"/>
			
			<div id="cont">
			<div class="d-flex justify-content-center">
				<input class="btn btn-secondary" id="btn1" type="submit" value="Update" />
			</div>
			<div class="d-flex justify-content-center">
				<a href="welcome"><input class="btn btn-secondary" id="btn1" onclick="location.href='welcome';" type="button" value="Back" /></a>
			</div>
			</div>
		</form>
		</div>
</main>
<jsp:include page="/layout/footer.jsp" />