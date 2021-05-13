package moveon.studentManager.service.impl;

import moveon.studentManager.mapper.AdminMapper;
import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.Student;
import moveon.studentManager.pojo.Teacher;
import moveon.studentManager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Course> findAllCourse() {
        return adminMapper.findAllCourse();
    }

    @Override
    public List<Teacher> findAllTeacher() {
        return adminMapper.findAllTeacher();
    }

    @Override
    public List<Student> findAllStudent() {
        return adminMapper.findAllStudent();
    }

    @Override
    public void deleteCourse(String cid) {
        adminMapper.deleteCourse(cid);
    }

    @Override
    public void deleteTeacher(String tid) {
        adminMapper.deleteTeacher(tid);
    }

    @Override
    public void deleteStudent(String sid) {
        adminMapper.deleteStudent(sid);
    }

    @Override
    public void insertOneCourse(String courseId, String courseName, String courseTeacher, String courseSite, String courseTime) {
        adminMapper.insertOneCourse(courseId,courseName,courseTeacher,courseSite,courseTime);
    }

    @Override
    public void insertOneTeacher(String tid, String tname, String age, String birthday, String sex, String course) {
        adminMapper.insertOneTeacher(tid,tname,age,birthday,sex,course);
    }

    @Override
    public void insertOneStudent(String sid, String name, String age, String cls, String birthday, String sex, String num) {
        adminMapper.insertOneStudent(sid,name,age,cls,birthday,sex,num);
    }

    @Override
    public List<Course> findOneCourse(String cname) {
        return adminMapper.findOneCourse(cname);
    }

    @Override
    public List<Teacher> findOneTeacher(String tname) {
        return adminMapper.findOneTeacher(tname);
    }

    @Override
    public List<Student> findOneStudent(String sname) {
        return adminMapper.findOneStudent(sname);
    }

    @Override
    public void addCourseTeacher(String tid, String cid) {
        adminMapper.addCourseTeacher(tid,cid);
    }
}
