package moveon.studentManager.mapper;

import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.Student;
import moveon.studentManager.pojo.Teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface AdminMapper {

    /**
     * 查询所有课程
     * @return
     */
    @Select("select * from course")
    List<Course> findAllCourse();

    /**
     * 查询所有教师
     * @return
     */
    @Select("select * from teacher")
    List<Teacher> findAllTeacher();

    /**
     * 查询所有学生
     * @return
     */
    @Select("select * from student")
    List<Student> findAllStudent();

    /**
     * 删除课程
     * @param cid
     */
    @Delete("delete from course where courseId = ${cid}")
    void deleteCourse(@Param("cid") String cid);

    /**
     * 删除教师
     * @param tid
     */
    @Delete("delete from teacher where tid=${tid}")
    void deleteTeacher(@Param("tid") String tid);

    /**
     * 删除学生
     * @param sid
     */
    @Delete("delete from student where sid=${sid}")
    void deleteStudent(@Param("sid") String sid);

    /**
     * 添加课程
     * @param courseId
     * @param courseName
     * @param courseTeacher
     * @param courseSite
     * @param courseTime
     */
    @Insert("insert into course(courseId,courseName,courseTeacher,courseSite,courseTime) values('${courseId}','${courseName}','${courseTeacher}','${courseSite}','${courseTime}')")
    void insertOneCourse(@Param("courseId")String courseId,@Param("courseName")String courseName,@Param("courseTeacher")String courseTeacher,@Param("courseSite")String courseSite,@Param("courseTime")String courseTime);

    /**
     * 添加教师
     * @param tid
     * @param tname
     * @param age
     * @param birthday
     * @param sex
     * @param course
     */
    @Insert("insert into teacher(tid,tname,age,birthday,sex,course) values('${tid}','${tname}','${age}','${birthday}','${sex}','${course}')")
    void insertOneTeacher(@Param("tid") String tid,@Param("tname")String tname,@Param("age")String age,@Param("birthday")String birthday,@Param("sex")String sex,@Param("course")String course);

    /**
     * 添加学生
     * @param sic
     * @param name
     * @param age
     * @param cls
     * @param birthday
     * @param sex
     * @param num
     */
    @Insert("insert into student(sid,name,age,cls,birthday,sex,num) values('${sid}','${name}','${age}','${cls}','${birthday}','${sex}','${num}')")
    void insertOneStudent(@Param("sid") String sic,@Param("name") String name,@Param("age") String age,@Param("cls") String cls,@Param("birthday") String birthday,@Param("sex")String sex,@Param("num")String num);

    /**
     * 通过课程名称模糊查询课程
     * @param cname
     */
    @Select("select * from course where courseName like '%${cname}%'")
    List<Course> findOneCourse(@Param("cname") String cname);

    /**
     * 通过教师姓名模糊查询教师
     * @param tname
     * @return
     */
    @Select("select * from teacher where tname like '%${tname}%'")
    List<Teacher> findOneTeacher(@Param("tname") String tname);

    /**
     * 通过学生姓名模糊查询学生
     * @param sname
     * @return
     */
    @Select("select * from student where name like '%${sname}%'")
    List<Student> findOneStudent(@Param("sname") String sname);

    /**
     * 设置课程的教师
     * @param tid
     * @param cid
     */
    @Insert("insert into tea_course(tid,cid)values(${tid},${cid})ON DUPLICATE KEY UPDATE tid=${tid},cid=${cid}")
    void addCourseTeacher(@Param("tid") String tid,@Param("cid") String cid);
}
