<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Personen-Liste</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>Personen-Liste</h1>
		</div>

		<div id="container">
			<div id="content">
				<table>
					<tr>
						<th>Vorname</th>
						<th>Nachname</th>
						<th>Land</th>
					</tr>
					<!-- Mit Hilfe der importierten jstl-core lib kann durch die Liste iteriert werden -->
					<c:forEach var="tempPersonen" items="${personen}">
						<tr>
							<td>${tempPersonen.vorname}</td>
							<td>${tempPersonen.nachname}</td>
							<td>${tempPersonen.land}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>