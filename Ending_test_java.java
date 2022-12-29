import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Stu{//定义一个学生类
    public String SName;
    public String Sno;
    public int Sage;
    public List<Course> courses;
    public Stu(String SName,String Sno,int Sage,List<Course> courses){
        this.SName = SName;
        this.Sno = Sno;
        this.Sage = Sage;
        this.courses = courses;
    }
    //设置学生的姓名并返回
    public void setSname(String Sname) {
        this.SName = Sname;
    }
    public String getSname(){
        return this.SName;
    }
    //设置学生的学号并返回
    public void setSno(String sno) {
        this.Sno = sno;
    }
    public String getSno() {
        return this.Sno;
    }
    //设置学生的年纪并返回
    public void setSage(int Sage){
        this.Sage = Sage;
    }
    public int getSage(){
        return this.Sage;
    }
    //设置学生的课程并返回
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public List<Course> getCourses() {
        return courses;
    }
    public String toString(){
        return "Student[" +
                "stuName='" + SName + '\'' +
                ", stuNo='" + Sno + '\'' +
                ", stuAge=" + Sage +
                ", courses=" + courses +
                ']';
    }
}
class Course{//定义一个课程类
    public String courseName;//课程名称
    public double dailyGrade;
    public double midGrade;
    public double doGrade;
    public double endGrade;
    public double sumGrade;
    public Course(String courseName,double dailyGrade,double midGrade,double doGrade,double endGrade,double sumGrade){
        this.courseName = courseName;
        this.dailyGrade = dailyGrade;
        this.midGrade = midGrade;
        this.doGrade = doGrade;
        this.endGrade = endGrade;
        this.sumGrade = sumGrade;
    }
    public String getCourseName(){
        return courseName;
    }
    //初始化平时成绩
    public  void setDailyGrade(double dailyGrade){
        this.dailyGrade = dailyGrade;
    }
    public double getDailyGrade(){
        return this.dailyGrade;
    }
    //初始化期中成绩
    public void setMidGrade(double midGrade){
        this.midGrade = midGrade;
    }
    public double getMidGrade(){
        return this.midGrade;
    }
    //初始化实习成绩
    public void setDoGrade(double doGrade){
        this.doGrade =  doGrade;
    }
    public double getDoGrade() {
        return this.doGrade;
    }
    //初始化期末成绩
    public void setEndGrade(double endGrade) {
        this.endGrade = endGrade;
    }
    public double getEndGrade(){
        return this.endGrade;
    }
    //初始化总评成绩
    public void setSumGrade(double sumGrade){
        this.sumGrade = sumGrade;
    }
    public double getSumGrade(){
        return this.sumGrade;
    }
    public String toString() {
        return "Course[" +
                "courseName='" + courseName + '\'' +
                ", dailyGrade=" + dailyGrade +
                ", midGrade=" + midGrade +
                ", doGrade=" + doGrade +
                ", endGrade=" + endGrade +
                ", sumGrade=" + sumGrade +
                ']';
    }
}
class Function_StuService{//具体类的实现方法
    List<Stu> stuList;
    public Function_StuService(){
        this.stuList = new ArrayList<>();
        List<Course> C1 = new ArrayList<>();
        Course c_1 = new Course("Math",55,85,63,96,95);
        Course c_2 = new Course("Chinese",55,42,22,75,75);
        Course c_3 = new Course("English",62,65,19,85,85);
        Course c_4 = new Course("Computer",45,85,85,74,74);
        C1.add(c_1);
        C1.add(c_2);
        C1.add(c_3);
        C1.add(c_4);
        List<Course> C2 = new ArrayList<>();
        Course c_5 = new Course("Math",74,52,85,55,85);
        Course c_6 = new Course("Chinese",52,41,41,26,74);
        Course c_7 = new Course("English",52,25,24,93,96);
        Course c_8 = new Course("Computer",42,85,74,63,75);
        C2.add(c_5);
        C2.add(c_6);
        C2.add(c_7);
        C2.add(c_8);
        List<Course> C3 = new ArrayList<>();
        Course c_9 = new Course("Math",29,85,22,55,85);
        Course c_10 = new Course("Chinese",96,96,85,96,66);
        Course c_11 = new Course("English",66,85,75,96,85);
        Course c_12 = new Course("Computer",88,88,88,56,96);
        C3.add(c_9);
        C3.add(c_10);
        C3.add(c_11);
        C3.add(c_12);

        Stu student1 = new Stu("丽丽","202001",20,C1);
        Stu student2 = new Stu("小王","202002",19,C2);
        Stu student3 = new Stu("小四","202003",21,C3);
        stuList.add(student1);
        stuList.add(student2);
        stuList.add(student3);
    }
    //添加学生进入列表
    public void add(Stu S){
        stuList.add(S);
        System.out.println("添加成功！！！");
    }
    //按照名字查询学生
    public void selectName(String name){
        boolean temp = false;
        for (int i = 0; i < stuList.size(); i++) {
            if (name.equals(stuList.get(i).getSname())){
                temp = true;
                System.out.println("姓名："+stuList.get(i).getSname()+",学号："+stuList.get(i).getSno()+",年龄："+stuList.get(i).getSage());
                System.out.println("该学生的成绩是：");
                for (int j = 0; j < stuList.get(i).getCourses().size(); j++) {
                    System.out.println(stuList.get(i).getCourses().get(j).toString());
                }
            }
        }
        if (!temp){
            System.out.println("很抱歉没有找到该学生信息！");
        }
    }
    //某门课程每个学生的总评成绩，及所有学生的总评成绩的总评分
    public void selectCourse(String courseName) {
        boolean temp = false;
        double sumGrade = 0;
        for (int i = 0; i < stuList.size(); i++) {
            for (int j = 0; j < stuList.get(i).getCourses().size(); j++) {
                if (courseName.equals(stuList.get(i).getCourses().get(j).getCourseName())){
                    temp = true;
                    sumGrade += stuList.get(i).getCourses().get(j).getSumGrade();
                    System.out.println(stuList.get(i).getSname()+"总评分是："+stuList.get(i).getCourses().get(j).getSumGrade());
                }
            }
        }
        if(!temp) {
            System.out.println("很抱歉没有找到该课程信息！");
        }else {
            System.out.println("所有学生的总评分是："+sumGrade);
        }
    }
    //分区段统计学生总评成绩的总评分
    public void selectCourseGrade(String course) {
        int excellent = 0;//优秀：90-100
        int fine = 0;//良好：70-89
        int qualified = 0;//合格：60-69
        int disqualification = 0;//不合格：0-59
        for (int i = 0; i < stuList.size(); i++) {
            for (int j = 0; j < stuList.get(i).getCourses().size(); j++) {
                if (stuList.get(i).getCourses().get(j).getSumGrade()>=90 ){
                    excellent++;
                }else if (stuList.get(i).getCourses().get(j).getSumGrade()>=70){
                    fine++;
                }else if (stuList.get(i).getCourses().get(j).getSumGrade()>=60){
                    qualified++;
                }else if (stuList.get(i).getCourses().get(j).getSumGrade()>=0){
                    disqualification++;
                }
            }
        }
        System.out.println("优秀：90-100分的有："+excellent+"人");
        System.out.println("良好：70-89分的有："+fine+"人");
        System.out.println("合格：60-69分的有："+qualified+"人");
        System.out.println("不合格：0-59分的有："+disqualification+"人");
    }
}

