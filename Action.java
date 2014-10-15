package Action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Action {
	private static  Connection conn = null;
	private static Statement st = null;
	
	private static String authorid;
	private static String isbn;
	
	public static Connection getConnection() {  
        Connection con = null;  //创建用于连接数据库的Connection对象  
        try {  
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  
              
            con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/bookdb", "root", "123456");// 创建数据连接  
              
        } catch (Exception e) {  
            System.out.println("数据库连接失败" sdfsdfsdf+ e.getMessage());  
        }  
        return con; //返回所建立的数据库连接  
    }  
	public static void queryAuthorid (){
		
		conn = getConnection();    //同样先要获取连接，即连接到数据库
		try{
			String sql = "select * from author where name = '"+"Roger S.Pressman"+"'";   // 查询数据的sql语句
			st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量
			
			ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集
			while (rs.next()) {
				authorid = rs.getString("authorid");
				System.out.println(authorid);
			}
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String queryBook() {
		
		conn = getConnection();    //同样先要获取连接，即连接到数据库
		try{
			String sql = "select * from book where authorid = '"+authorid+"'";    // 查询数据的sql语句
			st = (Statement) conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量
			
			ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集
			while (rs.next()) {
				isbn = rs.getString("isbn");
				System.out.println(isbn);
			}
	
}
