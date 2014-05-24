package data.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.MessageDao;
import data.dao.UserDao;
import data.dao.entity.Message;
import data.dao.entity.User;

/**
 * Servlet implementation class MyPageServlet
 */
public class MyPageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String disp = "WEB-INF/page/mypagetest.jsp";

        // user set
        UserDao userDao = new UserDao();
        User user = userDao.selectByPrimaryKey(1);
        request.setAttribute("user", user);

        // message set
        MessageDao messageDao = new MessageDao();
        List<Message> messageList = messageDao.selectByRecentRecord(20);
        request.setAttribute("messageList", messageList);

        RequestDispatcher dispatch = request.getRequestDispatcher(disp);

        dispatch.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        System.out.println("test");
    }

}
