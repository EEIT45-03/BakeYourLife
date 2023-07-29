package eeit45.group3.bakeyourlife._init;

import eeit45.group3.bakeyourlife.order.model.Order;
import eeit45.group3.bakeyourlife.order.model.OrderItem;
import eeit45.group3.bakeyourlife.order.model.SalesRecord;
import eeit45.group3.bakeyourlife.user.model.User;
import java.sql.*;
import java.util.Comparator;
import java.util.List;
import javax.sql.DataSource;

public class InsertInitDataJdbc {

  private DataSource dataSource;

  public InsertInitDataJdbc(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void saveAllByOrders(List<Order> orders) {
    String orderSql =
        "insert into orders (order_id,address, code, discount_amount, is_review,"
            + " order_date, order_no, order_status, pay_date, pay_type, refund_reason,"
            + " ship_date, shipping_fee, total_price, tracking_number, user_id) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String orderItemSql =
        " insert into order_item (item_no,order_id, product_name, product_no, product_type, qty, sub_total)"
            + " values (?, ?, ?, ?, ?, ?, ?)";

    // 先抓取OoderId、itemNo最後值
    Connection connection = null;
    Statement statement = null;
    PreparedStatement orderPs = null;
    PreparedStatement orderItemPs = null;
    try {
      connection = dataSource.getConnection();

      connection.setAutoCommit(false);
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT MAX(order_id) FROM orders");
      Integer orderId = 0;
      if (resultSet.next()) {
        orderId = resultSet.getInt(1) + 1;
      }
      resultSet = statement.executeQuery("SELECT MAX(item_no) FROM order_item");
      Integer itemNo = 0;
      if (resultSet.next()) {
        itemNo = resultSet.getInt(1) + 1;
      }
      setOrderId(orders, orderId, itemNo);

      orderPs = connection.prepareStatement(orderSql);
      orderItemPs = connection.prepareStatement(orderItemSql);

      int batchSize = 10000;
      int orderCount = 0;

      for (Order order : orders) {

        orderPs.setInt(1, order.getOrderId());
        orderPs.setString(2, order.getAddress());
        if (order.getCoupon() == null) {
          orderPs.setNull(3, Types.VARCHAR);
        } else {
          orderPs.setString(3, order.getCoupon().getCode());
        }
        orderPs.setInt(4, order.getDiscountAmount());
        orderPs.setBoolean(5, order.getReview());
        orderPs.setTimestamp(6, new Timestamp(order.getOrderDate().getTime()));
        orderPs.setString(7, order.getOrderNo());
        orderPs.setString(8, order.getOrderStatus().getCode());
        if (order.getPayDate() != null) {
          orderPs.setTimestamp(9, new Timestamp(order.getPayDate().getTime()));
        } else {
          orderPs.setNull(9, Types.TIMESTAMP);
        }
        orderPs.setInt(10, order.getPayType().ordinal());
        orderPs.setString(11, order.getRefundReason());
        if (order.getShipDate() != null) {
          orderPs.setTimestamp(12, new Timestamp(order.getShipDate().getTime()));
        } else {
          orderPs.setNull(12, Types.TIMESTAMP);
        }
        orderPs.setInt(13, order.getShippingFee());
        orderPs.setInt(14, order.getTotalPrice());
        if (order.getTrackingNumber() != null) {
          orderPs.setString(15, order.getTrackingNumber());
        } else {
          orderPs.setNull(15, Types.VARCHAR);
        }
        orderPs.setInt(16, order.getUser().getUserId());
        orderPs.addBatch();
        orderCount++;

        for (OrderItem orderItem : order.getOrderItemList()) {
          orderItemPs.setInt(1, orderItem.getItemNo());
          orderItemPs.setInt(2, order.getOrderId());
          orderItemPs.setString(3, orderItem.getProductName());
          orderItemPs.setString(4, orderItem.getProductNo());
          orderItemPs.setString(5, orderItem.getProductType());
          orderItemPs.setInt(6, orderItem.getQty());
          orderItemPs.setInt(7, orderItem.getSubTotal());
          orderItemPs.addBatch();
        }

        if (orderCount == batchSize) {
          statement.execute("SET IDENTITY_INSERT orders ON");
          connection.commit();
          int[] orderResult = orderPs.executeBatch();
          statement.execute("SET IDENTITY_INSERT orders OFF");
          connection.commit();
          statement.execute("SET IDENTITY_INSERT order_item ON");
          int[] orderItemResult = orderItemPs.executeBatch();
          statement.execute("SET IDENTITY_INSERT order_item OFF");
          connection.commit();
          orderCount = 0;
          System.out.println("批次新增訂單: " + orderResult.length + " 筆");
          System.out.println("批次新增訂單商品: " + orderItemResult.length + " 筆");
        }
      }

      statement.execute("SET IDENTITY_INSERT orders ON");
      int[] orderResult = orderPs.executeBatch();
      orderPs.close();
      statement.execute("SET IDENTITY_INSERT orders OFF");
      connection.commit();
      statement.execute("SET IDENTITY_INSERT order_item ON");

      int[] orderItemResult = orderItemPs.executeBatch();
      orderItemPs.close();
      System.out.println("總共新增訂單: " + orderResult.length + " 筆");
      System.out.println("總共新增訂單商品: " + orderItemResult.length + " 筆");

      statement.execute("SET IDENTITY_INSERT order_item OFF");
      statement.close();
      connection.commit();
      connection.setAutoCommit(true);
    } catch (SQLException e) {
      try {
        connection.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }
      throw new RuntimeException(e);
    }

    try {
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void saveAllByUsers(List<User> users) {
    String userSql =
        "insert into users "
            + "(user_id, address, authority, birth, email, full_name,"
            + " gender, image_url, password, phone, register_time, username,enabled)"
            + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    Connection connection = null;
    users.sort(Comparator.comparing(User::getRegisterTime));
    try {
      connection = dataSource.getConnection();
      connection.setAutoCommit(false);

      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT MAX(user_id) FROM users");
      int userId = 0;
      if (resultSet.next()) {
        userId = resultSet.getInt(1) + 1;
      }
      PreparedStatement userPs = connection.prepareStatement(userSql);
      for (User user : users) {
        userPs.setInt(1, userId);
        user.setUserId(userId);
        userPs.setString(2, user.getAddress());
        userPs.setString(3, user.getAuthority());
        userPs.setString(4, user.getBirth());
        userPs.setString(5, user.getEmail());
        userPs.setString(6, user.getFullName());
        userPs.setString(7, user.getGender());
        userPs.setString(8, user.getImageUrl());
        userPs.setString(9, user.getPassword());
        userPs.setString(10, user.getPhone());
        userPs.setTimestamp(11, user.getRegisterTime());
        userPs.setString(12, user.getUsername());
        userPs.setBoolean(13, user.isEnabled());
        userPs.addBatch();
        userId++;
      }
      statement.execute("SET IDENTITY_INSERT users ON");
      int[] userResult = userPs.executeBatch();
      statement.execute("SET IDENTITY_INSERT users OFF");
      connection.commit();
      System.out.println("總共新增使用者: " + userResult.length + " 筆");
      statement.close();
      userPs.close();

      connection.setAutoCommit(true);
      connection.close();
    } catch (SQLException e) {
      try {
        connection.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }
      throw new RuntimeException(e);
    }
  }

  public void saveAllBySalesRecords(List<SalesRecord> salesRecords) {
    String userSql =
        "insert into sales_record (id,farmer_id, product_id, product_no, sales_date, sales_qty, sales_sub_total) "
            + "values (?, ?, ?, ?, ?, ?, ?)";
    Connection connection = null;
    try {
      connection = dataSource.getConnection();
      connection.setAutoCommit(false);

      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM sales_record");
      int id = 0;
      if (resultSet.next()) {
        id = resultSet.getInt(1) + 1;
      }
      PreparedStatement userPs = connection.prepareStatement(userSql);
      for (SalesRecord salesRecord : salesRecords) {
        userPs.setInt(1, id);
        salesRecord.setId(id);
        if (salesRecord.getFarmerId() != null) {
          userPs.setInt(2, salesRecord.getFarmerId());
        } else {
          userPs.setNull(2, Types.INTEGER);
        }
        userPs.setInt(3, salesRecord.getProductId());
        userPs.setString(4, salesRecord.getProductNo());
        userPs.setTimestamp(5, new Timestamp(salesRecord.getSalesDate().getTime()));
        userPs.setInt(6, salesRecord.getSalesQty());
        userPs.setInt(7, salesRecord.getSalesSubTotal());
        userPs.addBatch();
        id++;
      }
      statement.execute("SET IDENTITY_INSERT sales_record ON");
      int[] userResult = userPs.executeBatch();
      statement.execute("SET IDENTITY_INSERT sales_record OFF");
      connection.commit();
      System.out.println("總共新增銷售紀錄: " + userResult.length + " 筆");
      statement.close();
      userPs.close();

      connection.setAutoCommit(true);
      connection.close();
    } catch (SQLException e) {
      try {
        connection.rollback();
      } catch (SQLException ex) {
        throw new RuntimeException(ex);
      }
      throw new RuntimeException(e);
    }
  }

  private void setOrderId(List<Order> orders, Integer orderId, Integer itemNo) {
    orders.sort(Comparator.comparing(Order::getOrderDate));
    for (Order order : orders) {
      order.setOrderId(orderId++);
      for (OrderItem orderItem : order.getOrderItemList()) {
        orderItem.setItemNo(itemNo++);
      }
    }
  }
}
