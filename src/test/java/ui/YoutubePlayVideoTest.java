package ui;

import BO.YoutubeBO;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({YoutubeBO.class, UniversalVideoListener.class})
public class YoutubePlayVideoTest {
    @Test
    @Video
    public void testPlayVideo() {
        YoutubeBO youtubeBO = new YoutubeBO();

        //check results and verify if they exists
        youtubeBO.search("never gonna give you up").checkResults();
        //play first video
        youtubeBO.playFirstVideo();

    }
}
