package org.ardias.github.resources;

import org.ardias.github.core.GitHubSearchService;
import org.ardias.github.core.GitHubUser;
import org.ardias.github.core.TopSearchParam;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * Created by Antonio Dias on 18/05/2017.
 */
@Path("/search")
public class GitHubSearchResource {

    private GitHubSearchService searchService;

    public GitHubSearchResource(GitHubSearchService searchService) {
        this.searchService = searchService;
    }

    @POST
    @Path("/{top}")
    public List<GitHubUser> search(@PathParam("top") @DefaultValue("5") String top) {
        TopSearchParam topSearchParam = parseParam(top);
        return searchService.doSearch(topSearchParam);
    }

    private TopSearchParam parseParam(String top) {
        Integer topVal = Integer.valueOf(top);
        switch (topVal) {
            case 5:
            default:
                return TopSearchParam.TOP5;
            case 10:
                return TopSearchParam.TOP10;
            case 50:
                return TopSearchParam.TOP50;
        }
    }

}
