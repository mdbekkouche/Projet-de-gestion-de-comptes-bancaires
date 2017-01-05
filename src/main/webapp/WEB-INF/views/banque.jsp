
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>banque</title>
</head>
<body>
	<div>
		<f:form modelAttribute="banqueForm" method="post" action="chargerCompte">
			<table>
				<tr>
					<td>Code:</td>
					<td><f:input path="code"/></td>
					<td><f:errors path="code"></f:errors></td>
				</tr>
				<tr>
					<td><input type="submit" value="OK"></td>
				</tr>
			</table>
		</f:form>
	</div>

	<c:if test="${ not empty banqueForm.compte }">
		<div>
			<table>
				<tr>
					<td>Solde:</td>
					<td>${ banqueForm.compte.solde }</td>
				</tr>
				<tr>
					<td>Date de création:</td>
					<td>${ banqueForm.compte.dateCreation }</td>
				</tr>
				<tr>
					<td>Date de création:</td>
					<td>${ banqueForm.typeCompte }</td>
				</tr>
				<c:if test="${ banqueForm.typeCompte == 'CompteCourant' }">
					<tr>
						<td>Découvert:</td>
						<td>${ banqueForm.compte.decouvert }</td>
					</tr>
				</c:if>
				<c:if test="${ banqueForm.typeCompte == 'CompteEpargne' }">
					<tr>
						<td>Taux:</td>
						<td>${ banqueForm.compte.taux }</td>
					</tr>
				</c:if>
			</table>
		</div>
	</c:if>


	<c:if test="${ not empty banqueForm.exception }">
		<div>
			${ banqueForm.exception }
		</div>
	</c:if>
</body>
</html>