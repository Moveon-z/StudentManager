package moveon.studentManager.service.impl;

import moveon.studentManager.mapper.StudentMapper;
import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.stu_course;
import moveon.studentManager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper mapper;

    @Override
    public List<Course> findStudentCourse(String sid) {
        return mapper.findStudentCourse(sid);
    }

    @Override
    public void deleteCourse(String sid,String cid){
        mapper.deleteCourse(sid,cid);
    }

    @Override
    public void addCourse(String sid, String cid) {
        mapper.insertCourse(sid,cid);
    }

    @Override
    public void updateStudentInfo(String sid, String name, String age, String cls, String birthday, String sex, String num) {
        mapper.updateStudentInfo(sid,name,age,cls,birthday,sex,num);
    }
}
