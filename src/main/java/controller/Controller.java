package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import robot.Robot;
import robot.SemanticNetRobot;
import robot.TuringRobot;

@WebServlet("/getMsg")
public class Controller extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5765160188981936290L;
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doGet(request, response);
	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String customerContent = request.getParameter("customerContent");
		System.out.println(customerContent);				
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		
		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Robot robot = SemanticNetRobot.getInstance();
//		Robot robot = TuringRobot.getInstance();
		out.write(robot.getReply(customerContent, request.getSession().getId()));
		out.flush();
		out.close();
	}
}
