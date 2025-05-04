<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {

            color: white; /* Optional: If text should be white for contrast */
        }
        h1 {
            color: #dc3545;
            margin-top: 50px;
        }
        .card {
            border-radius: 15px;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
        }
        .card-body {
            text-align: center;
        }
        .btn-report {
            background-color: #28a745;
            color: white;
            font-size: 1.5rem;
            padding: 15px 30px;
            text-decoration: none;
        }
        .btn-report:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<div class="container text-center">
    <h1>Welcome to Doctor Operations</h1>
    <div class="card" style="max-width: 500px; margin: 50px auto;">
        <div class="card-body">
            <h2 class="card-title">Manage Doctor Records</h2>
            <a href="report" class="btn btn-report">View Report</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
