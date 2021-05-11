package moveon.studentManager.service.impl;

import moveon.studentManager.mapper.TeacherMapper;
import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.StudentInfo;
import moveon.studentManager.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Course> findMyCourse(String tid) {
        return teacherMapper.findMyCourse(tid);
    }

    @Override
    public List<StudentInfo> managerStudent(String tid) {
        return teacherMapper.managerStudent(tid);
    }

    @Override
    public void modifyScore(String sid, String tid, String newScore) {
        teacherMapper.modifyScore(sid,tid,newScore);
    }
}
