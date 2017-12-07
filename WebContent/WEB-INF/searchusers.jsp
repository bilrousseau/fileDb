<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Rechercher des utilisateurs</title>
	</head>
	<body>
		<h1>Rechercher des utilisateurs</h1>
		
		<form action="/FileDb/SearchUsers" method="POST">
			<div>
				<input type="radio" name="field" value="lastname" checked><label>Nom</label>
				<select name="accuracyLastname">
					<option value="is">est</option>
					<option value="like">contient</option>
				</select>
				<input type="text" name="queryLastname">
			</div>
			<div>
				<input type="radio" name="field" value="firstname"><label>Prénom</label>
				<select name="accuracyFirstname">
					<option value="is">est</option>
					<option value="like">contient</option>
				</select>
				<input type="text" name="queryFirstname">
			</div>
			<div>
				<input type="radio" name="field" value="birthYear"><label>Année de naissance</label>
				<select name="accuracyBirthYear">
					<option value="slt">&lt;</option>
					<option value="lt">&lt;=</option>
					<option value="eq">=</option>
					<option value="gt">&gt;=</option>
					<option value="sgt">&gt;</option>
				</select>
				<input type="number" name="queryBirthYear">
			</div>
			<div>
				<input type="radio" name="field" value="email"><label>E-mail</label>
				<select name="accuracyEmail">
					<option value="is">est</option>
					<option value="like">contient</option>
				</select>
				<input type="text" name="queryEmail">
			</div>
			<div>
				<input type="submit" value="Rechercher">
			</div>
			<div>
				Trouvé : ${foundUser.getFirstname()} ${foundUser.getLastname()}, né.e le ${foundUser.getBirthDate()}, de mail ${foundUser.getEmail()}  
			</div>
		</form>
	</body>
</html>