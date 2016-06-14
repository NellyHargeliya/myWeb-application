package myServlet;

import mypackage.CSVRead;
import mypackage.Contact;
import mypackage.ContactDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Nelly on 12.06.2016.
 */
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ContactServlet() {
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = 1;
        int recordsRerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        ContactDAO dao = new ContactDAO();
        List<Contact> list = dao.viewAllContacts((page - 1) * recordsRerPage, recordsRerPage);
        int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsRerPage);
        request.setAttribute("contactList", list);
        request.setAttribute("noOfPage", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("listContact.jsp");
        view.forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        performTask(req, resp);

    }

    private void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        CSVRead r = new CSVRead();
        r.reader();

    }

}
