package Components.Resources.Servlet;

import Components.Resources.JavaTodo.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FileCounter")
public class FileCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int count ; 
	private CounterClass counterclass ; 
    public FileCounter() {
        // TODO Auto-generated constructor stub
    }

    
    public void init() throws ServletException{
    	counterclass = new CounterClass() ; 
    	try{
    		count=counterclass.getCount() ; 
    	}catch(Exception exception){
    		 throw new ServletException("An exception occurred in FileCounter"
    		 + exception.getMessage());
    	}//Catch
    }//init
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpsession = request.getSession(true) ; 
		httpsession.setMaxInactiveInterval(5) ; 
		response.setContentType("text/html") ;
		PrintWriter out  = response.getWriter() ;
		if(httpsession.isNew()){
			count++ ; 
		}
		out.println("<h1>This site has been accessed </h1>" + count + " times.");
	}
	public void  destroy(){
		super.destroy() ;
		try{
			counterclass.save(count) ;
		}catch(Exception e ){
			e.printStackTrace() ; 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
