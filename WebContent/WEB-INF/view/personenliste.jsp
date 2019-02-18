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
			<h1>Personen Datenbank</h1>
		</div>

		<div id="container">
			<div id="content">
			
			<input type="button" value="Neue Person" onclick="window.location.href='addPersonForm'; return false;" class="add-button">
			
				<table>
					<tr>
						<th>Vorname</th>
						<th>Nachname</th>
						<th>Land</th>
						<th>Aktionen</th>
					</tr>
					<!-- Mit Hilfe der importierten jstl-core lib kann durch die Liste iteriert werden -->
					<c:forEach var="tempPersonen" items="${personen}">
					
					<!-- Hier legen wir einen Update-Link an, welchen wir mit der ID des Datensatzes füllen -->
					<c:url var="updateLink" value="/personen/addPersonForm">
						<c:param name="personId" value="${tempPerson.personenNr}"></c:param>
					</c:url>
						<tr>
							<td>${tempPersonen.vorname}</td>
							<td>${tempPersonen.nachname}</td>
							<td>${tempPersonen.land}</td>
							<td><a href="${updateLink}">Update</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>