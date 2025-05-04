<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Doctor Report</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            margin-top: 20px;
            border-radius: 15px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
        }
        .btn-edit, .btn-delete {
            font-size: 1rem;
            padding: 8px 16px;
        }
        .btn-edit {
            background-color: #007bff;
            color: white;
        }
        .btn-edit:hover {
            background-color: #0056b3;
        }
        .btn-delete {
            background-color: #dc3545;
            color: white;
        }
        .btn-delete:hover {
            background-color: #c82333;
        }
        .table {
            margin-top: 20px;
        }
        .btn-add {
            background-color: #28a745;
            color: white;
            font-size: 1.1rem;
            margin-top: 30px;
        }
        .btn-back {
            background-color: #6c757d;
            color: white;
            font-size: 1.1rem;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h1 class="text-center mt-4">Doctor Report</h1>

    <c:choose>
        <c:when test="${!empty listDoctor}">
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Doctor ID</th>
                        <th>Name</th>
                        <th>Income</th>
                        <th>Qualification</th>
                        <th>Specialization</th>
                        <th>Mobile Number</th>
                        <th>Operations</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="doctor" items="${listDoctor}">
                        <tr>
                            <td>${doctor.did}</td>
                            <td>${doctor.dname}</td>
                            <td>${doctor.income}</td>
                            <td>${doctor.qlfy}</td>
                            <td>${doctor.specialization}</td>
                            <td>${doctor.mobileno}</td>
                            <td>
                                <a href="edit?no=${doctor.did}" class="btn btn-edit">Edit</a>
                                <a href="delete?no=${doctor.did}" class="btn btn-delete" onclick="return confirm('Are you sure?')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <div class="alert alert-warning text-center" role="alert">No doctors found!</div>
        </c:otherwise>
    </c:choose>

    <a href="register" class="btn btn-add btn-lg btn-block">Add New Doctor</a>
    <a href="./" class="btn btn-back btn-lg btn-block mt-4">Back to Home</a>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
