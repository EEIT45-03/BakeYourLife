package eeit45.group3.bakeyourlife.order.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import eeit45.group3.bakeyourlife.farmerproduct.model.FarmerProductBean;
import eeit45.group3.bakeyourlife.farmerproduct.service.FarmerProductService;
import eeit45.group3.bakeyourlife.good.model.Goods;
import eeit45.group3.bakeyourlife.good.service.GoodService;
import eeit45.group3.bakeyourlife.order.constant.OrderStatus;
import eeit45.group3.bakeyourlife.order.model.Cart;
import eeit45.group3.bakeyourlife.order.model.OrderItemReview;
import eeit45.group3.bakeyourlife.order.utils.ReviewListWrapper;
import eeit45.group3.bakeyourlife.productcomment.model.ProductComment;
import eeit45.group3.bakeyourlife.productcomment.service.ProductCommentService;
import eeit45.group3.bakeyourlife.user.model.User;
import eeit45.group3.bakeyourlife.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.service.OrderService;

@Controller
@SessionAttributes(value = {"cart"})
public class OrderUIController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private FarmerProductService farmerProductService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private ProductCommentService productCommentService;


    @GetMapping("/admin/Order/")
    public String viewAdminIndex(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date sdate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date edate,
            Model model) {
        List<Order> orders = null;
        if (sdate != null && edate != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(edate);
            cal.add(Calendar.DATE, 1);
            edate = cal.getTime();
            orders = orderService.findAllByOrderDateBetween(sdate, edate);
        } else {
            orders = orderService.findAll();
        }

        model.addAttribute("orders", orders);
        return "admin/order/Order";
    }

    @GetMapping("/User/order")
    public String viewOrder() {
        return "order/Order";
    }

    @GetMapping("/Cart")
    public String viewCart(@ModelAttribute Cart cart) {
//		List<Goods> goods = goodService.getAllGoods();
//		model.addAttribute("goods", goods);
        return "order/shoping-cart";
    }

    @GetMapping("CheckOut")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String viewCheckOut(@ModelAttribute("cart") Cart cart,
                               Model model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        User user = userService.getCurrentUser(authentication);
        model.addAttribute("address", user.getAddress());
        return "order/CheckOut";
    }

    @GetMapping("/admin/Order/sale")
    public String viewAdminSale(Model model) {
        Long count = orderService.count();
        List<Order> cancelled = orderService.findAllByOrderStatus(OrderStatus.CANCELLED);
        List<Order> refunded = orderService.findAllByOrderStatus(OrderStatus.REFUNDED);
        model.addAttribute("count", count);
        double cancelledPercent = (double) cancelled.size() / count;
        model.addAttribute("cancelled", (int) (cancelledPercent * 100));
        double refundedPercent = (double) refunded.size() / count;
        model.addAttribute("refunded", (int) (refundedPercent * 100));
        model.addAttribute("year", orderService.findYearSaleAmount());
        return "admin/order/Chart";
    }

    @GetMapping("/User/order/reviews/{orderId}")
    public String viewReviews(@PathVariable Integer orderId, Model model) {
        Order order = orderService.findByOrderId(orderId).orElse(null);
        ReviewListWrapper wrapper = new ReviewListWrapper();
        ArrayList<OrderItemReview> reviews = new ArrayList<>();
        if (order == null) {
            return "redirect:/User/order";
        }
        order.getOrderItemList().forEach(orderItem -> {
            OrderItemReview oir = new OrderItemReview();
            oir.setProductNo(orderItem.getProductNo());
            oir.setProductName(orderItem.getProductName());
            reviews.add(oir);
        });
        wrapper.setReviews(reviews);
        model.addAttribute("wrapper", wrapper);
        return "order/Review";
    }

    @PostMapping("/User/order/reviews/{orderId}")
    public String postReviews(@PathVariable Integer orderId,
                              @ModelAttribute ReviewListWrapper wrapper, Principal principal) {
        Order order = orderService.findByOrderId(orderId).orElse(null);
        if (order == null) {
            return "redirect:/User/order";
        }
        orderService.review(order.getOrderId(), true);
        User user = userService.findByUsername(principal.getName());

        wrapper.getReviews().forEach(review -> {
            //自己在最上面加需要的service
            Integer id = Integer.parseInt(review.getProductNo().substring(1));
            Integer star = review.getStar();
            String comment = review.getCommentContent();
            ProductComment productComment = null;
            switch (review.getProductNo().charAt(0)) {
                case 'F':
                    //小農商品評價
                    System.out.println("商品id:" + id + " star:" + star + " comment:" + comment);

                    FarmerProductBean farmerProductBean = farmerProductService.findByFarmerProductId(id);
                    if (user != null && farmerProductBean != null) {
                        Date date = new Date();
                        productComment = new ProductComment(farmerProductBean, user, date, comment, star);
                    }
                    productCommentService.create(productComment);
                    break;
                case 'G':
                    //烘培商品評價
                    System.out.println("商品id:" + id + " star:" + star + " comment:" + comment);
                    Goods goods = goodService.getGoods(id);
                    System.out.println(goods.getName());
                    if (user != null && goods != null) {
                        Date date = new Date();
                        productComment = new ProductComment(goods, user, date, comment, star);
                    }
                    productCommentService.create(productComment);

                    break;
            }
        });


        return "redirect:/User/order";
    }

    @ModelAttribute
    public Cart cart(@ModelAttribute Cart cart) {
        if (cart == null) {
            return new Cart();
        }
        return cart;
    }
}
