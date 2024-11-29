package ui;

import BO.YoutubeBO;
import org.testng.annotations.Test;

public class YoutubePlayVideo {
    @Test
    public void testPlayVideo() {
        YoutubeBO youtubeBO = new YoutubeBO();
        youtubeBO.search("never gonna give you up").playFirstVideo();
    }
}
