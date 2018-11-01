package org.joda.money;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface DataResource extends ClientBundle{

    DataResource INSTANCE= GWT.create(DataResource.class);

    @Source("CountryData.csv")
    TextResource countryData();

    @Source("CurrencyData.csv")
    TextResource currencyData();

    @Source("CountryDataExtension.csv")
    TextResource countryDataExtension();

    @Source("CurrencyDataExtension.csv")
    TextResource currencyDataExtension();

}
