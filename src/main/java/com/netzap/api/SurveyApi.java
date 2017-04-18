package com.netzap.api;

import com.netzap.application.SurveyApplicationService;
import com.netzap.api.response.SurveyListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/survey")
public class SurveyApi {

    @Autowired
    private SurveyApplicationService surveyApplicationService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public SurveyListResponse list(){
        return new SurveyListResponse(surveyApplicationService.findAllSurveys());
    }
}
