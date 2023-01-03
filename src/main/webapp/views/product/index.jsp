<%@page import="ReportPrinter.mybatis.dto.ProductDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<% List<ProductDTO> list = (List<ProductDTO>) request.getAttribute("lstProduct"); %>
<body>
	<table border="1" width= "50%">
		<tr>
			<th>#</th>
			<th>category</th>
			<th>subcategory</th>
			<th>name</th>
			<th>price</th>
			<th>image</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		
			<% for(ProductDTO product: list){ %>
			<tr>
				<td><%= product.getId()%></td>
				<td><%= product.getCategoryId()%></td>
				<td><%= product.getSubcategoryId()%></td>
				<td><%= product.getName()%></td>
				<td><%= product.getPrice()%></td>
				<td>
					<% if(product.getImageBase64() != null){ %>
						<img src="data:image/jpeg;base64,<%= product.getImageBase64() %>" style="max-width: 200px">
					<%}%>
				</td>
				<td><a href="create-update?id=<%= product.getId()%>">Edit</a></td>
				<td><a href="delete/<%= product.getId()%>">Delete</a></td>
			</tr>
			<%} %>
	</table>
</body>
</html>