package moveon.studentManager.service;

import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.StudentCourseScore;

import java.util.List;


public interface CourseService {



    /**
     * 通过课程编号查询课程信息
     * @param courseId
     */
    Course findCourse(String courseId);

    /**
     * 通过学生id查询该学生所有课程成绩
     * @param sid
     * @return
     */
    List<StudentCourseScore> findAllScore(String sid);

    /**
     * 通过学生id和课程id查询该学生的该课程的排名
     * @param sid
     * @param cid
     * @return
     */
    String courseScoreRanking(String sid,String cid);

    /**
     * 查询所有课程
     * @return
     */
    List<Course> allCourse();
}
