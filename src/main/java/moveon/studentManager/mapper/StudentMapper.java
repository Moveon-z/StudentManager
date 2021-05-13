package moveon.studentManager.mapper;

import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.stu_course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentMapper {

    /**
     * 查询学生课程
     * @param sid
     * @return
     */
    @Select("SELECT\n" +
            "\tc.*\n" +
            "FROM\n" +
            "\tstudent s,\n" +
            "\tcourse c,\n" +
            "\tstu_course sc\n" +
            "WHERE\n" +
            "\tsc.sid=s.sid\n" +
            "\tAND c.courseId=sc.cid\n" +
            "\tAND s.sid=#{sid}")
    List<Course> findStudentCourse(@Param("sid") String sid);

    /**
     * 删除学生课程
     * @param sid
     */
    @Delete("delete from stu_course where sid=#{sid} AND cid = #{cid}")
    void deleteCourse(@Param("sid") String sid,@Param("cid") String cid);

    /**
     * 选择课程
     * @param sid
     * @param cid
     */
    @Insert("INSERT INTO \n" +
            "\tstu_course(sid,cid,score)\n" +
            "VALUES(${sid},${cid},NULL)")
    void insertCourse(@Param("sid") String sid,@Param("cid") String cid);

    /**
     * 完善学生信息
     * @param sid
     * @param name
     * @param age
     * @param cls
     * @param birthday
     * @param sex
     * @param num
     */
    @Insert("INSERT INTO student(sid,NAME,age,cls,birthday,sex,num)VALUES(${sid},'${name}',${age},'${cls}','${birthday}','${sex}',${num})ON DUPLICATE KEY UPDATE name='${name}',age=${age},cls='${cls}',birthday='${birthday}',sex='${sex}',num=${num}")
    void updateStudentInfo(@Param("sid") String sid,@Param("name") String name,@Param("age") String age,@Param("cls") String cls,@Param("birthday") String birthday,@Param("sex") String sex,@Param("num") String num);
}
