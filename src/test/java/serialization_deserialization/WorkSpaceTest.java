package serialization_deserialization;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojo.workspace.WorkSpace;
import pojo.workspace.WorkSpaceRoot;

public class WorkSpaceTest {

        @Test
    public void workspaceTest()
{
    WorkSpace workSpace=new WorkSpace().setName("Shreyansh1234").setType("personal").setDescription("Rest Assured created this workspace.");
    WorkSpaceRoot workSpaceRoot = new WorkSpaceRoot();
    workSpaceRoot.setWorkSpace(workSpace);

    WorkSpaceRoot workSpaceRoot1
            = RestAssured.given()
            .baseUri("https://api.postman.com")
            .basePath("/workspaces")
            .contentType(ContentType.JSON)
            .header("X-Api-Key", "PMAK-614eba868c8a230037462114-3d9c7dd62db816398a5eb8bce4aec5e6f9")
            .body(workSpaceRoot)
            .log()
            .all()
            .when()
            .post()
            .then()
            .log()
            .all()
            .extract()
            .response()
            .as(WorkSpaceRoot.class);
}
}
