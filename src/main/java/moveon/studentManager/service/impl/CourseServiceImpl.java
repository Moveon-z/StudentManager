package moveon.studentManager.service.impl;

import moveon.studentManager.mapper.CourseMapper;
import moveon.studentManager.pojo.Course;
import moveon.studentManager.pojo.StudentCourseScore;
import moveon.studentManager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("courseService")
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Course findCourse(String courseId) {
        return courseMapper.findCourse(courseId);
    }

    @Override
    public List<StudentCourseScore> findAllScore(String sid) {
        return courseMapper.findAllScore(sid);
    }

    @Override
    public String courseScoreRanking(String sid, String cid) {
        return courseMapper.courseScoreRanking(sid,cid);
    }

    @Override
    public List<Course> allCourse() {
        return courseMapper.allCourse();
    }
}
