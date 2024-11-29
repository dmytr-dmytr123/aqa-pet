package api;

import model.Organization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteOrganizationTest {
    @Test
    public void testDeleteOrganization() {
        //ceate to delete
        Organization organization = TrelloApiHelper.createOrganization("Delete Organization");

        //verify
        Assert.assertNotNull(organization.getId(), "organization delete id failed");

        //delete
        TrelloApiHelper.deleteOrganization(organization.getId());

    }
}
