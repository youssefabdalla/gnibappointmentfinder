package org.joe.appointment.finder;

import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by AbdallaY on 05/10/2019.
 */
@RequiredArgsConstructor
public class FormPage {
    private final WebDriver webDriver;
    @FindBy(id = "Category")
    private WebElement categoryElement;
    @FindBy(id = "SubCategory")
    private WebElement subcategoryElement;

    private Select setCategory(String category) {
        Select categorySelect = new Select(categoryElement);
        categorySelect.selectByVisibleText(category);
        return categorySelect;
    }

    public Select setSubcategoryToAll() {
        return setSubcategory("All");
    }

    private Select setSubcategory(String subcat) {
        Select subcategorySelect = new Select(categoryElement);
        subcategorySelect.selectByVisibleText(subcat);
        return subcategorySelect;
    }

    public Select setCategoryToAll() {
        return setCategory("All");
    }
}