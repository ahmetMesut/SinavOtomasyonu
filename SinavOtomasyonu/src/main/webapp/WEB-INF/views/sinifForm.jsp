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
<title>Sinif Bilgisi</title>
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
				<h3 class="panel-title">Sinif Bilgisi</h3>
				 <div align="right"><a href="listAllSinif">Siniflari Listele</a></div>
				 <div align="right"><a href="/">Anasayfaya Dön</a></div>
			</div>
			<div class="panel-body">
				<form:form id="sinifRegisterForm" cssClass="form-horizontal"
					modelAttribute="sinif" method="post" action="saveSinif">
				
				   <form:hidden path="sinifId" value="${sinifObject.sinifId}" />

					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="sinifAdi">Sinif Adi</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="sinifAdi" value="${sinifObject.sinifAdi}" />
						</div>
					</div>


					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="sinifKapasite">Kac kisilik</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="sinifKapasite" value="${sinifObject.sinifKapasite}" />
						</div>
					</div>


					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="bolumu">Hangi Bolum Sınıfı</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="bolumu" value="${sinifObject.bolumu}" />
						</div>
					</div>
			
			
					<div class="form-group">
						<div class="row">
							<div class="col-xs-4"></div>
							<div class="col-xs-4">
								<input type="submit" id="saveSinif" class="btn btn-primary"
									value="Kaydet" onclick="return submitSinifForm();" />
							</div>
							<div class="col-xs-4"></div>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>

	




	<script type="text/javascript">
		function submitSinifForm() {

			var sinifAdi = $('#sinifAdi').val().trim();
			var sinifKapasite = $('#sinifKapasite').val();
			var bolumu = $('#bolumu').val().trim();
			

			if (sinifAdi.length == 0) {
				alert('Lütfen sınıf adı giriniz!');
				$('#sinifAdi').focus();
				return false;
			}

			if (sinifKapasite.length == 0) {
				alert('Lütfen kapasiteyi giriniz');
				$('#sinifKapasite').focus();
				return false;
			}

			if (bolumu.length == 0) {
				alert('Lütfen bu sınıf hangi bölümde giriniz.');
				$('#bolumu').focus();
				return false;
			}
		

			return true;
		};
	</script>





</body>
</html>