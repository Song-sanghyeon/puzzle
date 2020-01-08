package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.MemberDao;
import dao.ReportDao;
import vo.Member;
import vo.Report;

public class ReportService {
	// time attack 최고 기록 가져오기
	public int bestTimeReport(Report report) {
		System.out.println("▶▶▶▶▶ ReroitService 도착");
		
		Connection conn = null;
		int bestTime = 0;
		
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ReportDao reportDao = new ReportDao();
			bestTime = reportDao.bestTimeReport(conn, report);
			System.out.println("▶▶▶▶▶ ReportService 2번째 도착");
			System.out.println("ReportDao success!");
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
		System.out.println("ReportService success!");
		return bestTime;
	}
	
	public void AddReport(Report report, Member member) {
		System.out.println("▶▶▶▶▶ ReportService 도착");
		// 받아온 매개변수값 확인
		System.out.println("report : "+report);
		System.out.println("member : "+member);
		
		Connection conn = null;
		
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			// report insert
			ReportDao reportDao = new ReportDao();
			reportDao.addReport(conn, report);
			System.out.println("▶▶▶▶▶ ReportService 2번째 도착");
			System.out.println("ReportDao success!");
			// member insert
			MemberDao memberDao = new MemberDao();
			memberDao.userLevel(conn, member);
			System.out.println("▶▶▶▶▶ ReportService 2번째 도착");
			System.out.println("ReportDao success!");
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
		System.out.println("ReportService success!");
	}
}
