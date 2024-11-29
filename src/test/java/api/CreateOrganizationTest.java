package api;

import api.TrelloApiHelper;
import model.Organization;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateOrganizationTest {
    @Test
    public void testCreateOrganization() {
        //create organization
        Organization organization = TrelloApiHelper.createOrganization("Test Organization");
        //verify org
        Assert.assertNotNull(organization.getId(), "organization delete id failed");
        Assert.assertEquals(organization.getDisplayName(), "Test Organization", "organization name mismatch");
    }
}
