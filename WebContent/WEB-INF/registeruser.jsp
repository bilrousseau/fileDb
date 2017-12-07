<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Enregistrer un utilisateur</title>
	</head>
	<body>
		<form action="/FileDb/registerUser" method="POST">	
			<p>
				<label>Nom :</label><input type="text" name="lastname">
				<span class="${error_lastname}">${error_lastname_content}</span>
			</p>
			<p>
				<label>Prénom :</label><input type="text" name="firstname">
				<span class="${error_firstname}">${error_firstname_content}</span>
			</p>
			<p>
				<label>Date de naissance :</label><input type="text" name="birthDate">
				<span class="${error_birthdate}">${error_birthdate_content}</span>
			</p>
			<p>
				<label>E-mail :</label><input type="email" name="email">
				<span class="${error_email}">${error_email_content}</span>
			</p>
			<p>
				<input type="submit" value="Enregistrer">
			</p>
		</form>
	</body>
</html>