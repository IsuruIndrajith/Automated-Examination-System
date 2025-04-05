package com.auto.exam.Dto;

import java.util.List;

public record ModelListResponse(String object, List<GeminiModel> data) {
}

