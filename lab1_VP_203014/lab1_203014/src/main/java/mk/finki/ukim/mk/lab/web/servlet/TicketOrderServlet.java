package mk.finki.ukim.mk.lab.web.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.TicketOrder;
import mk.finki.ukim.mk.lab.service.TicketOrderService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name="ticket-order", urlPatterns = "/ticketOrder")
public class TicketOrderServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private TicketOrderService ticket;

    public TicketOrderServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

            @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            IWebExchange webExchange = JakartaServletWebApplication
                    .buildApplication(getServletContext())
                    .buildExchange(req, resp);
            WebContext context = new WebContext(webExchange);

                context.setVariable("title", req.getParameter("title"));
                context.setVariable("numTickets", req.getParameter("tickets"));
                context.setVariable("ipAddress", req.getRemoteAddr());

            springTemplateEngine
                    .process("orderConfirmation.html",
                            context,
                            resp.getWriter());
        }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            String movieTitle = req.getParameter("same");
            int numTickets = Integer.parseInt(req.getParameter("numTickets"));
            String address = req.getRemoteAddr();


            TicketOrder ticketOrder =  this.ticket.placeOrder(movieTitle, "Mateja Nikolik", address, numTickets);

            req.setAttribute("order",ticketOrder);
            resp.sendRedirect("/ticketOrder");

    }
}
