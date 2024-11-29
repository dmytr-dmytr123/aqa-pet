package api;

import model.Board;
import model.Organization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBoardTest {
    @Test
    public void testCreateBoard() {
        Organization organization = TrelloApiHelper.createOrganization("Board Organization");
        //create board
        Board board = TrelloApiHelper.createBoard("Test Board", organization.getId());
        //verify board by id
        Assert.assertNotNull(board.getId(), "board id failed");
        //verify board by name
        Assert.assertEquals(board.getName(), "Test Board", "Board name mismatch");
    }
}
