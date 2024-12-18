package ui;

import BO.YoutubeBO;
import allure.AllureMethodListener;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({YoutubeBO.class, UniversalVideoListener.class, AllureMethodListener.class})
public class YoutubePlayVideoTest {
    @DataProvider(name = "searchDataProvider")
    public Object[][] searchDataProvider() {
        return new Object[][] {
                {"never gonna give you up"},
                {"rick ast"},
        };
    }

    @Test(dataProvider = "searchDataProvider")
    @Video
    public void testPlayVideo(String searchQuery) {
        YoutubeBO youtubeBO = new YoutubeBO();

        //search for video
        youtubeBO.search(searchQuery).checkResults();

        //play first video
        youtubeBO.playFirstVideo();

    }
}
