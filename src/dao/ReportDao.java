package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Report;

public class ReportDao {
	// SELECT MIN(timer) AS best_time FROM report
	public int bestTimeReport(Connection conn, Report report) {
		System.out.println("▶▶▶▶▶ ReportDao 도착");
		// 받아온 매개변수값 확인
		System.out.println("report : "+report);
		System.out.println("conn : "+conn);
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT MIN(timer) AS best_time FROM report";
		int bestTime = 0;
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if(rs.next()) {
				bestTime = rs.getInt("best_time");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ReportDao success!");
		return bestTime;
	}
	
	// INSERT INTO report(member_id, report_date, COUNT, timer) VALUES("a", NOW(), "10", "10")
	public void addReport(Connection conn, Report report) {
		System.out.println("▶▶▶▶▶ ReportDao 도착");
		// 받아온 매개변수값 확인
		System.out.println("report : "+report);
		System.out.println("conn : "+conn);
		
		PreparedStatement stmt = null;
		String sql = "INSERT INTO report(member_id, report_date, COUNT, timer, best_combo, level) VALUES(?, NOW(), ?, ?, ?, ?)";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, report.getMember().getMemberId());
			stmt.setInt(2, report.getCount());
			stmt.setInt(3, report.getTimer());
			stmt.setInt(4, report.getBestCombo());
			stmt.setInt(5, report.getMember().getLevel());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("ReportDao success!");
	}
}
