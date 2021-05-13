package moveon.studentManager.controller;

import com.google.gson.Gson;
import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.Student;
import moveon.studentManager.pojo.Teacher;
import moveon.studentManager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/adminFindAllCourse")
    public void findAllCourse(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Course> allCourse = adminService.findAllCourse();
        response.setContentType("text/html;charset=utf-8");
        Gson gson = new Gson();
        String json = gson.toJson(allCourse);
        response.getWriter().print(json);
    }

    @RequestMapping("/adminFindAllTeacher")
    public void findAllTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Teacher> allTeacher = adminService.findAllTeacher();
        response.setContentType("text/html;charset=utf-8");
        Gson gson = new Gson();
        String json = gson.toJson(allTeacher);
        response.getWriter().print(json);
    }

    @RequestMapping("/adminFindAllStudent")
    public void findAllStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Student> allStudent = adminService.findAllStudent();
        response.setContentType("text/html;charset=utf-8");
        Gson gson = new Gson();
        String json = gson.toJson(allStudent);
        response.getWriter().print(json);
    }

    @RequestMapping("/deleteOneCourse")
    public void deleteOneCourse(HttpServletRequest request,HttpServletResponse response){
        String cid = request.getParameter("cid");
        adminService.deleteCourse(cid);
    }

    @RequestMapping("/deleteOneTeacher")
    public void deleteOneTeacher(HttpServletRequest request,HttpServletResponse response){
        String tid = request.getParameter("tid");
        adminService.deleteTeacher(tid);
    }

    @RequestMapping("/deleteOneStudent")
    public void deleteOneStudent(HttpServletRequest request,HttpServletResponse response){
        String sid = request.getParameter("sid");
        adminService.deleteStudent(sid);
    }

    @RequestMapping("/insertNewCourse")
    public void insertNewCourse(HttpServletRequest request,HttpServletResponse response){
        String courseId = request.getParameter("courseId");
        String courseName = request.getParameter("courseName");
        String courseTeacher = request.getParameter("courseTeacher");
        String courseSite = request.getParameter("courseSite");
        String courseTime = request.getParameter("courseTime");
        adminService.insertOneCourse(courseId,courseName,courseTeacher,courseSite,courseTime);
    }

    @RequestMapping("/insertNewTeacher")
    public void insertNewTeacher(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String tid = request.getParameter("tid");
        String tname = request.getParameter("tname");
        String tage = request.getParameter("tage");
        String tbirthday = request.getParameter("tbirthday");
        String tsex = request.getParameter("tsex");
        String tcourse = request.getParameter("tcourse");
        response.setContentType("text/html;charset=utf-8");
        try {
            adminService.insertOneTeacher(tid,tname,tage,tbirthday,tsex,tcourse);
            response.getWriter().print("添加成功");
        }catch (Exception e){
            response.getWriter().print("该系统未录入id为"+tid+"的用户，请先注册");
        }
    }

    @RequestMapping("/insertNewStudent")
    public void insertNewStudent(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String sid = request.getParameter("sid");
        String sname = request.getParameter("sname");
        String sage = request.getParameter("sage");
        String scls = request.getParameter("scls");
        String sbirthday = request.getParameter("sbirthday");
        String ssex = request.getParameter("ssex");
        String snum = request.getParameter("snum");
        response.setContentType("text/html;charset=utf-8");
        try {
            adminService.insertOneStudent(sid,sname,sage,scls,sbirthday,ssex,snum);
            response.getWriter().print("添加成功");
        }catch (Exception e){
            response.getWriter().print("该系统未录入id为"+sid+"的用户，请先注册");
        }
    }

    /**
     * 通过课程名称模糊查询课程
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/adminFindOneCourse")
    public void findOneCourse(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        String cname = request.getParameter("cname");
        List<Course> courses = adminService.findOneCourse(cname);
        Gson gson = new Gson();
        String json = gson.toJson(courses);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
    }

    @RequestMapping("/findOneTeacher")
    public void findOneTeacher(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String tname = request.getParameter("tname");
        List<Teacher> teachers = adminService.findOneTeacher(tname);
        Gson gson = new Gson();
        String json = gson.toJson(teachers);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
    }

    @RequestMapping("/findOneStudent")
    public void findOneStudent(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String sname = request.getParameter("sname");
        List<Student> students = adminService.findOneStudent(sname);
        Gson gson = new Gson();
        String json = gson.toJson(students);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
    }

    @RequestMapping("/addCourseTeacher")
    public void addCourseTeacher(HttpServletRequest request,HttpServletResponse response){
        String tid = request.getParameter("tid");
        String cid = request.getParameter("cid");
        adminService.addCourseTeacher(tid,cid);
    }
}
