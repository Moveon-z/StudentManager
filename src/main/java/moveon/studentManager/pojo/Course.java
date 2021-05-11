package moveon.studentManager.pojo;

import java.io.Serializable;

public class Course implements Serializable {

    private Integer courseId;
    private String courseName;
    private String courseTeacher;
    private String courseSite;
    private String courseTime;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getCourseSite() {
        return courseSite;
    }

    public void setCourseSite(String courseSite) {
        this.courseSite = courseSite;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseTeacher='" + courseTeacher + '\'' +
                ", courseSite='" + courseSite + '\'' +
                ", courseTime='" + courseTime + '\'' +
                '}';
    }
}
