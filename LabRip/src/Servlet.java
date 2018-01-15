
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    private List<Bicycle> bicycles;

    public Servlet() {
        this.bicycles = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
		res.setContentType("text/html;charset=UTF-8");

        PrintWriter out = res.getWriter();
 
		out.println("<!DOCTYPE HTML>");
        out.println("<html>");
        out.println("<body>");
        out.println("<table border=\"1\">");
        out.println("<caption>List of bicycles</caption>");
        out.println("<tr>");
        out.println("<th>Manufacturer</th>\n" +
                "    <th>Model</th>\n" +
                "    <th>Year Of Production</th>\n" +
                "    <th>Admition Date</th>\n" +
                "    <th>Is used</th>");
        out.println("</tr>");

        for(Bicycle bicycle : bicycles) {
            out.println(bicycle);
        }
		
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String manufacturer = req.getParameter("manufacturer");
        String model = req.getParameter("model");
        String dateString = req.getParameter("date");
        int yearOfProduction = Integer.parseInt(req.getParameter("yearOfProduction"));
        boolean isNew = req.getParameter( "isUsed" ) != null;

        bicycles.add(new Bicycle(manufacturer, model, yearOfProduction, convertDate(dateString), isNew));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.html");
        requestDispatcher.forward(req, res);
    }

    private Date convertDate(String dateString) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
        return date;
    }
}
