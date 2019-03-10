package model;

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.StrutsStatics;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class User {
    private int id;

    private String pwd;
    private String icon;
    private String phone;
    private String email;
    private String name;
    private Set<Order> orders = new HashSet<>();
    private Set<Order> cart;

    public Set<Order> getCart() {
        return cart;
    }

    public void setCart(Set<Order> cart) {
        this.cart = cart;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
