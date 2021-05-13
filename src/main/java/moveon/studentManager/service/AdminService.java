package moveon.studentManager.service;

import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.Student;
import moveon.studentManager.pojo.Teacher;

import java.util.List;

public interface AdminService {
    /**
     * 查询所有课程
     * @return
     */
    List<Course> findAllCourse();

    /**
     * 查询所有教师
     * @return
     */
    List<Teacher> findAllTeacher();

    /**
     * 查询所有学生
     * @return
     */
    List<Student> findAllStudent();

    /**
     * 删除课程
     * @param cid
     */
    void deleteCourse(String cid);

    /**
     * 删除教师
     * @param tid
     */
    void deleteTeacher(String tid);

    /**
     * 删除学生
     * @param sid
     */
    void deleteStudent(String sid);

    /**
     *添加课程
     * @param courseId
     * @param courseName
     * @param courseTeacher
     * @param courseSite
     * @param courseTime
     */
    void insertOneCourse(String courseId,String courseName,String courseTeacher,String courseSite,String courseTime);

    /**
     * 添加教师
     * @param tid
     * @param tname
     * @param age
     * @param birthday
     * @param sex
     * @param course
     */
    void insertOneTeacher(String tid,String tname,String age,String birthday,String sex,String course);

    /**
     * 添加学生
     * @param sid
     * @param name
     * @param age
     * @param cls
     * @param birthday
     * @param sex
     * @param num
     */
    void insertOneStudent(String sid,String name,String age,String cls,String birthday,String sex,String num);

    /**
     * 通过课程名称模糊查询课程
     * @param cname
     */
    List<Course> findOneCourse(String cname);

    /**
     * 通过教师姓名模糊查询教师
     * @param tname
     * @return
     */
    List<Teacher> findOneTeacher(String tname);

    /**
     * 通过学生姓名模糊查询学生
     * @param sname
     * @return
     */
    List<Student> findOneStudent(String sname);

    /**
     * 设置课程的教师
     * @param tid
     * @param cid
     */
    void addCourseTeacher(String tid,String cid);
}
