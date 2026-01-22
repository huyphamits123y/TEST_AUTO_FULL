package pages;

import Utils.Browsers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static Utils.Browsers.driver;
import static Utils.Browsers.executeScript;

public class TodoPage {

    By input = By.xpath("//input[@id='todo-input']");
    By labelList = By.xpath("//ul[@class='todo-list']//label");

    public void open() {
        Browsers.visit("https://todomvc.com/examples/react/dist/");
    }

    public void addTodo(String todo) {
        Browsers.fill(input, todo + "\n");
    }

    public boolean isExistedTodo(String todo) {
        return getCurrentTodo().stream().map(WebElement::getText).toList().getLast().equals(todo);
    }

    public List<WebElement> getCurrentTodo() {
        return Browsers.getElements(labelList);

    }

    public void deleteTodo(String todo) {
        Actions actions = new Actions(Browsers.driver);
        actions.moveToElement(Browsers.getElement(By.xpath("//label[.='" + todo + "']"))).perform();
        By deleteButton = By.xpath("//ul[@class='todo-list']//label[.='" + todo + "']/following-sibling::button");
        Browsers.click(deleteButton);
    }

    public int getItemsLeft() {
        if (Browsers.getElements(By.className("todo-count")).isEmpty()) {
            return 0;
        }
        String itemsLeftText = Browsers.getText(By.className("todo-count")).split(" ")[0];
        return Integer.parseInt(itemsLeftText);
    }

    public void updateTodo(String oldTodo, String newTodo) {
        WebElement oldTodoItem = Browsers
                .getElements(By.cssSelector("[data-testid='todo-item']"))
                .stream()
                .filter(item -> item.getText().equals(oldTodo))
                .toList()
                .getLast();


        Browsers.doubleClick(oldTodoItem);
        WebElement editTaskNameTextBox = oldTodoItem.findElement(By.cssSelector("input.new-todo"));
        executeScript(editTaskNameTextBox, "arguments[0].value = ''");
        editTaskNameTextBox.sendKeys(newTodo, Keys.ENTER);
    }



    public void completeTodo(String todo) {
        By toggle = By.xpath("//ul[@class='todo-list']//label[.='" + todo + "']/preceding-sibling::input[@class='toggle']");
        Browsers.click(toggle);
    }

}