public class Ending_test_java {
    public static void main(String[] args){
        String name;
        String name_2;
        String Sno;
        int Sage;
        List<Course> courses;
        String courseName;
        String course;
        System.out.println("请输入你要选择完成的项目：");
        System.out.println("1---创建学号集合");
        System.out.println("2---查询学生信息");
        System.out.println("3---列出某门课程的学生总评，及所有学生的总评分");
        System.out.println("4---分区统计某门课程的学生总评成绩，例如60分以下的学生人数、60-70分的学生人数等" );
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        Function_StuService stuService = new Function_StuService();
        if(num == 1){//创建一个学生集合
            System.out.println("请输入姓名、学号、年龄、所学课程集合");
            name = input.next();
            Sno = input.next();
            Sage = input.nextInt();
            stuService.add(new Stu(name,Sno,Sage,null));
        } else if (num == 2) {//查询学生信息
            System.out.println("请输入你要查询的学生信息：");
            name_2 = input.next();
            stuService.selectName(name_2);
        }else if(num == 3){//列出某门课程的每个学生的总评成绩，及所有学生总评成绩的总评分
            System.out.println("请输入你要查询的课程名称：");
            courseName = input.next();
            stuService.selectCourse(courseName);
        } else if (num == 4) {//分区段查询某门课程的学生的总评成绩
            System.out.println("请输入你要查询的课程：");
            course = input.next();
            stuService.selectCourseGrade(course);
        }
    }
}



