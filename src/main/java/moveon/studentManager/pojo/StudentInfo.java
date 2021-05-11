package moveon.studentManager.pojo;

import java.io.Serializable;

public class StudentInfo implements Serializable {

    private Integer sid;
    private String name;
    private String cls;
    private String sex;
    private String score;

    @Override
    public String toString() {
        return "StudentInfo{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", cls='" + cls + '\'' +
                ", sex='" + sex + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
