package moveon.studentManager.controller;

import com.google.gson.Gson;
import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.stu_course;
import moveon.studentManager.service.CourseService;
import moveon.studentManager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 通过学生id查询课程
     * @param request
     * @param response
     */
    @RequestMapping("/findStudentCourse")
    public void findCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String sid = request.getParameter("sid");
        List<Course> studentCourse = studentService.findStudentCourse(sid);
        Gson gson = new Gson();
        String json = gson.toJson(studentCourse);
        response.getWriter().print(json);
    }


    /**
     * 通过学生id和课程id删除学生的课程
     * @param request
     * @param response
     */
    @RequestMapping("/deleteCourse")
    public void deleteCourse(HttpServletRequest request,HttpServletResponse response){
        String sid = request.getParameter("sid");
        String cid = request.getParameter("cid");
        studentService.deleteCourse(sid,cid);
        System.out.println("删除成功");
    }

    @RequestMapping("/addCourse")
    public void addCourse(HttpServletRequest request,HttpServletResponse response){
        String sid = request.getParameter("sid");
        String cid = request.getParameter("cid");
        studentService.addCourse(sid,cid);
    }

}
