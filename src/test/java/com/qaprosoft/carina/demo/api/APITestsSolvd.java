package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class APITestsSolvd implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    public void getEmojisTest() {
        GetEmojisMethod getEmojisMethod = new GetEmojisMethod();
        getEmojisMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getEmojisMethod.callAPI();
        getEmojisMethod.validateResponse();
    }

    @Test()
    public void getReposAllTest() {
        GetReposAllMethod getReposAllMethod = new GetReposAllMethod("zebrunner");
        getReposAllMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getReposAllMethod.callAPI();
        getReposAllMethod.validateResponse();
    }

    @Test()
    public void getRepoTest() {
        GetRepoMethod getRepoMethod = new GetRepoMethod("zebrunner", "carina-demo");
        getRepoMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getRepoMethod.callAPI();
        getRepoMethod.validateResponse();
        getRepoMethod.validateResponseAgainstSchema("apiGit/repos/oneRepo/rs.schema");
    }

    @Test()
    public void postRepoTest() {
        PostRepoMethod postRepoMethod = new PostRepoMethod();
        postRepoMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postRepoMethod.callAPI();
        postRepoMethod.validateResponseAgainstSchema("apiGit/repos/oneRepo/creation/rs.schema");
    }

    @Test()
    public void deleteRepoTest() {
        DeleteRepoMethod deleteRepoMethod = new DeleteRepoMethod("gorduw", "test_repo");
        deleteRepoMethod.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        deleteRepoMethod.callAPI();
    }

    @Test()
    public void postRepoFromTemplateTest() throws InterruptedException {
        PostRepoMethod postRepoMethod = new PostRepoMethod();
        postRepoMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postRepoMethod.callAPI();
        postRepoMethod.validateResponseAgainstSchema("apiGit/repos/oneRepo/creation/rs.schema");
        Thread.sleep(1000);
        PostRepoFromTemplateMethod postRepoFromTemplateMethod = new PostRepoFromTemplateMethod("gorduw", "test_repo");
        postRepoFromTemplateMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postRepoFromTemplateMethod.callAPI();
    }

    @Test()
    public void getVulnerabilityOffTest() {
        GetVulnerabilityAlertsCheckMethod getVulnerabilityOff = new GetVulnerabilityAlertsCheckMethod("gorduw", "ukraine_geojson");
        getVulnerabilityOff.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        getVulnerabilityOff.callAPI();
    }

    @Test()
    public void putVulnerabilityOnTest() {
        PutVulnerabilityAlertsMethod putVulnerabilityAlertsMethod = new PutVulnerabilityAlertsMethod("gorduw", "ukraine_geojson");
        putVulnerabilityAlertsMethod.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        putVulnerabilityAlertsMethod.callAPI();
    }

    @Test()
    public void putVulnerabilityOnNoAccessTest() {
        PutVulnerabilityAlertsMethod putVulnerabilityAlertsCheckMethod = new PutVulnerabilityAlertsMethod("zebrunner", "carina");
        putVulnerabilityAlertsCheckMethod.expectResponseStatus(HttpResponseStatusType.NOT_FOUND_404);
        putVulnerabilityAlertsCheckMethod.callAPI();
    }

    @Test()
    public void lifetimeRepoTest() throws InterruptedException {
        final String owner = "gorduw";

        PostRepoMethod postRepoMethod = new PostRepoMethod();
        postRepoMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postRepoMethod.callAPI();
        Thread.sleep(500);

        PostRepoFromTemplateMethod postRepoFromTemplateMethod = new PostRepoFromTemplateMethod(owner, "test_repo");
        postRepoFromTemplateMethod.expectResponseStatus(HttpResponseStatusType.CREATED_201);
        postRepoFromTemplateMethod.callAPI();
        Thread.sleep(500);

        PutVulnerabilityAlertsMethod putVulnerabilityAlertsMethod = new PutVulnerabilityAlertsMethod(owner, "test_repo_from_temp");
        putVulnerabilityAlertsMethod.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        putVulnerabilityAlertsMethod.callAPI();
        Thread.sleep(500);

        GetVulnerabilityAlertsCheckMethod getVulnerabilityAlertsCheckMethod = new GetVulnerabilityAlertsCheckMethod(owner, "test_repo_from_temp");
        getVulnerabilityAlertsCheckMethod.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        getVulnerabilityAlertsCheckMethod.callAPI();
        Thread.sleep(200);

        DeleteRepoMethod deleteRepoMethod = new DeleteRepoMethod(owner, "test_repo");
        deleteRepoMethod.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        deleteRepoMethod.callAPI();
        deleteRepoMethod = new DeleteRepoMethod(owner, "test_repo_from_temp");
        deleteRepoMethod.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
        deleteRepoMethod.callAPI();
    }


}
