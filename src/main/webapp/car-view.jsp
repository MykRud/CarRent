<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Car Rent</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
        <style type="text/css">
            body{background: #eee}
            .date{font-size: 11px}
            .comment-text{font-size: 12px}
            .fs-12{font-size: 12px}
            .shadow-none{box-shadow: none}
            .name{color: #007bff}
            .cursor:hover{color: blue}
            .cursor{cursor: pointer}
            .textarea{resize: none}
        </style>
    </head>
    <body id="page-top">

        <%@include file="/fragments/navbar.jspf" %>

        <!-- Team-->
        <section class="page-section bg-light" id="team">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Перегляд авто</h2>
                </div>

                <div class="row mt-5">
                        
                    <div class="col-lg-8 mx-auto text-center">
                        <h1>${car.model}</h1>
                    <br>
                        <p class="large text-muted">Кількість місць: ${car.numberOfSeats}</p>
                        <p class="large text-muted">Ціна за оренду: ${car.price}$/200 км.</p>
                        <p class="large text-muted">Розташування від місця оренди: ${car.distance} км.</p>
                        <p class="large text-muted">Загальний кілометраж: ${car.totalKilometrage}</p>
                        <p class="large text-muted">Орендована? 
                            <c:choose>
                                <c:when test="${car.isRent==true}">Так</c:when>    
                                <c:otherwise>Ні</c:otherwise>
                            </c:choose>
                        </p>
                    </div>
                </div>

                 <div class="container mt-5">
    <div class="d-flex justify-content-center row">
        <div class="col-md-8">
            <div class="d-flex flex-column comment-section">
                <c:forEach items="${comments}" var="comment">
                <div class="bg-white p-2">
                    <div class="d-flex flex-row user-info"><img class="rounded-circle" src="assets/img/user.png" width="40">
                        <div class="d-flex flex-column justify-content-start ml-2"><span class="d-block font-weight-bold name">${comment.name}</span></div>
                    </div>
                    <div class="mt-2">
                        <p class="comment-text">${comment.text}</p>
                    </div>
                </div>
                </c:forEach>
                
                <form:form class="form form-horizontal" modelAttribute="comment" action="/add-comment?car_id=${car.id}">
                <div class="bg-light p-2">
                    <div class="d-flex flex-row align-items-start">
                        <img class="rounded-circle" src="assets/img/user.png" width="40">
                        <form:input class="form-control col-3 ml-1 shadow-none input-group" path="name" type="text" name="name" placeholder="Ім'я" />
                        <form:textarea class="form-control ml-1 shadow-none textarea" path="text" placeholder="Повідомлення"></form:textarea>
                    </div>
                    <div class="mt-2 text-right"><button class="btn btn-primary btn-sm shadow-none" type="submit">Коментувати</button></div>
                </div>
            </form:form>
            </div>
        </div>
    </div>
</div>
            </div>
        </section>
        
        <%@include file="/fragments/footer.jspf" %>

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>
