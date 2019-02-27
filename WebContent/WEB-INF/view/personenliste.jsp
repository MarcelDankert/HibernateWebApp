<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
				<!--  Suchfeld und Suche-Button hinzuf�gen -->
				<form:form action="suche" method="GET">
                Person suchen: <input type="text" name="suchname" />

					<input type="submit" value="Suchen" class="add-button" />
				</form:form>

				<input type="button" value="Neue Person"
					onclick="window.location.href='addPersonForm'; return false;"
					class="add-button">

				<table>
					<tr>
						<th>Vorname</th>
						<th>Nachname</th>
						<th>Land</th>
						<th>Aktionen</th>
					</tr>
					<!-- Mit Hilfe der importierten jstl-core lib kann durch die Liste iteriert werden -->
					<c:forEach var="tempPersonen" items="${personen}">

						<!-- Hier legen wir einen Update-Link an, welchen wir mit der ID des Datensatzes f�llen -->
						<c:url var="updateLink" value="/personen/updatePersonForm">
							<c:param name="personenNr" value="${tempPersonen.personenNr}"></c:param>
						</c:url>
						<!-- Hier legen wir einen L�schen-Link an, welcher den Datensatz l�scht -->
						<c:url var="deleteLink" value="/personen/delete">
							<c:param name="personenNr" value="${tempPersonen.personenNr}"></c:param>
						</c:url>
						<tr>
							<td>${tempPersonen.vorname}</td>
							<td>${tempPersonen.nachname}</td>
							<td>${tempPersonen.land}</td>
							<td><a href="${updateLink}">Update</a> | <!-- Hier f�gen wir eine Onclick-Methode hinzu, welche ein Pop-Up fenster erzeug, in dem man das L�schen best�tigen muss -->
								<a href="${deleteLink}"
								onclick="if (!(confirm('Sind sie sicher, dass sie diese Person l�schen wollen?'))) return false">L�schen</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>