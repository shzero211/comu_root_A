package com.ll.comu;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@AllArgsConstructor
public class ResultData<T> {
    private final String msg;
    private final String resultCode;
    private T data;
}
