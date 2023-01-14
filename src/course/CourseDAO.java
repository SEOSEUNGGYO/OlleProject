package course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.DatabaseUtil;

public class CourseDAO {
	public int courseInsert(CourseDTO courseDTO) {
		String SQL = "INSERT INTO course VALUES(?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, courseDTO.getCourse_id());
			pstmt.setString(2, courseDTO.getCourse_name());
			pstmt.setDouble(3, courseDTO.getCourse_length());
			pstmt.setInt(4, courseDTO.getCourse_hour());
			pstmt.setInt(5, courseDTO.getCourse_hour2());
			pstmt.setInt(6, courseDTO.getCourse_level());
			pstmt.setString(7, courseDTO.getCourse_start());
			pstmt.setString(8, courseDTO.getCourse_middle());
			pstmt.setString(9, courseDTO.getCourse_finish());
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(conn!=null) conn.close();}catch(Exception e) {e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		return -1;
	}
	
	//�ڽ� ������ �����Ѵ�
	public int courseUpdate(CourseDTO courseDTO) {
		String SQL = "UPDATE course set course_name=?,course_length=?,course_hour=?,course_hour2=?,course_level=?,course_start=?,course_middle=?,course_finish=? where course_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			
			pstmt.setString(1, courseDTO.getCourse_name());
			pstmt.setDouble(2, courseDTO.getCourse_length());
			pstmt.setInt(3, courseDTO.getCourse_hour());
			pstmt.setInt(4, courseDTO.getCourse_hour2());
			pstmt.setInt(5, courseDTO.getCourse_level());
			pstmt.setString(6, courseDTO.getCourse_start());
			pstmt.setString(7, courseDTO.getCourse_middle());
			pstmt.setString(8, courseDTO.getCourse_finish());
			pstmt.setString(9, courseDTO.getCourse_id());
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(conn!=null) conn.close();}catch(Exception e) {e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		return -1;
	}
	
	//������ �ڽ��� ������ ����
	public int courseDelete(String course_id) {	
		String SQL = "DELETE FROM course where course_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1, course_id);
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(conn!=null) conn.close();}catch(Exception e) {e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e) {e.printStackTrace();}
		}
		return -1;
	}
	
	
	//�ش� �ڽ��� ���� CourseDTO��ü�� ����
	public CourseDTO getCourse(String course_id){
		CourseDTO courseDTO = new CourseDTO();
		String SQL = "SELECT * FROM COURSE where course_id=?;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,course_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
					
				courseDTO.setCourse_id(rs.getString("course_id"));
				courseDTO.setCourse_name(rs.getString("course_name"));
				courseDTO.setCourse_length(rs.getDouble("course_length"));
				courseDTO.setCourse_hour(rs.getInt("course_hour"));
				courseDTO.setCourse_hour2(rs.getInt("course_hour2"));
				courseDTO.setCourse_level(rs.getInt("course_level"));
				courseDTO.setCourse_start(rs.getString("course_start"));
				courseDTO.setCourse_middle(rs.getString("course_middle"));
				courseDTO.setCourse_finish(rs.getString("course_finish"));
				
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(conn!=null) conn.close();}catch(Exception e) {e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		return courseDTO;
	}
	
	//CourseDTO�� ��ü row�� ArrayList�� ����
	public ArrayList<CourseDTO> getAllCourse(){
		ArrayList<CourseDTO> list = new ArrayList<CourseDTO>();
		String SQL = "SELECT * FROM COURSE order by course_id asc;";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DatabaseUtil.getConnection();
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				CourseDTO courseDTO = new CourseDTO();	
				courseDTO.setCourse_id(rs.getString("course_id"));
				courseDTO.setCourse_name(rs.getString("course_name"));
				courseDTO.setCourse_length(rs.getDouble("course_length"));
				courseDTO.setCourse_hour(rs.getInt("course_hour"));
				courseDTO.setCourse_hour2(rs.getInt("course_hour2"));
				courseDTO.setCourse_level(rs.getInt("course_level"));
				courseDTO.setCourse_start(rs.getString("course_start"));
				courseDTO.setCourse_middle(rs.getString("course_middle"));
				courseDTO.setCourse_finish(rs.getString("course_finish"));
				list.add(courseDTO);
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {if(conn!=null) conn.close();}catch(Exception e) {e.printStackTrace();}
			try {if(pstmt!=null) pstmt.close();}catch(Exception e) {e.printStackTrace();}
			try {if(rs!=null) rs.close();}catch(Exception e) {e.printStackTrace();}
		}
		
		return list;
	}
	
	
}
