package action;

import com.opensymphony.xwork2.ActionSupport;
import model.Book;
import service.AppService;

public class UpdateBookAction extends ActionSupport {
    private int id;

    private String name;
    private String author;
    private String summary;
    private float price;
    private int stock;
    private int year;

    public float getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getYear() {
        return year;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private AppService appService;

    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    public String queryItem() throws Exception {
        Book item = appService.getBookById(id);
        if (item != null) {
            setAuthor(item.getAuthor());
            setName(item.getName());
            setPrice(item.getPrice());
            setStock(item.getStock());
            setSummary(item.getSummary());
            setYear(item.getYear());
            return "success";
        }
        return "fail";
    }
}
