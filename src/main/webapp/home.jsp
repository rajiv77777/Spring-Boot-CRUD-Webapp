<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Boot App</title>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
</head>
<body>
<div>
<center><h2> ADD ITEM </h2></center>
  <form action="addAlien">
    <label for="laid">Aid</label>
    <input type="text" id="idaid" name="aid" placeholder="Your ID..">
    <label for="lname">Name</label>
    <input type="text" id="idname" name="name" placeholder="Your Name..">
    <input type="submit" value="Submit">
    <div>
    	Status : ${addAlienStatus}
    </div>
  </form>
  <center><h2> Fetch ITEM </h2></center>
  <form action="getAlien">
    <label for="laid">Aid</label>
    <input type="text" id=" aid" name="aid" placeholder="Your ID..">
    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>