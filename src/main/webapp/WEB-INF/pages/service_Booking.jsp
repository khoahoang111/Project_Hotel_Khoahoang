<%-- 
    Document   : searchBooking
    Created on : Jun 28, 2021, 8:09:54 PM
    Author     : khoa hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="include/css-page.jsp" />
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="include/menu-page.jsp" />

        <div class="block-30 block-30-sm item" style="background-image: url(<c:url value="/resources/images/bg_2.jpg"/>);" data-stellar-background-ratio="0.5">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-10">
                        <span class="subheading-sm">Rooms</span>
                        <h2 class="heading">Rooms &amp; Suites</h2>
                    </div>
                </div>
            </div>
        </div>
        </br>
        <div class="container">    
            <div class="row">
                <div class="col-md-12 col-xs-12 col-lg-12">
                    <button class="btn btn-primary"
                            onclick="location.href = '<c:url value="/view-booking" />'">Continue shopping</button>
                </div>
            </div>
            <div class="row mb-5">
                <div class="col-md-12 mb-12">             
                    <table class="table table-bordered table-hover">
                        <tr >
                            <td colspan = "5" style="color: red" ><b>Service Booking</b></td>
                        </tr>
                        <tr style="color: red">
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>                      
                            <th>Total Price</th>
                            <th>Action</th>
                        </tr>   
                        <c:forEach items="${serviceBooking}" var="s">
                            <tr>
                                <td>${s.service.name}</td>
                                <td> <fmt:formatNumber type="currency" value="${s.service.price}" /></td>
                                <td>
                                    <form action="${pageContext.request.contextPath}/price-service/${s.service.id}" method="post">
                                        <input type="number" id="quantity" class="form-control" name="quantity" value="${s.quantity}"/>
                                        <input name="serviceId" value="${s.service.id}" hidden/>
                                        <button class="btn btn-info"
                                                type="submit" >Update</button>
                                    </form>
                                </td>
                                <td><fmt:formatNumber type="currency" value="${s.service.price * s.quantity}" /></td>
                                <td>
                                    <button class="btn btn-danger"
                                                        onclick="location.href = '<c:url value="/remove-service/${s.service.id}" />'">Remove</button>
                                </td>
                            </tr>

                        </c:forEach>                   
                    </table>        
                </div>


            </div>





            <div class="row mb-5">
                <div class="col-md-12 mb-12"> 

                    <table class="table table-bordered table-hover">
                        <tr>
                            <td colspan = "4" style="color: white" ><b>Add New Service</b></td>
                        </tr>
                        <tr style=" color:  red">
                            <th>Name</th>
                            <th>Price</th>
                            <th>Open Time</th>                      
                            <th>Action</th>
                        </tr>
                        <c:forEach items="${service}" var="s">
                            <tr>
                                <td>${s.name}</td>
                                <td><fmt:formatNumber type="currency" value="${s.price}" /></td>
                                <td>${s.openTime}</td>
                                <td>
                                    <button class="btn btn-primary" onclick="location.href = '<c:url value="/service/${s.id}"/>'">Add Service</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>        
                </div>


            </div>
        </div>
        <jsp:include page="include/footer-page.jsp"/>
        <jsp:include page="include/js-page.jsp" />
    </body>
</html>
