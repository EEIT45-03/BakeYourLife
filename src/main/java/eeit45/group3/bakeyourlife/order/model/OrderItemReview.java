package eeit45.group3.bakeyourlife.order.model;

public class OrderItemReview {
    private String productNo;
    private String productName;
    private Integer star=1;
    private String commentContent;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Override
    public String toString() {
        return "商品評價{" +
                "productNo='" + productNo + '\'' +
                ", productName='" + productName + '\'' +
                ", star=" + star +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}
