package moveon.studentManager.mapper;

import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.StudentCourseScore;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseMapper {

    /**
     * 查询所有课程
     * @return
     */
    @Select("select * from course")
    List<Course> allCourse();

    /**
     * 通过课程编号查询课程信息
     * @param courseId
     * @return
     */
    @Select("SELECT * FROM course WHERE courseId = #{courseId}")
    Course findCourse(@Param("courseId") String courseId);

    /**
     * 通过学生id查询该学生的所有课程成绩
     * @param sid
     * @return
     */
    @Select("SELECT\n" +
            "\tsc.cid,\n" +
            "\tc.courseName,\n" +
            "\tc.courseTeacher,\n" +
            "\tc.courseSite,\n" +
            "\tc.courseTime,\n" +
            "\tsc.score\n" +
            "FROM\n" +
            "\tstudent s,\n" +
            "\tcourse c,\n" +
            "\tstu_course sc\n" +
            "WHERE\n" +
            "\tsc.cid=c.courseId AND\n" +
            "\tsc.sid=s.sid AND\n" +
            "\tsc.sid=${sid}")
    List<StudentCourseScore> findAllScore(@Param("sid")String sid);


    /**
     * 通过学生id和课程id获得该学生的该课程的排名
     * @param sid
     * @param cid
     * @return
     */
    @Select("SELECT \n" +
            "\trank\n" +
            "FROM \n" +
            "\t(SELECT \n" +
            "\t\tsc.sid,\n" +
            "\t\tc.courseId,\n" +
            "\t\tc.courseName,\n" +
            "\t\tsc.score,\n" +
            "\t\t@courseRank:=@courseRank + 1 AS rank\n" +
            "\tFROM\n" +
            "\t\tstu_course sc,\n" +
            "\t\tcourse c,\n" +
            "\t\tstudent s,\n" +
            "\t\t(SELECT @courseRank:=0) r\n" +
            "\tWHERE\n" +
            "\t\tsc.cid=c.courseId AND\n" +
            "\t\tsc.sid=s.sid AND\n" +
            "\t\tc.courseId=${cid}\n" +
            "\tORDER BY \n" +
            "\t\tscore DESC) rr\n" +
            "WHERE \n" +
            "\tsid=${sid}\n")
    String courseScoreRanking(@Param("sid")String sid,@Param("cid")String cid);
}
