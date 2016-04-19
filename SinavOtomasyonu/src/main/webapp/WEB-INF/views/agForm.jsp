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
<title>Araştırma Görevlisi Bilgisi</title>
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
				<h3 class="panel-title">Araştırma Görevlisi Bilgisi</h3>
				 <div align="right"><a href="listAllAg">Araştırma Görevlilerini Listele</a></div>
				 <div align="right"><a href="/">Anasayfaya Dön</a></div>
			</div>
			<div class="panel-body">
				<form:form id="agRegisterForm" cssClass="form-horizontal"
					modelAttribute="arastirmaGorevlisi" method="post" action="saveAg">
				
				   <form:hidden path="agId" value="${agObject.agId}" />

					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="agAdi">Adi</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="agAdi" value="${agObject.agAdi}" />
						</div>
					</div>


					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="agSoyadi">Soyadı</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="agSoyadi"
								value="${agObject.agSoyadi}" />
						</div>
					</div>


					<div class="form-group">
						<div class="control-label col-xs-3">
							<form:label path="agBolumu">Çalıştığı Bölüm</form:label>
						</div>
						<div class="col-xs-6">
							<form:input cssClass="form-control" path="agBolumu"
								value="${agObject.agBolumu}" />
						</div>
					</div>

			
					<div class="form-group">
						<div class="row">
							<div class="col-xs-4"></div>
							<div class="col-xs-4">
								<input type="submit" id="saveAg" class="btn btn-primary"
									value="Kaydet" onclick="return submitAgForm();" />
							</div>
							<div class="col-xs-4"></div>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>

	




	<script type="text/javascript">
		function submitAgForm() {

			var agAdi = $('#agAdi').val().trim();
			var agSoyadi = $('#agSoyadi').val().trim();
			var agBolumu = $('#agBolumu').val().trim();

			if (agAdi.length == 0) {
				alert('Lütfen bir isim giriniz!');
				$('#agAdi').focus();
				return false;
			}

			if (agSoyadi.length == 0) {
				alert('Lütfen bir soyisim giriniz!');
				$('#agSoyadi').focus();
				return false;
			}

			if (agBolumu.length == 0) {
				alert('Lütfen bir bölüm giriniz.');
				$('#agBolumu').focus();
				return false;
			}

			return true;
		};
	</script>





</body>
</html>