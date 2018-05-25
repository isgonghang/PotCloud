package com.pot.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pot.service.*;

public class DwrInfoOutput extends HttpServlet{
	String msgs;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String msgs;
		DwrServlet dwr = new DwrServlet();
		DwrInfoOutput infos = new DwrInfoOutput();
		infos.msgs = dwr.msgs;
		PrintWriter infoOut = response.getWriter(); 
		infoOut.write(infos.msgs);
	}
}
