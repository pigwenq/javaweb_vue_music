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
 * Servlet implementation class MyloveMusic
 */
@WebServlet("/MyloveMusic")
public class MyloveMusic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyloveMusic() {
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
		
		String username = request.getParameter("username");
		
		String sql = null;
		Connection conn = DBConn.getConn();
		PreparedStatement pst =null;
		ResultSet rs = null;
		
		try {
			sql = "select * from song A join collect B "
					+ "on A.id = B.songid where B.username = ? "
					+ "order by time desc" ; 
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			
			List<Song> songs = new ArrayList<Song>();
			while(rs.next()) {
				Song song = new Song();
				song.id = rs.getInt("id");
				song.songname = rs.getString("songname");
				song.singer = rs.getString("singer");
				song.typename = rs.getString("typename");
				song.fileurl = rs.getString("fileurl");
				song.clicknum = rs.getInt("clicknum");
				song.uploadtime = rs.getTimestamp("uploadtime");
				song.username = rs.getString("username");
				
				int year = song.uploadtime.getYear()+1900;
				int month = song.uploadtime.getMonth()+1;
				int day = song.uploadtime.getDate();
				song.date = String.valueOf(year)+'-'+String.valueOf(month)+
						'-'+String.valueOf(day);
				song.love = true;
				songs.add(song);
			}
			rs.close();
			pst.close();
			conn.close();
			
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(songs);
			
			out.print(json);
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
