package eeit45.group3.bakeyourlife.article.validator;

import eeit45.group3.bakeyourlife.article.model.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ArticleValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        boolean b = Article.class.isAssignableFrom(clazz);
        return b;
    }

    @Override
    public void validate(Object target, Errors errors) {

        Article article = (Article)target;

        ValidationUtils.rejectIfEmptyOrWhitespace
                (errors, "title", "","標題欄不能空白");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "", "日期欄不能空白");
        ValidationUtils.rejectIfEmptyOrWhitespace
                (errors, "content", "","內容欄不能空白");
        ValidationUtils.rejectIfEmptyOrWhitespace
                (errors, "type", "","必須挑選分類欄的選項");



        if (article.getType() == null) {
            errors.rejectValue("type","", "必須挑選分類欄的選項");
        }
    }

}
