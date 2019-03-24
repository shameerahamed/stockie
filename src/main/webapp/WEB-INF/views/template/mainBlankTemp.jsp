<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
<title>
	<tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
</head>
<body >
<table cellpadding="5" cellspacing="1" align="left" style="vertical-align: top" width="100%">
    <tr>
        <td align="center">
        	<%-- <tiles:insertAttribute name="header"></tiles:insertAttribute> --%>
        </td>
    </tr>
    <tr>
        <td>
        	<tiles:insertAttribute name="body"></tiles:insertAttribute>
        </td>
    </tr>
    <tr>
        <td align="center">
        	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
        </td>
    </tr>
</table>
</body>
</html>