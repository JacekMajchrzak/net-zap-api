package com.netzap.api.response;

import com.netzap.domain.Survey;

import java.util.List;

public class SurveyListResponse {
    private List<Survey> clients;

    public SurveyListResponse(List<Survey> clients) {
        this.clients = clients;
    }

    public List<Survey> getClients() {
        return clients;
    }
}
