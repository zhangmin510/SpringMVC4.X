<html>
<body>
<h2>Hello World!</h2>

<h3>FileUpload Test</h3>
<form method="post" enctype="multipart/form-data" action="uploadFile">
   Upload File <input type="file" name="file"><br />
   <input type="submit" value="upload">
</form>

<h3>MultiFileUpload Test</h3>
<form method="post" enctype="multipart/form-data" action="uploadFiles">
   Upload File 1 <input type="file" name="file"><br />
   Upload File 2 <input type="file" name="file"><br />
   Upload File 3 <input type="file" name="file"><br />
   <input type="submit" value="upload">
</form>
</body>
</html>
