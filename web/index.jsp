<%--
/**
 * @author Dan Crosby  CIT360
 * 3/6/19
 * A web page to demonstrate the servlet named Skaro.
 */
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>Daleks Command Central</title>
  </head>
  <body>
  <H1>Dan Crosby CIT 360 Daleks Command Central</H1>
  <H2>Featuring Apache TomCat Servlets</H2>

  <BR><BR>
    <form action="Servlet" method="post">
      <fieldset>
      <span>
        <img src="img/daleksec.jpg" width="100px" height="100px" alt="Dalek Sec">
        <input type="checkbox" id="d1" name="d1">
        <label for="d1">Dalek Sec</label>
      </span>

      <span>
        <img src="img/dalekwarriors.jpg" width="100px" height="100px" alt="Dalek Warriors">
        <input type="checkbox" id="d2" name="d2">
        <label for="d2">Dalek Warriors</label>
      </span>

      <span>
        <img src="img/supremecouncil.jpg" width="100px" height="100px" alt="Dalek Supreme Council">
        <input type="checkbox" id="d3" name="d3">
        <label for="d3">Dalek Supreme Council</label>
      </span>
      <br><br>

      <input type="submit" value="Go to battle!">
  </fieldset>
    </form>

  </body>
</html>
