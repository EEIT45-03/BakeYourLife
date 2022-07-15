package eeit45.group3.bakeyourlife.order.utils;

import eeit45.group3.bakeyourlife.order.model.OrderItemReview;

import java.util.ArrayList;

public class ReviewListWrapper {
    private ArrayList<OrderItemReview> reviews;

    public ArrayList<OrderItemReview> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<OrderItemReview> reviews) {
        this.reviews = reviews;
    }
}
