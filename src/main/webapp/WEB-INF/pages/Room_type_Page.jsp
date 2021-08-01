<%-- 
    Document   : Room_type_Page
    Created on : Jun 23, 2021, 5:08:41 PM
    Author     : khoa hoang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="include/css-page.jsp" />

    </head>
    <body>
        <jsp:include page="include/menu-page1.jsp" />
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






        <div class="site-section bg-light">
            <div class="container">
                <div class="row mb-5">
                    <div class="col-md-12 mb-5"> 
                        <c:forEach items="${limit}" var="r">
                            <div class="block-3 d-md-flex">
                                <c:forEach items="${image}" var="im">
                                    <c:if test="${im.roomType.id == r.roomType.id}">
                                        <div class="image" style="background-image: url(<c:url value="/resources/images/${im.name}"/>); "></div>
                                    </c:if>                                
                                </c:forEach>


                                <div class="text">
                                    <h2 class="heading">${r.roomType.name}</h2>
                                    <div class="price"><sup>$</sup><span class="number">${r.price}</span><sub>/per night.</sub></div>
                                    <ul class="specs mb-5">
                                        <li><strong>Guests:</strong>&ensp;${r.roomType.guest}/Persion.</li>
                                        <li><strong>Number of Bed:</strong>&ensp;${r.numberOfBed}.</li>
                                        <li><strong>Description:</strong>&ensp;${r.roomType.description}.</li>
                                        <li><strong>Size:</strong>&ensp;${r.roomType.size}.<sup>2</sup></li>                                        
                                    </ul>
                                    <p><a href="#" class="btn btn-primary py-3 px-5">Read More</a></p>                                 
                                </div>
                            </div>
                            </br>
                        </c:forEach>                          
                        <!-- comment -->
                        <!--<ul class="pagination" id="pagination"></ul>-->

                        <nav aria-label="Page navigation example">
                            <ul class="pagination justify-content-center">
                                <li class="page-item disabled">
                                    <a class="page-link" href="#" tabindex="-1">Previous</a>
                                </li>
                                <c:forEach  begin="1" end="${countroom}" var="i">
                                    <c:choose>
                                        <c:when test="${i == 1}">
                                            <li class="paging-item active"><a class="page-link" onclick="location.href = '<c:url value="/room_type/${i-1}"/>'">${i}</a></li>
                                            </c:when> 
                                            <c:otherwise>
                                            <li class="paging-item"><a class="page-link" onclick="location.href = '<c:url value="/room_type/${i-1}"/>'">${i}</a></li>
                                            </c:otherwise> 
                                        </c:choose>                                   
                                    </c:forEach>                               
                                <a class="page-link" href="#">Next</a>
                                </li>
                            </ul>
                        </nav>
                        <!--                        <div class="paging">
                                                  
                                                </div>-->
                    </div>              
                    <div class="row">
                        <div class="col-lg-4 mb-5">
                            <div class="block-34">                      
                                <div class="image">
                                    <a href="#"><img src="<c:url value="/resources/images/img_1.jpg"/>" alt="Image placeholder"></a>
                                </div>
                                <div class="text">
                                    <h2 class="heading">Bachelor Room</h2>
                                    <div class="price"><sup>$</sup><span class="number">156</span><sub>/per night</sub></div>
                                    <ul class="specs">
                                        <li><strong>Adults:</strong> 1</li>
                                        <li><strong>Categories:</strong> Single</li>
                                        <li><strong>Facilities:</strong> Closet with hangers, HD flat-screen TV, Telephone</li>
                                        <li><strong>Size:</strong> 20m<sup>2</sup></li>
                                        <li><strong>Bed Type:</strong> One bed</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 mb-5">
                            <div class="block-34">
                                <div class="image">
                                    <a href="#"><img src="<c:url value="/resources/images/img_2.jpg"/>" alt="Image placeholder"></a>
                                </div>
                                <div class="text">
                                    <h2 class="heading">Family Room</h2>
                                    <div class="price"><sup>$</sup><span class="number">245</span><sub>/per night</sub></div>
                                    <ul class="specs">
                                        <li><strong>Adults:</strong> 1</li>
                                        <li><strong>Categories:</strong> Single</li>
                                        <li><strong>Facilities:</strong> Closet with hangers, HD flat-screen TV, Telephone</li>
                                        <li><strong>Size:</strong> 20m<sup>2</sup></li>
                                        <li><strong>Bed Type:</strong> One bed</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 mb-5">
                            <div class="block-34">
                                <div class="image">
                                    <a href="#"><img src="<c:url value="/resources/images/img_3.jpg"/>" alt="Image placeholder"></a>
                                </div>
                                <div class="text">
                                    <h2 class="heading">Presidential Room</h2>
                                    <div class="price"><sup>$</sup><span class="number">375</span><sub>/per night</sub></div>
                                    <ul class="specs">
                                        <li><strong>Adults:</strong> 1</li>
                                        <li><strong>Categories:</strong> Single</li>
                                        <li><strong>Facilities:</strong> Closet with hangers, HD flat-screen TV, Telephone</li>
                                        <li><strong>Size:</strong> 20m<sup>2</sup></li>
                                        <li><strong>Bed Type:</strong> One bed</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 mb-5">
                            <div class="block-34">
                                <div class="image">
                                    <a href="#"><img src="<c:url value="/resources/images/img_1.jpg"/>" alt="Image placeholder"></a>
                                </div>
                                <div class="text">
                                    <h2 class="heading">Bachelor Room</h2>
                                    <div class="price"><sup>$</sup><span class="number">156</span><sub>/per night</sub></div>
                                    <ul class="specs">
                                        <li><strong>Adults:</strong> 1</li>
                                        <li><strong>Categories:</strong> Single</li>
                                        <li><strong>Facilities:</strong> Closet with hangers, HD flat-screen TV, Telephone</li>
                                        <li><strong>Size:</strong> 20m<sup>2</sup></li>
                                        <li><strong>Bed Type:</strong> One bed</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 mb-5">
                            <div class="block-34">
                                <div class="image">
                                    <a href="#"><img src="<c:url value="/resources/images/img_2.jpg"/>" alt="Image placeholder"></a>
                                </div>
                                <div class="text">
                                    <h2 class="heading">Family Room</h2>
                                    <div class="price"><sup>$</sup><span class="number">245</span><sub>/per night</sub></div>
                                    <ul class="specs">
                                        <li><strong>Adults:</strong> 1</li>
                                        <li><strong>Categories:</strong> Single</li>
                                        <li><strong>Facilities:</strong> Closet with hangers, HD flat-screen TV, Telephone</li>
                                        <li><strong>Size:</strong> 20m<sup>2</sup></li>
                                        <li><strong>Bed Type:</strong> One bed</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 mb-5">
                            <div class="block-34">
                                <div class="image">
                                    <a href="#"><img src="<c:url value="/resources/images/img_3.jpg"/>" alt="Image placeholder"></a>
                                </div>
                                <div class="text">
                                    <h2 class="heading">Presidential Room</h2>
                                    <div class="price"><sup>$</sup><span class="number">375</span><sub>/per night</sub></div>
                                    <ul class="specs">
                                        <li><strong>Adults:</strong> 1</li>
                                        <li><strong>Categories:</strong> Single</li>
                                        <li><strong>Facilities:</strong> Closet with hangers, HD flat-screen TV, Telephone</li>
                                        <li><strong>Size:</strong> 20m<sup>2</sup></li>
                                        <li><strong>Bed Type:</strong> One bed</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 mb-5">
                            <div class="block-34">
                                <div class="image">
                                    <a href="#"><img src="<c:url value="/resources/images/img_1.jpg"/>" alt="Image placeholder"></a>
                                </div>
                                <div class="text">
                                    <h2 class="heading">Bachelor Room</h2>
                                    <div class="price"><sup>$</sup><span class="number">156</span><sub>/per night</sub></div>
                                    <ul class="specs">
                                        <li><strong>Adults:</strong> 1</li>
                                        <li><strong>Categories:</strong> Single</li>
                                        <li><strong>Facilities:</strong> Closet with hangers, HD flat-screen TV, Telephone</li>
                                        <li><strong>Size:</strong> 20m<sup>2</sup></li>
                                        <li><strong>Bed Type:</strong> One bed</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 mb-5">
                            <div class="block-34">
                                <div class="image">
                                    <a href="#"><img src="<c:url value="/resources/images/img_2.jpg"/>" alt="Image placeholder"></a>
                                </div>
                                <div class="text">
                                    <h2 class="heading">Family Room</h2>
                                    <div class="price"><sup>$</sup><span class="number">245</span><sub>/per night</sub></div>
                                    <ul class="specs">
                                        <li><strong>Adults:</strong> 1</li>
                                        <li><strong>Categories:</strong> Single</li>
                                        <li><strong>Facilities:</strong> Closet with hangers, HD flat-screen TV, Telephone</li>
                                        <li><strong>Size:</strong> 20m<sup>2</sup></li>
                                        <li><strong>Bed Type:</strong> One bed</li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 mb-5">
                            <div class="block-34">
                                <div class="image">
                                    <a href="#"><img src="<c:url value="/resources/images/img_3.jpg"/>" alt="Image placeholder"></a>
                                </div>
                                <div class="text">
                                    <h2 class="heading">Presidential Room</h2>
                                    <div class="price"><sup>$</sup><span class="number">375</span><sub>/per night</sub></div>
                                    <ul class="specs">
                                        <li><strong>Adults:</strong> 1</li>
                                        <li><strong>Categories:</strong> Single</li>
                                        <li><strong>Facilities:</strong> Closet with hangers, HD flat-screen TV, Telephone</li>
                                        <li><strong>Size:</strong> 20m<sup>2</sup></li>
                                        <li><strong>Bed Type:</strong> One bed</li>
                                    </ul>
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







            <div class="site-section bg-light">
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
                                    <!-- <input type="submit" class="btn btn-primary submit"> -->
                                    <button type="submit" class="btn btn-primary submit">Subscribe</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="include/footer-page.jsp"/>
            <jsp:include page="include/js-page.jsp" />

            <script type="text/javascript">
                $(function () {
                    window.pagObj = $('#pagination').twbsPagination({
                        totalPages: ${countroom},
                        startPage: 1,
                        visiblePages: 5,
                        onPageClick: function (event, page) {
                            console.info(page + ' (from options)');
                        }
                    }).on('page', function (event, page) {
                        console.info(page + ' (from event listening)');
                    });
                });
            </script>
            <script>
                $("body").on("click", ".paging-item", function () {
                    alert($(this).text(); )
                })
            </script>

    </body>
</html>
