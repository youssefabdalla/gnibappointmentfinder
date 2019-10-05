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

    private Select setCategory(String category) {
        Select categorySelect = new Select(categoryElement);
        categorySelect.selectByVisibleText(category);
        return categorySelect;
    }

    public Select setCategoryToAll() {
        return setCategory("All");
    }
}