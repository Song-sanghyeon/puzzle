package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.Member;

public class MemberDao {
	// UPDATE member SET level=?, exp=? WHERE member_id=?
	public void userLevel(Connection conn, Member member) {
		System.out.println("▶▶▶▶▶ MemberDao 도착");
		System.out.println("conn : "+conn);
		System.out.println("member : "+member);
		
		PreparedStatement stmt = null;
		String sql = "UPDATE member SET level=?, exp=? WHERE member_id=?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, member.getLevel());
			stmt.setInt(2, member.getExp());
			stmt.setString(3, member.getMemberId());
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
		System.out.println("memberDao update success!");
	}
	
	// SELECT level, exp FROM member WHERE member_id =?
	public Member userInfo(Connection conn, Member member) {
		System.out.println("▶▶▶▶▶ MemberDao 도착");
		System.out.println("conn : "+conn);
		System.out.println("member : "+member);
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT level, exp FROM member WHERE member_id =?";
		
		try {
			stmt = conn.prepareStatement(sql);
			// 매개변수로 받아온 멤버객체에는 현재 로그인되어있는 유저의 id값이 저장되어있다 해당 id값을 기준으로 쿼리문 실행
			stmt.setString(1, member.getMemberId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				member = new Member();
				member.setLevel(rs.getInt("level"));
				member.setExp(rs.getInt("exp"));
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
		System.out.println("member : "+member);
		return member;
	}
	
	// UPDATE member SET member_id=?, member_level='N' WHERE member_id=?
	public void delete(Connection conn, Member member) {
		System.out.println("▶▶▶▶▶ MemberDao 도착");
		System.out.println("conn : "+conn);
		System.out.println("member : "+member);
		
		PreparedStatement stmt = null;
		String sql = "DELETE FROM member WHERE member_id=?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
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
		System.out.println("memberDao delete success!");
	}
	
	// UPDATE member SET member_id=?, member_pw=?, member_level='Y' WHERE member_id=?
	public void update(Connection conn, Member member) {
		System.out.println("▶▶▶▶▶ MemberDao 도착");
		System.out.println("conn : "+conn);
		System.out.println("member : "+member);
		
		PreparedStatement stmt = null;
		String sql = "UPDATE member SET member_id=?, member_pw=?, member_level=? WHERE member_id=?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			stmt.setString(3, member.getMemberLevel());
			stmt.setString(4, member.getMemberId());
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
		System.out.println("memberDao update success!");
	}
	
	// INSERT INTO member(member_id, member_pw, member_level) values(?,?,'Y')
	public void join(Connection conn, Member member) {
		System.out.println("▶▶▶▶▶ MemberDao 도착"); // Dao 도착 확인
		System.out.println("conn : "+conn); // 값 확인
		System.out.println("member : "+member);
		
		PreparedStatement stmt = null;
		String sql = "INSERT INTO member(member_id, member_pw, member_level) values(?,?,'Y')";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
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
		System.out.println("join dao success!");
	}
	
	
	// SELECT member_id FROM member WHERE member_id=? AND member_pw=? AND member_level='Y'
	public Member login(Connection conn, Member member) throws Exception {
		System.out.println("▶▶▶▶▶ MemberDao 도착"); // Dao 도착 확인
		System.out.println("conn : "+conn); // 값 확인
		System.out.println("member : "+member);
		
		Member returnMember = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT member_id FROM member WHERE member_id=? AND member_pw=? AND member_level='Y'";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			rs = stmt.executeQuery();
			if(rs.next()) {
				returnMember = new Member();
				returnMember.setMemberId(rs.getString("member_id"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("returnMember : "+returnMember);
		return returnMember;
	}
}
