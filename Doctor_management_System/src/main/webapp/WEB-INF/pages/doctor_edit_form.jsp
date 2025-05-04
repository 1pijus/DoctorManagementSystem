<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Doctor</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            background-color: white;
            border-radius: 10px;
            padding: 30px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
        }
        .form-container h1 {
            text-align: center;
            color: #28a745;
        }
        .btn-submit {
            background-color: #28a745;
            color: white;
            width: 100%;
            font-size: 1.2rem;
            padding: 10px;
        }
        .btn-submit:hover {
            background-color: #218838;
        }
        .btn-cancel {
            background-color: #dc3545;
            color: white;
            width: 100%;
            font-size: 1.2rem;
            padding: 10px;
            margin-top: 10px;
        }
        .btn-cancel:hover {
            background-color: #c82333;
        }
        .form-control {
            border-radius: 10px;
        }
        label {
            font-size: 1.1rem;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="form-container">
        <h1>Edit Doctor</h1>

        <frm:form modelAttribute="doctor">
            <div class="mb-3">
                <label for="did" class="form-label">Doctor ID</label>
                <frm:input path="did" cssClass="form-control" id="did" readonly="true"/>
            </div>

            <div class="mb-3">
                <label for="dname" class="form-label">Doctor Name</label>
                <frm:input path="dname" cssClass="form-control" id="name" required="required" />
            </div>

            <div class="mb-3">
                <label for="qlfy" class="form-label">Qualification</label>
                <frm:input path="qlfy" cssClass="form-control" id="qlfy" required="required"/>
            </div>

            <div class="mb-3">
                <label for="income" class="form-label">Income</label>
                <frm:input path="income" cssClass="form-control" id="income" required="required"/>
            </div>

            <div class="mb-3">
                <label for="mobileno" class="form-label">Mobile Number</label>
                <frm:input path="mobileno" cssClass="form-control" id="mobileno" required="required"/>
            </div>

            <div class="mb-3">
                <label for="specialization" class="form-label">Specialization</label>
                <frm:input path="specialization" cssClass="form-control" id="specialization" required="required"/>
            </div>

            <button type="submit" class="btn btn-submit">Save Changes</button>
            <button type="reset" class="btn btn-cancel">Cancel</button>
        </frm:form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
