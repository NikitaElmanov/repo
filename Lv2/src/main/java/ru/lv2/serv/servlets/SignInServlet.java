package ru.lv2.serv.servlets;

import ru.lv2.serv.accounts.AccountService;
import ru.lv2.serv.accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

public class SignInServlet extends HttpServlet {
    private final AccountService accountService;

    public SignInServlet (AccountService accountService) {
        this.accountService = accountService;
    }

    //sign in
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserProfile userProfile = accountService.getUserBySessionId(login);

        if (Objects.isNull(userProfile)
                || !userProfile.getLogin().equalsIgnoreCase(login)){

            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("Unauthorized");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("Authorized: " + login);
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
