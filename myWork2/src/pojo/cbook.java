package pojo;

import java.sql.Date;

public class cbook {
    private String isbn;
    private String cless;//和关键字重名
    private String subclass;
    private String name;
    private String author;
    private Float price;
    private Date pubdate;
    private String introduction;

    public cbook() {
    }

    public cbook(String isbn, String cless, String subclass, String name, String author, Float price, Date pubdate, String introduction) {
        this.isbn = isbn;
        this.cless=cless;
        this.subclass = subclass;
        this.name = name;
        this.author = author;
        this.price = price;
        this.pubdate = pubdate;
        this.introduction = introduction;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCless() {
        return cless;
    }

    public void setCless(String cless) {
        this.cless=cless;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return
                introduction+": introduction  " +
                pubdate +": pubdate  " +  '\'' +
                price+ ": price  " +'\'' +
                author+": author  " +  '\'' +
                name+ ": name  " + '\'' +
                subclass +": subclass  " + '\'' +
                cless+": Class  " +'\'' +
                isbn+": isbn'";
    }
}
