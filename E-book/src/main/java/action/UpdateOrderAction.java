package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.*;
import org.hibernate.Hibernate;
import service.AppService;

import java.sql.Timestamp;
import java.util.*;

public class UpdateOrderAction extends ActionSupport {
    private int id;
    private Timestamp time;
    private byte status;
    private Set<User> user = new HashSet<>();
    private Set<OrderItem> items;
    private int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    private AppService appService;

    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    public String add() throws Exception {
        Order order = new Order();
        order.setTime(new Timestamp(new Date().getTime()));

        User result = appService.getUserById(this.userid);
        if (result == null) {
            return "error";
        }
        Hibernate.initialize(result.getOrders());
        Set<User> user = new HashSet<>();
        user.add(result);
        order.setUser(user);

        Set<OrderItem> items = new HashSet<>();
        Map<String, Object> usersession = ActionContext.getContext().getSession();
        if (usersession.get("cart") != null) {
            Set<CartItem> cart = (Set<CartItem>) usersession.get("cart");
            Iterator it = cart.iterator();
            while (it.hasNext()) {
                CartItem item = (CartItem) it.next();
                OrderItem temp = new OrderItem();
                Book book = appService.getBookById(item.getBook());
                if (book == null) return "error";
                temp.setOrder(order);
                temp.setBookid(item.getBook());
                temp.setAmount(item.getAmount());
                items.add(temp);
                System.out.println(book.getId());
            }
            order.setItems(items);
            usersession.replace("cart", new HashSet<>());
        } else {
            return "error";
        }
        appService.addOrder(order);
        return "success";
    }

    public String querySales() throws Exception {
        List<Order> orders = appService.getAllOrders();
        for (Order order : orders) {
            Set<OrderItem> items = order.getItems();
            for (OrderItem item : items) {
                int flag = 0;
                for (OrderItem this_item: items){
                    if (this_item.getBook().getId() == item.getBookid()) {
                        this_item.setAmount(this_item.getAmount() + item.getAmount());
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) {
                    items.add(item);
                }
            }
        }
        return "success";
    }
}
