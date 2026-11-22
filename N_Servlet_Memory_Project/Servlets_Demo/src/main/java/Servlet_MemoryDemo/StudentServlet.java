
package Servlet_MemoryDemo;

// Servlet ke required imports
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/students") // Postman ka URL
public class StudentServlet extends HttpServlet {

    // ArrayList me students ka data temporary store hoga
    ArrayList<String> students = new ArrayList<>();

    // Servlet start hone par ye method chalega
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet Started");
    }

    // POST method: Naya student add karne ke liye
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws IOException {

        // Postman se student ka name lena
        String name = req.getParameter("name");

        // Student ko ArrayList me add karna
        students.add(name);

        // Response bhejna
        resp.getWriter().println("Student Added: " + name);
    }

    // GET method: Sabhi students ka data dekhne ke liye
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws IOException {

        // ArrayList ke sabhi students ko ek-ek karke print karna
        for (String name : students) {

            resp.getWriter().println(name);
        }
    }

    // PUT method: Student ka naam update karne ke liye
    @Override
    protected void doPut(HttpServletRequest req,
                         HttpServletResponse resp)
            throws IOException {

        // Purana aur naya naam lena
        String oldName = req.getParameter("oldName");
        String newName = req.getParameter("newName");

        // Purane naam ka index find karna
        int index = students.indexOf(oldName);

        // Agar student mil gaya
        if (index != -1) {

            // Purane naam ki jagah naya naam rakhna
            students.set(index, newName);

            resp.getWriter().println("Student Updated");

        } else {

            // Agar student nahi mila
            resp.getWriter().println("Student Not Found");
        }
    }

    // DELETE method: Student delete karne ke liye
    @Override
    protected void doDelete(HttpServletRequest req,
                            HttpServletResponse resp)
            throws IOException {

        // Delete karne ke liye student ka naam lena
        String name = req.getParameter("name");

        // ArrayList se student remove karna
        boolean result = students.remove(name);

        // Check karna ki student delete hua ya nahi
        if (result) {

            resp.getWriter().println("Student Deleted");

        } else {

            resp.getWriter().println("Student Not Found");
        }
    }

    // Servlet destroy hone par ye method chalega
    @Override
    public void destroy() {

        System.out.println("Servlet Destroyed");
    }
}
