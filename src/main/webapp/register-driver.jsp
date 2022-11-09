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
                    <h2 class="section-heading text-uppercase">Реєстрація водія</h2>
                    <h3 class="section-subheading text-muted">Вкажіть усю необхідну інформацію про водія</h3>
                </div>
                <!-- * * * * * * * * * * * * * * *-->
                <!-- * * SB Forms Contact Form * *-->
                <!-- * * * * * * * * * * * * * * *-->
                <!-- This form is pre-integrated with SB Forms.-->
                <!-- To make this form functional, sign up at-->
                <!-- https://startbootstrap.com/solution/contact-forms-->
                <!-- to get an API token!-->
                <form:form id="contactForm" modelAttribute="driver" data-sb-form-api-token="API_TOKEN" method="POST" action="/driver-register">
                    <div class="row align-items-stretch mb-5">
                        <div class="col-md-6">
                            <div class="form-group">
                                <!-- Name input-->
                                <form:input class="form-control" path="name" id="name" type="text" placeholder="Ваше ім'я *" data-sb-validations="required" />
                                <div class="invalid-feedback" data-sb-feedback="name:required">Ім'я обов'язкове</div>
                            </div>
                            <div class="form-group">
                                <!-- Email address input-->
                                <form:input class="form-control" path="driverLicence" id="driverLicence" type="text" placeholder="Номер ліцензії водія *" data-sb-validations="required" />
                                <div class="invalid-feedback" data-sb-feedback="driverLicence:required">Ліцензію слід обов'язково вказати.</div>
                            </div>



                            <div class="form-group mb-md-0">
                                <!-- Phone number input-->
                                <input class="form-control" name="cardNumber" id="cardNumber" type="text" placeholder="Номер банківської карти *" data-sb-validations="required" />
                                <div class="invalid-feedback" data-sb-feedback="cardNumber:required">Карту слід обов'язково вказати.</div>
                            </div>
                            <div class="form-group mb-md-0">
                                <!-- Phone number input-->
                                <input class="form-control" name="expMonth" id="expMonth" type="text" placeholder="Місяць *" data-sb-validations="required" />
                                <div class="invalid-feedback" data-sb-feedback="expMonth:required">Місяць слід обов'язково вказати.</div>
                            </div>
                            <div class="form-group mb-md-0">
                                <!-- Phone number input-->
                                <input class="form-control" name="expYear" id="expYear" type="text" placeholder="Рік *" data-sb-validations="required" />
                                <div class="invalid-feedback" data-sb-feedback="expYear:required">Рік слід обов'язково вказати.</div>
                            </div>


                            <div class="card border-0">
                                <div class="card-body p-0">

                                <!-- AUTO COMPLETE DROPDOWN -->
                                <select class="selectpicker form-control border-0 mb-1 px-4 py-4 rounded shadow" name="bankSystem" data-sb-validations="required">
                                        <option value="MasterCard">MasterCard</option>
                                        <option value="MasterCard">Visa</option>
                                        <option value="MasterCard">PayPal</option>
                                </select>
                                </div>
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
                    
                    <!-- Submit Button-->
                    <div class="text-center"><button class="btn btn-primary btn-xl text-uppercase" id="submitButton" type="submit">Зареєструвати водія</button></div>
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
