package com.redgogh.examples;

/* -------------------------------------------------------------------------------- *\
|*                                                                                  *|
|*    Copyright (C) 2019-2024 RedGogh All rights reserved.                          *|
|*                                                                                  *|
|*    Licensed under the Apache License, Version 2.0 (the "License");               *|
|*    you may not use this file except in compliance with the License.              *|
|*    You may obtain a copy of the License at                                       *|
|*                                                                                  *|
|*        http://www.apache.org/licenses/LICENSE-2.0                                *|
|*                                                                                  *|
|*    Unless required by applicable law or agreed to in writing, software           *|
|*    distributed under the License is distributed on an "AS IS" BASIS,             *|
|*    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.      *|
|*    See the License for the specific language governing permissions and           *|
|*    limitations under the License.                                                *|
|*                                                                                  *|
\* -------------------------------------------------------------------------------- */

import com.redgogh.common.BeanUtils;
import lombok.Data;
import org.junit.Test;

@SuppressWarnings("ALL")
public class BeanUtilsExample {

    @Data
    static class A {
        private String name;
        private String age;
    }

    @Data
    static class B extends A {
        private String aabb;
    }

    @Data
    static class C {
        private String name;
    }

    @Test
    public void copyPropertiesExample() {
        B b = new B();
        b.setName("John");
        b.setAge("30");

        C c = BeanUtils.copyProperties(b, C.class);
        System.out.println(c);
    }

}
