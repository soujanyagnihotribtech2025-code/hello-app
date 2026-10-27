import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String name = request.getParameter("name");
    if (name == null || name.trim().isEmpty()) name = "Guest";

    PrintWriter out = response.getWriter();
    out.println("<!doctype html><html><body><h1>Hello, "
        + escapeHtml(name) + "!</h1></body></html>");
  }

  private String escapeHtml(String value) {
    return value.replace("&", "&amp;").replace("<", "&lt;")
        .replace(">", "&gt;").replace("\"", "&quot;")
        .replace("'", "&#x27;");
  }
}