package com.management.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtils extends MainUtils {
	public static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_FORMAT);
	
	public static void response(HttpServletResponse response, String msg) {
		try {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println(msg);
			out.println("</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void goToMainPage(HttpServletRequest request,
            HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  
        try {
			rd.include(request,response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void goToPage(HttpServletRequest request,
            HttpServletResponse response, String page, Map<String, String> map) {
		
		for (Map.Entry<String, String> entry : map.entrySet()) {
			request.setAttribute(entry.getKey(), entry.getValue());
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(page);  
		
        try {
			rd.include(request,response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void goToPage(HttpServletRequest request,
            HttpServletResponse response, String page) {
		RequestDispatcher rd = request.getRequestDispatcher(page);  
		
        try {
			rd.include(request,response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	 public static String getNbr(String str) 
	    { 
	        // Remplacer chaque nombre non numérique par un espace
	        str = str.replaceAll("[^\\d]", " "); 
	        // Supprimer les espaces de début et de fin 
	        str = str.trim(); 
	        // Remplacez les espaces consécutifs par un seul espace
	        str = str.replaceAll(" +", " "); 
	  
	        return str; 
	    } 
	
	
}
