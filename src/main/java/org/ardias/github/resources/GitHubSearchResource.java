package org.ardias.github.resources;

import org.ardias.github.core.GitHubSearchResult;
import org.ardias.github.core.GitHubSearchService;
import org.ardias.github.core.TopSearchParam;

import javax.annotation.security.PermitAll;
import javax.validation.constraints.Pattern;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Antonio Dias on 18/05/2017.
 */
@Path("/search")
public class GitHubSearchResource {

    private GitHubSearchService searchService;

    public GitHubSearchResource(GitHubSearchService searchService) {
        this.searchService = searchService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public GitHubSearchResult search(@Pattern(regexp = "5|10|50", flags = Pattern.Flag.CASE_INSENSITIVE)
                                   @QueryParam("top") @DefaultValue("5") String top,
                                     @QueryParam("city") @DefaultValue("Barcelona") String city) {
        TopSearchParam topSearchParam = parseParam(top);
        return searchService.searchTopUserByReposInCity(city, topSearchParam);
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
