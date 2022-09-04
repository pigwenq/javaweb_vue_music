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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//��¼
		response.setContentType("text/plain;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out =  response.getWriter();
		
		
		User user = new User();
		user.username = request.getParameter("username");
		user.password = request.getParameter("password");
		
		String sql = null;
		Connection conn = DBConn.getConn();
		PreparedStatement pst =null;
		ResultSet rs = null;
		
		String msg ="";
		
		sql = "select * from user where username = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.username);
			rs = pst.executeQuery();
			if(rs.next()) {
				if(rs.getString("password").equals(user.password)) {
					msg = "��¼�ɹ�";
				}else {
					msg = "���벻��ȷ";
				}
			}else {
				msg = "�û���������";
			}
			rs.close();
			pst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//����vue
		out.print(msg);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
