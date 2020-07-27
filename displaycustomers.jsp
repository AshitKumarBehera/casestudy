<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
      <style>
                      table, tr, td
                      {
                            border    : 1px solid black;
                            width     : 40%;
                            text-align: center;
                      }
                     !-- table.center
                      {
                            margin-left:auto;
                            margin-right:auto;
                      }                
                  </style>

</head>
<body>
<center>
            <h2>CUSTOMER   LIST</h2>
			<c:forEach var="Customer" items="${list }">
						<table>
							<tr>
								<td>
									<h5>
									<c:out value="${Customer.getCid()}"></c:out>
									</h5>
								</td>
								<td> 
									<h5>
									<c:out value="${Customer.getCname()}"></c:out>
									</h5>
								</td>
								<td> 
									<h5>
									<c:out value="${Customer.getCbalance()}"></c:out>
									</h5>
								</td>	
							</tr>
						</table>
	     </c:forEach>
</center>
</body>
</html>