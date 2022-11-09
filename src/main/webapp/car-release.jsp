<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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

        <style type="text/css">
            .bg-light {
                background: #eef0f4;
            }

            .choices__list--dropdown .choices__item--selectable {
                padding-right: 1rem;
            }

            .choices__list--single {
                padding: 0;
            }

            .card {
                transform: translateY(-50%);
            }

            .choices[data-type*=select-one]:after {
                right: 1.5rem;
            }

            .shadow {
                box-shadow: 0.3rem 0.3rem 1rem rgba(178, 200, 244, 0.23);
            }
        </style>
    </head>
    <body id="page-top">
        
        <%@include file="/fragments/navbar.jspf" %>

        <!-- Team-->
        <section class="page-section bg-light" id="team">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">Звільнення авто від оренди</h2>
                </div>
                <div class="row">
                    <form method="POST" accept="/rent-car">
                    <div class="col-lg-6 pt-5">
                        <div class="card border-0">
                            <div class="card-body p-0">

                        <!-- AUTO COMPLETE DROPDOWN -->
                        <select class="selectpicker form-control border-0 mb-1 px-4 py-4 rounded shadow" name="car_id">
                            <c:forEach items="${cars}" var="car">
                                <option value="${car.id}">${car.model}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="text-center">
                <button class="btn btn-primary btn-xl text-uppercase" id="submitButton" type="submit">Звільнити авто</button>
            </div>
            </form>

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
        <script type="text/javascript">
            /* ==============================================
    CUSTOM SELECT
  ============================================== */
const sorting = document.querySelector('.selectpicker');
const commentSorting = document.querySelector('.selectpicker');
const sortingchoices = new Choices(sorting, {
    placeholder: false,
    itemSelectText: ''
});


// Trick to apply your custom classes to generated dropdown menu
let sortingClass = sorting.getAttribute('class');
window.onload= function () {
    sorting.parentElement.setAttribute('class', sortingClass);
}

        </script>
    </body>
</html>
