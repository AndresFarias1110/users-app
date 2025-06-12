package com.andres.test.test_rest.model.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Response<T> implements Serializable {

    private String message;

    private transient T data;
}
