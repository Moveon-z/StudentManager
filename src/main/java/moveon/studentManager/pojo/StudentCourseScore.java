package moveon.studentManager.pojo;

import java.io.Serializable;

public class StudentCourseScore implements Serializable {

    private Integer cid;
    private String courseName;
    private String courseTeacher;
    private String courseSite;
    private String courseTime;
    private Double score;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentCourseScore{" +
                "cid=" + cid +
                ", courseName='" + courseName + '\'' +
                ", courseTeacher='" + courseTeacher + '\'' +
                ", courseSite='" + courseSite + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", score=" + score +
                '}';
    }
}
