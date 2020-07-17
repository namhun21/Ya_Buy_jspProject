<%@page import="product.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="nav.jsp" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
	<%ArrayList<ProductDTO> plist = (ArrayList<ProductDTO>) request.getAttribute("plist");
   		int i =0;%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script type="text/javascript">
		function alert() {
			alert("test");
		}

		<%-- function itemShow(){
			document.write("<div class='col-lg-6 col-md-6'>");
			document.write("<div class='single-product-item'>");
			document.write("<figure>");
			document.write("<img src='<%= plist.get(i).getProduct_img() %>' alt="">");
			document.write("<div class='p-status'>new</div>");
			document.write("<div class='hover-icon'>");
			document.write("<a href='<%= plist.get(i).getProduct_img() %>' class='pop-up'><img src='img/icons/zoom-plus.png'
                            alt=''></a>");
			document.write("</div>");
			document.write("</figure>");
			document.write("<div class='product-text'>");
			document.write("<a href='ProductDetail'>");
			document.write("<h6><%= plist.get(i).getPname() %> </h6>");
			document.write("</a>");
			document.write("<p>$<%= plist.get(i).getPrice() %></p>");
			document.write("</div>");
			document.write("</div>");
			document.write("</div>");
		} --%>
	</script>
</head>

<body>
    <!-- Page Add Section Begin -->
    <section class="page-add">
        <div class="container">
            <div class="row">
                <div class="col-lg-4">
                    <div class="page-breadcrumb">
                        <h2>Dresses<span>.</span></h2>
                        <a href="#">Home</a>
                        <a href="#">Dresses</a>
                        <a class="active" href="#">Night Dresses</a>
                    </div>
                </div>
                <div class="col-lg-8">
                    <img src="img/add.jpg" alt="">
                </div>
            </div>
        </div>
    </section>
    <!-- Page Add Section End -->

    <!-- Categories Page Section Begin -->
    <section class="categories-page spad">
        <div class="container">
            <div class="categories-controls">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="categories-filter">
                            <div class="cf-left">
                                <form action="#">
                                    <select class="sort">
                                        <option value="">Sort by</option>
                                        <option value="">Orders</option>
                                        <option value="">Newest</option>
                                        <option value="">Price</option>
                                    </select>
                                </form>
                            </div>
                            <div class="cf-right">
                                <span><%=plist.size() %> Products</span>
                                <a href="#">2</a>
                                <a href="#" class="active">4</a>
                                <a href="#">6</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="single-product-item">
                        <figure>
                            <img src="<%= plist.get(i).getProduct_img() %>" alt="">
                            <div class="p-status new">new</div>
                            <div class="hover-icon">
                                <a href="<%= plist.get(i).getProduct_img() %>" class="pop-up"><img src="img/icons/zoom-plus.png"
                                        alt=""></a>
                            </div>
                        </figure>
                        <div class="product-text">
                          	<a href="ProductDetail?pid=<%=plist.get(i).getPid() %>">
                                <h6><%= plist.get(i).getPname() %></h6>
                            </a>
                            <p>$<%= plist.get(i).getPrice() %></p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="row">
                    <% int j = ++i;
                    for(;i<j+4;i++){
                    	if(i >= plist.size()) break;%>
                        <div class="col-lg-6 col-md-6">
                            <div class="single-product-item">
                                <figure>
                                    <img src="<%=plist.get(i).getProduct_img() %>" alt="">
                                    <div class="p-status sale">sale</div>
                                    <div class="hover-icon">
                                    <a href= "<%= plist.get(i).getProduct_img() %>" class="pop-up"><img
                                                src="img/icons/zoom-plus.png" alt=""></a>
                                    </div>
                                </figure>
                                <div class="product-text">
                                    <a href="ProductDetail?pid=<%=plist.get(i).getPid() %>">
                                        <h6><%= plist.get(i).getPname() %></h6>
                                    </a>
                                    <p>$<%= plist.get(i).getPrice() %></p>
                                </div>
                            </div>
                        </div>
                    <%} %>
                    </div>
                </div>
                <% 	j = i;
                   	for(;i<j+4;i++){
              		if(i >= plist.size()) break;%>
	                <div class="col-lg-3 col-md-6">
	                <div class="single-product-item">
	                    <figure>
	                        <img src="<%=plist.get(i).getProduct_img() %>" alt="">
	                        <div class="p-status popular">popular</div>
	                        <div class="hover-icon">
	                            <a href="<%= plist.get(i).getProduct_img() %>" class="pop-up"><img src="img/icons/zoom-plus.png"
	                                    alt=""></a>
	                        </div>
	                    </figure>
	                    <div class="product-text">
	                        <a href="ProductDetail?pid=<%=plist.get(i).getPid() %>">
	                            <h6><%= plist.get(i).getPname() %></h6>
	                        </a>
	                        <p>$<%= plist.get(i).getPrice() %></p>
	                    </div>
	                </div>
                </div>
                <%} %>
                <div class="col-lg-6 col-md-6">
                    <div class="row">
                    <% 	j = i;
	                   	for(;i<j+4;i++){
	              		if(i >= plist.size()) break;%>
		                <div class="col-lg-3 col-md-6">
			                <div class="single-product-item">
			                    <figure>
			                        <img src="<%= plist.get(i).getProduct_img() %>" alt="">
			                        <div class="p-status sale">sale</div>
			                        <div class="hover-icon">
			                            <a href="<%= plist.get(i).getProduct_img() %>" class="pop-up"><img src="img/icons/zoom-plus.png"
			                                    alt=""></a>
			                        </div>
			                    </figure>
			                    <div class="product-text">
			                        <a href="ProductDetail?pid=<%=plist.get(i).getPid() %>">
			                            <h6><%= plist.get(i).getPname() %></h6>
			                        </a>
			                        <p>$<%= plist.get(i).getPrice() %></p>
			                    </div>
			                </div>
		                </div>
	                <%} %>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
	                <div class="single-product-item">
	                    <figure>
	                        <img src="<% out.println(plist.get(i).getProduct_img()); %>" alt="">
	                        <div class="p-status new">new</div>
	                        <div class="hover-icon">
	                            <a href="<% out.println(plist.get(i).getProduct_img()); %>" class="pop-up"><img src="img/icons/zoom-plus.png"
	                                    alt=""></a>
	                        </div>
	                    </figure>
	                    <div class="product-text">
	                        <a href="ProductDetail?pid=<%=plist.get(i).getPid() %>">
	                            <h6><% out.println(plist.get(i).getPname()); %></h6>
	                        </a>
	                        <p>$<% out.println(plist.get(i).getPrice()); %></p>
	                    </div>
	                </div>
                </div>
            </div>
            <div class="more-product">
                <div class="row">
                    <div class="col-lg-12 text-center">
                        <a href="#" class="primary-btn">Load More</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Categories Page Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer-section spad">
        <div class="container">
            <div class="newslatter-form">
                <div class="row">
                    <div class="col-lg-12">
                        <form action="#">
                            <input type="text" placeholder="Your email address">
                            <button type="submit">Subscribe to our newsletter</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="footer-widget">
                <div class="row">
                    <div class="col-lg-3 col-sm-6">
                        <div class="single-footer-widget">
                            <h4>About us</h4>
                            <ul>
                                <li>About Us</li>
                                <li>Community</li>
                                <li>Jobs</li>
                                <li>Shipping</li>
                                <li>Contact Us</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="single-footer-widget">
                            <h4>Customer Care</h4>
                            <ul>
                                <li>Search</li>
                                <li>Privacy Policy</li>
                                <li>2019 Lookbook</li>
                                <li>Shipping & Delivery</li>
                                <li>Gallery</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="single-footer-widget">
                            <h4>Our Services</h4>
                            <ul>
                                <li>Free Shipping</li>
                                <li>Free Returnes</li>
                                <li>Our Franchising</li>
                                <li>Terms and conditions</li>
                                <li>Privacy Policy</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="single-footer-widget">
                            <h4>Information</h4>
                            <ul>
                                <li>Payment methods</li>
                                <li>Times and shipping costs</li>
                                <li>Product Returns</li>
                                <li>Shipping methods</li>
                                <li>Conformity of the products</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="social-links-warp">
			<div class="container">
				<div class="social-links">
					<a href="" class="instagram"><i class="fa fa-instagram"></i><span>instagram</span></a>
					<a href="" class="pinterest"><i class="fa fa-pinterest"></i><span>pinterest</span></a>
					<a href="" class="facebook"><i class="fa fa-facebook"></i><span>facebook</span></a>
					<a href="" class="twitter"><i class="fa fa-twitter"></i><span>twitter</span></a>
					<a href="" class="youtube"><i class="fa fa-youtube"></i><span>youtube</span></a>
					<a href="" class="tumblr"><i class="fa fa-tumblr-square"></i><span>tumblr</span></a>
				</div>
			</div>

<div class="container text-center pt-5">
                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart color-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
            </div>


		</div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/main.js"></script>
</body>

</html>