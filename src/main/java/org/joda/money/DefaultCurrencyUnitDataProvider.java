/*
 *  Copyright 2009-present, Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.money;

import java.util.Arrays;
import java.util.List;

/**
 * Provider for available currencies using a file.
 * <p>
 * This reads currencies from various files.
 * Firstly it reads the mandatory resource named {@code /org/joda/money/CurencyData.csv}.
 * Then it reads the mandatory resource named {@code /org/joda/money/CountryData.csv}.
 * These files are located in the joda-money jar file.
 * <p>
 * Then it reads optional resources named {@code META-INF/org/joda/money/CurencyDataExtension.csv}.
 * Then it reads optional resources named {@code META-INF/org/joda/money/CountryDataExtension.csv}.
 * These will be read using {@link ClassLoader#getResources(String)}.
 * These files may augment or replace data from the first two files.
 */
class DefaultCurrencyUnitDataProvider extends CurrencyUnitDataProvider {

    /**
     * Regex format for the money csv line.
     */
    private static final String CURRENCY_REGEX_LINE = new String("([A-Z]{3}),(-1|[0-9]{1,3}),(-1|[0-9]|[1-2][0-9]|30) *(#.*)?");
    /**
     * Regex format for the country csv line.
     */
    private static final String COUNTRY_REGEX_LINE = new String("([A-Z]{2}),([A-Z]{3}) *(#.*)?");

    /**
     * Registers all the currencies known by this provider.
     *
     * @throws Exception if an error occurs
     */
    @Override
    protected void registerCurrencies() throws Exception {
        parseCurrencies(Arrays.asList(DataResource.INSTANCE.currencyData().getText().split("\\r?\\n")));
        parseCountries(Arrays.asList(DataResource.INSTANCE.countryData().getText().split("\\r?\\n")));
        parseCurrencies(Arrays.asList(DataResource.INSTANCE.currencyDataExtension().getText().split("\\r?\\n")));
        parseCountries(Arrays.asList(DataResource.INSTANCE.countryDataExtension().getText().split("\\r?\\n")));
    }


    // parse the currencies
    private void parseCurrencies(List<String> content) throws Exception {
        for (String line : content) {


            String[] info = line.split(",");
            if (info.length > 0) {
                String currencyCode = info[0];
                int numericCode = Integer.parseInt(info[1]);
                int digits = Integer.parseInt(info[2]);
                registerCurrency(currencyCode, numericCode, digits);
            }
        }
    }

    // parse the countries
    private void parseCountries(List<String> content) throws Exception {
        for (String line : content) {
            String[] info = line.split(",");

            if (info.length> 0) {
                String countryCode = info[0];
                String currencyCode = info[1];
                registerCountry(countryCode, currencyCode);
            }
        }
    }

}
