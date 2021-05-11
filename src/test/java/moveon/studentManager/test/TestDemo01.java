package moveon.studentManager.test;

import moveon.studentManager.pojo.*;
import moveon.studentManager.service.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestDemo01 {


    /**
     * 登陆测试
     */
    @Test
    public void TestDemo01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ac.getBean("userService");
        List<User> list = userService.loginUser("moveon", "moveon");
        System.out.println("该用户的类型为:"+list.get(0).getType());
    }

    /**
     * 注册测试
     */
    @Test
    public void TestDemo02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService) ac.getBean("userService");
        User user = new User();
        user.setUsername("abcd");
        user.setPassword("abcd");
        user.setEmail("609997347@qq.com");
        user.setName("abcd");
        user.setType("student");
        try {
            service.registerUser(user);
            System.out.println("注册成功");
        }catch (Exception e){
            System.out.println("注册失败");
        }
    }

    /**
     * 查询所有课程测试
     */
    @Test
    public void TestDemo03(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService courseService = (CourseService) ac.getBean("courseService");
        List<Course> list = courseService.allCourse();
        for (Course course : list) {
            System.out.println(course);
        }
    }

    /**
     * 通过学生id查询已选课程
     */
    @Test
    public void TestDemo04(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService service = (StudentService)ac.getBean("studentService");
        List<Course> list = service.findStudentCourse("9");
        for (Course course : list) {
            System.out.println(course);
        }
    }

    /**
     * 通过学生id查询所有课程的信息和成绩
     */
    @Test
    public void TestDemo05(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        CourseService service = (CourseService) ac.getBean("courseService");
        List<StudentCourseScore> list = service.findAllScore("9");
        for (StudentCourseScore score : list) {
            System.out.println(score);
        }
    }

    /**
     * 测试通过教师id查找自己的课程
     */
    @Test
    public void TestDemo06(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherService teacherService = (TeacherService) ac.getBean("teacherService");
        List<Course> myCourse = teacherService.findMyCourse("15");
        System.out.println(myCourse);
    }

    /**
     * 测试通过教师id查询自己课程的学生inxi
     */
    @Test
    public void TestDemo07(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherService teacherService = (TeacherService) ac.getBean("teacherService");
        List<StudentInfo> studentInfos = teacherService.managerStudent("15");
        for (StudentInfo studentInfo : studentInfos) {
            System.out.println(studentInfo);
        }
    }

    /**
     * 通过学生id、教师id修改学生成绩
     */
    @Test
    public void TestDemo08(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        TeacherService teacherService = (TeacherService) ac.getBean("teacherService");
        try {
            teacherService.modifyScore("12","15","98");
            System.out.println("修改成功");
        }catch (Exception e){
            System.out.println("修改失败");
        }
    }

    /**
     * 测试管理员删除课程
     */
    @Test
    public void TestDemo09(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService adminService = (AdminService) ac.getBean("adminService");
        List<Course> list = adminService.findAllCourse();
        try {
            adminService.deleteCourse("2");
            System.out.println("删除成功");
        }catch (Exception e){
            System.out.println("删除失败");
        }
    }

    /**
     * 测试根据教师id删除教师
     */
    @Test
    public void TestDemo10(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService adminService = (AdminService) ac.getBean("adminService");
        try {
            adminService.deleteTeacher("7");
            System.out.println("删除成功");
        }catch (Exception e){
            System.out.println("删除失败");
        }
    }

    /**
     * 测试管理员查询所有学生
     */
    @Test
    public void TestDemo11(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService adminService = (AdminService) ac.getBean("adminService");
        List<Student> list = adminService.findAllStudent();
        for (Student student : list) {
            System.out.println(student);
        }
    }

    /**
     * 测试管理员删除指定学生id的学生
     */
    @Test
    public void TestDemo12(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService adminService = (AdminService) ac.getBean("adminService");
        try {
            adminService.deleteStudent("2");
            System.out.println("删除成功");
        }catch (Exception e){
            System.out.println("删除失败");
        }
    }

    /**
     * 测试用户修改密码功能
     */
    @Test
    public void TestDemo13(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ac.getBean("userService");
        try {
            userService.modifyPassword("1","moveon");
            System.out.println("修改成功");
        }catch (Exception e){
            System.out.println("修改失败");
        }
    }

    @Test
    public void TestDemo14(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminService adminService = (AdminService) ac.getBean("adminService");
        List<Course> courses = adminService.findOneCourse("基础");
        for (Course cours : courses) {
            System.out.println(cours);
        }
    }
}
