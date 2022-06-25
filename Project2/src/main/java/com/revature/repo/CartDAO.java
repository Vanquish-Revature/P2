//
////package com.revature.repo;
////import com.revature.models.Cart;
////import com.revature.models.User;
////
////import java.util.List;
////
////import org.springframework.data.jpa.repository.JpaRepository;
////import org.springframework.stereotype.Repository;
////@Repository
////public class CartDAO {
////	public List<Cart> findCartItemsByUser(User user)
////}
//
//
//import com.revature.models.Cart;
//import com.revature.models.User;
//
//import java.util.List;
//
//
//
//import org.hibernate.Session;
//import com.revature.utilities.HibernateUtil;
//public class CartDAO {
//
//public int submitCart(Cart cart) {
//Session ses = HibernateUtil.getSession();
//ses.save(cart);
//HibernateUtil.closeSession();
//return 0;
//}
//
//public List<Cart> getAllCarts() {
//Session ses = HibernateUtil.getSession();
//List<Cart> cartList = ses.createQuery("FROM Cart").list();
//HibernateUtil.closeSession();
//return cartList;
//}
//
//public Cart getCartById(int id) {
//Session ses = HibernateUtil.getSession();
//Cart cart = ses.get(Cart.class, id);
//HibernateUtil.closeSession();
//return cart;
//}
//}


