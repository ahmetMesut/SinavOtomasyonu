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
				<h3 class="panel-title">Ders Bilgisi</h3>
				 <div align="right"><a href="listAllDers">Dersleri Listele</a></div>
				 <div align="right"><a href="/">Anasayfaya Dön</a></div>
			</div>
			<div class="panel-body">
				<form:form id="dersRegisterForm" cssClass="form-horizontal"
					modelAttribute="ders" method="post" action="saveDers">
				
				   <form:hidden path="dersId" value="${dersObject.adersId}" />

					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="dersAdi">Ders Adi</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="dersAdi" value="${dersObject.dersAdi}" />
						</div>
					</div>


					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="verildigiSene">Kaçıncı sınıf dersi</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="verildigiSene" value="${dersObject.verildigiSene}" />
						</div>
					</div>


					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="hocasi">Ders Hocası</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="hocasi" value="${dersObject.hocasi}" />
						</div>
					</div>
					
					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="gozetmenHocasi">Gözetmen Hocası</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="gozetmenHocasi" value="${dersObject.gozetmenHocasi}" />
						</div>
					</div>

			
					<div class="form-group">
						<div class="row">
							<div class="col-xs-4"></div>
							<div class="col-xs-4">
								<input type="submit" id="saveDers" class="btn btn-primary"
									value="Kaydet" onclick="return submitDersForm();" />
							</div>
							<div class="col-xs-4"></div>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>

	




	<script type="text/javascript">
		function submitDersForm() {

			var dersAdi = $('#dersAdi').val().trim();
			var verildigiSene = $('#verildigiSene').val().trim();
			var hocasi = $('#hocasi').val().trim();
			var gozetmenHocasi = $('#gozetmenHocasi').val().trim();

			if (dersAdi.length == 0) {
				alert('Lütfen ders adı giriniz!');
				$('#dersAdi').focus();
				return false;
			}

			if (verildigiSene.length == 0) {
				alert('Lütfen yılını giriniz!');
				$('#verildigiSene').focus();
				return false;
			}

			if (hocasi.length == 0) {
				alert('Lütfen dersin hocasını giriniz.');
				$('#hocasi').focus();
				return false;
			}
			
			if (gozetmenHocasi.length == 0) {
				alert('Lütfen dersin gözetmen hocasını giriniz.');
				$('#gozetmenHocasi').focus();
				return false;
			}

			return true;
		};
	</script>





</body>
</html>