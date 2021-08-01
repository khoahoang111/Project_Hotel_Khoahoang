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
                            onclick="location.href = '<c:url value="/view-booking" />'">Back</button>
                </div>
            </div>


            <div class="row mb-5">
                <div class="col-md-12 mb-12"> 

                    <table class="table table-bordered table-hover">
                        <tr>
                            <td colspan="6" style="font-weight: bold; color: red">Your Booking</td>
                        </tr>
                        <tr style="color: red">
                            <th>Room Name</th>
                            <th>Price/night</th>
                            <th>night(s)</th>
                            <th>Discount</th>
                            <th>service</th>
                            <th>unit price</th>              
                        </tr>
                        <c:forEach items="${booking.bookingDetail}" var="bd">
                            <tr>
                                <td>${bd.room.roomNumber}</td>
                                <td><fmt:formatNumber type="currency" value="${bd.room.price}" /></td>
                                <c:if test="${night != 0}">
                                    <td>${night}</td>

                                </c:if>

                                <td>${bd.discount}</td>



                                <td>
                                    <ul>
                                        <c:forEach items="${bd.serviceBooking}" var="sv">
                                            <li>
                                                ${sv.service.name}( <fmt:formatNumber type="currency" value="${sv.service.price}" />)- Quantity: ${sv.quantity}
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </td>
                                <td><fmt:formatNumber type="currency" value="${bd.price * night}" /></td>                            
                            </tr>        
                        </c:forEach>
                        <tr>
                            <td  colspan="5" style="color: red ; text-align: right;font-weight:bold">TOTAL:</td>
                            <td style="color: red ;font-weight:bold" ><fmt:formatNumber type="currency" value="${booking.totalPrice * night}" /></td>
                        </tr>
                    </table>        
                </div>
            </div>
            <session>       
                <form action="<c:url value="/credit-card" />" method="POST" >
                    <div style="margin-bottom: 20px">
                        <h4>Enter your details </h4>
                    </div>
                    <div class="row">
                        <div class="form-group col-8">
                            <label>Full Name <font color = "#ff0000">(*)</font> </label>
                            <input class="form-control" type="text" name="full_name" value="${booking.fullName}" >
                        </div>
                        <div class="form-group col-4">
                            <label>Gender <font color = "#ff0000">(*)</font> </label>
                            <select name="gender" class="custom-select" id="inputGroupSelect01">
                                <c:forEach var="genderEnum" items="${genders}">
                                    <c:if test="${booking.gender != null}">
                                        <c:if test="${booking.gender == gender}">
                                            <option value="${genderEnum}" selected>${genderEnum}</option>
                                        </c:if>
                                        <c:if test="${booking.gender != gender}">
                                            <option value="${genderEnum}">${genderEnum}</option>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${booking.gender == null}">
                                        <option value="${genderEnum}">${genderEnum}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-7">
                            <label>Email <font color = "#ff0000">(*)</font> </label>
                            <div class="input-group">
                                <input type="text" name="email" class="form-control" value="${booking.email}" 
                                       placeholder="Enter your email" aria-label="Enter your email" aria-describedby="basic-addon2" required >
                                <div class="input-group-append">
                                    <span class="input-group-text" id="basic-addon2">@example.com</span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group col-5">
                            <label>Phone number <font color = "#ff0000">(*)</font> </label>
                            <input class="form-control" type="text" value="${booking.phone}" name="phone_number" maxlength="20" minlength="10" required >
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-7">
                            <label>Address: </label>
                            <input class="form-control" type="text" value="${booking.address}" name="address" >
                        </div>
                        <div class="form-group col-5">
                            <label>Your birthday: </label>
                            <div class="input-group date" id="reservationdate" data-target-input="nearest">
                                <input type="date" name="birthdate" class="form-control"  placeholder="dd/MM/yyyy"/>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="form-group" style=" margin: auto;">
                            <button type="submit" class="btn btn-primary btn-block" 
                                    style= color: white; width: 150px">Submit</button> 
                        </div>
                    </div>
                </form>
            </session>
        </div>               
        <jsp:include page="include/footer-page.jsp"/>
        <jsp:include page="include/js-page.jsp" />
    </body>
</html>
