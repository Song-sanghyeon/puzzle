package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import vo.Member;
import vo.Report;

public class ListDao {
	// SELECT member_id, report_date, count, timer FROM report WHERE month(report_date) = month(NOW()) ORDER BY timer ASC, COUNT ASC LIMIT 10
	public List<Report> monthTopList(Connection conn, Report report) {
		System.out.println("▶▶▶▶▶ ListDao 도착");
		// 받아온 매개변수 값 확인
		System.out.println("conn : "+conn);
		System.out.println("report : "+report);
		
		// 쿼리 호출
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT member_id, report_date, count, timer FROM report WHERE month(report_date) = month(NOW()) ORDER BY timer ASC, COUNT ASC LIMIT 10";
		List<Report> list = new ArrayList<Report>();
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				report = new Report();
				report.setMember(new Member());
				report.getMember().setMemberId(rs.getString("member_id"));
				report.setReportDate(rs.getString("report_date"));
				report.setCount(rs.getInt("count"));
				report.setTimer(rs.getInt("timer"));
				list.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(list);
		System.out.println("LitDao success!");
		return list;
	}
	
	// SELECT member_id, report_date, COUNT, timer FROM report WHERE day(report_date) = day(NOW()) ORDER BY timer ASC, COUNT ASC LIMIT 10
	public List<Report> dayTopList(Connection conn, Report report) {
		System.out.println("▶▶▶▶▶ ListDao 도착");
		// 받아온 매개변수 값 확인
		System.out.println("conn : "+conn);
		System.out.println("report : "+report);
		
		// 쿼리 호출
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT member_id, report_date, COUNT, timer FROM report WHERE day(report_date) = day(NOW()) ORDER BY timer ASC, COUNT ASC LIMIT 10";
		List<Report> list = new ArrayList<Report>();
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				report = new Report();
				report.setMember(new Member());
				report.getMember().setMemberId(rs.getString("member_id"));
				report.setReportDate(rs.getString("report_date"));
				report.setCount(rs.getInt("count"));
				report.setTimer(rs.getInt("timer"));
				list.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(list);
		System.out.println("LitDao success!");
		return list;
	}
	
	// SELECT member_id, report_date, COUNT, timer FROM report ORDER BY timer ASC, COUNT ASC LIMIT 10
	public List<Report> allTopList(Connection conn, Report report) {
		System.out.println("▶▶▶▶▶ ListDao 도착");
		// 받아온 매개변수 값 확인
		System.out.println("conn : "+conn);
		System.out.println("report : "+report);
		
		// 쿼리 호출
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT member_id, report_date, COUNT, timer FROM report ORDER BY timer ASC, COUNT ASC LIMIT 10";
		List<Report> list = new ArrayList<Report>();
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				report = new Report();
				report.setMember(new Member());
				report.getMember().setMemberId(rs.getString("member_id"));
				report.setReportDate(rs.getString("report_date"));
				report.setCount(rs.getInt("count"));
				report.setTimer(rs.getInt("timer"));
				list.add(report);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(list);
		System.out.println("LitDao success!");
		return list;
	}
	
	public List<Report> myReportList(Connection conn, Report report) {
		System.out.println("▶▶▶▶▶ ListDao 도착");
		// 받아온 매개변수 값 확인
		System.out.println("conn : "+conn);
		System.out.println("report : "+report);
		
		// 쿼리 호출
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT member_id, report_date, count, timer FROM report WHERE member_id=? LIMIT 10";
		List<Report> list = new ArrayList<Report>();
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, report.getMember().getMemberId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				report.setMember(new Member());
				report.getMember().setMemberId(rs.getString("member_id"));
				report.setReportDate(rs.getString("report_date"));
				report.setCount(rs.getInt("count"));
				report.setTimer(rs.getInt("timer"));
				list.add(report);
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
		System.out.println(list);
		System.out.println("listDao success!");
		return list;
	}
}
