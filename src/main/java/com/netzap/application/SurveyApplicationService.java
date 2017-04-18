package com.netzap.application;

import com.netzap.domain.Survey;
import com.netzap.domain.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyApplicationService {

    @Autowired
    private SurveyRepository surveyRepository;

    public List<Survey> findAllSurveys(){
        return surveyRepository.findAll();
    }



}
