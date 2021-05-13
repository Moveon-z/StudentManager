package moveon.studentManager.controller;

import com.google.gson.Gson;
import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.StudentInfo;
import moveon.studentManager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/findMyCourse")
    public void findMyCourse(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        String tid = request.getParameter("tid");
        List<Course> list = teacherService.findMyCourse(tid);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
    }

    @RequestMapping("/managerStudent")
    public void managerStudent(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
        String tid = request.getParameter("tid");
        List<StudentInfo> list = teacherService.managerStudent(tid);
        Gson gson = new Gson();
        String json = gson.toJson(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
    }

    @RequestMapping("/modifyScore")
    public void modifyScore(HttpServletRequest request,HttpServletResponse response,Model model){
        String sid = request.getParameter("sid");
        String tid = request.getParameter("tid");
        String newScore = request.getParameter("newScore");
        teacherService.modifyScore(sid,tid,newScore);
    }

    @RequestMapping("/updateTeacherInfo")
    public void updateTeacherInfo(HttpServletRequest request,HttpServletResponse response){
        String tid = request.getParameter("tid");
        String tname = request.getParameter("tname");
        String age = request.getParameter("age");
        String birthday = request.getParameter("birthday");
        String sex = request.getParameter("sex");
        String course = request.getParameter("course");
        teacherService.updateTeacherInfo(tid,tname,age,birthday,sex,course);
    }
}
