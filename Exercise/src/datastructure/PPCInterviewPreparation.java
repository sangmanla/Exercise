package datastructure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;

public class PPCInterviewPreparation {
    public static void main(String[] args) {
	String[] param = {"1", null, "3", "4", null};
	System.out.println(concatenate(param));
    }

    private static void hashMapTest() {
	HashMap map = new HashMap();
	Object obj1 = new Object();
	Object obj2 = obj1;
	System.out.println(obj1.hashCode());
	System.out.println(obj2.hashCode());
	System.out.println(obj1.equals(obj2));
	map.put(obj1, 1);
	map.put(obj2, 2);
	System.out.println(map.get(obj1));
    }

    /**
     * statement, resultset will be closed automatically
     * @param con
     */
    public static void testTryWithStatement(Connection con){
	String query = "select * from table";
	try(
		Statement stmt = con.createStatement();
    	    	ResultSet rs = stmt.executeQuery(query);
	){
	    while(rs.next()){
		
	    }
	}catch(SQLException e){
	    e.printStackTrace();
	}
    }
    
    public static void testPrepareStatement(){
	Connection con = null;
	PreparedStatement pStmt = null;
	try{
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    con = DriverManager.getConnection("jdbc:oracle:this:@localhost:1521:xe", "user", "pw");
	    
	    int batchCnt = 0;
	    for(int i=0;i<10000;i++){
		pStmt = con.prepareStatement("insert into table values(?, ?)");
		pStmt.setInt(1, 123);
        	pStmt.setString(2, "adf");
        	pStmt.addBatch();
        	batchCnt++;
        	
        	if(batchCnt == 1000){
        	    pStmt.executeBatch();
        	}
	    }
	    con.close();
	}catch(Exception e){
	    try {
		con.rollback();
	    } catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	    }
	    
	}finally{
	    if(pStmt!=null){
		try {
		    pStmt.close();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    if(con!=null){
		try {
		    con.close();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	}
    }

    public static void testStatement() {
	String url = "jdbc:mysql://localhost:testdb";
	String userName = "user";
	String password = "pw";

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String query = "select * from table";
	try {
	    Class.forName("com.mysql.jdbc.driver");
	    con = DriverManager.getConnection(url, userName, password);
	    stmt = con.createStatement();
	    rs = stmt.executeQuery(query);
	    while (rs.next()) {
		rs.getString(0);
	    }
	} catch (Exception e) {

	} finally {
	    if (rs != null) {
		try {
		    rs.close();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    if (stmt != null) {
		try {
		    stmt.close();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	    if (con != null) {
		try {
		    con.close();
		} catch (SQLException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	}
    }
    
    public static String concatenate(String[] strings){
	StringBuffer sb = new StringBuffer();
	Arrays.stream(strings).filter(x->x!=null).forEach(x -> {
	    sb.append(x);
	});
	return sb.toString();
    }
}
