package service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import dao.ListDao;
import vo.*;

public class ListService {
	// month top 10 list
	public List<Report> monthTopList(Report report) {
		System.out.println("▶▶▶▶▶ ListService 도착");
		// 받아온 매개변수 값 확인
		System.out.println("Report : "+report);
		
		List<Report> list = new ArrayList<Report>();
		Connection conn = null;
		
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ListDao listDao = new ListDao();
			list = listDao.monthTopList(conn, report);
			System.out.println("▶▶▶▶▶ ListService 2번째 도착");
			System.out.println("ListDao success!");
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ListService success!");
		return list;
	}
	
	// day top 10 list
	public List<Report> dayTopList(Report report) {
		System.out.println("▶▶▶▶▶ ListService 도착");
		// 받아온 매개변수 값 확인
		System.out.println("Report : "+report);
		
		List<Report> list = new ArrayList<Report>();
		Connection conn = null;
		
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ListDao listDao = new ListDao();
			list = listDao.dayTopList(conn, report);
			System.out.println("▶▶▶▶▶ ListService 2번째 도착");
			System.out.println("ListDao success!");
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ListService success!");
		return list;
	}
	
	// all top 10 list
	public List<Report> allTopList(Report report) {
		System.out.println("▶▶▶▶▶ ListService 도착");
		// 받아온 매개변수 값 확인
		System.out.println("Report : "+report);
		
		List<Report> list = new ArrayList<Report>();
		Connection conn = null;
		
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ListDao listDao = new ListDao();
			list = listDao.allTopList(conn, report);
			System.out.println("▶▶▶▶▶ ListService 2번째 도착");
			System.out.println("ListDao success!");
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ListService success!");
		return list;
	}
	
	
	public List<Report> myReportList(Report report) {
		System.out.println("▶▶▶▶▶ ListService 도착");
		// 받아온 매개변수 값 확인
		System.out.println("Report : "+report);
		
		List<Report> list = new ArrayList<Report>();
		Connection conn = null;
		
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ListDao listDao = new ListDao();
			list = listDao.myReportList(conn, report);
			System.out.println("▶▶▶▶▶ ListService 2번째 도착");
			System.out.println("ListDao success!");
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("listService success!");
		return list;
	}
}
