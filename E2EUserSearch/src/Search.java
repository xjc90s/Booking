import org.openqa.selenium.By;


public class Search extends BaseTest{

    public Search(int i){
    }

    public void search(){
        try{
            driver.get("http://booking.com");
            Thread.sleep(2000);
            driver.findElement(By.id("ss")).sendKeys("Porto  ");
            Thread.sleep(2000);
            driver.findElement(By.className("sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb")).sendKeys("01/12/2022");
            Thread.sleep(2000);
            driver.findElement(By.className("sb-searchbox__input")).sendKeys("08/12/2022");
            Thread.sleep(2000);
            driver.findElement(By.className("sb-searchbox-submit-col-submit-button")).click();
            Thread.sleep(2000);
            driver.quit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        createDriver(); // create devices
        search(); // user function
        //destroyDriver(); // destroy devices
    }

    public static void main(String[] args) {
        // Create object
        int i = 0;
        Search seach = new Search(i);

        // Get connected device count
        int totalDevices=1;
        // Initialize threads for each connected devices
        Search[] threads = new Search[totalDevices];

        // Create threads for each connected devices
        for(i=1;i<totalDevices;i++)
            threads[i] = new Search(i);

        // Start running execution on each device
        for(i=1;i<totalDevices;i++)
            threads[i].start();
    }
}