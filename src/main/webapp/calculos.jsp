<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Planilla</title>
</head>
<body bgcolor="c5de9">
<h1>Planilla de trabajadores</h1>
<%!
//metodo calcular planilla por hora...
public int calcular(int x,int y){
	//declaramos una variable de tipo entero
	//para el resultado
	int resultado =x*y;
	
	//retornamos el valor
	return resultado;
	
	
}//fin del metodo calcular...
%>

<% 
//recuperamos los valores del formulario...
int vh=Integer.parseInt(request.getParameter("valorh"));
int ch=Integer.parseInt(request.getParameter("cantidadh"));
//declaramos variable total a pagar de tipo entero...
//int tp=
out.println("<b> Total a pagar a trabajador </b>"+ calcular(vh,ch)+" soles ");
%>
</body>
</html>