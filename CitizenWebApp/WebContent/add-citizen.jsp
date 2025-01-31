<!DOCTYPE html>
<html>
<head>
    <title>Add Citizen</title>
</head>
<body>
    <h1>Add Citizen</h1>
    <form action="citizen" method="post">
        Serial Number: <input type="number" name="serialNumber" required><br>
        Name: <input type="text" name="name" required><br>
        Aadhaar Number: <input type="text" name="aadhaar" required><br>
        Mobile Number: <input type="text" name="mobile" required><br>
        Address: <input type="text" name="address" required><br>
        <input type="submit" value="Add Citizen">
    </form>
    <a href="view-citizens.jsp">View Citizens</a>
</body>
</html>