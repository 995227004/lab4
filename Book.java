package Action;



import java.sql.Connection; 
import java.sql.Date;
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;



@SuppressWarnings("serial")
public class Book extends ActionSupport{
	
	private String author;
	private int age;
	
	private float price;
	dfsfsdfdf
	public String getTitle() {
		return title;
	}


	public String getCountry() {
		return country;
	}



	public float getPrice() {
		return price;
	}


	public String getPublisher() {
		return publisher;
	}


	public Date getPublishdate() {
		return publishdate;
	}


	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}
	

	public int getAge() {
		return age;
	}


	
	public String getIsbn() {
		return isbn;
	}


	

	public String getAuthorid() {
		return authorid;
	}



	private  Connection conn = null;
	private  Statement st = null;
	
//	public static void main(String args[]){
//		GetBook get = new GetBook();
//	}
	
//	public GetBook(){
//		String dtr = null;
//		dtr = execute();
//		//System.out.print(author);
//		System.out.print(authorid);
//	}

	/**
	 * execute
	 */
	public String execute(){
		//isbn = "Hello everybody!!";
		queryAuthorid();
		queryBook();
		return "success";
	}
	
	
	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public Connection getConnection() {  
        Connection con = null;  //创建用于连接数据库的Connection对象  
        try {  
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  
               
            con = DriverManager.getConnection(  
                    "jdbc:mysql://localhost:3306/bookdb", "root", "123456");// 创建数据连接  
              
        } catch (Exception e) {  
            System.out.println("数据库连接失败" + e.getMessage());  
        }  
        return con; //返回所建立的数据库连接  
    }  
	public void queryAuthorid(){
		
		conn = getConnection();    //同样先要获取连接，即连接到数据库
		try{
			String sql = "select * from author where name = '"+author+"'";   // 查询数据的sql语句
			st = conn.createStatement();    //创建用于执行静态sql语句的Statement对象，st属局部变量
			ResultSet rs = st.executeQuery(sql);    //执行sql查询语句，返回查询数据的结果集
			while (rs.next()) {
				authorid = rs.getString("authorid");
				country = rs.getString("country");
				age = rs.getInt("age");
				System.out.println(authorid);
			}
			conn.close();	
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void queryBook() {
		
	public void validate() {
		
		if (username == null || username.trim().equals("")) {
			
			addFieldError("username", "空！");
		}
		
		if (birthday == null || birthday.after(new Date())) {
			
			addFieldError("birthday", 看见");
		}
		
		if (password1 == null || getPassword1().trim().equals("")) {
			
			addFieldError("password1", "为空！");
		}
	
		if (!getPassword1().equals(getPassword2())) {
			
			addFieldError("password2", "不一样！");
		}
	}
	
	
} 
