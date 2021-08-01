<%-- 
    Document   : searchBooking
    Created on : Jun 28, 2021, 8:09:54 PM
    Author     : khoa hoang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="include/css-page.jsp" />
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="include/menu-page.jsp" />
        <div class="block-30 block-30-sm item" style="background-image: url('resources/images/bg_2.jpg');" data-stellar-background-ratio="0.5">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-md-10">
                        <span class="subheading-sm">Rooms</span>
                        <h2 class="heading">Rooms &amp; Suites</h2>
                    </div>
                </div>
            </div>
        </div>


        <div class="site-section bg-light">
            <div class="container">


                <form action="${pageContext.request.contextPath}/search" method="GET">
                    <div class="row">




                        <div class="col-md-6 mb-3 mb-lg-0 col-lg-3">
                            <label for="text">Check In</label>
                            <div class="field-icon-wrap">
                                <!--                                <div class="icon"><span class="icon-calendar"></span></div>-->

                                <input class="form-control" type="date" name="check_in"  value="${checkin}" readonly>      


                            </div>
                        </div>
                        <div class="col-md-6 mb-3 mb-lg-0 col-lg-3">
                            <label for="checkin">Check Out</label>
                            <div class="field-icon-wrap">
                                <!--                                        <div class="icon"><span class="icon-calendar"></span></div>-->
                                <input class="form-control" type="date" name="check_out" value="${checkout}" readonly>                                                
                            </div>
                        </div> 
                        <div class="col-md-6 mb-3 mb-lg-0 col-lg-3">
                            <label for="checkin">Room Type</label>
                            <div class="field-icon-wrap">

                                <select name="roomTypeId" class="form-control" >
                                    <c:forEach items="${roomtype_id}" var="rt">
                                        <c:if test="${rt.id == roomtype}">
                                            <option value="${rt.id}" selected >${rt.name}</option>
                                        </c:if>      
                                        <c:if test="${rt.id != roomtype}">
                                            <option value="${rt.id}"  >${rt.name}</option>
                                        </c:if>   
                                    </c:forEach>
                                </select>
                            </div>
                        </div>  
                        <div class="col-md-6 col-lg-3 align-self-end">
                            <!--                        <button class="btn btn-primary btn-block">Check Availabilty</button>-->
                            <input type="submit" value="Check Availabilty" class="btn btn-primary btn-block"/>
                        </div>

                    </div>
                </form>
                </br>
                <!------------------------------------------------------------------------------------------>
                <div class="row">
                    <c:forEach items="${search}" var="k">
                        <div class="col-lg-4 mb-5">
                            <div class="block-34"> 
                                <div class="image">                                 
                                    <a href="#"><img src="<c:url value="/resources/images/img_1.jpg"/>" alt="Image placeholder"></a>
                                </div>

                                <div class="text">
                                    <h2 class="heading">${k.roomType.name}</h2>
                                    <c:if test="${discounts == 0}">
                                        <div class="price" style="color: red"><sup>$</sup><span class="number">${k.price}</span><sub>/per night</sub></div>
                                            </c:if>
                                            <c:if test="${discounts > 0}">
                                        <div class="price"><sup>$</sup><span class="number"><strike>${k.price}</strike></span><sub>/per night</sub></div>
                                        <div class="price" style="color: red"><sup>$</sup><span class="number" >${k.price * ((100 - discounts)/100)}</span><sub>/per night</sub></div>
                                            </c:if>
                                    <ul class="specs">
                                        <li><strong>Guests:</strong>&ensp;${k.roomType.guest}/Persion.</li>
                                        <li><strong>Number of Bed:</strong>&ensp;${k.numberOfBed}.</li>
                                        <li><strong>Description:</strong>&ensp;${k.roomType.description}.</li>
                                        <li><strong>Size:</strong>&ensp;${k.roomType.size}.<sup>2</sup></li>   

                                        <li><strong>Discount:</strong>&ensp;${discounts}.</li>   


                                    </ul>
                                </div>
                                <div class="text">
                                    <button class="btn btn-primary btn-block"
                                            onclick="location.href = '<c:url value="/booking/${k.id}"/>'">Booking Room</button>
                                </div>   
                            </div>

                        </div>        
                    </c:forEach>                       
                </div>
            </div>
        </div>





        <!--                    <nav aria-label="Page navigation example">
                                <ul class="pagination">
                                    <li class="page-item">
                                        <a class="page-link" href="#" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                            <span class="sr-only">Previous</span>
                                        </a>
                                    </li>
                                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                                    <li class="page-item">
                                        <a class="page-link" href="#" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                            <span class="sr-only">Next</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>-->



    </div>
