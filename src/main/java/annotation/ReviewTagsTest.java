package annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public class ReviewTagsTest {

    @ReviewTag("Positive")
    @ReviewTag("Detailed")
    public void review() {
        System.out.println("This product is amazing! I love it and it works perfectly.");
    }

    public static void main(String[] args) {
        try {
            ReviewTagsTest productReview = new ReviewTagsTest();
            productReview.review();

            // Accessing annotations
            ReviewTag[] tags = ReviewTagsTest.class.getMethod("review").getAnnotationsByType(ReviewTag.class);
            System.out.println("Review Tags:");
            for (ReviewTag tag : tags) {
                System.out.println(tag.value());
            }
        } catch (NoSuchMethodException e) {
        }
    }
}


@Repeatable(ReviewTags.class)
@Retention(RetentionPolicy.RUNTIME)
@interface ReviewTag {
    String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface ReviewTags {
    ReviewTag[] value();
}


