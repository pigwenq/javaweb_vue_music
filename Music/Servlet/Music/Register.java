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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ע��
		response.setContentType("text/plain;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out =  response.getWriter();
		
		
		User user = new User();
		user.username = request.getParameter("username");
		user.password = request.getParameter("password");
		user.createtime = new Timestamp(System.currentTimeMillis());
		
		String sql = null;
		Connection conn = DBConn.getConn();
		PreparedStatement pst =null;
		ResultSet rs = null;
		//�ж��û����Ƿ����
		try {
			sql = "select * from user where username = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.username);
			rs = pst.executeQuery();
			if(rs.next()) {
				out.print("�û����Ѵ���");
				rs.close();
				pst.close();
				conn.close();
				return;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//������ʱ����ע��
		try {
			sql = "insert into user value(null,?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.username);
			pst.setString(2,user.password);
			pst.setTimestamp(3, user.createtime);
			pst.execute();
			out.print("ע��ɹ�");
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
