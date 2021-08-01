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


                <div class="col-md-6 mb-3 mb-lg-0 col-lg-3">
                    <label for="text">Check In</label>
                    <div class="field-icon-wrap">
                        <!--                                <div class="icon"><span class="icon-calendar"></span></div>-->

                        <input class="form-control" type="date"  value="${checkin}" readonly>      


                    </div>
                </div>
                <div class="col-md-6 mb-3 mb-lg-0 col-lg-3">
                    <label for="checkin">Check Out</label>
                    <div class="field-icon-wrap">
                        <!--                                        <div class="icon"><span class="icon-calendar"></span></div>-->
                        <input class="form-control" type="date"  value="${checkout}" readonly>                                                
                    </div>
                </div> 
            </div>

            booking Date: ${booking.bookingDate}


            <div class="row">
                <div class="col-md-12 col-xs-12 col-lg-12">
                    <button class="btn btn-primary"
                            onclick="location.href = '<c:url value="/search?check_in=${checkin}&check_out=${checkout}&roomTypeId=${roomtype_id1}" />'">Continue shopping</button>
                </div>
            </div>


            <div class="row mb-5">
                <div class="col-md-12 mb-12"> 

                    <table class="table table-bordered table-hover">
                        <tr style="color: red">
                            <th>Room Name</th>
                            <th>Price/night</th>
                            <th>night(s)</th>
                            <th>Discount</th>

                            <th>unit price</th>
                            <th>service</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach items="${booking.bookingDetail}" var="bd">
                            <tr>
                                <td>${bd.room.roomNumber}</td>
                                <td><fmt:formatNumber type="currency" value="${bd.room.price}" /></td>
                                <c:if test="${night != 0}">
                                    <td>${night}</td>
                                    <!--                                        <form action="{pageContext.request.contextPath}/updateorder" method="post">
                                                                                <input type="number" id="quantity" class="form-control " name="quantity" value="{night}"/>
                                                                                <input name="productId" value="{item.value.product.id}" hidden/>
                                                                                <button class="btn btn-primary btn-block    "
                                                                                        type="submit" >Update</button>
                                                                            </form>-->

                                </c:if>

                                <td>${bd.discount}</td>
                                <td><fmt:formatNumber type="currency" value="${bd.price * night}" /></td>                                
                                <td>
                                    <ul>
                                        <c:forEach items="${bd.serviceBooking}" var="sv">
                                            <li>
                                                ${sv.service.name}( <fmt:formatNumber type="currency" value="${sv.service.price}" />)- Quantity: ${sv.quantity}
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </td>

                                <td>
                                    <button class="btn-primary" onclick="location.href = '<c:url value="/add-service/${bd.room.id}"/>'">Add Service</button>
                                    <button class=" btn-primary" onclick="location.href = '<c:url value="/remove-room/${bd.room.id}"/>'">Remove</button>
                                </td>
                            </tr>        
                        </c:forEach>
                    </table>        
                </div>

                <div class="row">
                    <div class="col-md-12 col-xs-12 col-lg-12">
                        <h2>Total:<fmt:formatNumber type="currency" value=" ${booking.totalPrice * night}" /></h2>
                    </div>
                    <div class="col-md-12 col-xs-12 col-lg-12">
                        <button class=" btn-primary" onclick="location.href = '<c:url value="/confirm"/>'">Confirm Booking</button>
                    </div>
                </div>



            </div>
        </div>
        <jsp:include page="include/footer-page.jsp"/>
        <jsp:include page="include/js-page.jsp" />
    </body>
</html>
