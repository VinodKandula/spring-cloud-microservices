package srai.composite.service.gateway.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import srai.common.micro.service.model.Recommendation;

@FeignClient("person-recommendation-service")
public interface PersonRecommendationService {
  @RequestMapping(method = RequestMethod.GET, value = "/recommendations/{personId}")
  ResponseEntity<Recommendation[]> getRecommendations(@PathVariable("personId") int personId);

  @RequestMapping(method = RequestMethod.GET, value = "/recommendations/{personId}?skipProblems=yes")
  ResponseEntity<Recommendation[]> getRecommendationsSP(@PathVariable("personId") int personId);
}

