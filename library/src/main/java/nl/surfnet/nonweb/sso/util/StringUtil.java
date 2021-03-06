package nl.surfnet.nonweb.sso.util;

/*
 * Copyright 2015 SURFnet BV, The Netherlands
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Utility class for methods to handle String.
 */
public final class StringUtil {

    //SecureRandom objects are expensive to initialize, keep one around and reuse it.
    private static SecureRandom _random = new SecureRandom();

    /**
     * Default constructor
     */
    private StringUtil() {
    }

    /**
     * Checks if a String is whitespace, empty ("") or null.
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("wiebe")     = false
     * StringUtils.isBlank("  wiebe  ") = false
     *
     * @param str the String to check, may be null
     * @return <code>true</code> if the String is null, empty or whitespace
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Generate strings to be used as session identifiers.
     *
     * @return
     */
    public static String generateSessionString() {
        return new BigInteger(130, _random).toString(32);
    }
}
