<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
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
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        
        <%@include file="/fragments/navbar.jspf" %>

        <!-- Contact-->
        <section class="page-section" id="contact">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Додати машину</h2>
                    <h3 class="section-subheading text-muted">Введіть свою інфомрацію для реєстрації машини</h3>
                </div>
                <!-- * * * * * * * * * * * * * * *-->
                <!-- * * SB Forms Contact Form * *-->
                <!-- * * * * * * * * * * * * * * *-->
                <!-- This form is pre-integrated with SB Forms.-->
                <!-- To make this form functional, sign up at-->
                <!-- https://startbootstrap.com/solution/contact-forms-->
                <!-- to get an API token!-->
                <form:form id="contactForm" data-sb-form-api-token="API_TOKEN" method="POST" action="/add-car" modelAttribute="car">
                    <div class="row align-items-stretch mb-5">
                        <div class="col-md-6">

                            <div class="form-group">
                                <!-- Name input-->
                                <form:input class="form-control" path="model" id="model" type="text" placeholder="Модель *" data-sb-validations="required" />
                                <div class="invalid-feedback" data-sb-feedback="model:required">Необхідно вказати модель</div>
                            </div>

                            <div class="form-group">
                                <!-- Name input-->
                                <form:input class="form-control" path="carNumber" id="carNumber" type="text" placeholder="Номер авто *" data-sb-validations="required" />
                                <div class="invalid-feedback" data-sb-feedback="carNumber:required">Необхідно вказати номер автомобіля</div>
                            </div>

                            <div class="form-group">
                                <!-- Email address input-->
                                <form:input class="form-control" path="numberOfSeats" id="numberOfSeats" type="text" placeholder="Кількість місць *" data-sb-validations="required" />
                                <div class="invalid-feedback" data-sb-feedback="numberOfSeats:required">Необхідно вказати кількість місць</div>
                            </div>

                            <div class="form-group mb-md-0">
                                <!-- Phone number input-->
                                <form:input class="form-control" path="price" id="price" type="text" placeholder="Ціна оренди *" data-sb-validations="required" />
                                <div class="invalid-feedback" data-sb-feedback="price:required">Необхідно вказати ціну оренди</div>
                            </div>
                        </div>
                        
                    </div>
                    <!-- Submit success message-->
                    <!---->
                    <!-- This is what your users will see when the form-->
                    <!-- has successfully submitted-->
                    
                    <!-- Submit error message-->
                    <!---->
                    <!-- This is what your users will see when there is-->
                    <!-- an error submitting the form-->
                    <div class="d-none" id="submitErrorMessage"><div class="text-center text-danger mb-3">Error sending message!</div></div>
                    <!-- Submit Button-->
                    <div class="text-center"><button class="btn btn-primary btn-xl text-uppercase" id="submitButton" type="submit">Підтвердити</button></div>
                </form:form>
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
