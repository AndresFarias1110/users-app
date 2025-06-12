package com.andres.test.test_rest.utility;

import org.modelmapper.ModelMapper;

public class Utilities {

    public static <T, C> C mapping(T elementMapping, Class<C> elementReturn) {
        return new ModelMapper().map(elementMapping, elementReturn);
    }
}
