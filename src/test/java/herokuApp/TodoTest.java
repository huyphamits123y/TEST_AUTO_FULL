package herokuApp;

import Utils.Browsers;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TodoPage;

public class TodoTest {
    WebDriver driver;
    TodoPage todoPage;

    @BeforeClass
    public void setUp() {
        driver = Browsers.setDriver("chrome");
        todoPage = new TodoPage();
        todoPage.open();
    }

    /**
     * Add todo la buy milk
     * kiem tra so luong item tang len mot don vi
     * buy milk xuat hien trong danh sach cua todoList
     */


    @Test(priority = 1)
    public void isAddedTodoSuccessfully() {
        int beforeAdd = todoPage.getItemsLeft();
        todoPage.addTodo("buy milk");
        int afterAdd = todoPage.getItemsLeft();
        Assert.assertTrue(afterAdd - beforeAdd == 1, "Items left is not increased by 1");
        Assert.assertTrue(todoPage.isExistedTodo("buy milk"));
    }

    /**
     * tao du lieu buy milk
     * xoa todo vua tao
     * kiem tra items left is increased by 1
     *
     * @throws InterruptedException
     */
    @Test(priority = 2)
    public void isDeleteTodoSuccessfully() {
        todoPage.addTodo("buy milk");
        int beforeDelete = todoPage.getItemsLeft();
        todoPage.deleteTodo("buy milk");
        int afterDelete = todoPage.getItemsLeft();
        Assert.assertTrue(beforeDelete - afterDelete == 1, "Items left is not decreased by 1");
    }

    /**
     * tao du lieu buy milk
     * cap nhat buy milk latest thanh buy apple
     * kiem tra lastest todo la buy apple
     */
    @Test(priority = 3)
    public void isUpdateTodoSuccessfully() {
        todoPage.addTodo("buy milk");
        todoPage.updateTodo("buy milk", "buy apple");
        Assert.assertTrue(todoPage.isExistedTodo("buy apple"));
    }

    /**
     * tao du lieu buy milk
     * complete todo buy milk
     * kiem tra items left giam 1 don vi
     */
    /**
     * tao du lieu buy milk
     * complete todo buy milk
     * kiem tra items left giam 1 don vi
     */
    @Test(priority = 4)
    public void isCompleteTodoSuccessfully() {
        todoPage.addTodo("buy milk");
        int beforeComplete = todoPage.getItemsLeft();
        todoPage.completeTodo("buy milk");
        int afterComplete = todoPage.getItemsLeft();
        Assert.assertEquals(beforeComplete - afterComplete, 1, "Items left is not decreased by 1 after completing todo");
    }

    @AfterClass
    public void tearDown() {
//        Browsers.quit();
    }
}
