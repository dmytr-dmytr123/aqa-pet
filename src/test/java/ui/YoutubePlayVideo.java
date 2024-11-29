package ui;

import BO.YoutubeBO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class YoutubePlayVideo {
    @Test
    public void testPlayVideo() {
        YoutubeBO youtubeBO = new YoutubeBO();

        //check results and verify if they exists
        youtubeBO.search("never gonna give you up").checkResults();
        //play first video
        youtubeBO.playFirstVideo();

    }
}
