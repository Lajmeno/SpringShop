package de.neuefische.Repos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/getrepos")
public class GetReposController {


    private String url ="https://api.github.com/users/Lajmeno/repos";

    public Repo[] getApiData() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<Repo[]> response =  template.getForEntity(url, Repo[].class);
        return response.getBody();
    }

    @GetMapping
    public Repo[] getRepos(){
        return getApiData();
    }
}
