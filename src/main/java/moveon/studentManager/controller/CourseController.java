package moveon.studentManager.controller;

import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Mod;
import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.StudentCourseScore;
import moveon.studentManager.service.CourseService;
import moveon.studentManager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.reflect.generics.tree.VoidDescriptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentService studentService;

    /**
     * 通过课程编号查询课程
     * @param request
     * @param response
     */
    @RequestMapping("/findCourse")
    public void findCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String cid = request.getParameter("cid");
        Course course = courseService.findCourse(cid);
        Gson gson = new Gson();
        String json = gson.toJson(course);
        response.getWriter().print(json);
    }

    /**
     * 通过学生id查询该学生所有的课程
     * @param request
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping("/findAllScore")
    public void findAllScore(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String sid = request.getParameter("sid");
        List<StudentCourseScore> allScore = courseService.findAllScore(sid);
        Gson gson = new Gson();
        String json = gson.toJson(allScore);
        response.getWriter().print(json);
    }

    /**
     * 通过学生的id和课程id查询该学生的该课程的排名
     * @param request
     * @param response
     * @param model
     * @throws IOException
     */
    @RequestMapping("/findCourseScoreRanking")
    public void findCourseScoreRanking(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        String sid = request.getParameter("sid");
        String cid = request.getParameter("cid");
        String ranking = courseService.courseScoreRanking(sid, cid);
        response.getWriter().print(ranking);
    }

    @RequestMapping("/findAllCourse")
    public void findAllCourse(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Course> list = courseService.allCourse();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        response.getWriter().print(json);
    }

}
