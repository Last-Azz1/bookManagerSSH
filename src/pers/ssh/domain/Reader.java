package pers.ssh.domain;

public class Reader {
    private Integer id;
    private String readername;
    private String readertype;
    private String sex;
    private String tel;
    private int max_num;
    private int days_num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReadername() {
        return readername;
    }

    public void setReadername(String readername) {
        this.readername = readername;
    }

    public String getReadertype() {
        return readertype;
    }

    public void setReadertype(String readertype) {
        this.readertype = readertype;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getMax_num() {
        return max_num;
    }

    public void setMax_num(int max_num) {
        this.max_num = max_num;
    }

    public int getDays_num() {
        return days_num;
    }

    public void setDays_num(int days_num) {
        this.days_num = days_num;
    }

    public Reader() {
    }

    public Reader(Integer id, String readername, String readertype, String sex, String tel, int max_num, int days_num) {
        this.id = id;
        this.readername = readername;
        this.readertype = readertype;
        this.sex = sex;
        this.tel = tel;
        this.max_num = max_num;
        this.days_num = days_num;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", readername='" + readername + '\'' +
                ", readertype='" + readertype + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", max_num=" + max_num +
                ", days_num=" + days_num +
                '}';
    }
}
