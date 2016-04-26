<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

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
					<a href="listAllSinav">Sinavlari Listele</a>
				</div>
				<div align="right">
					<a href="/">Anasayfaya Dön</a>
				</div>
			</div>
			<div class="panel-body">
				<form:form id="sinavRegisterForm" cssClass="form-horizontal"
					modelAttribute="sinav" method="post" action="saveSinav">

					<form:hidden path="sinavId" value="${sinavObject.sinavId}" />
					<div class="panel-body">

						<table class="table table-hover table-bordered">
							<thead style="background-color: #F2F5A9;">
								<tr>
								    <th>Sınav Günü</th>
									<th>Sınav Saati</th>
									<th>Sınav Adı</th>
									<th>Sınav Sınıfı</th>
									<th>Gözetmen Hocası</th>
									<th>Kaydet</th>
								</tr>
							</thead>
							<tbody>
								<tr>
								    <th><form:select path="sinavGunu" items="${gunler}" /></th>
									<th><form:select path="sinavSaati" items="${saatler}" /></th>
									<th><form:select path="sinavAdi" items="${dersler}" /></th>
									<th><form:select path="sinavSinifi" items="${siniflar}" /></th>
									<th><form:select path="gozetmenHocasi" items="${agler}" /></th>
									<th><input type="submit" id="saveSinav" class="btn btn-primary"
									value="Kaydet" onclick="return submitSinavForm();" /></th> 
								</tr>
							</tbody>
						</table>
					</div>



				</form:form>
			</div>
		</div>
	</div>
	
	
	<script type="text/javascript">
		function submitSinavForm() {

			var agAdi = $('#sinavSaati').val().trim();
			var agSoyadi = $('#sinavAdi').val().trim();
			var agBolumu = $('#sinavSinifi').val().trim();
			var agBolumu = $('#gozetmenHocasi').val().trim();

			if (sinavSaati.length == 0) {
				alert('Lütfen bir saat seçiniz!');
				$('#sinavSaati').focus();
				return false;
			}

			if (sinavAdi.length == 0) {
				alert('Lütfen bir sınav seçiniz!');
				$('#sinavAdi').focus();
				return false;
			}

			if (sinavSinifi.length == 0) {
				alert('Lütfen bir sınıf seçiniz.');
				$('#sinavSinifi').focus();
				return false;
			}

			if (gozetmenHocasi.length == 0) {
				alert('Lütfen bir gözetmen seçiniz.');
				$('#gozetmenHocasi').focus();
				return false;
			}
			return true;
		};
	</script>

</body>
</html>