</div>
</div>







<!--        <div class="site-section bg-light">
            <div class="container">
                <div class="row mb-5">
                    <div class="col-md-7 section-heading">
                        <span class="subheading-sm">Reviews</span>
                        <h2 class="heading">Guest Reviews</h2>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-lg-4">

                        <div class="block-33">
                            <div class="vcard d-flex mb-3">
                                <div class="image align-self-center"><img src="<c:url value="/resources/images/person_3.jpg"/>" alt="Person here"></div>
                                <div class="name-text align-self-center">
                                    <h2 class="heading">Martin Newmansfield</h2>
                                    <span class="meta">Satisfied Customer</span>
                                </div>
                            </div>
                            <div class="text">
                                <blockquote>
                                    <p>&rdquo; Lorem ipsum dolor sit amet consectetur adipisicing elit. Fuga aliquid. Atque dolore esse veritatis iusto eaque perferendis non dolorem fugiat voluptatibus vitae error ad itaque inventore accusantium tempore dolores sunt. &ldquo;</p>
                                </blockquote>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-6 col-lg-4">

                        <div class="block-33">
                            <div class="vcard d-flex mb-3">
                                <div class="image align-self-center"><img src="images/person_2.jpg" alt="Person here"></div>
                                <div class="name-text align-self-center">
                                    <h2 class="heading">Nancy Green</h2>
                                    <span class="meta">Satisfied Customer</span>
                                </div>
                            </div>
                            <div class="text">
                                <blockquote>
                                    <p>&rdquo; Lorem ipsum dolor sit amet consectetur adipisicing elit. Fuga aliquid. Atque dolore esse veritatis iusto eaque perferendis non dolorem fugiat voluptatibus vitae error ad itaque inventore accusantium tempore dolores sunt. &ldquo;</p>
                                </blockquote>
                            </div>
                        </div>

                    </div>
                    <div class="col-md-6 col-lg-4">

                        <div class="block-33">
                            <div class="vcard d-flex mb-3">
                                <div class="image align-self-center"><img src="images/person_1.jpg" alt="Person here"></div>
                                <div class="name-text align-self-center">
                                    <h2 class="heading">Elizabeth Charles</h2>
                                    <span class="meta">Satisfied Customer</span>
                                </div>
                            </div>
                            <div class="text">
                                <blockquote>
                                    <p>&rdquo; Lorem ipsum dolor sit amet consectetur adipisicing elit. Fuga aliquid. Atque dolore esse veritatis iusto eaque perferendis non dolorem fugiat voluptatibus vitae error ad itaque inventore accusantium tempore dolores sunt. &ldquo;</p>
                                </blockquote>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>

        <div class="block-22">
            <div class="container">
                <div class="row align-items-center justify-content-center">
                    <div class="col-md-7 text-center">
                        <h2 class="heading mb-4">Be Sure To Get Our Promos</h2>
                        <form action="#" class="subscribe">
                            <div class="form-group">
                                <input type="email" class="form-control email" placeholder="Enter your email">
                                 <input type="submit" class="btn btn-primary submit"> 
                                <button type="submit" class="btn btn-primary submit">Subscribe</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>-->
<!--</div>-->                    
<jsp:include page="include/footer-page.jsp"/>
<jsp:include page="include/js-page.jsp" />
</body>
</html>
