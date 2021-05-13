package moveon.studentManager.mapper;

import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.StudentInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {

    @Select("SELECT \n" +
            "\tc.courseId,\n" +
            "\tc.courseName,\n" +
            "\tc.courseTeacher,\n" +
            "\tc.courseSite,\n" +
            "\tc.courseTime\n" +
            "FROM\n" +
            "\tteacher t,\n" +
            "\tcourse c,\n" +
            "\ttea_course tc\n" +
            "WHERE\n" +
            "\tt.tid=tc.tid AND\n" +
            "\tc.courseId=tc.cid AND\n" +
            "\tt.tid=${tid}")
    List<Course> findMyCourse(@Param("tid") String tid);

    @Select("SELECT\n" +
            "\ts.sid,\n" +
            "\ts.name,\n" +
            "\ts.cls,\n" +
            "\ts.sex,\n" +
            "\tsc.score\n" +
            "FROM\n" +
            "\ttea_course tc,\n" +
            "\tteacher t,\n" +
            "\tstudent s,\n" +
            "\tstu_course sc\n" +
            "WHERE\n" +
            "\tsc.sid=s.sid AND\n" +
            "\tsc.cid=tc.cid AND\n" +
            "\ttc.tid = t.tid AND\n" +
            "\tt.tid = ${tid} ORDER BY score DESC")
    List<StudentInfo> managerStudent(@Param("tid") String tid);

    @Update("UPDATE\n" +
            "\tstu_course sc\n" +
            "SET \n" +
            "\tsc.score=${newScore}\n" +
            "WHERE\n" +
            "\tsc.sid=${sid} AND\n" +
            "\tsc.cid=(SELECT cid FROM tea_course WHERE tid=${tid}) ")
    void modifyScore(@Param("sid")String sid,@Param("tid") String tid,@Param("newScore") String newScore);

    @Insert("INSERT INTO \n" +
            "\tteacher(tid,tname,age,birthday,sex,course)\n" +
            "VALUES\n" +
            "\t(${tid},'${tname}',${age},'${birthday}','${sex}','${course}')\n" +
            "ON DUPLICATE KEY UPDATE\n" +
            "\ttname='${tname}',\n" +
            "\tage=${age},\n" +
            "\tbirthday='${birthday}',\n" +
            "\tsex='${sex}',\n" +
            "\tcourse='${course}'")
    void updateTeacherInfo(@Param("tid") String tid,@Param("tname") String tname,@Param("age") String age,@Param("birthday") String birthday,@Param("sex") String sex,@Param("course") String course);
}
