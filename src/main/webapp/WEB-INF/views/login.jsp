<jsp:include page="/layout/base.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<main class="container">
  <div class="d-flex justify-content-center mt-3">
    <form class="Form row gy-2" action="welcome" method="post">
      <h1 class="text-center">Log in</h1>
      <h4 class="col-md-6">Username</h4>
      <input class="col-md-6" type="text" name="login_id" required />
      <h4 class="col-md-6">Password</h4>
      <input class="col-md-6" type="password" name="password" required />
      <div class="d-flex justify-content-center">
        <input class="btn btn-success" type="submit" value="Log in" />
      </div>
    </form>
  </div>
</main>

<jsp:include page="/layout/footer.jsp" />