<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h2>Title: ${title}</h2>
<h2>Path: ${path}</h2>
<h2>Items: </h2>
<ul>
    <#list items as item>
        <li>${item}</li>
    </#list>
</ul>

</body>
</html>