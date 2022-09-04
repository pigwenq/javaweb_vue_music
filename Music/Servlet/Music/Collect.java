package Music;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Collect
 */
@WebServlet("/Collect")
public class Collect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Collect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out =  response.getWriter();
		
		
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		
		String sql = null;
		Connection conn = DBConn.getConn();
		PreparedStatement pst =null;
		ResultSet rs = null;
		
		try {
			//查询是否已有收藏记录
			sql = "select * from collect where songid = ? and username = ? ";
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2,username);
			rs = pst.executeQuery();
			//已有记录
			if(rs.next()) {
				//修改无
				sql = "delete from collect where songid = ? and username = ?";
				pst = conn.prepareStatement(sql);
				pst.setString(1, id);
				pst.setString(2,username);
				pst.execute();
			}else {
				sql = "insert into collect values(null,?,?,?)";
				pst = conn.prepareStatement(sql);
				
				pst.setString(1,username);
				pst.setString(2, id);
				pst.setTimestamp(3,new Timestamp(System.currentTimeMillis()));
				pst.execute();
				out.print("收藏成功");
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
