package Music;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class GetSongType
 */
@WebServlet("/GetSongType")
public class GetSongType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSongType() {
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
		
		String sql = null;
		Connection conn = DBConn.getConn();
		PreparedStatement pst =null;
		ResultSet rs = null;
		//判断用户名是否存在
		try {
			sql = "select * from songtype";
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();
			List<SongType> types = new ArrayList<SongType>();
			while(rs.next()) {
				SongType type = new SongType();
				type.id = rs.getInt("id");
				type.typename = rs.getString("typename");
				types.add(type);
			}
			
			rs.close();
			pst.close();
			conn.close();
			
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(types);		
			out.print(json);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
