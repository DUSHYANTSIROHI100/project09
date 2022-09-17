package com.durgasoft;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class UserService {
Connection con;
Statement st;
ResultSet rs;
String status="";
public UserService() {
try {
Class.forName("oracle.jdbc.OracleDriver");
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "xe", "123");
st=con.createStatement();
} catch (Exception e) {
e.printStackTrace();
}
}
public String checkLogin(String uname, String upwd){
try {
rs=st.executeQuery("select * from reg_Users where UNAME='"+uname+"' and UPWD='"+upwd+"'");
boolean b=rs.next();
if(b==true){
status="success";
}else{
status="failure";
}
} catch (Exception e) {
}
return status;
}
public String registration(String uname, String upwd, String uemail, String umobile){
	String status="";
try {
rs=st.executeQuery("select * from reg_Users where UNAME='"+uname+"'");
boolean b=rs.next();
if(b==true){
status="existed";
}else{
	int rowCount=st.executeUpdate("insert into reg_Users values('"+uname+"','"+upwd+"','"+uemail+"','"+umobile+"')");
			if(rowCount==1) {
				status="success";
			}
			else {
				status="failure";
			}
			} 
}catch (Exception e) {
			status="failure";
			e.printStackTrace();
			}
			return status;
			}
			}
