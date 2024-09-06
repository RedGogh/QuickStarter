package com.redgogh.examples;

/* -------------------------------------------------------------------------------- *\
|*                                                                                  *|
|*    Copyright (C) 2023 RedGogh                                                    *|
|*                                                                                  *|
|*    This program is free software: you can redistribute it and/or modify          *|
|*    it under the terms of the GNU General Public License as published by          *|
|*    the Free Software Foundation, either version 3 of the License, or             *|
|*    (at your option) any later version.                                           *|
|*                                                                                  *|
|*    This program is distributed in the hope that it will be useful,               *|
|*    but WITHOUT ANY WARRANTY; without even the implied warranty of                *|
|*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the                 *|
|*    GNU General Public License for more details.                                  *|
|*                                                                                  *|
|*    You should have received a copy of the GNU General Public License             *|
|*    along with this program.  If not, see <https://www.gnu.org/licenses/>.        *|
|*                                                                                  *|
|*    This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.    *|
|*    This is free software, and you are welcome to redistribute it                 *|
|*    under certain conditions; type `show c' for details.                          *|
|*                                                                                  *|
\* -------------------------------------------------------------------------------- */

import com.redgogh.tools.refection.UClass;
import com.redgogh.tools.refection.UField;
import lombok.AllArgsConstructor;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static com.redgogh.tools.AnyObjects.printf;

@SuppressWarnings("ALL")
public class UClassExample {

    @Test
    public void newUClassExample() {
        UClass uClass = new UClass(Button.class);

        printf("uClass(%s)\n", uClass.getName());

        List<UField> properties = uClass.getDeclaredFields();
        for (UField property : properties) {
            printf("  - uField path: %s\n", property.getPath());
        }
    }

    @AllArgsConstructor
    class User {
        /* test field */
        private String name;

        /* static method */
        public void sayIntroduce() {
            System.out.printf("介绍 - 永乐大帝\n");
        }

        /* static method */
        public static void say(String value) {
            System.out.printf("朱棣 - %s\n", value);
        }

    }

    @Test
    public void readFieldValueExample() {
        User judy = new User("Judy");
        System.out.println((String) new UClass(judy).readFieldValue("name", judy));
    }

    @Test
    public void invokeMethodExample() {
        User judy = new User("Judy");
        UClass uClass = new UClass(judy);

        uClass.invoke(judy,"sayIntroduce");
        uClass.staticInvoke("say", "如此江山，岂不让人留恋 ~");
    }

}
