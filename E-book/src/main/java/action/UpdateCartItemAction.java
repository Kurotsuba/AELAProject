package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import model.CartItem;
import service.AppService;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class UpdateCartItemAction extends ActionSupport {
    private int amount;
    private int bookid;

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private AppService appService;

    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    public String update() throws Exception {
        Map<String, Object> usersession = ActionContext.getContext().getSession();
        Set<CartItem> cart = (Set<CartItem>) usersession.get("cart");
        if (cart == null) return "error";
        Iterator it = cart.iterator();
        int flag = 0;
        while (it.hasNext()) {
            CartItem next = (CartItem) it.next();
            if (next.getBook() == this.bookid) {
                next.setAmount(this.amount);
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            CartItem item = new CartItem();
            item.setAmount(this.amount);
            item.setBook(this.bookid);
            cart.add(item);
        }
        usersession.replace("cart", cart);
        return "success";
    }

    public String delete() throws Exception {
        Map<String, Object> usersession = ActionContext.getContext().getSession();
        Set<CartItem> cart = (Set<CartItem>) usersession.get("cart");
        if (cart == null) return "error";
        Iterator it = cart.iterator();
        while (it.hasNext()) {
            CartItem next = (CartItem) it.next();
            if (next.getBook() == this.bookid) {
                it.remove();
                usersession.replace("cart", cart);
                return "success";
            }
        }
        return "error";// id does not exist
    }
}
