<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8"%>

<html>
	<head>
		<title>Login</title>
	  	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/bootstrap.min.css"> 
		<link rel="stylesheet" href="css/style.css">
	</head>

<body class="FDFF">
	<table class="loginHorizontalCenterTableWrapper"">
		<colgroup><col></colgroup>
		<tbody>
			<tr><td>
			<table class="loginVerticalCenterTableWrapper">
				<colgroup><col></colgroup>
				<tbody>
					<tr>
						<td>
							<form name="loginForm" id="login" action="/docker-test/login" method="post" class="form-horizontal">
								<div class="mLogin" class="form-group" style="width: 355px; height: 150px;">
									<div class="form-group">
										<label for="inputUsername" class="col-sm-2 control-label">Логин</label>
										<div class="col-sm-10">
										  <input type="text" class="form-control" id="inputUsername" placeholder="Логин" name="username" value="">
										</div>
									</div>
									<div class="form-group">
										<label for="inputPassword" class="col-sm-2 control-label">Пароль</label>
										<div class="col-sm-10">
										  <input type="password" class="form-control" id="inputPassword" placeholder="Пароль" name="password" value="">
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<button class="btn btn-default" type="submit" OnClick="document.loginForm.submit ()">Войти</button>
										</div>	
									</div>

								</div>
							</form>	
						</td>
					</tr>
				</tbody>
			</table>
		</td></tr>
		</tbody>
	</table>
</body>
</html>