<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ders Bilgisi</title>
<!-- Bootstrap CSS -->
<%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"> --%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	
	<style type="text/css">
	.myrow-container {
		margin-top: 20px;
	}
	</style>
</head>
<body class=".container-fluid">
	<div class="container myrow-container">
		<div class="panel panel-warning">
			<div class="panel-heading">
				<h3 class="panel-title">Sinav Bilgisi</h3>
				<div align="right">
					<a href="listAllDers">Sinavlari Listele</a>
				</div>
				<div align="right">
					<a href="/">Anasayfaya Dön</a>
				</div>
			</div>
			<div class="panel-body">
				<form:form id="sinavRegisterForm" cssClass="form-horizontal"
					modelAttribute="sinav" method="post" action="saveSinav">

					<form:hidden path="sinavId" value="${sinavObject.sinavId}" />

					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="sinavAdi">Sinav Adi</form:label>
						</div>
						<div class="col-xs-6">
							<form:select id="sinavAdi" path="sinavAdi" type="text"
								class="form:input-large">
								<c:forEach items="${dersAdlari}" var="d">

									<form:option value="${d.dersAdi}">${d.dersAdi}</form:option>

								</c:forEach>
							</form:select>
						</div>
					</div>


				</form:form>
			</div>
		</div>
	</div>



</body>
</html>