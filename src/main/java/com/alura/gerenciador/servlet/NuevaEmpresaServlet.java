package com.alura.gerenciador.servlet;

import java.awt.image.DataBuffer;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nuevaEmpresa")
public class NuevaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Nueva empresa registrada");
		String nombreEmpresa=request.getParameter("nombre"); 
		
		Empresa empresa=new Empresa();
		empresa.setNombre(nombreEmpresa);
		
		DB baseDeDatos = new DB();
		baseDeDatos.agregarEmpresa(empresa);
		
		//llamar al jsp
		RequestDispatcher rd =  request.getRequestDispatcher("/nuevaEmpresaRegistrada.jsp");
		request.setAttribute("empresa", empresa.getNombre());
		
		rd.forward(request, response);
		
		
	}

}
