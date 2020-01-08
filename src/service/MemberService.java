package service;
import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import vo.Member;

public class MemberService {
	// 게임이 종료된 뒤 level과 exp를 저장하는 service
	
	
	// member level, exp를 가져오기위한 service
		public Member userInfo(Member member) {
			System.out.println("▶▶▶▶▶ MemberService 도착");
			System.out.println("member : "+member);
			
			Connection conn = null;
			try {
				DBService dbService = new DBService();
				conn = dbService.getConnection();
				conn.setAutoCommit(false);
				MemberDao memberDao = new MemberDao();
				member = memberDao.userInfo(conn, member);
				System.out.println("▶▶▶▶▶ MemberService 2번째 도착");
				System.out.println("memberDao success!");
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
			System.out.println("member : "+member);
			System.out.println("MemberService UserInfo success!");
			return member;
		}
	
	// delete
		public void delete(Member member) {
			System.out.println("▶▶▶▶▶ MemberService 도착");
			System.out.println("member : "+member);
			
			Connection conn = null;
			try {
				DBService dbService = new DBService();
				conn = dbService.getConnection();
				conn.setAutoCommit(false);
				MemberDao memberDao = new MemberDao();
				memberDao.delete(conn, member);
				System.out.println("▶▶▶▶▶ MemberService 2번째 도착");
				System.out.println("memberDao success!");
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
			System.out.println("memberService delete success!");
		}
	
	// update
	public void update(Member member) {
		System.out.println("▶▶▶▶▶ MemberService 도착");
		System.out.println("member : "+member);
		
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			MemberDao memberDao = new MemberDao();
			memberDao.update(conn, member);
			System.out.println("▶▶▶▶▶ MemberService 2번째 도착");
			System.out.println("memberDao success!");
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
		System.out.println("memberService update success!");
	}
	
	public void join(Member member) {
		System.out.println("▶▶▶▶▶ MemberService 도착"); // service 도착 확인
		System.out.println(member); // 받아온 매개변수 확인
		
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			MemberDao memberDao = new MemberDao();
			// before
			memberDao.join(conn, member);
			System.out.println("▶▶▶▶▶ MemberService 2번째 도착");
			System.out.println("memberDao success!");
			// after
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
		System.out.println("MemberService join success!");
	}
	
	public String login(Member member) {
		System.out.println("▶▶▶▶▶ MemberService 도착"); // service 도착 확인
		System.out.println(member); // 받아온 매개변수 확인
		
		Member returnMember = null;
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			MemberDao memberDao = new MemberDao();
			// before
			returnMember = memberDao.login(conn, member);
			System.out.println("▶▶▶▶▶ MemberService 2번째 도착");
			System.out.println("memberDao success!");
			// after
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
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
		return returnMember.getMemberId();
	}
}
