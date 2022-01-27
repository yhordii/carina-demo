package com.qaprosoft.carina.demo.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;

public class PostRepoFromTemplateMethod extends AbstractApiMethodV2 {
    public PostRepoFromTemplateMethod(String template_owner, String template_repo){
        super("apiGit/repos/oneRepo/creationTemplate/rq.json", "apiGit/repos/oneRepo/creationTemplate/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("template_owner", template_owner);
        replaceUrlPlaceholder("template_repo", template_repo);
        request.header("Authorization", "Bearer " + R.CONFIG.get("git_token"));
    }
    public PostRepoFromTemplateMethod(String template_owner, String template_repo, String name, String description){
        super("apiGit/repos/oneRepo/creationTemplate/rq.json", "apiGit/repos/oneRepo/creationTemplate/rs.json");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
        replaceUrlPlaceholder("template_owner", template_owner);
        replaceUrlPlaceholder("template_repo", template_repo);
        replaceUrlPlaceholder("name", name);
        replaceUrlPlaceholder("description", description);
        request.header("Authorization", "Bearer " + R.CONFIG.get("git_token"));
    }
}
