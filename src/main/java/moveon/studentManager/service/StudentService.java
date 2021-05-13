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

    /**
     * 更新学生信息
     * @param sid
     * @param name
     * @param age
     * @param cls
     * @param birthday
     * @param sex
     * @param num
     */
    void updateStudentInfo(String sid,String name,String age,String cls,String birthday,String sex,String num);
}
