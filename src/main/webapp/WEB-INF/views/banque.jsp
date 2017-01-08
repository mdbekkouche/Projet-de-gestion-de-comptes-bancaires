
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>banque</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/resources/css/style.css" />
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
		<div>
			<table>
				<tr>
					<td>Code client:</td>
					<td>${ banqueForm.compte.client.codeClient }</td>
				</tr>
			</table>
		</div>
		<div>
			<table>
				<tr>
					<td>Nom client:</td>
					<td>${ banqueForm.compte.client.nomClient }</td>
				</tr>
			</table>
		</div>
		<div>
			<table>
				<tr>
					<td>Nom employe:</td>
					<td>${ banqueForm.compte.employe.nomEmploye }</td>
				</tr>
			</table>
		</div>
		
		<div>
			<f:form modelAttribute="banqueForm" action="saveOperation">
				<f:hidden path="code"/>
				<table>
					<tr>
						<td>Versement<f:radiobutton path="typeOperation" value="VERSEMENT" onclick="this.form.submit()"/></td>
						<td>Retrait<f:radiobutton path="typeOperation" value="RETRAIT" onclick="this.form.submit()"/></td>
						<td>Virement<f:radiobutton path="typeOperation" value="VIREMENT" onclick="this.form.submit()"/></td>
					</tr>
					<c:if test="${ not empty banqueForm.typeOperation }">
					
					    <tr>
					    	<td>Montant:</td>
					    	<td><f:input path="montant"/> </td>
					    	<td><f:errors path="montant"></f:errors> </td>
					    </tr>
					 		<c:if test="${ banqueForm.typeOperation == 'VIREMENT' }">
					 			<tr>
					 				<td>Compte:</td>
					 				<td><f:input path="code2"/></td>
					 				<td><f:errors path="code2"></f:errors> </td>
					 			</tr>
					 		</c:if>
					 		<tr>
					 			<td><input type="submit" name="action" value="Save"> </td>
					 		</tr>
					</c:if>
				</table>
			</f:form>
		</div>
		
		<div>
			<table class="tab1">
				<tr>
					<th>Numéro</th><th>Type</th><th>Date</th><th>Montant</th>
				</tr>
				<c:forEach items="${ banqueForm.operations }" var="operation">
				<tr>
					<td>${ operation.numeroOperation }</td>
					<td>${ operation }</td>
					<td>${ operation.dateOperation }</td>
					<td>${ operation.montant }</td>
				</tr>
				</c:forEach>
			</table>
			<div>
				<c:forEach begin="0" end="${ banqueForm.nbpages - 1 }" var="page">
					<c:choose>
						<c:when test="${ page == banqueForm.page }">
							<span class="current">Page ${ page }</span>
						</c:when>
						<c:otherwise>
                    		<span class="autrePage">
                    			<a href="chargerCompte?page=${ page }&code=${ banqueForm.code }">Page ${ page }</a>
                    		</span>
                    	</c:otherwise>
					</c:choose>
                    
				</c:forEach>
			</div>
		</div>
	</c:if>


	<c:if test="${ not empty banqueForm.exception }">
		<div>
			${ banqueForm.exception }
		</div>
	</c:if>
</body>
</html>