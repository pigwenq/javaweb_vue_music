package Music;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UpLoad
 */
@WebServlet("/UpLoad")
@MultipartConfig
public class UpLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out =  response.getWriter();
		
		Song song = new Song();
		song.songname = request.getParameter("songname");
		song.singer = request.getParameter("singer");
		song.username = request.getParameter("username");
		song.typename = request.getParameter("typename");
		song.uploadtime = new Timestamp(System.currentTimeMillis()); 
		
		//获取文件
		Part part = request.getPart("file");
		long len = part.getSize();		
	
		if(len>0) {
			String s = part.getHeader("Content-Disposition");
			int pos = s.lastIndexOf(".");
			String ext = "";//后缀名
			if(pos>0) {
				ext = s.substring(pos,s.length()-1);
			}
			song.fileurl = System.currentTimeMillis()+ext;
			part.write(getServletContext().getRealPath("/")+"//music//"+song.fileurl);
		}
	
		
		String sql = null;
		Connection conn = DBConn.getConn();
		PreparedStatement pst =null;
		//写入
		try {
			sql = "insert into song value(null,?,?,?,?,?,?,0)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, song.songname);
			pst.setString(2,song.singer);
			pst.setString(3, song.fileurl);
			pst.setString(4, song.username);
			pst.setString(5, song.typename);
			pst.setTimestamp(6, song.uploadtime);
			pst.execute();
			out.print("上传成功");
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
