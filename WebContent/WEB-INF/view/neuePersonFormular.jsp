<!-- Lib für MVC Formular-Tags -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Person hinzufügen</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>Personen Datenbank</h1>
		</div>

		<div id="container">
			<div id="content">
			<h2>Person hinzufügen</h2>
			<form:form action="personSpeichern" modelAttribute="person" method="POST">
			
			<!-- Daten mit ID verknüpfen -->
			<form:hidden path="personenNr"/>
				<table>
					<tbody>
						<tr>
							<td>
								<label>Vorname: </label>
								<td>
									<form:input path="vorname"/>
								</td>
							</td>
						</tr>
						<tr>
							<td>
								<label>Nachname: </label>
								<td>
									<form:input path="nachname"/>
								</td>
							</td>
						</tr>
						<tr>
							<td>
								<label>Land: </label>
								<td>
									<form:input path="land"/>
								</td>
							</td>
						</tr>
						<tr>
							<td>
								<label></label>
								<td>
									<input type="submit" value="Speichern" class="save"/>
								</td>
							</td>
						</tr>
					</tbody>
				</table>
			</form:form>
			<div style="clear; bot;"></div>
				<p>
					<a href="${pageContext.request.contextPath}/personen/liste">
						Zurück zur Liste
					</a>
				</p>
			</div>
		</div>
	</div>
</body>
</html>
</body>
</html>