package mk.finki.ukim.mk.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.service.MovieService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="movie-servlet")
public class MovieListSevlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final MovieService movieService;

    public MovieListSevlet(SpringTemplateEngine springTemplateEngine,MovieService movieService) {
        this.springTemplateEngine = springTemplateEngine;
        this.movieService = movieService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req,resp);

        WebContext context = new WebContext(webExchange);
        context.setVariable("movies", movieService.listAll());;

        springTemplateEngine.process(
                "listMovies.html",
                context,
                resp.getWriter()
        );
    }

    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String title = req.getParameter("radio");
            int tickets = Integer.parseInt(req.getParameter("numTickets"));
            System.out.println(title + tickets);
            resp.sendRedirect("/ticketOrder?title=" + title + "&tickets=" + tickets);
        }
}
