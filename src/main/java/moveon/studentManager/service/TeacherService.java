package moveon.studentManager.service;

import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.StudentInfo;

import java.util.List;

public interface TeacherService {

    /**
     * 通过教师id查询该教师所教的课程
     * @param tid
     * @return
     */
    List<Course> findMyCourse(String tid);

    /**
     * 通过教师id管理学生
     * @param tid
     * @return
     */
    List<StudentInfo> managerStudent(String tid);

    /**
     * 通过学生id，教师id修改学生的课程成绩
     * @param sid
     * @param tid
     * @param newScore
     */
    void modifyScore(String sid,String tid,String newScore);
}
