<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="Model.javaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<javaBeans> lista = (ArrayList<javaBeans>) request.getAttribute("contatos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda</title>
<link rel="icon"
	href="img/6989139_disease_diagnosis_healthcare_checkup_virus_icon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de contatos</h1>
	<a href="Novo.html" class="button">Novo contato</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Codigo</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>E-mail</th>
				<th>Opções</th>
				
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdcon()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getFone()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td> <a href="select?idcon=<%=lista.get(i).getIdcon() %>" class="button">editar</a></td>
			</tr>

			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>