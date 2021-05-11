package moveon.studentManager.service;

import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.stu_course;

import java.util.List;

public interface StudentService {

    /**
     * 查询学生课程
     * @param sid
     * @return
     */
    List<Course> findStudentCourse(String sid);

    /**
     * 删除学生课程
     * @param sid
     */
    void deleteCourse(String sid,String cid);

    /**
     * 添加学生课程
     * @param sid
     * @param cid
     */
    void addCourse(String sid,String cid);
}
