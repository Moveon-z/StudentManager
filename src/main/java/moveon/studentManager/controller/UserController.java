package moveon.studentManager.controller;

import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.User;
import moveon.studentManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.jvm.hotspot.debugger.Page;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/mainIndex")
    public void mainIndex(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }

    /**
     * 用户登陆主界面
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/index")
    public String loginStudentUser(Model model, HttpServletRequest request, HttpServletResponse response,HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        List<User> list = userService.loginUser(username,password);
        try {
            if (list != null){
                if (list.get(0).getType().equals("student")){
                    session.setAttribute("sname",list.get(0).getName());
                    session.setAttribute("sid",list.get(0).getId());
                    return "student/studentIndex1.jsp";
                }else if (list.get(0).getType().equals("teacher")){
                    session.setAttribute("tname",list.get(0).getName());
                    session.setAttribute("tid",list.get(0).getId());
                    return "teacher/teacherIndex.jsp";
                }else if(list.get(0).getType().equals("admin")){
                    session.setAttribute("aname",list.get(0).getName());
                    session.setAttribute("aid",list.get(0).getId());
                    return "admin/adminIndex.jsp";
                }
                return "fail.jsp";
            }else {
                return "fail.jsp";
            }
        }catch (Exception ex){
            return "fail.jsp";
        }
    }

    /**
     * 用户注册界面
     * @param model
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/register")
    public String registerUser(Model model,HttpServletRequest request,HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("userType");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setType(type);
        user.setName(name);
        user.setEmail(email);
        boolean flag = userService.registerUser(user);
        if (flag){
            return "../login.jsp";
        }else {
            return "fail.jsp";
        }
    }

    /**
     * 注销/退出用户
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/logoutUser")
    public void logoutUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.setContentType("text/html;charset=utf-8");
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }


    @RequestMapping("/modifyPassword")
    public void modifyPassword(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        String newPassword = request.getParameter("newPassword");
        userService.modifyPassword(id,newPassword);
    }

}
