package moveon.studentManager.pojo;

import java.io.Serializable;

public class stu_course implements Serializable {

    private String name;
    private Integer courseId;
    private String courseName;
    private String courseTeacher;
    private String courseSite;
    private String courseTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public void setCourseTeacher(String courseTea) {
        this.courseTeacher = courseTea;
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
        return "stu_course{" +
                "name='" + name + '\'' +
                ", courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseTeacher='" + courseTeacher + '\'' +
                ", courseSite='" + courseSite + '\'' +
                ", courseTime='" + courseTime + '\'' +
                '}';
    }
}
