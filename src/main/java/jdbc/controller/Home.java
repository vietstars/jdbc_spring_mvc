package jdbc.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.*; 
import java.util.List;
import java.util.ArrayList;

import jdbc.model.Account;

@Controller
@SuppressWarnings("unchecked")
public class Home {

	private List<Account> accounts = new ArrayList();

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/hypernate","root","admin");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from account");
			while(rs.next()){
				Account account = new Account();
				account.setId(rs.getInt(1));
        		account.setEmail(rs.getString(2));
        		account.setPassword(rs.getString(3));
        		account.setGender(rs.getString(4));
        		account.setStatus(rs.getInt(5));
        		accounts.add(account);
			}
			model.addAttribute("accounts", accounts);
			con.close();  
		}catch(Exception e){ 
			System.out.println(e);
		}
		return "home";
	}

}